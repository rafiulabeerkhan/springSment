package com.example.project.demo.Machine;

import com.example.project.demo.Material.MaterialEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

@Service
public class MachineService {
    @Autowired
    public MachineRepository repo;
    @Autowired
    private FileDataRepository fileDataRepository;

    @Value("${file.path}")
    private String FOLDER_PATH;
    public List<MachineEntity> getAllMaterial() {
        return repo.findAll();
    }

    public MachineEntity getMachineId(Long id) {
        return repo.findById(id).orElse(null);
    }

    public MachineEntity saveMachine(MachineEntity machine) {
        return this.repo.save(machine);
    }

    public Boolean deleteMachine(Long id) {
        if (repo.findById(id).isPresent()) {
            repo.deleteById(id);
            return true;
        }
        return false;
    }

}
