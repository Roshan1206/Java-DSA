package basic;

import java.util.Arrays;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("Hello World"));
        System.out.println(isPalindrome("abcba"));
        System.out.println(isPalindrome("12321"));
    }

    public static boolean isPalindrome(String string){
//        String reverseString = Arrays.stream(string.split("")).toList().reversed().toString();
        StringBuilder reverseString = new StringBuilder(string).reverse();
//        return string.equalsIgnoreCase(reverseString);
        return string.equalsIgnoreCase(String.valueOf(reverseString));
    }
}
