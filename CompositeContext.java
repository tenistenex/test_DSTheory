package test_DSTheory;



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class CompositeContext {
	String contextName;
	public ArrayList member = new ArrayList<>();
	
	Map<String, Double> set = new HashMap<String, Double>();
	
	public CompositeContext(String contextName){
		this.contextName = contextName;
	}
	
	public void addMember(Sensor s){
		member.add(s);
	}
	
	public void addMember(ContextA a){
		member.add(a);
	}
	
	public void addMember(ContextB b){
		member.add(b);
	}
	
	
}
