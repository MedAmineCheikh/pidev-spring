package tn.esprit.spring.services;

import java.util.List;

import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.Training;

public interface IUserService {

	void affecterUserToTraining(int iduser, String idTraining);
	
}
