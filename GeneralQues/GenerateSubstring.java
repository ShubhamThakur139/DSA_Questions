package GeneralQues;

public class GenerateSubstring {
    public static void main(String[] args) {
        String str = "abcdef";

        int n = str.length();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                System.out.println(str.substring(i, j));
            }
        }

    }
}
