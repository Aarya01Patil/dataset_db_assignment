import java.util.*;

public class Driver {
    public static void main(String[] args) {
        ArrayList<Book> books = DatasetReader.readBooksFromCSV("books.csv");
        
        System.out.println("Book Inventory System");
        System.out.println("=====================");
        System.out.println();
        
        System.out.println("1. Count books by George Orwell:");
        int count = countBooksByAuthor("George Orwell", books);
        System.out.println("George Orwell has " + count + " books");
        System.out.println();
        
        System.out.println("2. All authors:");
        printAllAuthors(books);
        System.out.println();
        
        System.out.println("3. Books by George Orwell:");
        printBooksByAuthor("George Orwell", books);
        System.out.println();
        
        System.out.println("4. Books with rating 4.5 or higher:");
        printBooksByRating(4.5, books);
        System.out.println();
        
        System.out.println("5. Book prices by George Orwell:");
        printBookPricesByAuthor("George Orwell", books);
    }
    
    public static int countBooksByAuthor(String authorName, ArrayList<Book> books) {
        int count = 0;
        for (Book book : books) {
            if (book.getAuthor().equals(authorName)) {
                count++;
            }
        }
        return count;
    }
    
    public static void printAllAuthors(ArrayList<Book> books) {
        Set<String> authors = new HashSet<>();
        for (Book book : books) {
            authors.add(book.getAuthor());
        }
        for (String author : authors) {
            System.out.println(author);
        }
    }
    
    public static void printBooksByAuthor(String authorName, ArrayList<Book> books) {
        for (Book book : books) {
            if (book.getAuthor().equals(authorName)) {
                System.out.println(book.getName());
            }
        }
    }
    
    public static void printBooksByRating(double rating, ArrayList<Book> books) {
        for (Book book : books) {
            if (book.getUserRating() >= rating) {
                System.out.println(book.getName() + " by " + book.getAuthor() + " - Rating: " + book.getUserRating());
            }
        }
    }
    
    public static void printBookPricesByAuthor(String authorName, ArrayList<Book> books) {
        for (Book book : books) {
            if (book.getAuthor().equals(authorName)) {
                System.out.println(book.getName() + " - $" + book.getPrice());
            }
        }
    }
}
