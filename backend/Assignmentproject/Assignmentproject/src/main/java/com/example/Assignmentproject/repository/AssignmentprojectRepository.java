package com.example.Assignmentproject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.example.Assignmentproject.entity.AssignmentprojectEntity;
import java.util.Optional;

@Repository
public interface AssignmentprojectRepository extends MongoRepository<AssignmentprojectEntity, String> {
    Optional<AssignmentprojectEntity> findByEmail(String email);
    boolean existsByEmail(String email);
}
