package practice.pr03.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Train {
    private int id;
    private String trainNumber;
    private String time;

    public Train(Train other) {
        id = other.id;
        trainNumber = other.trainNumber;
        time = other.time;
    }
}


