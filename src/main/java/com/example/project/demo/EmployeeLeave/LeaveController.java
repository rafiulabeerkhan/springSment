package com.example.project.demo.EmployeeLeave;

import com.example.project.demo.EmployeeAttendance.AttendanceEntity;
import com.example.project.demo.EmployeeAttendance.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leave")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class LeaveController {
    @Autowired
    public LeaveService service;

    @GetMapping("/getAll")
    public List<LeaveEntity> getAllLeave(){
        return service.getAllLeave();
    }
    @PostMapping
    public LeaveEntity addLeave( @RequestBody LeaveEntity leave ){
        return service.saveLeave(leave);
    }

    @GetMapping("/{id}")
    public LeaveEntity getLeaveById(@PathVariable("id")Long id){
        return service.getLeaveId(id);
    }

    @PutMapping("/{id}")
    public LeaveEntity updateLeave(@RequestBody LeaveEntity leave){
        return service.saveLeave(leave);
    }
    @DeleteMapping("/{id}")
    public void deleteLeaveById(@PathVariable("id")Long id){
        service.deleteLeave(id);
    }
}
