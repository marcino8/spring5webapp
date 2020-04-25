package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric=new Author("Eric", "Evans");
        Book book=new Book("Domain Driven Design", "33145");
        eric.getBooks().add(book);
        book.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(book);

        Author rod=new Author("Rod", "Johnson");
        Book book2=new Book("J2EE Development without EJB","3416343765");
        rod.getBooks().add(book2);
        book2.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRepository.save(book2);

        Publisher Helion= new Publisher("ul Dluga 17","Warszawa", "Mazowieckie", "30-444","Helion" );

        System.out.println("Started in bootstrap");
        System.out.println("Nuber of books: "+bookRepository.count());
        System.out.println("Nuber of authors: "+authorRepository.count());
        System.out.println(("Nasz publisher: "+Helion.toString()));
    }
}
