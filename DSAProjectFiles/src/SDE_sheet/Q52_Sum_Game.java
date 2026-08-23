package SDE_sheet;

public class Q52_Sum_Game {
    public boolean sumGame(String num) {
        int length=num.length();
        int sum=0;
        int sum2=0;
        int q1=0;
        int q2=0;
        for(int i=0;i<length;i++){
            char ch= num.charAt(i);
            if(i<length/2){
                if(ch=='?') q1++;
                else sum+=(ch-'0');
            }else{
                if(ch=='?') q2++;
                else sum2+=(ch-'0');
            }
        }
        int totalq=q1+q2;
        if(totalq %2 !=0){
            return true;
        }
        double target=sum2-sum;
        double advantage=4.5*(q1-q2);
        if(target==advantage){
            return false;
        }




        return true;
    }
}
