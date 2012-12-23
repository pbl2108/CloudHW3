package twitter;

import java.io.Serializable;
import java.util.List;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;

@PersistenceCapable
public class SearchResult {
    @Persistent
	private String _buzzWord;
	
    @Persistent
	private List<TwitterBean> _tweets;
    
    
    public SearchResult (String buzzWord, List<TwitterBean> tweets) {
    	this._buzzWord = buzzWord;
    	this._tweets = tweets;
    }
    
    public List<TwitterBean> getTweets() {
    	return this._tweets;
    }
    
    public String getBuzzWord () {
    	return this._buzzWord;
    }
}
