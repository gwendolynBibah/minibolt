package com.gwen.minibolt.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Regional {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String region;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "region")
    private List<Town> town = new ArrayList<>();
}
