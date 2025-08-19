import java.io.*;
import java.util.*;

public class DatasetReader {
    public static ArrayList<Book> readBooksFromCSV(String filename) {
        ArrayList<Book> books = new ArrayList<>();
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line = br.readLine();
            
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 7) {
                    String name = values[0];
                    String author = values[1];
                    double rating = Double.parseDouble(values[2]);
                    int reviews = Integer.parseInt(values[3]);
                    double price = Double.parseDouble(values[4]);
                    int year = Integer.parseInt(values[5]);
                    String genre = values[6];
                    
                    Book book = new Book(name, author, rating, reviews, price, year, genre);
                    books.add(book);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        
        return books;
    }
}
