/*
 * CS2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Activity 30 - CollectionsDriver class
 */

import java.util.*;

public class CollectionsDriver {

    public static void main(String[] args) {

        // TODO: create a HashMap with the following associations:
        // 511:Joe, 923:Carla, 728:Paula, 298:Zion
        // print the HashMap using its toString implementation
        // note that the order or insertion (or of the keys) is not preserved
        Map hm = new HashMap<Integer, String>();
        hm.put(511, "Joe");
        hm.put(923, "Carla");
        hm.put(728, "Paula");
        hm.put(298, "Zion");
        System.out.println(hm);

        // TODO: now create a LinkedHashMap with the same associations
        // note than now the order of insertion is preserved
        Map lhm = new LinkedHashMap<Integer, String>();
        lhm.put(511, "Joe");
        lhm.put(923, "Carla");
        lhm.put(728, "Paula");
        lhm.put(298, "Zion");
        System.out.println(lhm);
        Set<Integer> keys = lhm.keySet();

        Iterator<Integer> it = keys.iterator();
        while (it.hasNext()) {
            Integer key = it.next();
            System.out.println(key + ":" + lhm.get(key));
        }
        System.out.println();

        lhm.remove(511);
        lhm.put(511, "Joe");
        for (Integer key: keys) {
            System.out.println(key + ":" + lhm.get(key));
        }


        // TODO: now create a TreeMap with the same associations
        // note that the order of the keys is now preserved
        Map tm = new TreeMap<Integer, String>();
        tm.put(511, "Joe");
        tm.put(923, "Carla");
        tm.put(728, "Paula");
        tm.put(298, "Zion");
        System.out.println(tm);

        // TODO: create a LinkedList with the following elements:
        // Joe, Carla, Paula, Zion, Paula
        // print the LinkedList using its toString implementation
        // note that duplicates are allowed
        List ll = new LinkedList<String>();
        String joe   = "Joe";
        String carla = "Carla";
        String paula = "Paula";
        String zion  = "Zion";
        ll.add(joe);
        ll.add(carla);
        ll.add(paula);
        ll.add(zion);
        ll.add(paula); // duplicates allowed!!!
        System.out.println("ll: " + ll);

        // TODO: now create a HashSet with the same elements
        // note that duplicates are not allowed anymore
        // also note that the order or insertion (or of the keys) is not preserved
        Set hs = new HashSet<String>();
        hs.add(joe);
        hs.add(carla);
        hs.add(paula);
        hs.add(zion);
        hs.add(paula); // duplicates not allowed!!!
        System.out.println("hs: " + hs);

        // TODO: now create a LinkedHashSet with the same elements
        // note that duplicates are still not allowed
        // also note that now the order of insertion is preserved
        Set lhs = new LinkedHashSet<String>();
        lhs.add(joe);
        lhs.add(carla);
        lhs.add(paula);
        lhs.add(zion);
        lhs.add(paula); // duplicates not allowed!!!
        System.out.println(lhs);

        // TODO: finally create a TreeSet with the same elements
        // note that duplicates are still not allowed
        // also note that now the elements are sorted
        Set ts = new TreeSet<String>();
        ts.add(joe);
        ts.add(carla);
        ts.add(paula);
        ts.add(zion);
        ts.add(paula); // duplicates not allowed!!!
        System.out.println(ts);
    }
}
