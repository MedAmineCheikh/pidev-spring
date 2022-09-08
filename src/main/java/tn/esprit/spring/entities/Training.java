package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Training implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String idTrainning;
	private String TrainningName;
	private String TrainerName;
	private String Duration;
	private String Files;
	private String Description;
	@Temporal(TemporalType.DATE)
	private Date TrainingDate;
	@Enumerated(EnumType.STRING)
	Theme Theme;
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	public  List<Certificat> certificat;
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private List<User> users;
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JsonIgnore
	private List<FileDB> fileDB;
}
