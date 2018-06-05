package test_DSTheory;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class CompositeContext {
	String contextName;
	public ArrayList<Context> member = new ArrayList<Context>();
	
	Map<String, Double> set = new HashMap<String, Double>();
	
	public CompositeContext(String contextName){
		this.contextName = contextName;
	}
	
	public void addMember(Context a){
		member.add(a);
	}
	
}
