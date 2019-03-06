import java.util.LinkedHashMap;

public class LRUCache<K,V> extends LinkedHashMap<K, V> {
	
	public static void main(String[] args) {
		LRUCache<Integer,String> lruCache = new LRUCache<Integer,String>(5);
		lruCache.put(1, "One");
		lruCache.put(2, "Two");
		lruCache.put(3, "Three");
		lruCache.put(4, "Four");
		lruCache.put(5, "Five");
		
		System.out.println("lruCache==" + lruCache);
		lruCache.put(6, "Six");
		System.out.println("lruCache after six==" + lruCache);
		
		lruCache.get(2);
		lruCache.put(7, "Seven");
		System.out.println("lruCache after seven==" + lruCache);
		
	}
	
	private int size;
	
	LRUCache(int size) {
		super(size,0.75f,true);
		this.size=size;
	}
	
	@Override
	protected boolean removeEldestEntry(java.util.Map.Entry<K, V> eldest) {
		// TODO Auto-generated method stub
		return size() > size;
	}
	
	
	
	

}
