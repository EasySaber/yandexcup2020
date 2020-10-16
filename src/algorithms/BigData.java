package algorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class BigData {
    static int n;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("file/algorithms/bigData.txt"));
        int[] a;
        int[] b;


        b = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = b[0];
        m = b[1];
        a = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        b = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        reader.close();

        long[][] c = new long[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                c[i][j] = (long) (a[i] * Math.pow(10, 9) + b[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print("\t" + c[i][j]);
            }
            System.out.println();
        }
        System.out.println(getMaxSum(0, 0, c[0][0], 0, c));
    }

    private static long getMaxSum(int x, int y, long sum, long rezSum, long[][] c) {
        if ((x == n - 1) & (y == m - 1)) {
            if (sum > rezSum) {
                rezSum = sum;
            }
        } else {
            if (x < n - 1) {
                rezSum = getMaxSum(x + 1, y, sum + c[x + 1][y], rezSum, c);
            }
            if (y < m - 1) {
                rezSum = getMaxSum(x, y + 1, sum + c[x][y + 1], rezSum, c);
            }
        }
        return rezSum;
    }
}
