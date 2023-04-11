package com.gwen.minibolt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gwen.minibolt.enums.GENERAL_STATUS;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;

import java.util.List;

@Data
@Entity
@Table(name = "menus")
@SQLDelete(sql = "UPDATE users SET deleted =true WHERE id=?")
//@Where(clause = "deleted=false")
public class Menu {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    private String  id;
    private String name;
    private GENERAL_STATUS status;
    private boolean deleted = Boolean.FALSE;
    @JsonIgnore
    @OneToMany(mappedBy = "menu")
    private List<Food> foods;

    //restaurant key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id", nullable = false)
    private Restaurant restaurant;
}
