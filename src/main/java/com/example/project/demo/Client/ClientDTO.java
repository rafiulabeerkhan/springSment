package com.example.project.demo.Client;

import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
    private String clientName;
    private String designation;
    private String contactNo;
    private String officeAddress;
    private String orderInfo;
    private Integer quantity;

}
