package NeetCode_150;

public class Q2_Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        //Check the lengths of both strings
        if(s.length()!=t.length()){
            return false;
        }
        //create a array to count charcter frequencies
        int[] charcount = new int[26];//assuming only L.C english letters
        //Increment count for each character in 'S' and decrement for each in 'T'
        for(int i=0;i<s.length();i++){
            charcount[s.charAt(i) - 'a']++;
            charcount[t.charAt(i) - 'a']--;
        }
        //chech if count are zero
        for(int count:charcount){
            if(count!=0){
                return false;
            }

        }
        return true;
    }
}
