package tn.esprit.spring.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.spring.dto.updatetrainingdto;
import tn.esprit.spring.entities.FileDB;
import tn.esprit.spring.entities.Theme;
import tn.esprit.spring.entities.Training;
import tn.esprit.spring.mappers.trainingmapper;
import tn.esprit.spring.repository.FileDBRepository;
import tn.esprit.spring.repository.TrainingRepository;
import tn.esprit.spring.repository.UserRepository;

@Service
@Transactional
public class TrainingServiceImpl implements ITrainingService {
@Autowired
	UserRepository userRepository;
@Autowired
trainingmapper trainingmappers;
	@Autowired
	private FileDBRepository fileDBRepository;
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
	public void deleteTraining(String id) {
		// TODO Auto-generated method stub
		Training training=trainingRepository.findByIdTrainning(id);
		trainingRepository.delete(training);
	}

	@Override
	public void  updateTraining(updatetrainingdto dto){
		Training training=trainingRepository.findByIdTrainning(dto.getIdTrainning());
		trainingmappers.updateTrainFromDto(dto,training);
		trainingRepository.save(training);
	}

	@Override
	public Training retrieveTraining(String id) {
		// TODO Auto-generated method stub
		Training c=trainingRepository.findByIdTrainning(id);

		return c;
	}

	@Override
	public List<Training> findByTheme(Theme Theme) {
		return null;
	}
	@Override
	public Page<Training> paginationTraining(int pagenbr,int pagesize){
		Page<Training> trainingPage= trainingRepository.findAll(PageRequest.of(pagenbr,pagesize));
return trainingPage;
	}
@Override
	public FileDB store(MultipartFile file,String idf) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		String id = idf;
		FileDB FileDB = new FileDB(id,fileName, file.getContentType(), file.getBytes());
		return fileDBRepository.save(FileDB);

	}
@Override
	public FileDB getFile(String id) {

		return fileDBRepository.findById(id).get();
	}

	@Override
	public void addfiletotraining(String id,String idt) {
		FileDB fileDB=fileDBRepository.findById(id).get();
		Training training=trainingRepository.findByIdTrainning(idt);
		training.getFileDB().add(fileDB);

	}

	@Override
	public List<FileDB> getTrainingsFiles(String id) {
		Training training=trainingRepository.findByIdTrainning(id);
		List<FileDB> fileDBList =new ArrayList<>();
		for (FileDB fileDB:training.getFileDB())
		{
				fileDBList.add(fileDB);
		}
		return fileDBList;
	}

	@Override
	public Stream<FileDB> getAllFiles() {
		return fileDBRepository.findAll().stream();
	}
}
	


