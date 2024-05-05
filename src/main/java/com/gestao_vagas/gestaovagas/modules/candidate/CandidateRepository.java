package com.gestao_vagas.gestaovagas.modules.candidate;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
//Recebe como parâmetro a entidade e o tipo da chave primária (id)
public interface CandidateRepository extends JpaRepository<CandidateEntity, UUID>{
  Optional<CandidateEntity> findByUsernameOrEmail(String username, String email);
}
