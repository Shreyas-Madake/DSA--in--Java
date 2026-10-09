package SDE_sheet;

public class Q68_removeOuterParentheses {
    public String removeOuterParentheses(String s) {
        StringBuilder ans=new StringBuilder();
        int depth=0;
        for(char ch: s.toCharArray()){
            if(ch=='('){
                if(depth!=0){
                    ans.append('(');
                }
                depth++;
            }
            else if(ch==')'){
                depth--;
                if(depth!=0){
                    ans.append(')');
                }
            }
        }
        return ans.toString();

    }
}
