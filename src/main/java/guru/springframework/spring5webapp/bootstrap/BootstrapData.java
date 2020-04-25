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
        this.publisherRepository=publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher Helion= new Publisher("ul Dluga 17","Warszawa", "Mazowieckie", "30-444","Helion" );
        publisherRepository.save(Helion);
        Author eric=new Author("Eric", "Evans");
        Book book=new Book("Domain Driven Design", "33145");
        eric.getBooks().add(book);
        book.getAuthors().add(eric);
        book.setPublisher(Helion);
        Helion.getBooks().add(book);

        authorRepository.save(eric);
        bookRepository.save(book);
        publisherRepository.save(Helion);

        Author rod=new Author("Rod", "Johnson");
        Book book2=new Book("J2EE Development without EJB","3416343765");
        rod.getBooks().add(book2);
        book2.getAuthors().add(rod);
        Helion.getBooks().add(book2);
        book2.setPublisher(Helion);

        authorRepository.save(rod);
        bookRepository.save(book2);
        publisherRepository.save(Helion);



        System.out.println("Started in bootstrap");
        System.out.println("Nuber of books: "+bookRepository.count());
        System.out.println("Nuber of authors: "+authorRepository.count());
        System.out.println("Nasz publisher: "+Helion.toString());
        System.out.println("Ilosc wydawnictw: "+publisherRepository.count());
        System.out.println(("Ksiazki wydawnictwa "+Helion.getName()+": "+Helion.getBooks().size()));
    }
}
