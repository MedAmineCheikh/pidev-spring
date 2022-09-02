package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdAccount;
	private String nom;
	private String prenom;
	@Temporal(TemporalType.DATE)
	private java.util.Date dateNaissance;
    private String email;
	private String Username;
	private String Password;
	@Enumerated(EnumType.STRING)
	Role Role;
	@Enumerated(EnumType.STRING)
	Theme Theme;
	private Double Balance;
	private String Location;
	private Boolean Status;
	private String Current_Trainning;
	private String Finished_Trainning;
	private Long About;

	@OneToOne
	 Calendar calendar;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private List<Job_Offer> job_offer;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private List<Job_Post> job_post;
	
	@ManyToMany(mappedBy="users", cascade = CascadeType.ALL)
	private List<Training>  trainings;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="user")
	private List<Favorite> favorite;
	
	@ManyToMany(mappedBy="users", cascade = CascadeType.ALL)
	private List<Comments> comments;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Posts> posts;
	@ManyToMany(mappedBy="users", cascade = CascadeType.ALL)
	private List<Event> event;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="users")
	private List<Reclamation> reclamations;
}
