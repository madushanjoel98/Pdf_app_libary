package edu.app.domains;





import javax.persistence.*;


@Entity 
public class Subcategory {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sutid;
	
	@Column(nullable = false)
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "catid", nullable = false)
	private Category cats;

	public int getSutid() {
		return sutid;
	}

	public void setSutid(int sutid) {
		this.sutid = sutid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Category getCats() {
		return cats;
	}

	public void setCats(Category cats) {
		this.cats = cats;
	}
	
	
}
