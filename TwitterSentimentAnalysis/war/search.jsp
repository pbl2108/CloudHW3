<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.List" %>
<%@ page import="javax.jdo.Query" %>
<%@ page import="java.util.logging.Level" %>

<%@ page import="twitter.TwitterBean" %>
<%@ page import="twitter.PMF" %>
<%@ page import="twitter.BuzzModule" %>
<%@ page import="twitter.SearchResult" %>



<%@ page import="com.google.appengine.api.memcache.ErrorHandlers" %>
<%@ page import="com.google.appengine.api.memcache.MemcacheService" %>
<%@ page import="com.google.appengine.api.memcache.MemcacheServiceFactory" %>
<%@ page import="com.google.appengine.labs.repackaged.org.json.JSONObject" %>
<%@ page import="com.google.appengine.labs.repackaged.org.json.JSONArray" %>
<%@ page import="com.google.appengine.labs.repackaged.org.json.JSONException" %>
<%@ page import="com.google.appengine.api.users.User" %>
<%@ page import="com.google.appengine.api.users.UserService" %>
<%@ page import="com.google.appengine.api.users.UserServiceFactory" %>

<%@ page import="javax.jdo.PersistenceManager" %>


<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Twitter Sentiment Analysis</title>
		<link type="text/css" rel="stylesheet" href="/css/styles.css" />
	</head>
	
	<body  class="pagebackground">
		
		<form action="/search" method="post">
			<div class="header">
				<div class="innerHeader">
					<span>Enter keyword to find the buzz:</span> 
					<input type="text" class="textField" name="keywords" />
					<input type="submit" value="Search" />
				</div>
			</div>
  		</form>
  		
  		<div class="content">
			<div class="innerContent">
			
				<div class="innerLeftContent">
				<div class="toolTipClass">
					<div class="tweetContainer">
						<span>Last search results
						</span>* <a href="#">Refresh</a> * <a href="#">View All</a>
					</div>
					<div class="tweetContainer">
						<div class="twitterContent">
							<div class="tweetHeader">
								<a href="http://www.twitter.com/patkelsey" target="_blank" class="userAnchor"><strong>data["from_user_name"] Thom at Yahoo</strong> <span class="userSpan"><s>@</s> <b>data["from_user"]</b>
								</span>
									<img class="avatarClass" src="http://a0.twimg.com/profile_images/1510199369/unser_Multiuniversum_normal.jpg"
										alt="rrr" />
								</a>
							</div>
							<p>
								@patkelsey I just wanted to thank you for your...
							</p>
						</div>
					</div>
					<div class="tweetContainer">
						<div class="twitterContent">
							<div class="tweetHeader">
								<a href="http://www.twitter.com/patkelsey" target="_blank" class="userAnchor"><strong>data["from_user_name"] Thom at Yahoo</strong> <span class="userSpan"><s>@</s> <b>data["from_user"]</b>
								</span>
									<img class="avatarClass" src="http://a0.twimg.com/profile_images/1510199369/unser_Multiuniversum_normal.jpg"
										alt="rrr" />
								</a>
							</div>
							<p>
								@patkelsey I just wanted to thank you...
							</p>
						</div>
					</div>
					<div class="tweetContainer">
						<div class="twitterContent">
							<div class="tweetHeader">
								<a href="http://www.twitter.com/patkelsey" target="_blank" class="userAnchor"><strong>data["from_user_name"] Thom at Yahoo</strong> <span class="userSpan"><s>@</s> <b>data["from_user"]</b>
								</span>
									<img class="avatarClass" src="http://a0.twimg.com/profile_images/1510199369/unser_Multiuniversum_normal.jpg"
										alt="rrr" />
								</a>
							</div>
							<p>
								@patkelsey I just wanted to thank...
							</p>
						</div>
					</div>
				</div>
			</div>
			
			
  			<div class="toolTipClass1">
	  			<div class="tweetContainer">
					<h4>Tweets</h4>
				</div>
				
				
				
				
				
				
				<%
		  			String buzzWord = request.getParameter("buzz");
		    		if (buzzWord != null) {
		  			
		  			
		  					
							String query = request.getParameter("query");
        
        					String value = null;
		  					
		  					MemcacheService syncCache = MemcacheServiceFactory.getMemcacheService();
        					syncCache.setErrorHandler(ErrorHandlers.getConsistentLogAndContinue(Level.INFO));
        					value = (String) syncCache.get(query); // read from cache
        					if (value != null) {		  					
							try {
								JSONObject myjson = new JSONObject(value);
        						JSONArray the_json_array = myjson.getJSONArray("results"); 
  
        						int size = the_json_array.length();
								for (int i = 0; i < size; i++) 
						        { 
						            JSONObject another_json_object = the_json_array.getJSONObject(i); 
						  
						            String tweet_id = another_json_object.get("id_str").toString(); 
						            String text = another_json_object.get("text").toString(); 
						            String from_user = another_json_object.get("from_user").toString(); 
						            String from_user_name = another_json_object.get("from_user_name").toString(); 
						            String created_at = another_json_object.get("created_at").toString(); 
						            String profile_image_url = another_json_object.get("profile_image_url").toString(); 		  					
		      	%>
				      			<div class="tweetContainer">
									<div class="twitterContent">
										<div class="tweetHeader">
											<a href="javascript:void(0)" target="_blank" class="userAnchor">
												<strong><%= from_user_name %></strong> <span class="userSpan">
												<s>@</s> 
												<b><%= from_user%></b>
											</span>
												<img class="avatarClass" src="<%= profile_image_url %>"
													alt="avatar" />
											</a>
										</div>
										<p>
											<%= text %>
										</p>
									</div>
								</div>
		      			
				<%					}//for loop
				
								} catch (JSONException e){ 
								%>
									EXCEPTION
								<%
								
								}							
							}
						}	
		  		%>
				
				
				
				
  		

  				</div>
  				<div style="clear: both"></div>
  			</div>
		</div>
	</body>
</html>