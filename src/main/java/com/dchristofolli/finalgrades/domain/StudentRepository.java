package com.dchristofolli.finalgrades.domain;

import com.dchristofolli.finalgrades.v1.dto.Aluno;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Aluno, Long> {
}
