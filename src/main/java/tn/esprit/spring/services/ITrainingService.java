package tn.esprit.spring.services;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;

import org.springframework.web.multipart.MultipartFile;
import tn.esprit.spring.dto.updatetrainingdto;
import tn.esprit.spring.entities.FileDB;
import tn.esprit.spring.entities.Theme;
import tn.esprit.spring.entities.Training;
import tn.esprit.spring.entities.User;



public interface ITrainingService {

	List<Training> retrieveAllTraining();
	Training addTraining(Training c);
	void deleteTraining(String id);
void  updateTraining(updatetrainingdto dto);
	Training retrieveTraining(String id);
	List<Training> findByTheme(Theme Theme);
	public Page<Training> paginationTraining(int pagenbr, int pagesize);
	public Stream<FileDB> getAllFiles();
	public FileDB store(MultipartFile file,String idf) throws IOException;
	public FileDB getFile(String id);

	public void addfiletotraining(String id,String idt);
	public List<FileDB> getTrainingsFiles(String id);
}
