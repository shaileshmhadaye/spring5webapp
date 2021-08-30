package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started in bootstrap");
        Author author = new Author("Shailesh", "Mhadaye");
        Book book = new Book("History", "231234");
        Publisher publisher = new Publisher("Oxford","bhandup", "Mumbai", "Maharashtra", "400042");
        publisherRepository.save(publisher);
        author.getBooks().add(book);
        book.getAuthors().add(author);
        book.setPublisher(publisher);
        publisher.getBooks().add(book);

        authorRepository.save(author);
        bookRepository.save(book);
        publisherRepository.save(publisher);

        Author author2 = new Author("Shruti", "Mahalkar");
        Book book2 = new Book("Science", "2324534");
        Publisher publisher2 = new Publisher("Panya","dombivli", "Mumbai", "Maharashtra", "400067");
        author2.getBooks().add(book2);
        book2.getAuthors().add(author2);
        book2.setPublisher(publisher);
        publisher.getBooks().add(book2);

        authorRepository.save(author2);
        bookRepository.save(book2);
        publisherRepository.save(publisher);
        publisherRepository.save(publisher2);
        System.out.println("Number of books:"+bookRepository.count());
        System.out.println("Number of publishers:"+publisherRepository.count());
        System.out.println("publisher books:"+publisher.getBooks().size());

    }
}
