import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            //readFileByte();
            compareFileTo();
            //readFileToPage();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void readFileByte() throws IOException {
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("src/main/dir/1.txt"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        int line;
        while ((line = in.read()) != -1) {
            out.write((char) line);
        }

        byte[] bt = out.toByteArray();
        System.out.println(Arrays.toString(bt));
        in.close();
        out.close();
    }

    public static void compareFileTo() throws IOException {

        ArrayList<InputStream> all = new ArrayList<InputStream>();
        all.add(new FileInputStream("src/main/dir/1.txt"));
        all.add(new FileInputStream("src/main/dir/2.txt"));
        all.add(new FileInputStream("src/main/dir/3.txt"));

        BufferedInputStream in = new BufferedInputStream(new SequenceInputStream(Collections.enumeration(all)));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("out.txt"));
        int rl;
        while ((rl = in.read()) != -1) {
            out.write(rl);
            System.out.print((char) rl);
        }
        in.close();
        out.close();
    }


    public static void readFileToPage() throws IOException {
        final int PAGE_SIZE = 100;
        RandomAccessFile raf = new RandomAccessFile("src/main/dir/1.txt", "r");
        Scanner scan = new Scanner(System.in);
        System.out.println("Показать страницу: ");
        int page = scan.nextInt() - 1;
        raf.seek(page * PAGE_SIZE);
        byte[] rb = new byte[100];
        raf.read(rb);
        System.out.println(new String(rb));
        raf.close();
    }
}
