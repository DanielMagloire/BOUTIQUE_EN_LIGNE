package Dan.org.eboutique;

import static org.junit.Assert.*;



import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;



 
public class TestJPA {
	//Attribut
	/*ClassPathXmlApplicationContext context;*/

	@Before
	public void setUp() throws Exception {
		//Initialisation
		/*context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"} );*/
	}
	
	//Ce test unitaire de JUnit nous permet de voir si la base de données a été créée ou non
	@Test
	public void testCreationBD() {
		try{
			ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"} );
			assertTrue(true);
		}catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}
	
	//Ce test unitaire de JUnit nous permet de voir si nous pouvons ajouter les catégories dans la base de données 
	//Nous allons tout d'abord dans le fichier applicationContext.xml créer les beans: dao, instance metier et ont fait l'injection de cette instance metier
	
	/*@Test       //Celui ci ne passe pas
	public void test1() {
		try{
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"} );
			IAdminCategoriesMetier metier = (IAdminCategoriesMetier) context.getBean("metier"); //on lui dde de nous donner un bean appelé metier
			
			//Recuperer la liste des catégories à partir de la couche métier
			List<Categorie> ctg = metier.listCategories();
			metier.ajouterCategorie(new Categorie("Ordinateurs", "Ordi", null, "image1.jpg"));
			metier.ajouterCategorie(new Categorie("Imprimantes", "Imp", null, "image1.jpg"));
			List<Categorie> ctg1 = metier.listCategories();
			assertTrue(ctg.size()+2 == ctg1.size());
		}catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}*/
	
	//Pour que cela marche, nous devons ajouter l'annotation @Transactional à la classe BoutiqueMetierImpl et la validation au niveau de l'attribut description qui doit prendre au minimum 8 caracteres et nous en avons mis que 3
	
	/*@Test    
	public void testCategorie() {
		try{
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"} );
			IAdminCategoriesMetier metier = (IAdminCategoriesMetier) context.getBean("metier"); //on lui dde de nous donner un bean appelé metier
			
			//Recuperer la liste des catégories à partir de la couche métier
			List<Categorie> ctg = metier.listCategories();
			metier.ajouterCategorie(new Categorie("Ordinateurs", "Ordinateur neuf", null, "image1.jpg"));
			metier.ajouterCategorie(new Categorie("Imprimantes", "Imprimante neuve", null, "image1.jpg"));
			List<Categorie> ctg1 = metier.listCategories();
			assertTrue(ctg.size()+2 == ctg1.size());
		}catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}*/
	
	/*@Test    
	public void testProduit() {
		try{
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"applicationContext.xml"} );
			IAdminProduitsMetier metier = (IAdminProduitsMetier) context.getBean("metier"); //on lui dde de nous donner un bean appelé metier
			
			//Recuperer la liste des produits à partir de la couche métier
			List<Produit> pdt = metier.listproduits();
			metier.ajouterProduit(new Produit("HP45ERT", "Bonne marque", 65000, 20, true, "image.jpg"), 1L);
			metier.ajouterProduit(new Produit("HP55UERT", "Meilleure marque", 75000, 30, true, "image.jpg"), 1L);
			List<Produit> pdt1 = metier.listproduits();
			assertTrue(pdt.size()+2 == pdt1.size());
		}catch (Exception e) {
			assertTrue(e.getMessage(), false);
		}
	}*/
}
