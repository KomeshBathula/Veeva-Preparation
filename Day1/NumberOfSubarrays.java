package Day1;
import java.util.HashMap;
import java.util.Scanner;

public class NumberOfSubarrays {
    private static int getCountOfSubarrays(int n, int[] arr, int k) {
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            int target = sum - k;

            if (map.containsKey(target)) count += map.get(target);

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(getCountOfSubarrays(n, arr, k));
        sc.close();

    }
}
