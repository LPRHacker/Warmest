import java.util.LinkedList;

import javafx.util.Pair;

public class WarmestV2<K,V> {
	LinkedList<Pair<K,V>> warmset = null;
	public WarmestV2(){
		super();
		warmset  = new LinkedList<Pair<K,V>>();
		
	}
	public V getWarmest() { //O(1)
		return warmset.getLast().getValue(); //O(1)
	}
	public V get(K k) { //O(n)
		V val = null;
		int index=0;
		for(;index<warmset.size();index++) { //O(n)
			if(warmset.get(index).getKey().equals(k)){
				val = warmset.get(index).getValue();
				break;
			}
		}
			
		if(val==null && warmset.size()==index)
			return null;
		if(warmset.size()-1!=index) { //O(1)
			warmset.remove(index); //O(1)
			warmset.offerLast(new Pair<K, V>(k,val)); //O(1)
		}
		return val;
	}
	public void put(K k, V v) { //O(n)
		for(Pair<K, V> p:warmset) { //O(n)
			if(p.getKey().equals(k)) //O(1)
				warmset.remove(p); //O(1)
		}
		
		warmset.offerLast(new Pair<K, V>(k, v)); //O(1)
		
	}
	public V remove(K k) { //O(n)
		V v = null;
		int index=0;
		for(;index<warmset.size();index++) { //O(n)
			if(warmset.get(index).getKey().equals(k)) //O(1)
				v = warmset.remove(index).getValue(); //O(1)
		}
		return v; //O(1)
	}
	public String toString() {
		return warmset.toString();
	}
}
