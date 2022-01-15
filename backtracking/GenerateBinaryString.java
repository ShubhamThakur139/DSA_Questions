package backtracking;

public class GenerateBinaryString {
    public static void main(String[] args) {
        String str = "000";
        char arr[] = str.toCharArray();
        backtrack(0, arr);
    }

    private static void backtrack(int i, char arr[]) {
        System.out.println(String.valueOf(arr));

        for (int j = i; j < arr.length; j++) {
            arr[j] = '1';
            backtrack(j + 1, arr);
            arr[j] = '0';
        }
    }
}
