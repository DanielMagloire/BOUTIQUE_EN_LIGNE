package dan.med.eboutique.metier;

import dan.med.eboutique.entities.Categorie;
import dan.med.eboutique.entities.Role;
import dan.med.eboutique.entities.User;

public interface IAdminCategoriesMetier extends IAdminProduitsMetier {

	public Long ajouterCategorie(Categorie c);
	public void supprimerCategrorie(Long idcat);
	public void modifierCategorie(Categorie c);
	public void ajouterUser(User u);
	public void attribuerRole(Role r,Long userID);
}
