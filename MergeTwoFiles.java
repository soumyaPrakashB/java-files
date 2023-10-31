import java.io.*;

/*
    Merge two files into a third file
 */
public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");

        File file3 = new File("file3.txt");

        PrintWriter writer = new PrintWriter(file1);

        writer.println("ABC");
        writer.println(123);
        writer.println(true);
        writer.flush();
        writer.close();

        writer = new PrintWriter(file2);

        writer.println("DEF");
        writer.println(456);
        writer.println(false);
        writer.flush();
        writer.close();

        BufferedReader reader = new BufferedReader(new FileReader(file1));

        writer = new PrintWriter(file3);

        String next = reader.readLine();

        while(next != null) {
            writer.println(next);
            next = reader.readLine();
        }

        reader = new BufferedReader(new FileReader(file2));

        next = reader.readLine();

        while(next != null) {
            writer.println(next);
            next = reader.readLine();
        }

        writer.flush();
        writer.close();
        reader.close();
    }
}
