package String;
// Given an array of strings strs, group the anagrams together. You can return the answer in any order.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };

        List<List<String>> ans = groupAnagrams(strs);
        System.out.println(ans);
    }

    private static List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char carr[] = s.toCharArray();
            Arrays.sort(carr);
            String sortstr = String.valueOf(carr);
            if (!map.containsKey(sortstr)) {
                map.put(sortstr, new ArrayList<>());
            }

            map.get(sortstr).add(s);

        }

        return new ArrayList<>(map.values());
    }
}

// Input: strs = ["eat","tea","tan","ate","nat","bat"]
// Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

// Input: strs = [""]
// Output: [[""]]