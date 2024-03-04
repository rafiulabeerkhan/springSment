package com.example.project.demo.Machine;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@org.springframework.stereotype.Repository
public interface MachineRepository extends JpaRepository<MachineEntity, Long> {
   // Optional<ImageData> findByName(String fileName);

}
