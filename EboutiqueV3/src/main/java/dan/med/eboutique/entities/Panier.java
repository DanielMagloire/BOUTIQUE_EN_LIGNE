package dan.med.eboutique.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Panier implements Serializable {
	//Nous allons ici travailer avec une collection de type Map. Car nous permet de retrouver le produit par sa reference ou par son id
	private Map<Long, LigneCommande> ligneCommandes = new HashMap<Long, LigneCommande>(); //Long est le type de idProduit et il est initialis~par HashMap
	
	//pour la gestion du panier, nous allons ajouter quelques méthodes utilitaitres
	//1: Qui permet d'ajouter un produit
	public void addArticle(Produit p, int quantite){
		//Pour ajouter il faut d'abord vérifier si le produit n'existe pas dans la liste
		if(ligneCommandes.get(p.getIdProduit())==null){
			//Si il est vide je cré une ligne de commande
			LigneCommande lc = new LigneCommande();
			//Je definit cette line de commande
			lc.setProduit(p);
			lc.setQuantite(quantite);
			lc.setPrix(p.getPrix());
		}
		else {
			LigneCommande lc = ligneCommandes.get(p.getIdProduit());
			lc.setQuantite(lc.getQuantite() + quantite);
		}
	}
	
	//2: Qui permet de consulter la liste des ligne de commande
	public Collection<LigneCommande> getLigneCommandes(){
		return ligneCommandes.values(); //je passe vers value comme c'est une collection de type Map et recupere juste la liste de comman
	}
	
	//3: Qui permet de retourner le total du panier
	public double getTotal(){
		double total = 0;
		for(LigneCommande lc:ligneCommandes.values()){
			total +=lc.getPrix() * lc.getQuantite();
		}
		return total;
	}
	
	//4: Qui permet de connaitre le nombre de produit
	public int getSize(){
		return ligneCommandes.size();
	}
	
	//5: Qui permet de supprimer une ligne de panier
	public void deletedLigneCommande(Long idProduit){
		ligneCommandes.remove(idProduit);
		
		
	}
	

}
