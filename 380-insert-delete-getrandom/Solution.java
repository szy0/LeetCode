import java.util.*;

class RandomizedSet {
    private Map<Integer, Integer> map; // entry <val, index in list>
    private List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        else {
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        else {
            int index = map.get(val); // an empty postion in the list
            map.remove(val);
            if (index != list.size() - 1) {
                list.set(index, list.get(list.size() - 1)); // fill the position with the last element in the list
                map.replace(list.get(index), index); // the index for the element changed.
            }
            list.remove(list.size() - 1);
            return true;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        int e = new Random().nextInt(list.size());
        return list.get(e);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */