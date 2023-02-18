import java.util.ArrayList;

public class SetOperations {
	//Complement (GOOD)
	public ArrayList<Integer> complement(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		for (int i = 0; i < list1.size(); i++) {
			if (list2.contains(list1.get(i))) 
				list2.remove(list1.get(i));
		}
		return list2;
	}
	//Intersection (GOOD)
	public ArrayList<Integer> intersection(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		ArrayList<Integer> unionList = new ArrayList<Integer>();
		
		for (int i = 0; i < list1.size(); i++) {
			if (list2.contains(list1.get(i)))
				unionList.add(list1.get(i));
		}
		
		return unionList;
	}
	//Union (GOOD)
	public ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		for (int i = 0; i < list1.size(); i++) {
			if (!list2.contains(list1.get(i)))
				list2.add(list1.get(i));
		}
		
		return list2;
	}
}
