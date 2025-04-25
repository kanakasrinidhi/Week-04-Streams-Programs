import java.util.*;
import java.util.stream.*;

class Book {
    String title;
    String author;
    String genre;
    double rating;

    Book(String title, String author, String genre, double rating) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.rating = rating;
    }
}

class BookRecommendation {
    String title;
    double rating;

    BookRecommendation(String title, double rating) {
        this.title = title;
        this.rating = rating;
    }

    public String toString() {
        return title + " (Rating: " + rating + ")";
    }
}

public class BookRecommendationSystem {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Dune", "Frank Herbert", "Science Fiction", 4.6),
                new Book("Foundation", "Isaac Asimov", "Science Fiction", 4.2),
                new Book("Hyperion", "Dan Simmons", "Science Fiction", 4.3),
                new Book("Neuromancer", "William Gibson", "Science Fiction", 4.1),
                new Book("Snow Crash", "Neal Stephenson", "Science Fiction", 3.9),
                new Book("2001: A Space Odyssey", "Arthur C. Clarke", "Science Fiction", 4.4),
                new Book("Ender's Game", "Orson Scott Card", "Science Fiction", 4.5),
                new Book("The Martian", "Andy Weir", "Science Fiction", 4.7),
                new Book("Brave New World", "Aldous Huxley", "Science Fiction", 4.0),
                new Book("Starship Troopers", "Robert A. Heinlein", "Science Fiction", 4.2),
                new Book("The Left Hand of Darkness", "Ursula K. Le Guin", "Science Fiction", 4.3)
        );

        List<BookRecommendation> recommendations = books.stream()
                .filter(book -> book.genre.equals("Science Fiction") && book.rating > 4.0)
                .map(book -> new BookRecommendation(book.title, book.rating))
                .sorted((b1, b2) -> Double.compare(b2.rating, b1.rating))
                .limit(10)
                .collect(Collectors.toList());

        // Pagination: 2 pages, 5 books each
        int pageSize = 5;
        int totalPages = (int) Math.ceil(recommendations.size() / (double) pageSize);

        for (int page = 1; page <= totalPages; page++) {
            System.out.println("📘 Page " + page);
            recommendations.stream()
                    .skip((page - 1) * pageSize)
                    .limit(pageSize)
                    .forEach(System.out::println);
            System.out.println();
        }
    }
}
