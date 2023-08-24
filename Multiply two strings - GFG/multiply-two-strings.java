//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.math.*;

class Multiply{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            String a=sc.next();
            String b=sc.next();
            Solution g=new Solution();
            System.out.println(g.multiplyStrings(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String multiplyStrings(String s1,String s2)
    {
        //code here.
        boolean isNegative = false;

        if (s1.charAt(0) == '-' && s2.charAt(0) != '-') {
            isNegative = true;
            s1 = s1.substring(1);
        } else if (s1.charAt(0) != '-' && s2.charAt(0) == '-') {
            isNegative = true;
            s2 = s2.substring(1);
        } else if (s1.charAt(0) == '-' && s2.charAt(0) == '-') {
            s1 = s1.substring(1);
            s2 = s2.substring(1);
        }

        if (s1.equals("0") || s2.equals("0"))
            return "0";

        int[] res = new int[s1.length() + s2.length()];

        for (int i = s1.length() - 1; i >= 0; i--) {
            for (int j = s2.length() - 1; j >= 0; j--) {
                res[i + j + 1] += (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
                res[i + j] += res[i + j + 1] / 10;
                res[i + j + 1] %= 10;
            }
        }

        int i = 0;
        StringBuilder ans = new StringBuilder();
        while (i < res.length && res[i] == 0)
            i++;
        while (i < res.length)
            ans.append(res[i++]);

        return isNegative ? "-" + ans.toString() : ans.toString();
    }
}