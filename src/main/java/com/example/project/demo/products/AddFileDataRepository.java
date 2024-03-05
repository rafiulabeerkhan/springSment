package com.example.project.demo.products;

import com.example.project.demo.Machine.FileData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddFileDataRepository extends JpaRepository<com.example.project.demo.Machine.FileData,Long> {
    List<com.example.project.demo.Machine.FileData> findByName(String fileName);

    @Query(value = "SELECT * FROM FILE_DATA where name = :name limit 1", nativeQuery = true)
    public FileData findAllSortedByNameUsingNative(@Param(value = "name") String name );
}
