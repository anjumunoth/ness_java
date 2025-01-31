package ECommerceApp;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

public class MapExamples2 {
	public static void main(String args[]) {
		TreeMap<Integer, String> treeMap = new TreeMap<>();
		treeMap.put(101, "sara");
		treeMap.put(99, "tara");
		treeMap.put(67, "lara");
		treeMap.put(11, "ram");
		treeMap.put(45, "jack");
		System.out.println("Initial content" + treeMap);

		treeMap.put(77, "john");
		System.out.println("After modification" + treeMap);
		treeMap.remove(99);
		System.out.println("After modification" + treeMap);

		TreeMap<String, String> treeMap1 = new TreeMap<>();
		treeMap1.put("101", "sara");
		treeMap1.put("99", "tara");
		treeMap1.put("67", "lara");
		treeMap1.put("11", "ram");
		treeMap1.put("45", "jack");

		ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>(100, 0.75f, 16);
		map.put("A", "Apple");
		map.putAll(treeMap1);
		System.out.println("Initial content" + map);

		map.put("A", "hari");
		System.out.println("After modification" + map);// A="hari"
		map.putIfAbsent("A", "girish");
		System.out.println("After modification" + map);// A="hari"
		String res = map.getOrDefault("Z", "");
		System.out.println("Value of Z" + res);// Z=""
		map.putIfAbsent("Z", "girish");
		res = map.getOrDefault("Z", "");
		System.out.println("Value of Z" + res);// Z="girish"

		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + "->" + entry.getValue());
			map.put("G", "Good");
		}
		System.out.println("After modification" + map);//

		HashMap<Products, String> prCategory = new HashMap<Products, String>();
		Products p1 = new Products(1, 1500, 50, 10, "Laptop", "High performance laptop", "Black", "E001");
		Products p2 = new Products(2, 500, 100, 5, "Smartphone", "Latest model smartphone", "Blue", "E002");
		Products p3 = new Products(3, 200, 30, 0, "Headphones", "Noise-cancelling headphones", "Red", "A003");
		Products p4 = new Products(4, 700, 20, 15, "Smartwatch", "Fitness tracking smartwatch", "White", "E004");
		Products p5 = new Products(5, 100, 200, 20, "USB Drive", "32GB USB flash drive", "Silver", "A005");

		prCategory.put(p1, "E001");
		prCategory.put(p2, "E002");
		prCategory.put(p3, "E003");
		prCategory.put(p4, "E001");
		prCategory.put(p5, "E001");
		System.out.println("PrMap " + prCategory);

		p1 = null;
		System.gc();
		System.out.println("PrMap " + prCategory);// will it have p1;

		WeakHashMap<Products, String> prCategoryWHM = new WeakHashMap<Products, String>(prCategory);
		System.out.println("Weak hash map" + prCategoryWHM);// will it have p1;
		Products p6 = new Products(6, 100, 50, 10, "Pad", "High performance laptop", "Black", "E001");
		prCategoryWHM.put(p6, "E1002");
		System.out.println("Weak hash map" + prCategoryWHM);// will it have p1;

		p6 = null;//
		p5 = null;// p5 will stay in memory because it is referenced in prCategory; Hence not
					// removed from prCategoryWHM
		System.gc();// explicitly calling it
		System.out.println("Weak hash map" + prCategoryWHM);// will it have p6 -- no; entry for p6 will be deleted
															// implicitly

		Products prod1 = new Products(1, 1500, 50, 10, "Laptop", "High performance laptop", "Black", "E001");
		;
		prod1 = null;// why is it garbage collected -- point prod1 to nothing; end the scope of
						// object; since scope is over -- garbage collected

		prod1 = new Products(1, 1500, 50, 10, "Laptop", "High performance laptop", "Black", "E001");
		// Create a new object and make prod1 point to it

	}
}
