package twitter; 
  
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.net.URL; 
import java.net.URLConnection; 
import java.util.ArrayList; 
import java.util.List; 
import java.util.logging.Level;
  
import javax.jdo.PersistenceManager;  
import javax.servlet.http.*; 
  
import com.google.appengine.api.memcache.ErrorHandlers;
import com.google.appengine.api.memcache.MemcacheService;
import com.google.appengine.api.memcache.MemcacheServiceFactory;
import com.google.appengine.labs.repackaged.org.json.JSONArray; 
import com.google.appengine.labs.repackaged.org.json.JSONException; 
import com.google.appengine.labs.repackaged.org.json.JSONObject; 
  
@SuppressWarnings("serial") 
public class SearchServlet extends HttpServlet { 
    public void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws IOException {         
   /*   request.setAttribute("tweets", null); 
        RequestDispatcher dispatcher = request.getRequestDispatcher("/search.jsp"); 
        try { 
            dispatcher.forward(request,  response); 
        } catch (ServletException e) { 
            e.printStackTrace(); 
        }*/
    } 
      
    public void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws IOException { 
          

        String query0 = req.getParameter("keywords"); 
        String query = query0.replace(" ","%20"); 
        URL Twitter = new URL("http://search.twitter.com/search.json?q=" + query + "&rpp=100" + "&result_type=mixed"); 
        
        

        String value = null;

        /* Check the MemCache first */
        MemcacheService syncCache = MemcacheServiceFactory.getMemcacheService();
        syncCache.setErrorHandler(ErrorHandlers.getConsistentLogAndContinue(Level.INFO));
        value = (String) syncCache.get(query); // read from cache
        if (value != null) return;
        

          
        URLConnection yc = Twitter.openConnection(); 
        BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream())); 
          
        String inputLine; 
        StringBuffer output = new StringBuffer(""); 
          
        while ((inputLine = in.readLine()) != null) { 
            output.append((inputLine)); 
        } 
        in.close(); 
          
        String json = output.toString(); 
  
        //resp.getWriter().print("<p>"); 
        //resp.getWriter().println(json); 
        //resp.getWriter().print("</p>"); 
          
        List<TwitterBean> listOfTweets = null; 
        try { 
            listOfTweets = this.parseJSON(json); 
        } catch (JSONException e) { 
            e.printStackTrace(); 
        } 
          
        if (listOfTweets == null) { 
            resp.sendRedirect("/search.jsp"); 
            return; 
        } 
          
        PersistenceManager pm = PMF.get().getPersistenceManager(); 
          
        try { 
             pm.makePersistentAll(listOfTweets); 
               
         } finally { 
             pm.close(); 
         } 
        
        BuzzModule buzz = new BuzzModule();
        
        buzz.addStopWord(query0);
        
        for (TwitterBean t : listOfTweets) {
    		buzz.analyzeBuzz(t.getText());
    	}
        
        buzz.rmStopWord(query0);
        
        /* Send to servlet */
        String buzzWord = buzz.getBuzz(); 
        
        
        StringBuilder sb = new StringBuilder();
        sb.append("{\"buzz\":");
        sb.append('"');
        sb.append(buzzWord);
        sb.append('"');
        sb.append(',');
        
        sb.append("\"query\":");
        sb.append('"');
        sb.append(req.getParameter("keywords"));
        sb.append('"');
        sb.append(',');
        sb.append("\"results\" : [");
        for (TwitterBean t : listOfTweets) {
    		if (buzz.isTweetBuzz(t.getText(), buzzWord)) {
    			System.out.println(t.getText());
    			sb.append(t.toString());
    			sb.append(',');
    		}
    	}
    
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]}");
        
                
        /* Store results in MemCache */
        syncCache.put(query, sb.toString()); // populate cache
        

        resp.sendRedirect("/search.jsp?buzz=" + buzzWord + "&query=" + query);

    } 
      
    /** 
     * Parses a JSON string into collection of TwitterBean objects. 
     *  
     * @param json  the JSON string to parse 
     * @return  collection of TwitterBean objects 
     * @throws JSONException    if the parsing is not successful 
     */
    public List<TwitterBean> parseJSON(String json)  
            throws JSONException { 
          
        JSONObject myjson = new JSONObject(json);
        JSONArray the_json_array = myjson.getJSONArray("results"); 
  
        int size = the_json_array.length();
        //ArrayList<JSONObject> arrays = new ArrayList<JSONObject>(); 
        List<TwitterBean> listOfTweets = new ArrayList<TwitterBean>(); 
  
        for (int i = 0; i < size; i++) 
        { 
            JSONObject another_json_object = the_json_array.getJSONObject(i); 
  
            String tweet_id = another_json_object.get("id_str").toString(); 
            String text = another_json_object.get("text").toString(); 
            String from_user = another_json_object.get("from_user").toString(); 
            String from_user_name = another_json_object.get("from_user_name").toString(); 
            String created_at = another_json_object.get("created_at").toString(); 
            String profile_image_url = another_json_object.get("profile_image_url").toString(); 
  
            TwitterBean tb = new TwitterBean(tweet_id, text, from_user, from_user_name, profile_image_url, created_at); 
            listOfTweets.add(tb); 
        } 
          
        return listOfTweets; 
          
    } 
}   