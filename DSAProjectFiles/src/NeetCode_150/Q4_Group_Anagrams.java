package NeetCode_150;

import java.util.*;

public class Q4_Group_Anagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0){
            return new ArrayList();
        }
        Map<String,List>ansmap=new HashMap<>();
        int [] count= new int[26];//To create an array to store Alphabate
        for(String s:strs){
            Arrays.fill(count,0);//To fill all the array places as zero
            for(char c:s.toCharArray()){
                count[c-'a']++;/*To put 1 in all the places in array where character of
                that str is present*/
            }
            StringBuilder sb= new StringBuilder("");
            for(int i=0;i<26;i++){
                sb.append("#");
                sb.append(count[i]);
            }
            String key=sb.toString();
            if(!ansmap.containsKey(key)){
                ansmap.put(key, new ArrayList());
            }
            ansmap.get(key).add(s);
        }
        return new ArrayList(ansmap.values());

    }
}
