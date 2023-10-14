import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class MyHashMap<K, V> implements Map<K, V> {
	private static final int INITIAL_NUM_BUCKETS = 4;

	private int size = 0;
	private double loadFactorThreshold = 0.5;
	private List<Entry<K, V>>[] buckets;

	private static class Entry<K, V> implements Map.Entry<K, V> {
		K key;
		V value;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		@Override
		public K getKey() {
			return key;
		}

		@Override
		public V getValue() {
			return value;
		}

		@Override
		public V setValue(V value) {
			V oldValue = this.value;
			this.value = value;
			return oldValue;
		}
	}

	public MyHashMap() {
		buckets = new LinkedList[INITIAL_NUM_BUCKETS];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean containsKey(Object key) {
		if (get(key) != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean containsValue(Object value) {
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] != null) {
				List<Entry<K, V>> bucket = buckets[i];
				for (Entry<K, V> entry : bucket) {
					if (entry.getValue().equals(value)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public V get(Object key) {
		Integer bucketIndex = Math.abs(key.hashCode()) % buckets.length;
		List<Entry<K, V>> bucket = buckets[bucketIndex];
		if (bucket != null) {
			for (Entry<K, V> entry : bucket) {
				if (entry.getKey().equals(key)) {
					return entry.getValue();
				}
			}
		}
		return null;
	}

	@Override
	public V put(K key, V value) {
		int bucketIndex = Math.abs(key.hashCode()) % buckets.length;
		List<Entry<K, V>> bucket = buckets[bucketIndex];
		if (bucket == null) {
			bucket = new LinkedList<Entry<K, V>>();
			buckets[bucketIndex] = bucket;
		}
		for (Entry<K, V> entry : bucket) {
			if (entry.getKey().equals(key)) {
				V oldValue = entry.getValue();
				entry.value = value;
				return oldValue;
			}
		}

		bucket.add(new Entry<K, V>(key, value));
		size++;

		// Homework part 1:
		// Check if load factor has exceeded the load factor threshold
		// Take action if it has, rehash()
		if (size > (buckets.length * loadFactorThreshold)) {
			rehash();
		}
		return value;
	}

	// New rehash method for expanding hashmap once half full.
	// Homework part 1
	private void rehash() {
		LinkedList<Entry<K, V>>[] newBuckets = new LinkedList[buckets.length * 2];

		size = 0;

		Set<K> set = keySet();

		for (K key : set) {
			V value = get(key);

			int bucketIndex = Math.abs(key.hashCode()) % newBuckets.length;
			LinkedList<Entry<K, V>> bucket = newBuckets[bucketIndex];
			if (bucket == null) {
				bucket = new LinkedList<Entry<K, V>>();
				newBuckets[bucketIndex] = bucket;
			}

			bucket.add(new Entry<K, V>(key, value));
			size++;
		}

		buckets = newBuckets;
	}

	@Override
	public V remove(Object key) {
		int bucketIndex = Math.abs(key.hashCode()) % buckets.length;
		List<Entry<K, V>> bucket = buckets[bucketIndex];
		if (bucket != null) {
			for (Entry<K, V> entry : bucket) {
				if (entry.getKey().equals(key)) {
					V value = entry.getValue();
					bucket.remove(entry);
					size--;
					return value;
				}
			}
		}
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> m) {
		// TODO Auto-generated method stub

	}

	@Override
	public void clear() {
		for (List<Entry<K, V>> bucket : buckets) {
			bucket = null;
		}
		size = 0;
	}

	@Override
	public Set<K> keySet() {
		Set<K> set = new HashSet<K>();
		for (int i = 0; i < buckets.length; i++) {
			if (buckets[i] != null) {
				List<Entry<K, V>> bucket = buckets[i];
				for (Entry<K, V> entry : bucket) {
					set.add(entry.getKey());
				}
			}
		}
		return set;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

}
