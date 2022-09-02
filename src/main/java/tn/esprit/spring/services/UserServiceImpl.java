package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Training;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.TrainingRepository;
import tn.esprit.spring.repository.UserRepository;
@Service
public class UserServiceImpl implements IUserService {


	@Autowired
	TrainingRepository trainingRepository;
	@Autowired
	UserRepository userRepository;
	@Override
	public void affecterUserToTraining(int iduser, int idTraining) {
		User user = userRepository.findById(iduser).get();
		Training training = trainingRepository.findById(idTraining).get();
		training.getUsers().add(user);
		trainingRepository.save(training);
		
		
	}
	
}
