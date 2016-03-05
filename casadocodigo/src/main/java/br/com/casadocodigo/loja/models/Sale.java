package br.com.casadocodigo.loja.models;

import javax.json.Json;
import javax.json.JsonObjectBuilder;

/**
 * Created by Nando on 04/03/16.
 */
public class Sale {
    private Book book;
    private String title;

    public void setBook(Book book) {
        this.book = book;
    }

    public Book getBook() {
        return book;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toJson(){
        JsonObjectBuilder json = Json.createObjectBuilder();
        return json
                .add("title", this.title)
                .add("bookId", this.book.getId())
                    .build()
                        .toString();
    }


}
