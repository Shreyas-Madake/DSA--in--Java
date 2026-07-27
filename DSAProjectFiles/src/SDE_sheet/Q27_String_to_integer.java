package SDE_sheet;

public class Q27_String_to_integer {
    public int myAtoi(String s) {
        long total=0;
        int sign=1;
        int index=0;
        if(s.length()==0) return 0;
        while(index<s.length()&& s.charAt(index)==' ') index++;
        // Safety check if string was all spaces (e.g., "   ")
        if (index >= s.length()) return 0;
        if(s.charAt(index)=='+'|| s.charAt(index)=='-'){
            sign= s.charAt(index) =='+'? 1:-1;
            index++;
        }
        while(index<s.length()){
            int digit=s.charAt(index)-'0'; // to convert it into digits
            if(digit<0 || digit>9) break;
            total=total*10 + digit;
            // these 2 check if the integer is out of 32_bit signed integer range
            if(sign*total>Integer.MAX_VALUE){// not sign * digit as digit will be only from 0 to 9
                return Integer.MAX_VALUE;
            }
            if(sign*total<Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }
            // total=total*10 + digit;// to take 123 separate and not to add it that is 1+2+3=6
            index++;
        }
        return (int)total*sign;
    }
}
