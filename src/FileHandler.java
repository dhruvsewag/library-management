import java.io.*;
import java.util.*;

public class FileHandler {

    private static final String FILE_NAME = "library_data.txt";

    public static List<Book> loadData() {
        List<Book> list = new ArrayList<>();

        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
                return list;
            }

            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;

            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    list.add(Book.fromFileString(line));
                }
            }

            br.close();
        } catch (Exception e) {
            System.out.println("Error loading data: " + e.getMessage());
        }

        return list;
    }

    public static void saveData(List<Book> books) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));

            for (Book b : books) {
                bw.write(b.toFileString());
                bw.newLine();
            }

            bw.close();

        } catch (Exception e) {
            System.out.println("Error saving data: " + e.getMessage());
        }
    }
}
