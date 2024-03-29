class Solution {
    public String convert(String s, int numRows) {
        StringBuilder res = new StringBuilder();
        if(numRows==1){
            return s;
        }
        int[] factors = new int[]{(numRows-1)*2,0};
        for (int j = 0; j < numRows; j++) {
            factors[1]=factors[0]-j*2;
            for (int i = 0; i <s.length() ; i+=factors[0]) {
                if(i+j<s.length()){
                    res.append(s.charAt(j + i));
                }
                if(j==0 || j==numRows-1){
                    continue;
                }
                if(j+i+factors[1]<s.length()){
                    res.append(s.charAt(j+i+factors[1]));
                }
            }
        }
        return res.toString();
    }
}