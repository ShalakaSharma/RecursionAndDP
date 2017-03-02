package problems;

import java.util.ArrayList;

public class PowerSet {
	public static void main(String[] args) {
		
		ArrayList<Integer> set = new ArrayList<Integer>();
		
		set.add(10);
		set.add(20);
		
		ArrayList<ArrayList<Integer>> powerset = getSubsets(set, 0);
		
		System.out.println(powerset);
	}

	public static ArrayList<ArrayList<Integer>> getSubsets(
			ArrayList<Integer> set, int index) {

		ArrayList<ArrayList<Integer>> allsubsets;
		if (index == set.size()) {
			allsubsets = new ArrayList<ArrayList<Integer>>();
			allsubsets.add(new ArrayList<Integer>()); // Empty Subset
		} else {
			allsubsets = getSubsets(set, index + 1);
			int item = set.get(index);
			ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<ArrayList<Integer>>();
			for(ArrayList<Integer> subset: allsubsets) {
				ArrayList<Integer> newsubset = new ArrayList<Integer>();
				newsubset.addAll(subset);
				newsubset.add(item);
				moresubsets.add(newsubset);
			}
			allsubsets.addAll(moresubsets);
		}
		return allsubsets;
	}
}
