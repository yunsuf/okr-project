package com.okr.app.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
public class Objective {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    @Column(length = 1000)
    private String description;
    private String status; // e.g., PLANNED, IN_PROGRESS, COMPLETED
    
    // New fields from Constitution
    private String scope; // e.g., COMPANY, TEAM, INDIVIDUAL
    private String purpose; // e.g., COMMITTED, ASPIRATIONAL, LEARNING

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    @OneToMany(mappedBy = "objective", cascade = CascadeType.ALL)
    private List<KeyResult> keyResults;
}
