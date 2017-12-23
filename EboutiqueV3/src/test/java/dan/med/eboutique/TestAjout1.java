package dan.med.eboutique;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dan.med.eboutique.entities.Categorie;
import dan.med.eboutique.entities.Produit;
import dan.med.eboutique.metier.IAdminCategoriesMetier;

public class TestAjout1 {
	/*ClassPathXmlApplicationContext context;*/
	
	@Before
	public void setUp() throws Exception {
		/*context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"} );*/
	}

	@Test
	public void testAjoutProduit() {
		try{
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"} );
			IAdminCategoriesMetier metier = (IAdminCategoriesMetier) context.getBean("metier");
			//On recupère la liste des produits
			List<Produit> pdt1 = metier.listproduits();
			
			//On ajoute les produits
			metier.ajouterProduit(new Produit("HP45ERT", "Bonne marque", 2000, 10, true, "image1.jpeg"), 1L);
			metier.ajouterProduit(new Produit("JET806OT","Marque Allemande", 6000, 13, true, "image2.jpeg"), 1L);
			metier.ajouterProduit(new Produit("TOSHIBA", "Bonne marque", 5000, 5, true, "image2.jpeg"), 1L);
			
			//On recupère à nouveau la liste des catégories
			List<Produit> pdt2 = metier.listproduits();
			assertTrue(pdt1.size()+3 == pdt2.size()); //Condition à vérifier que le test est vrai
		}catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}

}
