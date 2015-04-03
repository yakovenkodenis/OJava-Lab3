import java.io.*;
import java.nio.charset.Charset;

public class Task6 {

    public static void filter(Reader mails, Reader groups, Writer users) throws IOException {
        BufferedReader brm = new BufferedReader(mails);
        BufferedReader brg = new BufferedReader(groups);
        BufferedWriter bwu = new BufferedWriter(users);
        String m = brm.readLine();
        String g = brg.readLine();
        while (m != null && g != null) {
            if(!m.startsWith("#") && !g.startsWith("#")) {
                bwu.write(m + ";" + g.split(";")[1] + System.lineSeparator());
            }
            m = brm.readLine();
            g = brg.readLine();
        }
        bwu.close();
    }

    public static void main(String[] args) throws IOException {
        Reader mails = new FileReader("task5_1.txt");
        Reader groups = new FileReader("task5_2.txt");
        Writer users = new FileWriter("task5_output.txt");
        filter(mails, groups, users);

//        Reader r = new FileReader("task5_output.txt");
//        int i;
//        while ((i = r.read()) != -1) {
//            System.out.print((char)i);
//        }
        InputStreamReader r = new InputStreamReader(new FileInputStream("task5_output.txt"), "UTF-8");
        int i;
        while ((i = r.read()) != -1) {
            System.out.print((char)i);
        }
    }
}
