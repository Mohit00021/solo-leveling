package com.mo.sololeveling.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "skills")
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skills_id", nullable = false)
    private Long id;

    private String name;
    private String description;
    private String category;

}