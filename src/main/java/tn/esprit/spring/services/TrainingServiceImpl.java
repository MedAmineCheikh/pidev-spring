package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Theme;
import tn.esprit.spring.entities.Training;
import tn.esprit.spring.repository.TrainingRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
public class TrainingServiceImpl implements ITrainingService {
@Autowired
	UserRepository userRepository;
	@Autowired
	TrainingRepository trainingRepository;
	@Override
	public List<Training> retrieveAllTraining() {
		// TODO Auto-generated method stub
		return (List<Training>)trainingRepository.findAll();
	}

	@Override
	public Training addTraining(Training c) {
		// TODO Auto-generated method stub
		return trainingRepository.save(c);
	}

	@Override
	public void deleteTraining(Integer id) {
		// TODO Auto-generated method stub
		trainingRepository.deleteById(id);
	}

	@Override
	public Training updateTraining(Training c) {
		// TODO Auto-generated method stub
		return trainingRepository.save(c);
	}

	@Override
	public Training retrieveTraining(Integer id) {
		// TODO Auto-generated method stub
		Training c=trainingRepository.findById(id).get();
		return c;
	}
	@Override
	public List<Training> findByTheme(Theme Theme){
		return trainingRepository.findByTheme(Theme);
	}
//	@Override
//	public List<Training> findByall(String training, String trainer,Theme Theme){
//		return trainingRepository.findByall(training, trainer, Theme);
//	}	
//	
	//@Override
	//public List<Training> suggestionTouser(int idaccount){
		//return trainingRepository.suggestionTouser(idaccount);}
		
	}
	


