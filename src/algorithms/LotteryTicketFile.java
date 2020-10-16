package algorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class LotteryTicketFile {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new FileReader("file/algorithms/input.txt"));
        String line;
        byte[] ai = new byte[10];
        byte[] bj = new byte[6];
        int count = 0;
        byte k;

        while ((line = input.readLine()) != null) {
            if (count == 0) {
                for (int i = 0; i < 10; i++) {
                    ai[i] = Byte.parseByte(line.substring(0, line.contains(" ") ? line.indexOf(" ") : line.length()));
                    line = line.substring(line.indexOf(" ") + 1);
                }
                Arrays.sort(ai);
            }
            if (count > 1) {
                k = 0;
                for (int j = 0; j < 6; j++) {
                    bj[j] = Byte.parseByte(line.substring(0, line.contains(" ") ? line.indexOf(" ") : line.length()));
                    if (Arrays.binarySearch(ai, bj[j]) >= 0) {
                        k++;
                    }
                    line = line.substring(line.indexOf(" ") + 1);
                }
                System.out.println(k >= 3 ? "Lucky" : "Unlucky");
            }
            count++;
        }
        input.close();
    }
}
