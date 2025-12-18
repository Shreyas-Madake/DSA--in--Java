package NeetCode_150;

import java.util.Stack;

public class Q20_Valid_Parentheses {
    public boolean isValid(String s) {
        Stack<Character> map= new Stack<>();

        for(char c:s.toCharArray()){
            if(c=='(' || c=='{' || c=='['){
                map.push(c);
            }

            else{
                if(c==')'){
                    if(map.isEmpty() || map.pop()!='('){
                        return false;
                    }
                }

                if(c=='}'){
                    if(map.isEmpty() || map.pop()!='{'){
                        return false;
                    }
                }

                if(c==']'){
                    if(map.isEmpty() || map.pop()!='['){
                        return false;
                    }
                }
            }
            //return map.isEmpty();
        }

        return map.isEmpty();
    }

}
