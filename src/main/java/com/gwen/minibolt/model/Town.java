package com.gwen.minibolt.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
@Table(name = "town")
public class Town {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    private String  id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Regional region;

//    @JsonIgnore
//    @OneToMany(mappedBy = "location")
//    private List<Restaurant> restaurants;

}