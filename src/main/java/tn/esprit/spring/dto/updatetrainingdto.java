package tn.esprit.spring.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class updatetrainingdto {

    private String idTrainning;
    private String TrainningName;
    private String TrainerName;
    private String Duration;
    private String Files;
    private String Description;
}
