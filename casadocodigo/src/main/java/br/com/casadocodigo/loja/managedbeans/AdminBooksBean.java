package br.com.casadocodigo.loja.managedbeans;

import br.com.casadocodigo.loja.daos.AuthorDAO;
import br.com.casadocodigo.loja.daos.BookDAO;
import br.com.casadocodigo.loja.models.Author;
import br.com.casadocodigo.loja.models.Book;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nando on 15/02/16.
 */
@Model
public class AdminBooksBean {

    private Book product = new Book();

    @Inject
    private BookDAO bookDAO;

    @Inject
    private AuthorDAO authorDAO;

    private List<Author> authors = new ArrayList<>();
    private List<Integer> selectedAuthorsIds = new ArrayList<>();

    @Transactional
    public void save(){
        populateBookAuthor();
        bookDAO.save(product);
        clearObjects();
    }

    public Book getProduct() {
        return product;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Integer> getSelectedAuthorsIds() {
        return selectedAuthorsIds;
    }

    public void setSelectedAuthorsIds(List<Integer> selectedAuthorsIds) {
        this.selectedAuthorsIds = selectedAuthorsIds;
    }

    @PostConstruct
    public void load(){
        this.authors = authorDAO.list();
    }


    private void populateBookAuthor(){
        selectedAuthorsIds.stream()
                .map((id)->{
                        Author author = new Author(id);
                        System.out.println(author);
                        return author;
                    }).forEach(product::add);
    }


    private void clearObjects(){
        this.product = new Book();
        this.selectedAuthorsIds.clear();
    }
}
