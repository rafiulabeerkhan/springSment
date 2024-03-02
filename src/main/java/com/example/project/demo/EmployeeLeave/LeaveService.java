package com.example.project.demo.EmployeeLeave;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveService {
    @Autowired
    public LeaveRepository repo;

    public List<LeaveEntity> getAllLeave() {
        return repo.findAll();
    }

    public LeaveEntity getLeaveId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public LeaveEntity saveLeave(LeaveEntity leave) {
        return this.repo.save(leave);
    }

    public Boolean deleteLeave(Long id) {
        if (repo.findById(id).isPresent()) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

}
