package com.traini8.backend.Service;

import com.traini8.backend.DAO.TrainingCenter;
import com.traini8.backend.Repository.TrainingCenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class TrainingCenterService {
    @Autowired
    private TrainingCenterRepository repository;
    public List<TrainingCenter> getAllTrainingCenters() {
        return repository.findAll();
    }
    public TrainingCenter saveTrainingCenter(TrainingCenter trainingCenter) {
        trainingCenter.setCreatedOn(Instant.now().toEpochMilli());
        return repository.save(trainingCenter);
    }

}
