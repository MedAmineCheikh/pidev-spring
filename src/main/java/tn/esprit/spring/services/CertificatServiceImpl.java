package tn.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.dto.updatecertifcatdto;
import tn.esprit.spring.entities.Certificat;
import tn.esprit.spring.entities.Training;
import tn.esprit.spring.mappers.certififcatmapper;
import tn.esprit.spring.repository.CertificatRepository;
import tn.esprit.spring.repository.TrainingRepository;
@Service
public class CertificatServiceImpl implements ICertificatsService {

	@Autowired
	CertificatRepository certificatRepository;
	@Autowired
	TrainingRepository trainingRepository;
	@Autowired
	certififcatmapper certififcatmappers;
	@Override
	public List<Certificat> retrieveAllCertificats() {
		// TODO Auto-generated method stub
		
		return (List<Certificat>)certificatRepository.findAll();
	}

	@Override
	public Certificat addCertificats(Certificat c) {
		// TODO Auto-generated method stub
		return certificatRepository.save(c);
	}

	@Override
	public void deleteCertificats(Integer id) {
		// TODO Auto-generated method stub
		certificatRepository.deleteById(id);;
		
	}

	@Override
	public void updateCertificats(updatecertifcatdto dto) {
		// TODO Auto-generated method stub
		Certificat certificat= certificatRepository.findById(dto.getIdCerteficat()).get();
		certififcatmappers.updateCertifiFromDto(dto,certificat);
		certificatRepository.save(certificat);
	}

	@Override
	public Certificat retrieveCertificats(Integer id) {
		// TODO Auto-generated method stub
		Certificat c=certificatRepository.findById(id).get();
		return c;
	}
	@Override
	public void affecterCertificatToTraining(int idCer, String idTraining) {
		Certificat certificat = certificatRepository.findById(idCer).get();
		Training training = trainingRepository.findByIdTrainning(idTraining);
		training.getCertificat().add(certificat);
		trainingRepository.save(training);

	}

}
