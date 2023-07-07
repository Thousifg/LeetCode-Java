class Solution {
    public String restoreString(String s, int[] arr) {
        int len=arr.length;
        String []s1=new String[len];
        StringBuilder a=new StringBuilder();
        
        for(int i=0;i<len;i++){
            s1[arr[i]]=String.valueOf(s.charAt(i));
        }
        for(String str1: s1){
            a.append(str1);
        }
        return a.toString();
        
    }
}