package NeetCode_150;

public class Q11_Valid_Palindrome {
    public boolean isalphanumericCharacter(char c) {
        return (c>='a'&& c<='z')||
                (c>='A'&& c<='Z')||
                (c>='0'&& c<='9');
    }
    public boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j){
            char c1=s.charAt(i);
            char c2=s.charAt(j);
            if(!isalphanumericCharacter(c1)){
                i=i+1;
                continue;
            }
            if(!isalphanumericCharacter(c2)){
                j=j-1;
                continue;
            }
            if( Character.toLowerCase(c1)!= Character.toLowerCase(c2)){
                return false;
            }
            i=i+1;
            j=j-1;
        }
        return true;
    }

}
