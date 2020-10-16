package algorithms;

import java.util.Arrays;

public class LotteryTicket {
    public static void main(String[] args) {
        byte[] ai = new byte[10];
        byte[] bj = new byte[6];
        int n;
        byte r;

        System.out.print("Выбранные номера: ");
        for (byte i = 0; i < 10; i++) {
            ai[i] = (byte) (Math.random() * 32 + 1);
            System.out.print("\t" + ai[i]);
        }
        Arrays.sort(ai);

        n = (int) (Math.random() * 1000 + 1);
        System.out.println("\nКоличество билетов: " + n);

        for (int i = 1; i <= n; i++) {
            r = 0;
            for (byte j = 0; j < 6; j++) {
                bj[j] = (byte) (Math.random() * 32 + 1);
                if (Arrays.binarySearch(ai, bj[j]) >= 0) {
                    r++;
                }
            }
            System.out.println("Билет №" + i + " : " + Arrays.toString(bj) + (r >= 3 ? "Lucky" : "Unlucky"));
        }
    }
}
