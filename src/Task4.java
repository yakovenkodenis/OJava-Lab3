import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task4 implements Iterable<String>{

    private static ArrayList<String> sentences;

    public Task4(File file, String encoding) throws IOException  {
        sentences = parseSentences(getStringFromFile(file, encoding));
    }

    private static String getStringFromFile(File file, String encoding) throws IOException{
        Scanner s = new Scanner(file, encoding);
        StringBuilder sb = new StringBuilder();
        while(s.hasNext()) {
            sb.append(s.next()).append(" ");
        }
        return sb.toString();
    }

    private static ArrayList<String> parseSentences(String s) {
        Pattern pattern = Pattern.compile("\\p{Lu}([^.]*).");
        ArrayList<String> list = new ArrayList<>();
        Matcher m = pattern.matcher(s);
        while (m.find()) {
            list.add(m.group());
        }
        return list;
    }

    @Override
    public Iterator<String> iterator() {
        return sentences.iterator();
    }

    public static void main (String[] args) throws IOException {
        Task4 t = new Task4(new File("task4.txt"), "UTF-8");
        for(String s : t) {
            System.out.println(s);
        }
    }
}
