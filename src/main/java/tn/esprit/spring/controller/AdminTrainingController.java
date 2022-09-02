package tn.esprit.spring.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.esprit.spring.entities.Training;
import tn.esprit.spring.services.ITrainingService;
import tn.esprit.spring.utils.FileDownloadutil;
import tn.esprit.spring.utils.FileUploadResponse;
import tn.esprit.spring.utils.FileUploadUtil;


@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/adminTraining")
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
		@GetMapping("/retrieve-training/{training-id}")
		public Training retrieveTraining(@PathVariable("training-id") Integer trainingId) {
		return trainingService.retrieveTraining(trainingId);
		}
		// http://localhost:8089/SpringMVC/adminTraining/add-training
		@PostMapping("/add-training")
		public Training addTraining(@RequestBody Training c) {
			return trainingService.addTraining(c);
			}		
		
		// http://localhost:8089/SpringMVC/adminTraining/remove-training/{training-id}
		@DeleteMapping("/remove-training/{training-id}")
		@ResponseBody
		public void removeTraining1(@PathVariable("training-id") Integer trainingId) {
		trainingService.deleteTraining(trainingId);
		}
		// http://localhost:8089/SpringMVC/adminTraining/modify-training/1
		@PutMapping("/modify-training/{id}")
		@ResponseBody
		public Training updateTraining(@PathVariable("id") int IdTraining,@RequestBody Training training) {
		return trainingService.updateTraining(training);
		}
//		// http://localhost:8089/SpringMVC/adminTraining/findByall
//		@GetMapping("/findByall/{training}/{trainer}/{Theme}")
//		public  List<Training> findByall(@PathVariable("training")String training,@PathVariable("trainer")String trainer,@PathVariable("Theme")Theme Theme) {
//			return trainingService.findByall(training, trainer, Theme);
//			}
		//@GetMapping("/suggestionTouser/{idaccount}")
		//public  List<Training> suggestionTouser (@PathVariable("idaccount") int idaccount){
			//return trainingService.suggestionTouser(idaccount);
			//}
		@PostMapping("/uploadFile")
		public ResponseEntity<FileUploadResponse> uploadFile(
		@RequestParam( "file") MultipartFile multipartFile) throws IOException {

		String fileName = StringUtils. cleanPath(multipartFile. getOriginalFilename( ) ) ;
		long size = multipartFile. getSize( );
		String fileCode = FileUploadUtil . saveFile(fileName, multipartFile);

		FileUploadResponse response = new FileUploadResponse( ) ;
		response. setFileName (fileName) ;
		response . setSize (size) ;
		response. setDownloadUri("/downloadFile/" + fileCode);
		return new ResponseEntity<> (response, HttpStatus. OK);
		}
		
		@GetMapping ( "/downloadFile/{fileCode}")
		public ResponseEntity<?> downloadFile(@PathVariable("fileCode") String fileCode) {
		FileDownloadutil downloadUtil = new FileDownloadutil( );
		Resource resource = null;

		try {
		resource = downloadUtil . getFileAsResource(fileCode) ;
		} catch (IOException e) {
		return ResponseEntity . internalServerError() . build( );
		}
		if (resource == null) {
		return new ResponseEntity<> ("File not found", HttpStatus. NOT_FOUND);
		}
		String contentType = "application/octet-stream" ;
		String headerValue = "attachment; filename=\"" + resource. getFilename() + "\"";

		return ResponseEntity . ok( )

. contentType (MediaType.parseMediaType(contentType) )
. header (HttpHeaders . CONTENT_DISPOSITION, headerValue)
. body (resource) ;
		}

}
