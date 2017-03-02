package problems;

import java.util.ArrayList;

public class PermWithoutDup {

	public static void main(String[] args) {
		ArrayList<ArrayList<String>> allPerms = new ArrayList<ArrayList<String>>();
		System.out.println(getPerms(new StringBuffer("abade"), allPerms,4).size());
	}
	public static ArrayList<String> getPerms(StringBuffer str, ArrayList<ArrayList<String>> allPerms, int position) {
		
		if(str == null || str.length() == 0) {
			return null;
		} 
		
		char c = str.charAt(position);
	
		if(allPerms.size() == position) {
			ArrayList<String> perms = new ArrayList<String>();
			perms.add(c+"");
			allPerms.add(perms);
		} else {
			ArrayList<String> perms = getPerms(str, allPerms, position-1);
			ArrayList<String> newPerms = new ArrayList<String>();
			for(String p : perms) {
				StringBuffer sb = new StringBuffer(p);
				for(int i=0;i<p.length()+1;i++) {
					sb.insert(i, c);
					if(!newPerms.contains(sb)) {
						newPerms.add(sb.toString());
					}
					sb = new StringBuffer(p);
				}
			}
			allPerms.add(newPerms);
			
		}
		return allPerms.get(position);
	}
}
