package br.com.casadocodigo.loja.resources;

import br.com.casadocodigo.loja.daos.BookDAO;
import br.com.casadocodigo.loja.models.Book;
import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Nando on 29/02/16.
 */
@Path("books")
@Stateful
public class BooksResources {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager manager;

    private BookDAO bookDAO;

    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Wrapped(element="books")
    public List<Book> lastBooks(){
        return bookDAO.lastReleases();
    }

    @PostConstruct
    public void load(){
        bookDAO = new BookDAO(manager);
    }


}
