package twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.servlet.http.*;

@SuppressWarnings("serial")
public class SearchServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.setContentType("text/plain");
        resp.getWriter().println("Hello, world GET");
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    throws IOException {
    	
    	String query = req.getParameter("keywords");
    	query = query.replace(" ","%20");
    	URL Twitter = new URL("http://search.twitter.com/search.json?q=" + query);
    	
    	URLConnection yc = Twitter.openConnection();
    	BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
    	
    	String inputLine;
    	StringBuffer output = new StringBuffer("");
    	
    	while ((inputLine = in.readLine()) != null) {
    		output.append((inputLine));
    	}
    	in.close();
    	
    	String json = output.toString();

    	resp.getWriter().print("<p>");
    	resp.getWriter().println(json);
    	resp.getWriter().print("</p>");
    	//resp.sendRedirect("/search.jsp");
    }
}	