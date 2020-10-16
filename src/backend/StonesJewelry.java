package backend;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class StonesJewelry {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("file/backend/StonesJewelry.txt"));
        String j = reader.readLine();
        String s = reader.readLine();
        reader.close();
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (j.contains(String.valueOf(s.charAt(i)))) {
                count++;
            }
        }
        System.out.println(count);
    }
}
