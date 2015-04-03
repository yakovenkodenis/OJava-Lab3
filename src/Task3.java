
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task3 {

    private static final String FILE_NAME = "task3.txt";

    private static boolean isInteger(String s) {
        if (s.length() < 1) {
            return false;
        } else {
            for (int i = 0; i < s.length(); ++i) {
                if (!Character.isDigit(s.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    private static boolean isDouble(String s) {
        if (s.length() < 2) {
            return false;
        } else {
            int dots = 0;
            for (int i = 0; i < s.length() && dots <= 1; ++i) {
                if (s.charAt(i) == '.') {
                    dots++;
                    if (dots > 1) {
                        return false;
                    }
                } else if (!Character.isDigit(s.charAt(i)) && s.charAt(i) != '.') {
                    return false;
                }
            }
            return dots == 1;
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        String tmp;
        List<String> arr = new ArrayList<>();
        Scanner s = new Scanner(new File(FILE_NAME), "UTF-8");
        while (s.hasNext()) {
            tmp = s.next();
            sb.append(tmp).append(" ");
            arr.add(tmp);
        }
        String content = sb.toString();
        s.close();
        System.out.println(content);

        s = new Scanner(System.in);
        String line;
        while (s.hasNextLine() && !"stop".equals(line = s.nextLine())) {
            switch (line) {
                case "char":
                    for (String c : arr) {
                        System.out.print(c.length() == 1 ? c + " " : "");
                    }
                    System.out.println();
                    break;
                case "int":
                    for (String c : arr) {
                        if (isInteger(c)) {
                            System.out.print(c + " ");
                        }
                    }
                    System.out.println();
                    break;
                case "double":
                    for (String c : arr) {
                        if (isDouble(c)) {
                            System.out.print(c + " ");
                        }
                    }
                    System.out.println();
                    break;
                case "String":
                    for (String c : arr) {
                        if (c.length() > 1 && !isInteger(c) && !isDouble(c)) {
                            System.out.print(c + " ");
                        }
                    }
                    System.out.println();
                    break;
                default:
                    System.out.println("UNKNOWN TYPE ERROR");
                    break;
            }
        }
    }
}
