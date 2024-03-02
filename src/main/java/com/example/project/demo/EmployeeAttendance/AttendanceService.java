package com.example.project.demo.EmployeeAttendance;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {
    @Autowired
    public AttendanceRepository repo;

    public List<AttendanceEntity> getAttendance() {
        return repo.findAll();
    }

    public AttendanceEntity getAttendanceById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public AttendanceEntity saveAttendance(AttendanceEntity attendance) {
        return this.repo.save(attendance);
    }

    public Boolean deleteAttendance(Long id) {
        if (repo.findById(id).isPresent()) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

}
