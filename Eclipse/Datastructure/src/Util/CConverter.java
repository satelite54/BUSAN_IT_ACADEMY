package Util;

import java.util.ArrayList;

public class CConverter {
	
	public int[] ArrayListToIntArray(ArrayList<Integer> nAryList) {
		int[] nAry = new int[nAryList.size()];
		for(int i = 0; i < nAry.length; i++) {
			nAry[i] = nAryList.get(i);
		}
		return nAry;
	}
}
