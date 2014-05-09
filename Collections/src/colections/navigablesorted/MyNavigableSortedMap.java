package colections.navigablesorted;

import java.util.NavigableMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class MyNavigableSortedMap {
	public static void main(String[] args) {
		NavigableMap<String, String> original = new TreeMap<>();
		original.put("1", "1");
		original.put("2", "2");
		original.put("3", "3");
		original.put("4", "4");
		original.put("5", "5");

		// this submap1 will contain "3", "3"
		SortedMap<String, String> submap1 = original.subMap("2", "4");

		for (String string : submap1.keySet()) {
			System.out.println(string);
		}

		// this submap2 will contain ("2", "2") ("3", "3") and ("4", "4")
		// because
		// fromInclusive=true, and toInclusive=true
		NavigableMap<String, String> submap2 = original.subMap("2", true, "4",
				true);
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		for (String string : submap2.keySet()) {
			System.out.println(string);
		}
	}
}
