package com.example.Assignmentproject.service;

import com.example.Assignmentproject.dto.AssignmentprojectDto;
import com.example.Assignmentproject.entity.AssignmentprojectEntity;
import java.util.List;

public interface AssignmentprojectService {

    AssignmentprojectEntity createUser(AssignmentprojectDto dto);

    List<AssignmentprojectEntity> getAllUsers();
    
    AssignmentprojectEntity getUserById(String id);

    AssignmentprojectEntity updateUser(String id, AssignmentprojectDto dto);

    void deleteUser(String id);
}
