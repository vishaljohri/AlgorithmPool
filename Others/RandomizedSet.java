
import java.util.ArrayList;
import java.util.HashMap;

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
