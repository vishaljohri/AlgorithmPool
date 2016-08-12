import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class RandomizedCollectionWithDuplicates {
	 
    HashMap<Integer, Set<Integer>> hm;
    List<Integer> list;
    /** Initialize your data structure here. */
    public RandomizedCollectionWithDuplicates() {
        hm = new HashMap<>();
        list = new ArrayList<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        int loc = list.size();
        if(!hm.containsKey(val)) {
            Set<Integer> set = new HashSet<>();
            set.add(loc);
            hm.put(val, set);
            list.add(val);
            return true;
        }
        else {
            hm.get(val).add(loc);
            list.add(val);
            return false;
        }
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!hm.containsKey(val)) {
            return false;
        }
        else {
            Set<Integer> set = hm.get(val);
            int loc = set.iterator().next();
            int lastElement = list.get(list.size() - 1);;
            if(loc < list.size() - 1) {
                list.set(loc, lastElement);
                hm.get(lastElement).remove(list.size() - 1);
                hm.get(lastElement).add(loc);
            }
            if(lastElement != val || loc == list.size() - 1);
            	set.remove(loc);
            if(set.size() == 0)
                hm.remove(val);
            list.remove(list.size() - 1);
            return true;
        }
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        int loc = (int) (Math.random() * list.size());
        return list.get(loc);
    }
}

public class RandomizedSet {
	HashMap<Integer, Integer> hm;
	ArrayList<Integer> list;
    public RandomizedSet() {
        hm = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(hm.containsKey(val))
        	return false;
        hm.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!hm.containsKey(val))
        	return false;
        int loc = hm.get(val);
        if(loc < list.size() - 1) {
        	int temp = list.get(list.size() - 1);
        	list.set(loc, temp);
        	hm.put(temp, loc);
        }
        hm.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    public int getRandom() {
    	return list.get((int) (Math.random() * list.size()));
    }
    
	public static void main(String[] args) {
		RandomizedSet rs = new RandomizedSet();
		System.out.println(rs.insert(1));
		System.out.println(rs.insert(5));
		System.out.println(rs.insert(7));
		System.out.println(rs.insert(1));
		System.out.println(rs.insert(4));
		System.out.println(rs.remove(1));
		System.out.println(rs.insert(8));
		System.out.println(rs.getRandom());		

	}

}
