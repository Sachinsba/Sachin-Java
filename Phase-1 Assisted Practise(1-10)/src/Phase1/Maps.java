package Phase1;

import java.util.HashMap;
import java.util.TreeMap;

import javax.swing.text.html.HTML;

public class Maps {
	public static void main(String[] args) {
		
		//HashMap
		HashMap h = new HashMap();
		h.put(10, 100);
		h.put(13, "Sachin");
		h.put(15.6, 150);
		h.put(15, true);
		h.put(false, 175.67);
		h.put(11, 250);
		System.out.println(h);
		
		System.out.println();
		
		//TreeMap
		TreeMap t = new TreeMap<>();
		t.put(10, "Sachin");
		t.put(45, 123654);
		t.put(15, "delhi");
		t.put(12, 4789);
		t.put(65, "Ayush");
		System.out.println(t);
	}
}
