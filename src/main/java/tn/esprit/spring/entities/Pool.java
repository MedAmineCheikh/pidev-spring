package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pool implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdPool;
	private String NamePool;
	private int NbDonateur;
	private int Sum;
	private int Goal ;
	private String Description;
	
	@OneToOne
	private Event event;
	
	 
	@OneToMany(cascade = CascadeType.ALL, mappedBy="pool")
	private List<Particip_Donation> Particip_donation;
}
	