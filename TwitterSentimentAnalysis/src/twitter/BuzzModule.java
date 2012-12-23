package twitter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class BuzzModule {
	
	public Set<String> stopWords = new HashSet<String>(Arrays.asList(new String[] {
			"a",
			"able",
			"about",
			"after",
			"against",
			"again",
			"above",
			"according",
			"accordingly",
			"across",
			"actually",
			"after",
			"afterwards",
			"again",
			"against",
			"aint",
			"all",
			"allow",
			"allows",
			"almost",
			"alone",
			"along",
			"already",
			"also",
			"although",
			"always",
			"am",
			"among",
			"amongst",
			"an",
			"and",
			"another",
			"any",
			"anybody",
			"anyhow",
			"anyone",
			"anything",
			"anyway",
			"anyways",
			"anywhere",
			"apart",
			"appear",
			"appreciate",
			"appropriate",
			"are",
			"arent",
			"around",
			"as",
			"aside",
			"ask",
			"asking",
			"associated",
			"at",
			"available",
			"away",
			"awfully",
			"be",
			"became",
			"because",
			"become",
			"becomes",
			"becoming",
			"been",
			"before",
			"beforehand",
			"behind",
			"being",
			"believe",
			"below",
			"beside",
			"besides",
			"better",
			"between",
			"beyond",
			"both",
			"brief",
			"but",
			"by",
			"cmon",
			"cs",
			"came",
			"can",
			"cant",
			"cannot",
			"cant",
			"cause",
			"causes",
			"certain",
			"certainly",
			"changes",
			"clearly",
			"co",
			"com",
			"come",
			"comes",
			"concerning",
			"consequently",
			"consider",
			"considering",
			"contain",
			"containing",
			"contains",
			"corresponding",
			"could",
			"couldnt",
			"course",
			"currently",
			"definitely",
			"described",
			"despite",
			"did",
			"didnt",
			"different",
			"do",
			"does",
			"doesnt",
			"doing",
			"dont",
			"done",
			"down",
			"downwards",
			"during",
			"each",
			"edu",
			"eg",
			"eight",
			"either",
			"else",
			"elsewhere",
			"en",
			"enough",
			"entirely",
			"especially",
			"et",
			"etc",
			"even",
			"ever",
			"every",
			"everybody",
			"everyone",
			"everything",
			"everywhere",
			"ex",
			"exactly",
			"example",
			"except",
			"far",
			"few",
			"fifth",
			"first",
			"five",
			"followed",
			"following",
			"follows",
			"for",
			"former",
			"formerly",
			"forth",
			"four",
			"from",
			"further",
			"furthermore",
			"get",
			"gets",
			"getting",
			"given",
			"gives",
			"go",
			"goes",
			"going",
			"gone",
			"got",
			"gotten",
			"greetings",
			"had",
			"hadnt",
			"happens",
			"hardly",
			"has",
			"hasnt",
			"have",
			"havent",
			"having",
			"he",
			"hes",
			"hello",
			"help",
			"hence",
			"her",
			"here",
			"heres",
			"hereafter",
			"hereby",
			"herein",
			"hereupon",
			"hers",
			"herself",
			"hi",
			"him",
			"himself",
			"his",
			"hither",
			"hopefully",
			"how",
			"howbeit",
			"however",
			"i",
			"id",
			"ill",
			"im",
			"ive",
			"ie",
			"if",
			"ignored",
			"immediate",
			"in",
			"inasmuch",
			"inc",
			"indeed",
			"indicate",
			"indicated",
			"indicates",
			"inner",
			"insofar",
			"instead",
			"into",
			"inward",
			"is",
			"isnt",
			"it",
			"itd",
			"itll",
			"its",
			"its",
			"itself",
			"just",
			"keep",
			"keeps",
			"kept",
			"know",
			"knows",
			"known",
			"last",
			"lately",
			"later",
			"latter",
			"latterly",
			"least",
			"less",
			"lest",
			"let",
			"lets",
			"like",
			"liked",
			"likely",
			"little",
			"lol",
			"look",
			"looking",
			"looks",
			"ltd",
			"mainly",
			"many",
			"may",
			"maybe",
			"me",
			"mean",
			"meanwhile",
			"merely",
			"might",
			"more",
			"moreover",
			"most",
			"mostly",
			"much",
			"must",
			"my",
			"myself",
			"name",
			"namely",
			"nd",
			"nearly",
			"necessary",
			"need",
			"needs",
			"neither",
			"never",
			"nevertheless",
			"new",
			"next",
			"nine",
			"no",
			"nobody",
			"non",
			"none",
			"noone",
			"nor",
			"normally",
			"not",
			"nothing",
			"novel",
			"now",
			"nowhere",
			"obviously",
			"of",
			"off",
			"often",
			"oh",
			"ok",
			"okay",
			"old",
			"on",
			"once",
			"one",
			"ones",
			"only",
			"onto",
			"other",
			"others",
			"otherwise",
			"ought",
			"our",
			"ours",
			"ourselves",
			"out",
			"outside",
			"over",
			"overall",
			"own",
			"particular",
			"particularly",
			"per",
			"perhaps",
			"placed",
			"please",
			"plus",
			"possible",
			"presumably",
			"probably",
			"provides",
			"que",
			"quite",
			"qv",
			"rather",
			"rd",
			"re",
			"really",
			"reasonably",
			"regarding",
			"regardless",
			"regards",
			"require",
			"requires",
			"relatively",
			"respectively",
			"right",
			"rt",
			"said",
			"same",
			"saw",
			"say",
			"saying",
			"says",
			"second",
			"secondly",
			"see",
			"seeing",
			"seem",
			"seemed",
			"seeming",
			"seems",
			"seen",
			"self",
			"selves",
			"sensible",
			"sent",
			"serious",
			"seriously",
			"seven",
			"several",
			"shall",
			"she",
			"should",
			"shouldnt",
			"since",
			"six",
			"so",
			"some",
			"somebody",
			"somehow",
			"someone",
			"something",
			"sometime",
			"sometimes",
			"somewhat",
			"somewhere",
			"soon",
			"sorry",
			"specified",
			"specify",
			"specifying",
			"still",
			"sub",
			"such",
			"sup",
			"sure",
			"ts",
			"take",
			"taken",
			"tell",
			"tends",
			"th",
			"than",
			"thank",
			"thanks",
			"thanx",
			"that",
			"thats",
			"thats",
			"the",
			"their",
			"theirs",
			"them",
			"themselves",
			"then",
			"thence",
			"there",
			"theres",
			"thereafter",
			"thereby",
			"therefore",
			"therein",
			"theres",
			"thereupon",
			"these",
			"they",
			"theyd",
			"theyll",
			"theyre",
			"theyve",
			"think",
			"third",
			"this",
			"thorough",
			"thoroughly",
			"those",
			"though",
			"three",
			"through",
			"throughout",
			"thru",
			"thus",
			"together",
			"to",
			"too",
			"took",
			"toward",
			"towards",
			"tried",
			"tries",
			"truly",
			"try",
			"trying",
			"twice",
			"twitter",
			"twitpic",
			"under",
			"unfortunately",
			"unless",
			"unlikely",
			"unto",
			"up",
			"upon",
			"us",
			"use",
			"used",
			"useful",
			"uses",
			"using",
			"usually",
			"value",
			"various",
			"very",
			"via",
			"viz",
			"vs",
			"want",
			"wants",
			"was",
			"wasnt",
			"way",
			"we",
			"wed",
			"well",
			"were",
			"weve",
			"welcome",
			"well",
			"went",
			"were",
			"werent",
			"what",
			"whats",
			"whatever",
			"when",
			"whence",
			"whenever",
			"where",
			"wheres",
			"whereafter",
			"whereas",
			"whereby",
			"wherein",
			"whereupon",
			"wherever",
			"whether",
			"which",
			"while",
			"whither",
			"who",
			"whos",
			"whoever",
			"whole",
			"whom",
			"whose",
			"why",
			"will",
			"willing",
			"wish",
			"with",
			"without",
			"wont",
			"wonder",
			"would",
			"would",
			"wouldnt",
			"yes",
			"yet",
			"you",
			"youd",
			"youll",
			"youre",
			"youve",
			"your",
			"yours",
			"yourself",
			"yourselves",
			"rt",
			"ht",
			"oh",
			"ff",
			"de",
			" ",
			""
		}));
	public HashMap<String,Integer> frequencies=new HashMap<String,Integer>();
	public String query; 
	
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
//    	String buzzWord = buzz.getBuzz();
//    	
//    	i=0;
//    	while (i < text.length){
//    		if (buzz.isTweetBuzz(text[i], buzzWord))
//    			System.out.println(text[i]);
//			i++;
//    	}
//    }
    
    public void addStopWord(String text) {
    	this.query = text;
    	String[] words = text.toLowerCase().split(" ");
    	
    	for (String w: Arrays.asList(words)){
    		w = w.replaceAll("\\W", ""); 
    		this.stopWords.add(w);
    	}
		
	}
    
    public void rmStopWord(String text) {
    	String[] words = text.toLowerCase().split(" ");
    	
    	for (String w: Arrays.asList(words)){
    		w = w.replaceAll("\\W", ""); 
    		this.stopWords.remove(w);
    	}
		
	}

	public void analyzeBuzz(String text){
    	String[] words = text.toLowerCase().split(" ");
    	
    	for (String w: Arrays.asList(words)){
    		w = w.replaceAll("\\W", ""); 
    		if( stopWords.contains(w)) {
    			    continue;
    		}
    		Integer num=frequencies.get(w);
    		if (num!=null)
    			frequencies.put(w,num+1);
    		else
    			frequencies.put(w,1);
    		
    		System.out.println(w + " " + frequencies.get(w) + " " + text);
    	}
    }
	
	public boolean isTweetBuzz(String text, String buzz){
    	String[] words = text.toLowerCase().split(" ");

    	buzz = buzz.replaceAll("\\W", "");
     	
    	for (String w: Arrays.asList(words)){
    		w = w.replaceAll("\\W", ""); 
    		if( buzz.equals(w)) {
    			if (text.toLowerCase().contains(query.toLowerCase()))
    				return true;
    			else
    				continue;
    		}
    	}
    	
    	return false;
    }
    
    public String getBuzz(){
    	Iterator iterator = frequencies.keySet().iterator();  

//    	String topResults[] = new String[5];
//    	for (int i = 0; i<topResults.length ; i++)
//    		topResults[i]= "";
    	
    	int value = 0;
    	String highestKey = "";
    	String secondHighestKey = "";
    	int secondValue = 0;
    	String thirdHighestKey = "";
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
    			if(thirdHighestKey != "")
    				thirdValue = frequencies.get(thirdHighestKey);
    			secondHighestKey = highestKey;
    			if(secondHighestKey != "")
    				secondValue = frequencies.get(secondHighestKey);
    			highestKey = key;
    			continue;
    		}

    		if (secondValue <= tmpValue){
    			thirdHighestKey = secondHighestKey;
    			secondHighestKey = key;
    			if(thirdHighestKey != "")
    				thirdValue = secondValue = frequencies.get(thirdHighestKey);
    			if(secondHighestKey != "")
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
		
		String buzzMsg = highestKey;
		
		if ( frequencies.get(highestKey) == frequencies.get(secondHighestKey)){
			buzzMsg = highestKey + " " + secondHighestKey;
		}else
			System.out.println("QUERY = " + this.query);
			if(this.query.toLowerCase().contains(highestKey.toLowerCase())){
				System.out.println("QUERY2");
				if(this.query.toLowerCase().contains(secondHighestKey.toLowerCase())){
					System.out.println("QUERY3");
					buzzMsg = thirdHighestKey;
				}else{
					System.out.println("QUERY4");
					buzzMsg = secondHighestKey;
				}
			}
				
		
		return buzzMsg;
    }

}


