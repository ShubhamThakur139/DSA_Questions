package backtracking;

//problem statement: Here we have given a array and we have to print all the permutations
//[1 2 3] : [1 2 3] [1 3 2] [2 1 3] [2 3 1] [3 1 2] [3 2 1]
public class ArrayPermutation {

    static void swap(int arr[], int i, int curr) {
        if (i == curr)
            return;
        int temp = arr[i];
        arr[i] = arr[curr];
        arr[curr] = temp;
    }

    static void perm(int arr[], int curr) {
        if (curr == arr.length) {
            for (int j : arr) {
                System.out.print(j + " ");
            }
            System.out.println();
            return;
        }

        for (int i = curr; i < arr.length; i++) {
            swap(arr, i, curr);
            perm(arr, curr + 1);
            swap(arr, i, curr);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3 };
        perm(arr, 0);
    }
}
