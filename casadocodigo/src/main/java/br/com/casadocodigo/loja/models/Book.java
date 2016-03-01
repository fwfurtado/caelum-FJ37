package br.com.casadocodigo.loja.models;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.*;
import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Nando on 15/02/16.
 */
@Cacheable
@Entity
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    private String title;

    @NotBlank
    @Length(min = 10)
    private String description;

    @Min(50)
    private int numberOfPages;

    @DecimalMin("20")
    private BigDecimal price;

    @ManyToMany
    @Size(min = 1)
    @XmlElement(name="authors")
    @XmlElementWrapper(name = "authors")
    private List<Author> authors = new ArrayList<>();

    @Future
    @NotNull
    @Temporal(TemporalType.DATE)
    private Calendar releaseDate;

    private String summaryPath;
    private String coverPath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }




    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", price=" + price +
                '}';
    }

    public void setReleaseDate(Calendar releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Calendar getReleaseDate() {
        return releaseDate;
    }

    public void setSummaryPath(String summaryPath) {
        this.summaryPath = summaryPath;
    }

    public String getSummaryPath() {
        return summaryPath;
    }

    public void setCoverPath(String  coverPath) {
        this.coverPath = coverPath;
    }

    public String  getCoverPath() {
        return coverPath;
    }
}
