package Array_String;

import java.util.*;

public class RandomizedSet {
            /*
                    Arraylist    HashMap
        insert          O(1)       O(1)
        remove          O(n)       O(1)
        get random      O(1)       O(n)
         */

    List<Integer> list;
    Map<Integer, Integer> map;
    Random random = new Random();


    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val))
            return false;
        map.put(val, list.size());
        list.add(val);
        return true;

    }

    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        int pos = map.get(val);
        if (pos != (list.size() - 1)) {
            int lastElement = list.get(list.size() - 1);
            list.set(pos, lastElement);
            map.put(lastElement, pos);
        }
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int randomInt = random.nextInt(list.size());
        return list.get(randomInt);
    }


    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();

        // Insert elements
        System.out.println(obj.insert(1)); // Output: true (1 is inserted)
        System.out.println(obj.insert(2)); // Output: true (2 is inserted)
        System.out.println(obj.insert(3)); // Output: true (3 is inserted)
        System.out.println(obj.insert(1)); // Output: false (1 is already present)

        // Remove elements
        System.out.println(obj.remove(2)); // Output: true (2 is removed)
        System.out.println(obj.remove(4)); // Output: false (4 is not present)

        // Get random element
        System.out.println(obj.getRandom()); // Output: Random element from the set [1, 3]

        // Insert another element
        System.out.println(obj.insert(4)); // Output: true (4 is inserted)

        // Get random element again
        System.out.println(obj.getRandom()); // Output: Random element from the set [1, 3, 4]
    }

}
