import java.io.*;

/*
    Merge two files into a third file
 */
public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        MergeTwoFiles fileMerger = new MergeTwoFiles();

        File file1 = new File("file1.txt");
        File file2 = new File("file2.txt");

        fileMerger.prepareTwoFiles(file1, file2);

        File file3 = new File("file3.txt");
        fileMerger.appendMerge(file1, file2, file3);

        File file4 = new File("file4.txt");
        fileMerger.alternateLineMerge(file1, file2, file4);

    }

    /**
     * Will write to the file4 the content of file1 and file2 alternatively, line by line
     * @param file1
     * @param file2
     * @param file4
     * @throws IOException
     */
    private void alternateLineMerge(File file1, File file2, File file4) throws IOException {
        BufferedReader reader1 = new BufferedReader(new FileReader((file1)));
        BufferedReader reader2 = new BufferedReader(new FileReader((file2)));

        String line1 = reader1.readLine();
        String line2 = reader2.readLine();

        PrintWriter writer = new PrintWriter(file4);

        while(line1 != null || line2 != null) {
            if(line1 != null) {
                writer.println(line1);
            }
            if(line2 != null) {
                writer.println(line2);
            }
            line1 = reader1.readLine();
            line2 = reader2.readLine();
        }

        writer.flush();
        reader1.close();
        reader2.close();
    }

    /**
     * Prepares two input files
     * @param file1
     * @param file2
     * @throws IOException
     */
    void prepareTwoFiles(File file1, File file2) throws IOException {
        PrintWriter writer = new PrintWriter(file1);

        writer.println("ABC");
        writer.println(123);
        writer.println(true);
        writer.println(1);
        writer.println(2);
        writer.flush();
        writer.close();

        writer = new PrintWriter(file2);

        writer.println("DEF");
        writer.println(456);
        writer.println(false);
        writer.flush();
        writer.close();
    }

    /**
     * First write the content of file1 and then write the content of file2 into file3
     * @param file1 input file1
     * @param file2 input file2
     * @param file3 result
     * @throws IOException
     */
    void appendMerge(File file1, File file2, File file3) throws IOException {
        PrintWriter writer = new PrintWriter(file3);

        BufferedReader reader = new BufferedReader(new FileReader(file1));
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
