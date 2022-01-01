package com.guillaume.training.repository.dao;

import com.guillaume.training.controller.mapper.PerformanceMapper;
import com.guillaume.training.repository.PerformanceRepository;
import com.guillaume.training.service.model.Performance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class PerformanceDAO {
    private final PerformanceRepository performanceRepository;

    @Autowired
    public PerformanceDAO(PerformanceRepository performanceRepository) {
        this.performanceRepository = performanceRepository;
    }

    public List<Performance> findAll(){
        return performanceRepository.findAll().stream()
                .map(PerformanceMapper::getModelFromEntity)
                .collect(Collectors.toList());
    }

    public Optional<Performance> findById(Long id){
        return performanceRepository.findById(id)
                .map(PerformanceMapper::getModelFromEntity);
    }

    public Performance save(Performance performance){
        return PerformanceMapper.getModelFromEntity(
                performanceRepository.save(PerformanceMapper.getEntityFromModel(performance))
        );
    }
}
