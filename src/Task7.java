import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class Task7 {

    public static void main(String[] args) throws IOException {
        final String p = "(?i)^\"([єЄіІЇїёЁА-Яа-я0-9_\\w]+) ([єЄіІЇїёЁА-Яа-я0-9_]+) ([єЄіІЇїёЁА-Яа-я0-9_]+(-\\d)?) (?:.+)?\",\"(\\d+)\\.(\\d+)\\.(\\d+)\",\"(\\d+):(\\d+):(\\d+)\"(?:.*?)$";
        final String rep = "$7-$6-$5 ==> $8:$9 $1 $2 $3";
        List<String> res = Files.readAllLines(Paths.get("src" + File.separator + "TimeTable.csv"), Charset.forName("utf-8"));
        res.remove(0);
        for (int i = 0; i < res.size(); ++i) {
            res.set(i, res.get(i).replaceAll(p, rep));
        }
        res.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                try {
                    final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd ==> kk:mm");
                    return format.parse(o1).compareTo(format.parse(o2));
                } catch (ParseException e) {
                    return 0;
                }
            }
        });
        List<String> result = new ArrayList<>(res);
        for (int i = 0; i < res.size(); ++i) {
            String t1 = res.get(i).substring(0, 10);
            String t2 = i == 0 ? t1 : res.get(i - 1).substring(0, 10);
            if (!t1.equals(t2)) {
                result.set(i, "----------------" + System.lineSeparator() + result.get(i));
            }
        }
//        for (String s : result) {
//            System.out.println(s);
//        }

        for(int i = 0; i < 14; ++i) {
            System.out.println(result.get(i));
        }
    }
}
