package dan.med.eboutique.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity  //Annotation JPA
@Table(name = "produits") //Annotation JPA
public class Produit implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProduit;
	@NotEmpty //Annotation validation avec Hibernate validator: N'accepte pas que designation soit null
	@Size(min = 4, max = 15)
	private String designation;
	@Size(min = 8)
	private String descriptionProduit;
	private double prix;
	private int quantite;
	private boolean selected; //attribut selectionné
	private String photo;
	@ManyToOne //Annotation JPA
	@JoinColumn(name = "idCategorie") //Peut avoir un autre nom que celui de sa table d'origine mais pour la bonne pratique gardons le nom initial
	private Categorie categorie; //Un produit appartient à une catégorie
	public Long getIdProduit() {
		return idProduit;
	}
	public void setIdProduit(Long idProduit) {
		this.idProduit = idProduit;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getDescriptionProduit() {
		return descriptionProduit;
	}
	public void setDescriptionProduit(String descriptionProduit) {
		this.descriptionProduit = descriptionProduit;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantité() {
		return quantite;
	}
	public void setQuantité(int quantité) {
		this.quantite = quantité;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	//Constructeur sans parametre
	public Produit() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Constructeur avec parametre
	public Produit(String designation, String descriptionProduit, double prix, int quantité, boolean selected,
			String photo) {
		super();
		this.designation = designation;
		this.descriptionProduit = descriptionProduit;
		this.prix = prix;
		this.quantite = quantité;
		this.selected = selected;
		this.photo = photo;
	}
	
}
