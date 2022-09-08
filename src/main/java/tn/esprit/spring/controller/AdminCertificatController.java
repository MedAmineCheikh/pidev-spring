package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.dto.updatecertifcatdto;
import tn.esprit.spring.entities.Certificat;
import tn.esprit.spring.services.ICertificatsService;
import tn.esprit.spring.services.ITrainingService;
import tn.esprit.spring.services.mailservice;

@RestController
@CrossOrigin(origins="http://localhost:4200")

public class AdminCertificatController {
	@Autowired
	ITrainingService trainingService;
	@Autowired
	mailservice mailservices;
	@Autowired
	ICertificatsService certificatService;
	// http://localhost:8089/SpringMVC/adminCertificat/retrieve-all-certificats
		@GetMapping("/retrieve-all-certificats")
		public List<Certificat> getCertificats() {
		List<Certificat> listCertificats = certificatService.retrieveAllCertificats();
		return listCertificats;
		}
		// http://localhost:8089/SpringMVC/adminCertificat/retrieve-certificat/8
		@GetMapping("/retrieve-certificat/{certificat-id}")
		public Certificat retrieveCertificats(@PathVariable("certificat-id") Integer certificatId) {
		return certificatService.retrieveCertificats(certificatId);
		}
		// http://localhost:8089/SpringMVC/adminCertificat/add-certificat
		@PostMapping("/add-certificat")
		public Certificat addCertificats(@RequestBody Certificat c) {
			mailservices.sendMessageWithAttachment(c.getEmail(),c.getUsername(),
					c.getNomCerteficate(),c.getTrainername());
		return certificatService.addCertificats(c);




		}
		// http://localhost:8089/SpringMVC/adminCertificat/remove-certificat/{certificat-id}
		@DeleteMapping("/remove-certificat/{certificat-id}")
		@ResponseBody
		public void removeCertificats1(@PathVariable("certificat-id") Integer certificatId) {
		certificatService.deleteCertificats(certificatId);
		}
		// http://localhost:8089/SpringMVC/adminCertificat/modify-certificat/1
		@PutMapping("/modify-certificat")
		@ResponseBody
		public void updateCertificats(@RequestBody updatecertifcatdto certificat) {
		certificatService.updateCertificats(certificat);
		}
		// http://localhost:8089/SpringMVC/adminCertificat/affecter-certificat-training/{id-certificat}/{id-training}
		@PutMapping("/affecter-certificat-training/{id-certificat}/{id-training}")
		public void affecterCertificatToTraining(@PathVariable("id-certificat") int idCer, @PathVariable("id-training") String idTraining){
			certificatService.affecterCertificatToTraining(idCer,idTraining);
			}

}
