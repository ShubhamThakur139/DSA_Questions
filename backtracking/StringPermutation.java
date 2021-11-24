package backtracking;

//problem statement: we have given a string and we have to print all the permutations
//abc: [abc,acb,bac,bca,cab,cba]
public class StringPermutation {
    static void printPerm(String up, String p) {

        if (up.length() == 0) {
            System.out.println(p);
            return;
        }

        for (int i = 0; i < up.length(); i++) {
            char ch = up.charAt(i);
            String lhs = up.substring(0, i);
            String rhs = up.substring(i + 1);
            String ros = lhs + rhs;
            printPerm(ros, p + ch);
        }
    }

    public static void main(String[] args) {
        String str = "abc";
        printPerm(str, "");
    }
}
