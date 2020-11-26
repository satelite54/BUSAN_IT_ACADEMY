package Sort;

public class CSort {
	public int[] StrAraytoIntAraybubbleSort(int a, String[] strAray) {
        int[] nAry = new int[a];
        for(int i = 0; i < strAray.length; i++) {
            nAry[i] = Integer.parseInt(strAray[i]);
        }
        nAry = bulbbleSort(nAry);
        return nAry;
	}
	public int[] bulbbleSort(int[] nAry) {
        for(int j = nAry.length - 1; j >= 0; j--) {
            for(int k = 0; k < j; k++) {
                if(nAry[k] > nAry[k+1]) {
                    int temp = nAry[k];
                    nAry[k] = nAry[k+1];
                    nAry[k+1] = temp;
                }
            }
        }
        return nAry;
	}
}
