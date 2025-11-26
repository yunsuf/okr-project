package com.okr.app.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String mission;
    private String vision;
    
    @OneToMany(mappedBy = "company")
    private List<User> users;
}
