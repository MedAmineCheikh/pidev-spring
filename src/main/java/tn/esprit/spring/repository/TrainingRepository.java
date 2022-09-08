package tn.esprit.spring.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Theme;
import tn.esprit.spring.entities.Training;
@Repository
public interface TrainingRepository extends CrudRepository<Training, Integer> {

    Training findByIdTrainning(String id);
    Page<Training>  findAll(Pageable pageable);
}

	               
				
