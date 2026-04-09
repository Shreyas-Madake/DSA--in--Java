package NeetCode_150;
import java.util.*;

public class Q70_Word_Ladder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList); // O(1) lookup now, we converted wordList is a     List  — so .contains() on it is O(n) and weare calling it thousands of times. that's what's causing TLE
        Queue<String> queue=new LinkedList<>();
        queue.add(beginWord);
        queue.add(null);
        //mark Vistited word
        Set<String> visited=new HashSet<>();
        visited.add(beginWord);
        int level=1;
        while(!queue.isEmpty()){
            String word=queue.poll();
            if(word==null){
                level++;
                if(!queue.isEmpty())
                    queue.add(null);
                continue;
            }

            // found the end word
            if(word.equals(endWord)) return level;
            // modify each character(so word distance is 1)
            for(int i=0;i<word.length();i++){
                char[] chars=word.toCharArray();
                for(char c='a';c<='z';c++){
                    chars[i]=c;
                    String newword=new String(chars);
                    //put it in the queue
                    if(wordSet.contains(newword)&& !visited.contains(newword)){

                        visited.add(newword);
                        queue.add(newword);
                    }
                }
            }

        }
        return 0;
    }
}
