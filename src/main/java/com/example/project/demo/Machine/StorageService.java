package com.example.project.demo.Machine;

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
public class StorageService {

    @Autowired
    private FileDataRepository fileDataRepository;

    @Value("${file.path}")
    private String FOLDER_PATH;








    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        String filePath = FOLDER_PATH + file.getOriginalFilename();
        FileData fileData=fileDataRepository.save(
                FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath).build()
        );
//        FileData fileDataOld = new FileData();
//        fileDataOld.setName(file.getOriginalFilename());
//        fileDataOld.setType(file.getContentType());
//        fileDataOld.setFilePath(filePath);
//
//        fileDataOld = fileDataRepository.save(fileDataOld);

        file.transferTo(new File(filePath));

        if (fileData != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return "Could not upload the file: " + file.getOriginalFilename();
    }

    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
//        Optional<FileData> fileData = fileDataRepository.findByName(fileName);
        FileData fileData = fileDataRepository.findAllSortedByNameUsingNative(fileName);
        String filePath=fileData.getFilePath();
//        String filePath=fileData.get().getFilePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }

    public List<FileInfoDTO> getAllImage() throws IOException {
        List<FileInfoDTO> fileInfoDTOS = new ArrayList<>();
        List<FileData> fileDataList = fileDataRepository.findAll();
        fileDataList.forEach(fileData -> {
            try {
                String filePath=fileData.getFilePath();
                byte[] images = Files.readAllBytes(new File(filePath).toPath());
                FileInfoDTO fileInfoDTO = new FileInfoDTO(fileData.getName(), fileData.getFilePath(), images);
                fileInfoDTOS.add(fileInfoDTO);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        return fileInfoDTOS;
    }



}
