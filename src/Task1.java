import java.io.File;
import java.io.FileNotFoundException;
import java.text.BreakIterator;
import java.util.Scanner;

public class Task1 {

    private static final String FILE_NAME = "src" + File.separator + "1.txt";

    private static final String EOL = System.lineSeparator();

    private static final String ENCODING = "UTF-8";

    public static void main(String[] args) throws FileNotFoundException {
        String content;
        StringBuilder sb = new StringBuilder();
        Scanner s = new Scanner(new File(FILE_NAME), ENCODING);
        while(s.hasNextLine()) {
            sb.append(s.nextLine()).append(EOL);
        }
        content = sb.substring(0, sb.length() - EOL.length());
        s.close();
        sb = new StringBuilder();
        BreakIterator boundary = BreakIterator.getWordInstance();
        boundary.setText(content);
        int start = boundary.first();
        for(int end = boundary.next(); end != BreakIterator.DONE; start = end, end = boundary.next()) {
            String tmp = content.substring(start, end);
            sb.append((end - start > 2) ? tmp.toUpperCase() : tmp);
        }
        System.out.println(sb.toString());
    }
}
