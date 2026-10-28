package practice.pr03.service;

import practice.pr03.model.Train;
import practice.pr03.repository.TrainRepository;

import java.util.List;

public class TrainService {
    public static TrainService instance;
    private TrainRepository trainRepository;

    private TrainService(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    public static TrainService getInstance() {
        if (instance == null) {
            instance = new TrainService(TrainRepository.getInstance());
        }
        return instance;
    }

    public void register(Train train) {
        trainRepository.insert(train);
    }

    public List<Train> getTrainAll() {
        return trainRepository.findAll();
    }


}
