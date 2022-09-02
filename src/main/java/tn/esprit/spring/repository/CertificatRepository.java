package tn.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.spring.entities.Certificat;
@Repository
public interface CertificatRepository extends CrudRepository<Certificat, Integer> {

}
