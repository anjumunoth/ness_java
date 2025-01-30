package ECommerceApp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MapExamples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
		hashMap.put("sara", 101);
		hashMap.put("tara", 102);
		hashMap.put("lara", 103);
		hashMap.put("ram", 104);
		System.out.println("Initial content" + hashMap);// nitial content{lara=103, sara=101, tara=102, ram=104}
		hashMap.put("sara", 110);
		System.out.println("content after modification" + hashMap);// content after modification{lara=103, sara=110,
																	// tara=102, ram=104}
		hashMap.put("SARA", 999);
		System.out.println("content after modification" + hashMap);// content after modification{lara=103, sara=110,
																	// tara=102, SARA=999, ram=104}
		List<Integer> numbers = IntStream.rangeClosed(1, 100).boxed().collect(Collectors.toList());

		// Partition the numbers into ranges
		Map<String, List<Integer>> partitionedNumbers = numbers.stream().collect(Collectors.groupingBy(number -> {
			if (number <= 30) {
				return "0-30";
			} else if (number <= 60) {
				return "31-60";
			} else {
				return "61-100";
			}
		}));// partitionedNumbers -- data stored internally -- hashmap,
		HashMap<String, List<Integer>> partitionedNumbersinHashMap = new HashMap<String, List<Integer>>(
				partitionedNumbers);
		// for converting one map type to hashmap using this constructor

		partitionedNumbersinHashMap.forEach((range, nums) -> {
			System.out.println("Range " + range + ": " + nums);
		});

		for (Map.Entry<String, List<Integer>> entry : partitionedNumbersinHashMap.entrySet()) {
			System.out.println("Key" + entry.getKey());
			System.out.println("Value" + entry.getValue());
			System.out.println("Entry" + entry.toString());
		}

		for (String key : partitionedNumbersinHashMap.keySet()) {
			System.out.println("Key" + key);
			System.out.println("Value" + partitionedNumbersinHashMap.get(key));

		}
		int i = 10;
		String str1 = new String(String.valueOf(i));

		ArrayList<Integer> arr1 = new ArrayList<Integer>();
		arr1.add(10);
		arr1.add(20);
		arr1.add(30);
		arr1.add(40);

		Iterator<Integer> iter = arr1.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
			// create an exception
//			arr1.add(35);
			arr1.set(0, 99);
		}
		System.out.println("after modification" + arr1);
		for (Map.Entry<String, List<Integer>> entry : partitionedNumbersinHashMap.entrySet()) {
			System.out.println("Key" + entry.getKey());
			System.out.println("Value" + entry.getValue());
			System.out.println("Entry" + entry.toString());
			entry.setValue(Arrays.asList(1, 2, 3));

		}
		System.out.println("After modifications");
		for (String key : partitionedNumbersinHashMap.keySet()) {
			System.out.println("Key" + key);
			System.out.println("Value" + partitionedNumbersinHashMap.get(key));

		}

		System.out.println("LinkedHashmap ");
		LinkedHashMap<String, Integer> linkedHashMapWithInsertionOrder = new LinkedHashMap<String, Integer>();
		linkedHashMapWithInsertionOrder.put("sara", 101);
		linkedHashMapWithInsertionOrder.put("tara", 102);
		linkedHashMapWithInsertionOrder.put("lara", 103);
		linkedHashMapWithInsertionOrder.put("ram", 104);
		System.out.println("Initial content" + linkedHashMapWithInsertionOrder);

		linkedHashMapWithInsertionOrder.remove("sara");
		System.out.println("content after modification" + linkedHashMapWithInsertionOrder);

		Map<String, String> lruCache = new LinkedHashMap<>(5, 0.75f, true) {
			protected boolean removeEldestEntry(Map.Entry<String, String> eldest) {
				return size() > 5; // Maximum size of 5 entries
			}
		};
		lruCache.put("sara", "101");
		lruCache.put("tara", "102");
		lruCache.put("lara", "103");
		lruCache.put("ram", "104");
		lruCache.put("jack", "105");
		System.out.println("Initial content" + lruCache);
		lruCache.get("sara");
		lruCache.get("tara");
		lruCache.put("jill", "106");
		System.out.println("content after modification" + lruCache);

	}

}
// Solution : Concurrenthashmap , CopyOnWriteArrayList 
/*
 * Change the existing key of a element in a hash map --no ; key can never be
 * modified -- yes ; remove that key and add a new key -- during iteration --
 * throw an exception
 * 
 * -- structure (data)
 * 
 * Linked list -- iteration ; modify the value -- no exception
 * 
 * 
 */
