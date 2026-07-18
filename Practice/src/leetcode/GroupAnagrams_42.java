package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_42 {

    public static void main(String[] args) {
        String[] strings = {"eat","tea","tan","ate","nat","bat"};
        List<List<String>> res = approach2(strings);
        res.stream().forEach(System.out::println);
    }

    /**
     * Sort every string and then create a key value pair.
     * Key = sorted string. value = List of original string
     * add new string in the list.
     */
    public static List<List<String>> approach1(String[] strs) {
        Map<String, List<String>> map = new HashMap();
        for(String str: strs){
//            convert to char array and sort than convert back to string
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String s = new String(chars);

//            add new array list if key is not present
            map.putIfAbsent(s, new ArrayList<>());
//            get the list and add new value in it
            map.get(s).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static List<List<String>> approach2(String[] strings){
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strings){
//            creating the char array as key
            char[] chars = new char[26];
            for (char c: str.toCharArray()){
                chars[c - 'a']++;
            }
            String s = new String(chars);

//            add new array list if key is not present
            map.putIfAbsent(s, new ArrayList<>());
//            get the list and add new value in it
            map.get(s).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
