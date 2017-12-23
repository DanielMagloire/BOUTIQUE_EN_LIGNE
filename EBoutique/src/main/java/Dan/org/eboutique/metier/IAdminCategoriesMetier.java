package Dan.org.eboutique.metier;

import Dan.org.eboutique.entities.Categorie;
import Dan.org.eboutique.entities.Role;
import Dan.org.eboutique.entities.User;

public interface IAdminCategoriesMetier extends IAdminProduitsMetier {
	public Long ajouterCategorie(Categorie c);
	public void supprimerCategrorie(Long idcat);
	public void modifierCategorie(Categorie c);
	public void ajouterUser(User u);
	public void attribuerRole(Role r,Long userID);
}
