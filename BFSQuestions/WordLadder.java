package BFSQuestions;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        String[] wordList = { "hot", "dot", "dog", "lot", "log", "cog" };
        int ans = ladderLength(beginWord, endWord, wordList);
        System.out.println(ans);
    }

    private static int ladderLength(String beginWord, String endWord, String[] wordList) {
        Set<String> set = new HashSet<>();
        for (String words : wordList) {
            set.add(words);
        }

        if (!set.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new LinkedList<>();

        q.add(beginWord);
        int depth = 0;
        while (!q.isEmpty()) {
            depth += 1;
            int q_size = q.size();
            while (q_size-- != 0) {
                String word = q.poll();
                // check for all possible 1 depth words
                for (int i = 0; i < word.length(); ++i) // For each index
                {
                    char[] temp = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; ++c) // Try all possible chars
                    {
                        temp[i] = c;
                        String str = String.valueOf(temp);
                        if (word.compareTo(str) == 0)
                            continue; // Skip the same word
                        if (str.compareTo(endWord) == 0)
                            return depth + 1; // endWord found
                        if (set.contains(str)) {
                            q.add(str);
                            set.remove(str);
                        }
                    }
                }
            }

        }

        return 0;
    }
}

// Given two words, beginWord and endWord, and a dictionary wordList, return the
// number of words in the shortest transformation sequence from beginWord to
// endWord, or 0 if no such sequence exists.