package edu.app.domains;

import jakarta.persistence.*;

@Entity
public class Books {
    @Id
    @Column(name = "book_id", nullable = false)
    private long book_id;

    @Lob
    @Column(name = "book_name")
    private String book_name;

    @Lob
    @Column(name = "firebase_url",nullable = true)
    private String firebase_url;

    @ManyToOne(optional = false)
    @JoinColumn(name = "subcategory_sutid", nullable = false)
    private Subcategory subcategory;

    public Subcategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(Subcategory subcategory) {
        this.subcategory = subcategory;
    }

    public String getFirebase_url() {
        return firebase_url;
    }

    public String getBook_name() {
        return book_name;
    }

    public void setBook_name(String book_name) {
        this.book_name = book_name;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }
}
