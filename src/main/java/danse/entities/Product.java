package danse.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	 
	private String name;
	private String picture;
	private String comment;
	private Integer totalQuantity;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_category")
	private Category category;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_type")
	private Type type;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_colour")
	private Colour colour;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_box")
	private Box box;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="id_kind")
	private Kind kind;
	
	@OneToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL,mappedBy="sizeQuantityPk.product")
	private List<SizeQuantity> sizeQuantities;
	

	public void setSizeQuantities(List<SizeQuantity> sizeQuantities) {
		this.sizeQuantities = sizeQuantities;
	}

	
	public Product() {
		
	}
	
	public Product(String name, String picture, String comment, Integer totalQuantity, Category category, Type type, Colour colour, Box box, Kind kind) {
		this.name=name;
		this.picture=picture;
		this.comment=comment;
		this.totalQuantity=totalQuantity;
		this.category=category;
		this.type=type;
		this.colour=colour;
		this.box=box;
		this.kind=kind;
	}
	
	// toString
	public String toString() {
		return String.format("Product[%d, %s, %s, %s, %d, %d]", id, name,comment,picture,totalQuantity,category.getId());
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getTotalQuantity() {
		return totalQuantity;
	}

	public void setTotalQuantity(Integer totalQuantity) {
		this.totalQuantity = totalQuantity;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Colour getColour() {
		return colour;
	}

	public void setColour(Colour colour) {
		this.colour = colour;
	}

	public Box getBox() {
		return box;
	}

	public void setBox(Box box) {
		this.box = box;
	}

	public Kind getKind() {
		return kind;
	}

	public void setKind(Kind kind) {
		this.kind = kind;
	}

	
}
