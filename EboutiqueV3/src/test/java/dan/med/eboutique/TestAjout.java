package dan.med.eboutique;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dan.med.eboutique.entities.Categorie;
import dan.med.eboutique.metier.IAdminCategoriesMetier;

public class TestAjout {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAjoutCategorie() {
		try{
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"} );
			IAdminCategoriesMetier metier = (IAdminCategoriesMetier) context.getBean("metier");
			//On recupère la liste des catégories
			List<Categorie> cts1 = metier.listCategories();
			//On ajoute les catégorie
			metier.ajouterCategorie(new Categorie("Ordinateur", "Ordinateur neuf", null, "image1.jpeg"));
			metier.ajouterCategorie(new Categorie("Imprimante", "Imprimante ocassion", null, "image2.jpeg"));
			
			//On recupère à nouveau la liste des catégories
			List<Categorie> cts2 = metier.listCategories();
			assertTrue(cts1.size()+2 == cts2.size()); //Condition à vérifier que le test est vrai
		}catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}

}
