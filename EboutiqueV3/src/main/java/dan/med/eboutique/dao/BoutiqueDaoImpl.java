package dan.med.eboutique.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dan.med.eboutique.entities.LigneCommande;
import dan.med.eboutique.entities.Categorie;
import dan.med.eboutique.entities.Client;
import dan.med.eboutique.entities.Commande;
import dan.med.eboutique.entities.Panier;
import dan.med.eboutique.entities.Produit;
import dan.med.eboutique.entities.Role;
import dan.med.eboutique.entities.User;

public class BoutiqueDaoImpl implements IBoutiqueDAO {

	//Délaration d'un entitymanager et pour faire l'injection @PersistenceContext
		@PersistenceContext
		private EntityManager em;
		

		@Override
		public Long ajouterCategorie(Categorie c) {
			em.persist(c);
			return c.getIdcategorie();
		}

		@Override
		public List<Categorie> listCategories() {
			Query req = em.createQuery("select c from Categorie c");
			return req.getResultList();
		}

		@Override //Consulter une categorie
		public Categorie getCategorie(Long idCat) {
			return em.find(Categorie.class, idCat);
		}

		@Override
		public void supprimerCategrorie(Long idcat) {
			// Il faut tout d'abord la charge
			Categorie c = em.find(Categorie.class, idcat);
			//Et on supprime car nous supposons qu'elle existe
			em.remove(c);
			
		}

		@Override
		public void modifierCategorie(Categorie c) {
			em.merge(c);
		}

		@Override
		public Long ajouterProduit(Produit p, Long idCat) {
			Categorie c = getCategorie(idCat); //On lui associe une catégorie pour ajouter ce produit
			p.setCategorie(c);
			em.persist(p);
			return p.getIdProduit();
		}

		@Override
		public List<Produit> listproduits() {
			Query req = em.createQuery("select p from Produit p");
			return req.getResultList();
		}

		@Override
		public List<Produit> produitsParMotCle(String mc) {
			Query req = em.createQuery("select p from Produit p where p.designation like : x or p.description like : x");
			req.setParameter("x", "%" + mc + "%");
			return req.getResultList();
		}

		@Override
		public List<Produit> produitsParCategorie(Long idCat) {
			Query req = em.createQuery("select p from Produit p where p.categorie.idCategorie = : x");
			req.setParameter("x", idCat);
			return req.getResultList();
		}

		@Override
		public List<Produit> produitsSelectionnes() {
			//Chercher tous les produits ui sont selectionnés
			Query req = em.createQuery("select p from Produit p where p.selected = true");
			return req.getResultList();
		}

		@Override
		public Produit getProduit(Long idP) {
			//Consulter un produit
			return em.find(Produit.class, idP);
		}

		@Override
		public void supprimerProduit(Long idP) {
			// Cherche tout d'abord le produit à partir de sn Id
			Produit p = getProduit(idP);
			em.remove(p);
		}

		@Override
		public void modifierProduit(Produit p) {
			em.merge(p);
		}

		@Override
		public void ajouterUser(User u) {
			em.persist(u);
		}

		@Override
		public void attribuerRole(Role r, Long userID) {
			User u = em.find(User.class, userID); //Nous recuperons tout d'abord l'utilisateur
			u.getRoles().add(r); //Associer le role à cette utilisateur
			em.persist(r); //Puis nous enregistrons le role
		}

		@Override
		public Commande enregistrerCommande(Panier p, Client c) {
			em.persist(c); // Tout dabord enregistrer le client
			Commande cmd = new Commande();//Créer une commande
			//Ensuite, definissons les informations sur la commande
			cmd.setDateCommande(new Date());
			cmd.setLigneCommandes(p.getLigneCommandes());//collection de ligne de commande
			//Enregistrer les ligne de commandes. On fait une boucles
			for(LigneCommande lc : p.getLigneCommandes()){
				em.persist(lc);
			}
			em.persist(cmd);//Enfin nous enregistrons la commande
			return cmd;
		}

	}

