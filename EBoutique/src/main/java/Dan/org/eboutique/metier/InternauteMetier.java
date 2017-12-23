package Dan.org.eboutique.metier;

import java.util.List;

import Dan.org.eboutique.entities.Categorie;
import Dan.org.eboutique.entities.Client;
import Dan.org.eboutique.entities.Commande;
import Dan.org.eboutique.entities.Panier;
import Dan.org.eboutique.entities.Produit;

public interface InternauteMetier {
	
	public List<Categorie> listCategories(); //Un internaute peut consulter la liste des catégories
	public Categorie getCategorie(Long idCat); //Un internaute peut consulter une catégorie
	public List<Produit> listproduits();  //Un internaute peut consulter la liste des produits
	public List<Produit> produitsParMotCle(String mc); //Un internaute peut consulter la liste des produits par mot cle (mc)
	public List<Produit> produitsParCategorie(Long idCat); //Un internaute peut consulter la liste des produits par categorie
	public List<Produit> produitsSelectionnes();  //Un internaute peut consulter la liste des produits selectionnés
	public Produit getProduit(Long idP); //Un internaute peut consulter un produit
	public Commande enregistrerCommande(Panier p,Client c);  //Peut enregistrer une commande
}
