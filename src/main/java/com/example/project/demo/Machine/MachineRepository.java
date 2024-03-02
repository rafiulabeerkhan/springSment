package com.example.project.demo.Machine;


import org.springframework.data.jpa.repository.JpaRepository;
@org.springframework.stereotype.Repository
public interface MachineRepository extends JpaRepository<MachineEntity, Long> {


}
