package Dan.org.eboutique.metier;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import Dan.org.eboutique.dao.IBoutiqueDAO;
import Dan.org.eboutique.entities.Categorie;
import Dan.org.eboutique.entities.Client;
import Dan.org.eboutique.entities.Commande;
import Dan.org.eboutique.entities.Panier;
import Dan.org.eboutique.entities.Produit;
import Dan.org.eboutique.entities.Role;
import Dan.org.eboutique.entities.User;

@Transactional
public class BoutiqueMetierImpl implements IAdminCategoriesMetier {
	//Nous devons ici être lié à ces interfaces ci-dessou
	private IBoutiqueDAO dao;
	//Pour l'injection, nous devons générer le setdao
	
	public void setDao(IBoutiqueDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public Long ajouterProduit(Produit p, Long idCat) {
		// TODO Auto-generated method stub
		return dao.ajouterProduit(p, idCat);
	}

	@Override
	public void supprimerProduit(Long idP) {
		dao.supprimerProduit(idP);
	}

	@Override
	public void modifierProduit(Produit p) {
		dao.modifierProduit(p); 
	}

	@Override
	public List<Categorie> listCategories() {
		// TODO Auto-generated method stub
		return dao.listCategories();
	}

	@Override
	public Categorie getCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return dao.getCategorie(idCat);
	}

	@Override
	public List<Produit> listproduits() {
		// TODO Auto-generated method stub
		return dao.listproduits();
	}

	@Override
	public List<Produit> produitsParMotCle(String mc) {
		// TODO Auto-generated method stub
		return dao.produitsParMotCle(mc);
	}

	@Override
	public List<Produit> produitsParCategorie(Long idCat) {
		// TODO Auto-generated method stub
		return dao.produitsParCategorie(idCat);
	}

	@Override
	public List<Produit> produitsSelectionnes() {
		// TODO Auto-generated method stub
		return dao.produitsSelectionnes();
	}

	@Override
	public Produit getProduit(Long idP) {
		// TODO Auto-generated method stub
		return dao.getProduit(idP);
	}

	@Override
	public Commande enregistrerCommande(Panier p, Client c) {
		// TODO Auto-generated method stub
		return dao.enregistrerCommande(p, c);
	}

	@Override
	public Long ajouterCategorie(Categorie c) {
		// TODO Auto-generated method stub
		return dao.ajouterCategorie(c);
	}

	@Override
	public void supprimerCategrorie(Long idcat) {
		dao.supprimerCategrorie(idcat);
		
	}

	@Override
	public void modifierCategorie(Categorie c) {
		dao.modifierCategorie(c);
		
	}

	@Override
	public void ajouterUser(User u) {
		dao.ajouterUser(u);
		
	}

	@Override
	public void attribuerRole(Role r, Long userID) {
		dao.attribuerRole(r, userID);
	}

}
