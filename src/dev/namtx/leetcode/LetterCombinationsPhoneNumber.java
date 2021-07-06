package dev.namtx.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations("5"));
    }

    public static List<String> letterCombinations(String digits) {
        HashMap<Character, String[]> mapping = new HashMap<>();
        mapping.put('2', new String[]{"a", "b", "c"});
        mapping.put('3', new String[]{"d", "e", "f"});
        mapping.put('4', new String[]{"g", "h", "i"});
        mapping.put('5', new String[]{"j", "j", "l"});
        mapping.put('6', new String[]{"m", "n", "o"});
        mapping.put('7', new String[]{"p", "q", "r", "s"});
        mapping.put('8', new String[]{"t", "u", "v"});
        mapping.put('9', new String[]{"w", "x", "y", "z"});
        List<String> result = new ArrayList<>();

        backtrack(digits, mapping, result, "", 0);

        return result;
    }

    public static void backtrack(String digits, HashMap<Character, String[]> mapping, List<String> result, String temp, int i) {
        if (temp.length() == digits.length()) {
            result.add(temp);
            return;
        }

        Character c = digits.charAt(i);

        for (int j = 0; j < mapping.get(c).length; j++) {
            temp = temp.concat(mapping.get(c)[j]);
            backtrack(digits, mapping, result, temp, i+1);
            temp = temp.substring(0, temp.length() - 1);
        }
    }
}
