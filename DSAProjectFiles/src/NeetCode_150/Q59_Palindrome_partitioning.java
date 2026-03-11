package NeetCode_150;

import java.util.ArrayList;
import java.util.List;

public class Q59_Palindrome_partitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> res=new ArrayList<>();
        List<String> path=new ArrayList<>();
        fun(0,s,path,res);
        return res;
    }
    void fun(int index,String s,List<String> path, List<List<String>> res){
        if(index==s.length()){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=index;i<s.length();++i){
            if(isPalindrome(s,index,i)){
                path.add(s.substring(index,i+1));
                fun(i+1,s,path,res);
                path.remove(path.size()-1);
            }
        }
    }
    boolean isPalindrome(String s, int start,int end){
        while(start<=end){
            if(s.charAt(start++)!=s.charAt(end--)){
                return false;
            }
        }
        return true;
    }
}
