package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Certificat;

public interface ICertificatsService  {
	List<Certificat> retrieveAllCertificats();
	Certificat addCertificats(Certificat c);
	void deleteCertificats(Integer id);
	Certificat updateCertificats(Certificat c);
	Certificat retrieveCertificats(Integer id);
	void affecterCertificatToTraining(int idCer, int idTraining);

}
