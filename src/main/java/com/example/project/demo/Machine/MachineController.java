package com.example.project.demo.Machine;

import com.example.project.demo.invoice.InvoiceEntity;
import com.example.project.demo.invoice.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/machine")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class MachineController {
    @Autowired
    public MachineService service;

    @GetMapping("/getAll")
    public List<MachineEntity> getAllMachine(){
        return service.getAllMaterial();
    }
    @PostMapping
    public MachineEntity addMachine( @RequestBody MachineEntity machine ){
        return service.saveMachine(machine);
    }

    @GetMapping("/{id}")
    public MachineEntity getMachineById(@PathVariable("id")Long id){
        return service.getMachineId(id);
    }

    @PutMapping("/{id}")
    public MachineEntity updateMachine(@RequestBody MachineEntity machine){
        return service.saveMachine(machine);
    }
    @DeleteMapping("/{id}")
    public void deleteMachineById(@PathVariable("id")Long id){
        service.deleteMachine(id);
    }
}
