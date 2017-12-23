package Dan.org.eboutique.dao;

import java.util.List;

import Dan.org.eboutique.entities.Categorie;
import Dan.org.eboutique.entities.Client;
import Dan.org.eboutique.entities.Commande;
import Dan.org.eboutique.entities.Panier;
import Dan.org.eboutique.entities.Produit;
import Dan.org.eboutique.entities.Role;
import Dan.org.eboutique.entities.User;

public interface IBoutiqueDAO {
	
	public Long ajouterCategorie(Categorie c);
	public List<Categorie> listCategories();
	public Categorie getCategorie(Long idCat);
	public void supprimerCategrorie(Long idcat);
	public void modifierCategorie(Categorie c);
	
	public Long ajouterProduit(Produit p, Long idCat);
	public List<Produit> listproduits();
	public List<Produit> produitsParMotCle(String mc);
	public List<Produit> produitsParCategorie(Long idCat);
	public List<Produit> produitsSelectionnes();
	public Produit getProduit(Long idP);
	public void supprimerProduit(Long idP);
	public void modifierProduit(Produit p);
	
	public void ajouterUser(User u);
	public void attribuerRole(Role r,Long userID);
	public Commande enregistrerCommande(Panier p,Client c);

}
