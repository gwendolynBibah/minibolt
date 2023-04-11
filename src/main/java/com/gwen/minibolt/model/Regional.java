package com.gwen.minibolt.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Regional {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    private String  id;

    private String region;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "region")
    private List<Town> town = new ArrayList<>();
}
