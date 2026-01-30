package com.example.Assignmentproject.serviceImpl;

import com.example.Assignmentproject.dto.AssignmentprojectDto;
import com.example.Assignmentproject.entity.AssignmentprojectEntity;
import com.example.Assignmentproject.exception.AssignmentprojectResourceNotFoundException;
import com.example.Assignmentproject.repository.AssignmentprojectRepository;
import com.example.Assignmentproject.service.AssignmentprojectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentprojectServiceImpl implements AssignmentprojectService {

    @Autowired
    private AssignmentprojectRepository repository;

    @Override
    public AssignmentprojectEntity createUser(AssignmentprojectDto dto) {
        if(repository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        AssignmentprojectEntity user = new AssignmentprojectEntity();
        user.setFullName(dto.getFullName());
        user.setEmail(dto.getEmail());
        user.setMobileNumber(dto.getMobileNumber());
        user.setPassword(dto.getPassword());
        user.setDateOfBirth(dto.getDateOfBirth());
        return repository.save(user);
    }

    @Override
    public List<AssignmentprojectEntity> getAllUsers() {
        return repository.findAll();
    }
    
    @Override
    public AssignmentprojectEntity getUserById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new AssignmentprojectResourceNotFoundException("User not found with id " + id));
    }

    @Override
    public AssignmentprojectEntity updateUser(String id, AssignmentprojectDto dto) {
        AssignmentprojectEntity user = repository.findById(id)
                .orElseThrow(() -> new AssignmentprojectResourceNotFoundException("User not found with id " + id));
        user.setFullName(dto.getFullName());
        user.setMobileNumber(dto.getMobileNumber());
        user.setPassword(dto.getPassword());
        user.setDateOfBirth(dto.getDateOfBirth());
        return repository.save(user);
    }

    @Override
    public void deleteUser(String id) {
        AssignmentprojectEntity user = repository.findById(id)
                .orElseThrow(() -> new AssignmentprojectResourceNotFoundException("User not found with id " + id));
        repository.delete(user);
    }
}
