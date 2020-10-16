package algorithms;

import java.util.Scanner;

public class FactorPalindromes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String strInput = input.nextLine();
        String strRez = null;
        int count = strInput.length();

        for (int i = 0; i < count - 1; i++) {
            if ((strInput.charAt(i) == strInput.charAt(i + 1)) &
                    (strRez == null || strInput.charAt(i) < strRez.charAt(0))) {
                strRez = strInput.substring(i, i + 2);
                i++;
            }
        }
        if ((strRez == null) & (count > 2)) {
            for (int i = 0; i < count - 2; i++) {
                if (strInput.charAt(i) == strInput.charAt(i + 2)) {
                    if (strRez == null || strInput.charAt(i) < strRez.charAt(0)) {
                        strRez = strInput.substring(i, i + 3);
                    } else {
                        if (strInput.charAt(i) == strRez.charAt(0) & strInput.charAt(i) < strRez.charAt(1)) {
                            strRez = strInput.substring(i, i + 3);
                        }
                    }
                }
            }
        }
        System.out.println(strRez != null ? strRez : "-1");

    }
}
