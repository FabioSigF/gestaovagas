package com.gestao_vagas.gestaovagas.modules.company.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestao_vagas.gestaovagas.modules.company.dto.CreateJobDTO;
import com.gestao_vagas.gestaovagas.modules.company.entities.JobEntity;
import com.gestao_vagas.gestaovagas.modules.company.useCases.CreateJobUseCase;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/job")
public class JobController {

  @Autowired
  private CreateJobUseCase createJobUseCase;

  @PostMapping("/")
  public ResponseEntity<Object> create(@Valid @RequestBody CreateJobDTO createJobDTO, HttpServletRequest request) {
    try {
      var companyId = request.getAttribute("company_id");

      var jobEntity = JobEntity.builder().company_id(UUID.fromString(companyId.toString()))
          .benefits(createJobDTO.getBenefits())
          .description(createJobDTO.getDescription()).level(createJobDTO.getLevel()).build();
          
      var result = this.createJobUseCase.execute(jobEntity);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
