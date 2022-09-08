package tn.esprit.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class updatecertifcatdto {
    private int IdCerteficat;
    private String nomCerteficate;
    private Date date;
    private String username;
    private String trainername;
    private String duration;
    private String email;
}
