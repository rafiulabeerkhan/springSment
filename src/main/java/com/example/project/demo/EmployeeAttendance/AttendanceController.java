package com.example.project.demo.EmployeeAttendance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class AttendanceController {
    @Autowired
    public AttendanceService service;

    @GetMapping("/getAll")
    public List<AttendanceEntity> getAllClient(){
        return service.getAttendance();
    }
    @PostMapping
    public AttendanceEntity addAttendance( @RequestBody AttendanceEntity attendance){
        return service.saveAttendance(attendance);
    }

    @GetMapping("/{id}")
    public AttendanceEntity getAttendanceById(@PathVariable("id")Long id){
        return service.getAttendanceById(id);
    }

    @PutMapping("/{id}")
    public AttendanceEntity updateAttendance(@RequestBody AttendanceEntity attendance){
        return service.saveAttendance(attendance);
    }
    @DeleteMapping("/{id}")
    public void deleteAttendanceById(@PathVariable("id")Long id){
        service.deleteAttendance(id);
    }
}
