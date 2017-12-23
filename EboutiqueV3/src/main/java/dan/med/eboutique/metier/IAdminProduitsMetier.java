package dan.med.eboutique.metier;

import dan.med.eboutique.entities.Produit;

//Un AdminProduit peut utiliser les méthodes qui sont dans InternauteMetier. Donc il y a héritage
public interface IAdminProduitsMetier extends InternauteMetier {
	public Long ajouterProduit(Produit p, Long idCat);  //Peut ajouter les produits
	public void supprimerProduit(Long idP); //Supprimer
	public void modifierProduit(Produit p); //Modifier
}
