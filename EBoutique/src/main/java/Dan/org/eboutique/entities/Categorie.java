package Dan.org.eboutique.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name ="categories")
public class Categorie implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategorie;
	@NotEmpty
	@Size(min = 4, max = 20)
	private String nomCategorie;
	@Size(min = 8)
	private String description;
	@Lob
	private byte[] photo;
	private String nomphoto;
	@OneToMany(mappedBy ="categorie") //Relation ou association bidirectionnelle
	private Collection<Produit> produits; //Une catégorie correspond à plusieurs produit
	public Long getIdcategorie() {
		return idCategorie;
	}
	public void setIdcategorie(Long idcategorie) {
		this.idCategorie = idcategorie;
	}
	public String getNomcategorie() {
		return nomCategorie;
	}
	public void setNomcategorie(String nomcategorie) {
		this.nomCategorie = nomcategorie;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public String getNomphoto() {
		return nomphoto;
	}
	public void setNomphoto(String nomphoto) {
		this.nomphoto = nomphoto;
	}
	public Collection<Produit> getProduits() {
		return produits;
	}
	public void setProduits(Collection<Produit> produits) {
		this.produits = produits;
	}
	//Constructeur sans parametre
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	//Constructeur avec parametre
	public Categorie(String nomcategorie, String description, byte[] photo, String nomphoto) {
		super();
		this.nomCategorie = nomcategorie;
		this.description = description;
		this.photo = photo;
		this.nomphoto = nomphoto;
	}
	
	
}
