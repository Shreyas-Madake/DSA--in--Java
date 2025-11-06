package NeetCode_150;

import java.util.ArrayList;
import java.util.List;

public class Q9_encode_decode_string {
    public String encode(List<String> strs){
    StringBuilder encodedstring=new StringBuilder();
    for(String str:strs){
        encodedstring.append(str.length()).append("#").append(str);
    }
    return encodedstring.toString();
    }
    public List<String>decode(String str){
        List<String>decodedstring=new ArrayList<>();
        int i=0;
        while (i<str.length()){
            int sepIdx=str.indexOf("#",i);
            int len=Integer.parseInt(str.substring(i,sepIdx));
            i=sepIdx+1;
            String decode=str.substring(i,i+len);
            decodedstring.add(decode);
            i=i+len;
        }
        return decodedstring;
    }
}
