import java.util.HashMap;
import java.util.LinkedList;

public class Warmest<K,V> {
	LinkedList<K> warmset = null;
	HashMap<K, V> hm = null;
	public Warmest(){
		super();
		warmset  = new LinkedList<K>();
		hm = new HashMap<K, V>();
		
	}
	public V getWarmest() { //O(1)
		return hm.get(warmset.getFirst()); //O(1)
	}
	public V get(K k) { //O(1)
		V val = hm.get(k);//O(1)
		if(val==null)
			return null;
		if(!warmset.getFirst().equals(k)) { //O(1)
			warmset.remove(k); //O(1)
			warmset.offerFirst(k); //O(1)
		}
		return val;
	}
	public void put(K k, V v) { //O(n)
		if(warmset.contains(k)) //O(n)
			warmset.remove(k); //O(1)
		warmset.offerFirst(k); //O(1)
		hm.put(k, v); //O(1)
	}
	public V remove(K k) { //O(1)
		warmset.remove(k); //O(1)
		return hm.remove(k); //O(1)
	}
	public String toString() {
		return hm.toString()+"\t"+warmset.toString();
	}
}
