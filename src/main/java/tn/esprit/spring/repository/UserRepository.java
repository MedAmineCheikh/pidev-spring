package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Training;
import tn.esprit.spring.entities.User;
@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
	
}
