package BookShop;

import BookShop.entities.Author;
import BookShop.entities.Book;
import BookShop.repositories.AuthorRepository;
import BookShop.repositories.BookRepository;
import BookShop.services.SeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class ConsoleRunner implements CommandLineRunner {


    private final SeedService seedService;
    private final BookRepository bookRepository;
    private AuthorRepository authorRepository;

    @Autowired
    public ConsoleRunner(SeedService seedService, BookRepository bookRepository, AuthorRepository authorRepository) {
        this.seedService = seedService;
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    private void booksAfter2000() {
        LocalDate yearAfter2000 = LocalDate.of(2000, 12, 31);
        List<Book> books = bookRepository.findByReleaseDateAfter(yearAfter2000);

        books.forEach(b -> System.out.println(b.getReleaseDate() + " " + b.getTitle()));

        int count = bookRepository.countByReleaseDateAfter(yearAfter2000);

        System.out.println("Total count: " + count);
    }

    private void authorsWithBookBefore1990() {
        LocalDate year1990 = LocalDate.of(1990, 1, 1);
        List<Author> authors = authorRepository.findDistinctByBooksReleaseDateBefore(year1990);

        authors.forEach(a -> System.out.println(a.getFirstName() + " " + a.getLastName()));
    }

    @Override
    public void run(String... args) throws Exception {
        seedService.seedAll();
        booksAfter2000();
        authorsWithBookBefore1990();

    }
}
