package practice.pr03.repository;

import practice.pr03.model.Train;

import java.util.ArrayList;
import java.util.List;

public class TrainRepository {
    public static TrainRepository instance;
    private List<Train> trains;
    private int lastId;

    private TrainRepository() {
        trains = new ArrayList<>();
        lastId = 1;
    }

    public static TrainRepository getInstance() {
        if (instance == null) {
            instance = new TrainRepository();
        }
        return instance;
    }

    public void insert(Train train) {
        train.setId(lastId++);
        trains.add(train);
    }

    public List<Train> findAll() {
        return trains.stream().map(train -> new Train(train)).toList();
    }

}
