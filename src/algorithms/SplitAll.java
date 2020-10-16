package algorithms;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SplitAll {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("file/algorithms/splitAll.txt"));
        String line;
        String rez = "Yes";
        int count = 0;
        float[] xy;
        float x1 = 0;
        float x2;
        float y1 = 0;
        float y2;
        float a = 0;
        float b = 0;
        float c = 0;

        while ((line = reader.readLine()) != null) {
            if (count == 0) {
                if (Integer.parseInt(line) <= 2) {
                    break;
                }
                count = 1;
            }
            if (count == 2) {
                xy = getCenter(line);
                x1 = xy[0];
                y1 = xy[1];
                count = 3;
            }
            if (count == 4) {
                xy = getCenter(line);
                x2 = xy[0];
                y2 = xy[1];
                if (x1 == x2 & y1 == y2) {
                    count = 3;
                } else {
                    a = y1 - y2;
                    b = x2 - x1;
                    c = x1 * y2 - x2 * y1;
                    count = 4;
                }
            }
            if (count > 4) {
                xy = getCenter(line);
                x1 = xy[0];
                y1 = xy[1];
                if ((a * x1 + b * y1 + c) != 0) {
                    rez = "No";
                    break;
                }
            }
            count++;
        }
        reader.close();
        System.out.println(rez);
    }

    private static float[] getCenter(String line) {
        String str = line;
        float[] center = new float[2];
        int x1 = 0;
        int x2 = 0;
        int y1 = 0;
        int y2 = 0;
        int i = 0;
        int r;
        int k = Integer.parseInt(line.substring(0, line.indexOf(" ")));
        if (k == 0) {
            while (i < 3) {
                str = str.substring(str.indexOf(" ") + 1);
                r = Integer.parseInt(str.contains(" ") ? str.substring(0, str.indexOf(" ")) : str);
                switch (i) {
                    case 1: center[0] = r;
                        break;
                    case 2: center[1] = r;
                        break;
                }
                i++;
            }
        }
        if (k == 1) {
            while (i < 6) {
                str = str.substring(str.indexOf(" ") + 1);
                r = Integer.parseInt(str.substring(0, str.indexOf(" ")));
                switch (i) {
                    case 0: x1 = r;
                        break;
                    case 1: y1 = r;
                        break;
                    case 4: x2 = r;
                        break;
                    case 5: y2 = r;
                        break;
                }
                i++;
            }
            center[0] = ((float) x1 + x2)/ 2;
            center[1] = ((float) y1 + y2) / 2;
        }
        return center;
    }
}
