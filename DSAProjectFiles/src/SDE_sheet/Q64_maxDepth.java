package SDE_sheet;

public class Q64_maxDepth {
    public int maxDepth(String s) {
        int max=0;
        int sum=0;
        for(char ch: s.toCharArray()){
            if(ch=='('){
                sum++;
                max=Math.max(max,sum);
            }else if(ch==')'){
                sum--;
            }
        }
        return max;

    }
}
