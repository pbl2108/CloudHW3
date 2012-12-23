package twitter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class BuzzModule {
	
	public Set<String> stopWords = new HashSet<String>(Arrays.asList(new String[] {
			"a",
			"about",
			"above",
			"after",
			"again",
			"against",
			"all",
			"am",
			"an",
			"and",
			"any",
			"are",
			"arent",
			"as",
			"at",
			"be",
			"because",
			"been",
			"before",
			"being",
			"below",
			"between",
			"both",
			"but",
			"by",
			"cant",
			"cannot",
			"could",
			"couldnt",
			"did",
			"didt",
			"do",
			"does",
			"doesnt",
			"doing",
			"dont",
			"down",
			"during",
			"each",
			"few",
			"for",
			"from",
			"further",
			"had",
			"hadnt",
			"has",
			"hasnt",
			"have",
			"havent",
			"having",
			"he",
			"hed",
			"hell",
			"hes",
			"her",
			"here",
			"heres",
			"hers",
			"herself",
			"him",
			"himself",
			"his",
			"how",
			"hows",
			"i",
			"id",
			"ill",
			"im",
			"ive",
			"if",
			"in",
			"into",
			"is",
			"isnt",
			"it",
			"its",
			"itself",
			"lets",
			"me",
			"more",
			"most",
			"mustnt",
			"my",
			"myself",
			"no",
			"nor",
			"not",
			"of",
			"off",
			"on",
			"once",
			"only",
			"or",
			"other",
			"ought",
			"our",
			"ours",
			"ourselves",
			"out",
			"over",
			"own",
			"same",
			"shant",
			"she",
			"shed",
			"shell",
			"shes",
			"should",
			"shouldnt",
			"so",
			"some",
			"such",
			"than",
			"that",
			"thats",
			"the",
			"their",
			"theirs",
			"them",
			"themselves",
			"then",
			"there",
			"theres",
			"these",
			"they",
			"theyd",
			"theyll",
			"theyre",
			"theyve",
			"this",
			"those",
			"through",
			"to",
			"too",
			"under",
			"until",
			"up",
			"very",
			"was",
			"wasnt",
			"we",
			"wed",
			"we'll",
			"were",
			"weve",
			"were",
			"werent",
			"what",
			"whats",
			"when",
			"whens",
			"where",
			"wheres",
			"which",
			"while",
			"who",
			"whos",
			"whom",
			"why",
			"whys",
			"with",
			"wont",
			"would",
			"wouldnt",
			"you",
			"youd",
			"youll",
			"youre",
			"youve",
			"your",
			"yours",
			"yourself",
			"yourselves"
	}));
	public HashMap<String,Integer> frequencies=new HashMap<String,Integer>();
	
//    public static void main(String[] args) {
//    	
//    	String text[] = new String[8];
//    	BuzzModule buzz = new BuzzModule();
//    	int i = 0;
//    	
//    	text[0] = "Happy 2013, let's analyse how #cloud will evolve. What you need to know. #cloudsource - http://ow.ly/gfS7P ";
//    	text[1] = "In 2012, SaaS HR showed C-suite a safe path to cloud computing http://ow.ly/gjxSt  ->Insights from @Josh_Bersin & @billkutik";
//    	text[2] = "Big data analytics, CloudStack top hot cloud computing trends in 2013 http://sns.mx/R2mCy6 ";
//    	text[3] = "Powered by @app_engine, South African startup Nomanini's voucher sales terminal enables local entrepreneurs http://goo.gl/jEP3a ";
//    	text[4] = "Use Cloud Computing Technology to Expand Your Company | North ICT Network http://www.northictnetwork.org/use-cloud-computing-technology-to-expand-your-company.html ";
//    	text[5] = "First steps to creating a Cloud Computing Strategy for 2013 http://bit.ly/T5Z9tH ";
//    	text[6] = "2013 2013 2013 2013";
//    	text[7] = "test test test";
//    	
//    
//    	buzz.addStopWord("Cloud Computing");
//    	
//    	
//    	while (i < text.length){
//    		buzz.analyzeBuzz(text[i]);
//			i++;
//    	}
//		
//    	buzz.rmStopWord("Cloud Computing");
//    	
//    	buzz.getBuzz();
//			
//    }
    
    public void addStopWord(String text) {
    	String[] words = text.toLowerCase().split(" ");
    	
    	for (String w: Arrays.asList(words)){
    		w = w.replaceAll("[^a-z][^0-9]", "");
    		this.stopWords.add(w);
    	}
		
	}
    
    public void rmStopWord(String text) {
    	String[] words = text.toLowerCase().split(" ");
    	
    	for (String w: Arrays.asList(words)){
    		w = w.replaceAll("[^a-z][^0-9]", "");
    		this.stopWords.remove(w);
    	}
		
	}

	public void analyzeBuzz(String text){
    	String[] words = text.toLowerCase().split(" ");
    	
    	for (String w: Arrays.asList(words)){
    		w = w.replaceAll("[^a-z][^0-9]", "");
    		if( stopWords.contains(w)) {
    			    continue;
    			  }
    		Integer num=frequencies.get(w);
    		if (num!=null)
    			frequencies.put(w,num+1);
    		else
    			frequencies.put(w,1);
    	}
    }
    
    public String getBuzz(){
    	Iterator iterator = frequencies.keySet().iterator();  


    	int value = 0;
    	String highestKey = null;
    	String secondHighestKey = null;
    	int secondValue = 0;
    	String thirdHighestKey = null;
    	int thirdValue = 0;



    	while (iterator.hasNext()) {  
    		String key = iterator.next().toString();  
    		int tmpValue = frequencies.get(key);  

    		System.out.print(key + " " + frequencies.get(key) + "     ");
    		System.out.print(highestKey + " " + value + " ");
    		System.out.print(secondHighestKey + " " + frequencies.get(secondHighestKey) + " ");
    		System.out.println(thirdHighestKey + " " +  frequencies.get(thirdHighestKey) + " ");

    		if (value <= tmpValue){
    			value = tmpValue;
    			thirdHighestKey = secondHighestKey;
    			if(thirdHighestKey != null)
    				thirdValue = frequencies.get(thirdHighestKey);
    			secondHighestKey = highestKey;
    			if(secondHighestKey != null)
    				secondValue = frequencies.get(secondHighestKey);
    			highestKey = key;
    			continue;
    		}

    		if (secondValue <= tmpValue){
    			thirdHighestKey = secondHighestKey;
    			secondHighestKey = key;
    			if(thirdHighestKey != null)
    				thirdValue = secondValue = frequencies.get(thirdHighestKey);
    			if(secondHighestKey != null)
    				secondValue = frequencies.get(secondHighestKey);
    			continue;
    		}

    		if (thirdValue <= tmpValue){
    			thirdValue = tmpValue;
    			thirdHighestKey = key;
    			continue;
    		}


    	}
    	
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println(highestKey + " " + value);
		System.out.println(secondHighestKey + " " + frequencies.get(secondHighestKey));
		System.out.println(thirdHighestKey + " " +  frequencies.get(thirdHighestKey));
		
		String buzzMsg = null;
		
		if ( frequencies.get(highestKey) == frequencies.get(secondHighestKey)){
			buzzMsg = highestKey + " " + secondHighestKey;
		}else
			buzzMsg = highestKey;
		
		return buzzMsg;
    }

}


