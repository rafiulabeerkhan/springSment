package com.example.project.demo.EmployeeAttendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveService {
    @Autowired
    public LeaveRepository repo;

    public List<AttendanceEntity> getAllLeave() {
        return repo.findAll();
    }

    public AttendanceEntity getLeaveId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public AttendanceEntity saveLeave(AttendanceEntity leave) {
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
