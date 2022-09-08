package tn.esprit.spring.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "files")
@Getter@Setter @AllArgsConstructor @NoArgsConstructor
public class FileDB {
    @Id
    private String id;
    private String name;
    private String type;
    @Lob
    private byte[] data;

}
