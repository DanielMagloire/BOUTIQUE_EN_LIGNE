package dan.med.eboutique.dao;

import java.util.List;

import dan.med.eboutique.entities.*;
import dan.med.eboutique.entities.Client;
import dan.med.eboutique.entities.Commande;
import dan.med.eboutique.entities.Panier;
import dan.med.eboutique.entities.Produit;
import dan.med.eboutique.entities.Role;
import dan.med.eboutique.entities.User;

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
