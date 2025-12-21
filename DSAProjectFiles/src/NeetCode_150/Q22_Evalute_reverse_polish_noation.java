package NeetCode_150;
import java.util.Stack;

public class Q22_Evalute_reverse_polish_noation {
    public int evalRPN(String[] tokens) {
        String exprstr= "*/-+";
        Stack <Integer> stack=new Stack<>();

        for(int i=0;i<tokens.length;i++){
            String token=tokens[i];

            if(exprstr.contains(token)){
                int op2=stack.pop();
                int op1=stack.pop();
                int val=0;

                switch(token){

                    case "+":
                        val=op1+op2;
                        break;

                    case "-":
                        val=op1-op2;
                        break;

                    case "*":
                        val=op1*op2;
                        break;

                    case "/":
                        val=op1/op2;
                        break;
                }
                stack.push(val);
            }
            else{
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();

    }
}
