class Solution {
    public int reverse(int x) {
        long fNum = 0;
        while(x!=0){
            int lastDig = x%10;
            fNum += lastDig;
            fNum = fNum*10;
            x= x/10;
        }
        fNum = fNum/10;
        if(fNum > Integer.MAX_VALUE || fNum<Integer.MIN_VALUE){
            return 0;
        }
        if(x<0){
            return (int)(-1*fNum);
        }
        return (int)fNum;
    }
}