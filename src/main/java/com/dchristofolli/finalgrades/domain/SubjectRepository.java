package com.dchristofolli.finalgrades.domain;

import com.dchristofolli.finalgrades.v1.dto.Disciplina;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends MongoRepository<Disciplina, Long> {
}
