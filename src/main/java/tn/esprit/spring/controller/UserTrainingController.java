package tn.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entities.Theme;
import tn.esprit.spring.entities.Training;
import tn.esprit.spring.services.ITrainingService;
import tn.esprit.spring.services.IUserService;

@RestController
@RequestMapping("/userTraining")
public class UserTrainingController {
	@Autowired
	IUserService UserService;
	@Autowired
	ITrainingService trainingService;
	// http://localhost:8089/SpringMVC/userTraining/retrieve-all-trainings
		@GetMapping("/retrieve-all-trainings")
		public List<Training> getTrainings() {
		List<Training> listTrainings = trainingService.retrieveAllTraining();
		return listTrainings;
		}
		// http://localhost:8089/SpringMVC/userTraining/affecter-user-training/{id-user}/{id-training}
		@PutMapping("/affecter-user-training/{id-user}/{id-training}")
		public void affecterUserToTraining(@PathVariable("id-user") int idUser, @PathVariable("id-training") String idTraining){
			UserService.affecterUserToTraining(idUser,idTraining);
			}
		@GetMapping("/findBytheme/{Theme}")
		public  List<Training> findByTheme(@PathVariable("Theme") Theme Theme) {
			return trainingService.findByTheme(Theme);
		}
		
}
