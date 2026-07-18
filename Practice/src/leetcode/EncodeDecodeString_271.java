package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeString_271 {

    public static void main(String[] args) {
        System.out.println(decode(encode(Arrays.asList("Hello", "World", "Welcome"))));
    }

    public static String encode(List<String> strings) {
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s.length()).append("#").append(s);
        }
        return sb.toString();
    }

    public static List<String> decode(String s){
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < s.length()){
            int j = i;
            while (s.charAt(j) != '#') j++;
            int len = Integer.parseInt(s.substring(i, j));
            result.add(s.substring(j+1, j+1+len));
            i=j+1+len;
        }
        return result;

    }
}
