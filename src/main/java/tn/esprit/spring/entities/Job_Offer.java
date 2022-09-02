package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Job_Offer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdOffer;
	private String PartnerName;
	@Temporal(TemporalType.DATE)
	private Date Start_Date;
	@Temporal(TemporalType.DATE)
	private Date End_Date;
	private Long Description;
	@ManyToOne
	User user;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="job_offer")
	private List<Job_Post> job_post;
}
