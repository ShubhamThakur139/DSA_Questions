package backtracking;

import java.util.ArrayList;
import java.util.List;

public class GeneratePermutation {
    public static void main(String[] args) {
        int n = 3;
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), n);
        System.out.println(list);
    }

    private static void backtrack(List<List<Integer>> list, List<Integer> temp, int n) {
        if (temp.size() == n) {
            list.add(new ArrayList<>(temp));
            return;
        } else {
            for (int i = 1; i <= n; i++) {
                if (temp.contains(i))
                    continue;
                temp.add(i);
                backtrack(list, temp, n);
                temp.remove(temp.size() - 1);
            }
        }
    }
}
