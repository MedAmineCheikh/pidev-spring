package tn.esprit.spring.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tn.esprit.spring.dto.updatetrainingdto;
import tn.esprit.spring.entities.FileDB;
import tn.esprit.spring.entities.ResponseFile;
import tn.esprit.spring.entities.ResponseMessage;
import tn.esprit.spring.entities.Training;
import tn.esprit.spring.services.ITrainingService;
import tn.esprit.spring.utils.FileDownloadutil;
import tn.esprit.spring.utils.FileUploadResponse;
import tn.esprit.spring.utils.FileUploadUtil;


@RestController
@CrossOrigin(origins="http://localhost:4200")

public class AdminTrainingController {

	
	@Autowired
	ITrainingService trainingService;
	
	// http://localhost:8089/SpringMVC/adminTraining/retrieve-all-trainings
		@GetMapping("/retrieve-all-trainings")
		public List<Training> getTrainings() {
		List<Training> listTrainings = trainingService.retrieveAllTraining();
		return listTrainings;
		}
		// http://localhost:8089/SpringMVC/adminTraining/retrieve-training/8
		@GetMapping("/retrieve-training/{IdTrainning}")
		public Training retrieveTraining(@PathVariable String IdTrainning) {
		return trainingService.retrieveTraining(IdTrainning);
		}
		// http://localhost:8089/SpringMVC/adminTraining/add-training
		@PostMapping("/add-training")
		public Training addTraining(@RequestBody Training c) {
			return trainingService.addTraining(c);
			}		
		
		// http://localhost:8089/SpringMVC/adminTraining/remove-training/{training-id}
		@DeleteMapping("/remove-training/{training-id}")
		@ResponseBody
		public void removeTraining1(@PathVariable("training-id") String trainingId) {
		trainingService.deleteTraining(trainingId);
		}
		// http://localhost:8089/SpringMVC/adminTraining/modify-training/1
		@PutMapping("/modify-training")
		@ResponseBody
		public void updateTraining(@RequestBody updatetrainingdto training) {
		trainingService.updateTraining(training);
		}


	// http://localhost:8089/SpringMVC/retrieve-training/pageable
	@GetMapping("/retrieve-training/pageable")
	public Page<Training> retrieveTrainingPageable(@RequestParam(name = "page",defaultValue = "0") int pagenbr,
												   @RequestParam (name = "size",defaultValue = "3")int pagesize) {
		return trainingService.paginationTraining(pagenbr,pagesize);
	}


	@PostMapping("/upload/{idf}")
	public ResponseEntity<ResponseMessage> uploadFile(@ModelAttribute("file") MultipartFile file,@PathVariable String idf) {
		String message = "";
		try {
			trainingService.store(file,idf);
			message = "Uploaded the file successfully: " + file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		} catch (Exception e) {
			message = "Could not upload the file: " + file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
	@GetMapping("/files")
	public ResponseEntity<List<ResponseFile>> getListFiles() {
		List<ResponseFile> files = trainingService.getAllFiles().map(dbFile -> {
			String fileDownloadUri = ServletUriComponentsBuilder
					.fromCurrentContextPath()
					.path("/files/")
					.path(dbFile.getId())
					.toUriString();
			return new ResponseFile(
					dbFile.getName(),
					fileDownloadUri,
					dbFile.getType(),
					dbFile.getData().length);
		}).collect(Collectors.toList());
		return ResponseEntity.status(HttpStatus.OK).body(files);
	}
	@GetMapping("/files/{id}")
	public ResponseEntity<byte[]> getFile(@PathVariable String id) {
		FileDB fileDB = trainingService.getFile(id);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
				.body(fileDB.getData());
	}
	@PutMapping("/addfiletotraining/{id}/{idt}")
	public void addfiletotraining(@PathVariable String id,@PathVariable String idt,@RequestBody Training t){
		trainingService.addfiletotraining(id,idt);
	}

	@GetMapping("/myfiles/{id}")
	public  ResponseEntity<List<ResponseFile>> getTrainingsFiles(@PathVariable String id){

		List<ResponseFile> files =trainingService.getTrainingsFiles(id).stream().map(dbFile -> {
			String fileDownloadUri = ServletUriComponentsBuilder
					.fromCurrentContextPath()
					.path("/files/")
					.path(dbFile.getId())
					.toUriString();
			return new ResponseFile(
					dbFile.getName(),
					fileDownloadUri,
					dbFile.getType(),
					dbFile.getData().length);
		}).collect(Collectors.toList());
			return ResponseEntity.status(HttpStatus.OK).body(files);
	}
}
