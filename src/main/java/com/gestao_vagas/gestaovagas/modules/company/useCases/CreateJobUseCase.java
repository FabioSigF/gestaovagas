package com.gestao_vagas.gestaovagas.modules.company.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestao_vagas.gestaovagas.modules.company.entities.JobEntity;
import com.gestao_vagas.gestaovagas.modules.company.repositories.JobRepository;

@Service
public class CreateJobUseCase {
  
  @Autowired
  private JobRepository jobRepository;

  public JobEntity execute(JobEntity jobEntity){
    return this.jobRepository.save(jobEntity);
  }
}
