package Phase1;

import java.util.*;

public class Collections {
	public static void main(String[] args) {

		//ArrayList
		ArrayList al = new ArrayList();
		al.add(48);
		al.add("Delhi");
		al.add(68.45f);
		System.out.println("ArrayList: "+al);

		//LinkedList
		LinkedList ll = new LinkedList();
		ll.add(78);
		ll.add("Banglore");
		ll.add(87.5f);
		System.out.println("\nLinkedList: "+ll);

		//HashSet
		HashSet<Integer> h = new HashSet<Integer>();
		h.add(4568);
		h.add(456);
		h.add(358);
		h.add(1254);

		System.out.println("\nHashSet:");
		Iterator<Integer> itr=h.iterator();  
		while(itr.hasNext()){  
			System.out.print(itr.next()+" "); 
		}
		System.out.println();
		//TreeSet
		TreeSet<Integer> t = new TreeSet<Integer>();
		t.add(45);
		t.add(48);
		t.add(42);
		t.add(32);
		t.add(15);
		t.add(10);
		t.add(59);
		System.out.println("\nTreeset: "+t);
		
		//LinkedHashSet
		LinkedHashSet ls = new LinkedHashSet<>();
		ls.add(45);
		ls.add(48);
		ls.add(42);
		ls.add(32);
		ls.add(15);
		ls.add(10);
		ls.add(59);
		System.out.println("\nLinkedHashSet: "+ls);
		
		//ArrayDeque
		ArrayDeque ad = new ArrayDeque();
		ad.add(15);
		ad.add(48);
		ad.add(448.45f);
		ad.addFirst("java");
		ad.add(98);
		System.out.println("\nArrayDeque: "+ad);
	}
}
