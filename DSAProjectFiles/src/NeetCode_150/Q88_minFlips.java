package NeetCode_150;

public class Q88_minFlips {
    public int minFlips(String s) {
        int n=s.length();
        s=s+s;
        // will make s1 like s1="0101010101"
        //will make s2 like s2="101010101010"
        StringBuilder s1=new StringBuilder();
        StringBuilder s2=new StringBuilder();
        for(int i=0;i<2*n;i++){
            s1.append(i%2==0?'0':'1');
            s2.append(i%2==0?'1':'0');
        }
        // now our khandani Sliding Window
        int result=Integer.MAX_VALUE;
        int flip1=0;
        int flip2=0;
        int i=0;
        int j=0;
        while(j<2*n){
            if(s.charAt(j)!=s1.charAt(j)) flip1++;
            if(s.charAt(j)!=s2.charAt(j)) flip2++;
            //shrink the window from left if window size exceeds n
            //here we will update the cont while shrinking
            if(j-i+1>n){
                if(s.charAt(i)!=s1.charAt(i)){
                    flip1--;
                }
                if(s.charAt(i)!=s2.charAt(i)){
                    flip2--;
                }
                i++;
            }
            // update result when window size equals n
            if(j-i+1==n){
                result=Math.min(result,Math.min(flip1,flip2));
            }
            j++;
        }
        return result;


    }
}
