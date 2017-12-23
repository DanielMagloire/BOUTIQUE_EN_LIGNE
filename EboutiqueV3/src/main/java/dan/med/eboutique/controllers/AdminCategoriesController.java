package dan.med.eboutique.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.validation.Valid;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import dan.med.eboutique.entities.Categorie;
import dan.med.eboutique.metier.IAdminCategoriesMetier;


	@Controller
	@RequestMapping(value = "/adminCat") //Pour dire que tous les liens (URL) pour aller vers la gestion des Categories commencent par adminCat
	public class AdminCategoriesController {
		@Autowired  //Dire à Spring qu'au moment du demarrage de cherche un objet qui implemente cet interface et l'associer à metier
		private IAdminCategoriesMetier metier;
		
		@RequestMapping(value = "/index")
		public String index(Model model){
			//Creation d'un formulaire
			model.addAttribute("Categorie", new Categorie()); //Ceci pour la saisie d'une catégorie
			model.addAttribute("Categories", metier.listCategories());//Ceci pour afficher toutes les catégories
			return "categories";
		}
		
		@RequestMapping(value = "/saveCat")
		public String saveCat(@Valid Categorie c, BindingResult bindingResult, Model model, MultipartFile file) throws IOException{
			
			if(bindingResult.hasErrors()){
				model.addAttribute("Categories", metier.listCategories());
				return"categories";
			}
			if(!file.isEmpty()){
				BufferedImage bi = ImageIO.read(file.getInputStream());
				c.setPhoto(file.getBytes()); 
				c.setNomphoto(file.getOriginalFilename());
			}
			metier.ajouterCategorie(c);
			
			model.addAttribute("Categorie", new Categorie()); //Ceci pour la saisie d'une catégorie
			model.addAttribute("Categories", metier.listCategories());//Ceci pour afficher toutes les catégories
			return "categories";
		}
		
		@RequestMapping(value ="photoCat", produces = MediaType.IMAGE_JPEG_VALUE)
		@ResponseBody
		public byte[] photoCat(Long idCat) throws IOException{
			Categorie c = metier.getCategorie(idCat);
			return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto()));
			//return IOUtils.toByteArray(new ByteArrayInputStream(c.getPhoto()));
		}

	}
