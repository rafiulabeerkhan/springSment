package com.example.project.demo.products;

import com.example.project.demo.Machine.FileInfoDTO;
import com.example.project.demo.Machine.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/productImage")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class AddingController {


    @Autowired
    private StorageService service;



    @PostMapping("/fileSystem")
    public ResponseEntity<?> uploadImageToFIleSystem(@RequestParam("image") MultipartFile file) throws IOException {
        String message = "";
        try {
            message = service.uploadImageToFileSystem(file);
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            message = "Could not upload the file: " + file.getOriginalFilename() + ". Error: " + e.getMessage();
            return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
        }
    }

    @GetMapping("/fileSystem/{fileName}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String fileName) throws IOException {
        byte[] imageData = service.downloadImageFromFileSystem(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);

    }

    @GetMapping("/fileSystem")
    public ResponseEntity<?> getAllImage() throws IOException {
        List<FileInfoDTO> fileInfoDTOList = service.getAllImage();
        return ResponseEntity.status(HttpStatus.OK)
                .body(fileInfoDTOList);
    }
}
