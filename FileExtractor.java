import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class FileExtractor {
    public static void main(String[] args) throws IOException {
        FileExtractor fileExtractor = new FileExtractor();

        File input = new File("input.txt");
        File delete = new File("delete.txt");
        File output = new File("output.txt");

        fileExtractor.prepareInputFile(input);
        fileExtractor.prepareDeleteFile(delete);

        fileExtractor.extractOutputFile(input, delete, output);
    }

    void extractOutputFile(File input, File delete, File output) throws IOException {
        Set<Integer> toBeRemovedSet = new HashSet<>();

        //Need a reader to read the files
        //BufferedReader is the preferred reader
        //BufferedReader can't directly read from file. Need a FileWriter
        BufferedReader reader = new BufferedReader(new FileReader(delete));

        String deleteLine = reader.readLine();

        while(deleteLine != null) {
            toBeRemovedSet.add(Integer.valueOf(deleteLine));
            deleteLine = reader.readLine();
        }

        //Need a writer to write to the output file
        PrintWriter writer = new PrintWriter(output);

        reader = new BufferedReader(new FileReader(input));
        String inputLine = reader.readLine();

        //Check for all the entry from input file in toBeRemovedSet
        //if present in set, don't add in output file
        while(inputLine != null) {
            if(!toBeRemovedSet.contains(Integer.valueOf(inputLine))) {
                writer.println(inputLine);
            }
            inputLine = reader.readLine();
        }

        writer.flush();
        writer.close();
    }

    void prepareInputFile(File input) throws IOException {
        //Need a writer to write to the input file
        //PrintWriter is the preferred writer
        try(PrintWriter writer = new PrintWriter(input)) {
            writer.println(111);
            writer.println(222);
            writer.println(333);
            writer.println(444);
            writer.println(555);

            writer.flush();
        }
    }

    void prepareDeleteFile(File delete) throws IOException {
        //Need a writer to write to the delete file
        //PrintWriter is the preferred writer
        try(PrintWriter writer = new PrintWriter(delete)) {
            writer.println(111);
            writer.println(555);

            writer.flush();
        }
    }
}
