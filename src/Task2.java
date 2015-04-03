import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class Task2 {

    private static final String FILE_INPUT_NAME = "input.txt";

    private static final String FILE_OUTPUT_NAME = "output.txt";

    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream(FILE_INPUT_NAME);
        Random rnd = new Random();
        for(int i = 0; i < 20; ++i) {
            fos.write(rnd.nextInt(50));
        }
        fos.close();
        FileInputStream fis = new FileInputStream(FILE_INPUT_NAME);
        int[] arr = new int[20];
        int x, i = 0;
        System.out.print("input  ==> ");
        while ((x = fis.read()) != -1) {
            arr[i] = x;
            i++;
            System.out.print(x + " ");
        }
        fis.close();
        System.out.println();
        Arrays.sort(arr);
        fos = new FileOutputStream(FILE_OUTPUT_NAME);
        System.out.print("output ==> ");
        for(i = 0; i < arr.length; ++i) {
            fos.write(arr[i]);
            System.out.print(arr[i] + " ");
        }
    }
}
