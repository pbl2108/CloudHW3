<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="java.util.List" %>
<%@ page import="javax.jdo.Query" %>
<%@ page import="twitter.TwitterBean" %>
<%@ page import="twitter.PMF" %>
<%@ page import="twitter.BuzzModule" %>

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
		  			
		  			PersistenceManager pm = PMF.get().getPersistenceManager();
		  			BuzzModule buzz = new BuzzModule();
		  			
		  			Query q = pm.newQuery(TwitterBean.class);
					try {
		  					List<TwitterBean> listOfTweets = (List<TwitterBean>) q.execute();
		  					if (!listOfTweets.isEmpty()) {
		  						int count = 0;
		    					for (TwitterBean t : listOfTweets) {
		    						
		    						
		    						if (buzz.isTweetBuzz(t.getText(), buzzWord)){
		    						count++;
		      	%>
				      			<div class="tweetContainer">
									<div class="twitterContent">
										<div class="tweetHeader">
											<a href="javascript:void(0)" target="_blank" class="userAnchor">
												<strong><%= t.getFromUserName()%></strong> <span class="userSpan">
												<s>@</s> 
												<b><%= t.getFromUser()%></b>
											</span>
												<img class="avatarClass" src="<%= t.getProfileImageUrl()%>"
													alt="rrr" />
											</a>
										</div>
										<p>
											<%= t.getText() %>
										</p>
									</div>
								</div>
		      			
				<%				if (count > 10) break;
		    						}
								}
		  					} else {
								// Handle "no results" case
		  					}
						} finally {
		  					q.closeAll();
						}
					}	
		  		%>
  				</div>
  				<div style="clear: both"></div>
  			</div>
		</div>
	</body>
</html>