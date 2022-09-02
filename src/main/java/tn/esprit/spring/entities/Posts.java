package tn.esprit.spring.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
public class Posts implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int IdPosts;
	private String Post_Title;
	private String Post_Description;
	private String Picture;
	private String Rating;
	@Temporal(TemporalType.DATE)
	private Date Date_post;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="posts")
	private List<Comments> comments;
	
	@ManyToMany(mappedBy="posts", cascade = CascadeType.ALL)
	private List<User> users;
	@ManyToOne
	Forum forum ;

}
