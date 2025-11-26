package com.okr.app.model;

import jakarta.persistence.*;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.time.LocalDate;

@Data
@Entity
public class KeyResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    
    // Tracking fields from Constitution
    private Integer weight; // Percentage (0-100)
    private Integer progress; // Percentage (0-100)
    private LocalDate targetDate;
    private String type; // PERCENTAGE, INCREASING, DECREASING
    
    // Value tracking
    private Double minValue;
    private Double targetValue;
    private Double maxValue;
    private Double currentValue;
    
    private String metric; // e.g., %, $, count (legacy field, kept for compatibility)

    @ManyToOne
    @JoinColumn(name = "objective_id")
    @JsonIgnore
    private Objective objective;
}
