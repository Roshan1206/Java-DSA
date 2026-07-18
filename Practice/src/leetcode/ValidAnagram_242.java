package leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * {@link https://leetcode.com/problems/valid-anagram/description/}
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 */
public class ValidAnagram_242 {

    public static void main(String[] args) {
        String s= "anagram";
        String t = "anragam";
        System.out.println(approach3(s, t));
    }

    /**
     * Create 2 maps, add char as key and no of elements as values in both.
     * Iterate through 1 map and check whether that key is present with same value or not.
     */
    public static boolean approach1(String s, String t) {
        if (s.length() != t.length())
            return false;

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (char c : s.toCharArray()){
            sMap.put(c, sMap.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : sMap.entrySet()){
            char c = entry.getKey();
            if (tMap.containsKey(c)){
                if (entry.getValue() != tMap.get(c)){
                    return false;
                }
            } else return false;
        }
        return true;
    }

    /**
     * Create a map and add char as key and no of occurrence as value from 1 string.
     * Iterate through other string and check whether that char is present or not.
     * If present decrement the value. if value = 1, remove key
     * At the end if map is empty, than it is anagram else not
     */
    public static boolean approach2(String s, String t) {
        if(s.length() != t.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(char c: t.toCharArray()){
            if(!map.containsKey(c))
                return false;
            if(map.get(c)==1){
                map.remove(c);
            }else{
                map.put(c, map.get(c)-1);
            }
        }
        return map.isEmpty();
    }

    /**
     * Convert both string into char array and sort them.
     * Iterate through 1 array and check whether the same value is present at same index in other array
     */
    public static boolean approach3(String s, String t){
        if (s.length() != t.length()){
            return false;
        }

        char[] sCharArray = s.toCharArray();
        Arrays.sort(sCharArray);
        char[] tCharArray = t.toCharArray();
        Arrays.sort(tCharArray);

        for (int i = 0; i < sCharArray.length; i++) {
            if (sCharArray[i] != tCharArray[i]){
                return false;
            }
        }
        return true;
    }
}
