package edu.app.domains;

import javax.persistence.*;

@Entity
public class Books {
    @Id
    @Column(name = "book_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    
    
    @Lob
    @Column(name = "firebase_image",nullable = true)
    private String firebase_image;

    
    @Lob
    @Column(name = "description",nullable = true)
    private String description;
    
    
    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFirebase_image() {
		return firebase_image;
	}

	public void setFirebase_image(String firebase_image) {
		this.firebase_image = firebase_image;
	}

	public void setFirebase_url(String firebase_url) {
		this.firebase_url = firebase_url;
	}

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
