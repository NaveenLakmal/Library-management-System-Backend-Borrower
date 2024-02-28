package edu.icet.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class User {
    private Long bid;
    private String nic;
    private String name;
    private String country;
    private String contactNumber;
    private String address;
    private String email;
    private String username;
    private String password;


}
