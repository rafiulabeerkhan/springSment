package com.example.project.demo.products;


import lombok.Data;


@Data
public class AddFileInfoDTO {
    private Long id;
    private String name;
    private String filePath;
    private String type;






    private String url;
    private  byte[] image;

    public AddFileInfoDTO(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public AddFileInfoDTO(String name, String url, byte[] image) {
        this.name = name;
        this.url = url;
        this.image = image;
    }
}
