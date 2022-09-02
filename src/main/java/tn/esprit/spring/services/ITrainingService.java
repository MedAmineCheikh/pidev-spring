package tn.esprit.spring.services;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.Theme;
import tn.esprit.spring.entities.Training;
import tn.esprit.spring.entities.User;



public interface ITrainingService {

	List<Training> retrieveAllTraining();
	Training addTraining(Training c);
	void deleteTraining(Integer id);
	Training updateTraining(Training c);
	Training retrieveTraining(Integer id);
	List<Training> findByTheme(Theme Theme);
//	List<Training> findByall(String training,String trainer,Theme Theme);
	//public List<Training> suggestionTouser(int idaccount);
}
