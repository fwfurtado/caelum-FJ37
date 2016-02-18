package br.com.casadocodigo.loja.managedbeans;

import br.com.casadocodigo.loja.daos.AuthorDAO;
import br.com.casadocodigo.loja.daos.BookDAO;
import br.com.casadocodigo.loja.infra.MessagesHelper;
import br.com.casadocodigo.loja.models.Author;
import br.com.casadocodigo.loja.models.Book;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
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

    @Inject
    private MessagesHelper messageHelper;

    @Transactional
    public String  save(){
        populateBookAuthor();
        bookDAO.save(product);

        messageHelper.addFlash(new FacesMessage("Livro cadastrado com sucesso"));

        return "/livros/list?faces-redirect=true";
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
    private void load(){
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
}
