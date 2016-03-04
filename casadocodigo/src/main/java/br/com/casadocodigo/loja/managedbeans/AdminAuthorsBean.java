package br.com.casadocodigo.loja.managedbeans;

import br.com.casadocodigo.loja.daos.AuthorDAO;
import br.com.casadocodigo.loja.models.Author;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Nando on 03/03/16.
 */
@Model
public class AdminAuthorsBean {

    @Inject
    private Author author;
    @Inject
    private AuthorDAO authorDAO;

    private List<Author> authors;


    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Transactional
    public void save() {
//        authorDAO.save(author);
        authors.add(author);
    }

    @Transactional
    public void delete(Author author){
        authors.remove(author);
//        authorDAO.delete(author);
    }

    @PostConstruct
    public void load(){
        authors = authorDAO.list();
    }
}
