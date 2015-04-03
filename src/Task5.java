import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Task5 {
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);
        String line;
        while(s.hasNextLine() && !"stop".equals(line = s.nextLine())) {
            System.out.println(
                    ResourceBundle.getBundle("resources",
                            new Locale(line.substring(line.indexOf(' ') + 1, line.length())))
                            .getString(line.substring(0, line.indexOf(' '))));
        }
    }
}
