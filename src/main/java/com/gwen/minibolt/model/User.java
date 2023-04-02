package com.gwen.minibolt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gwen.minibolt.enums.ROLE;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.SQLDelete;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET deleted =true WHERE id=?")
//@Where(clause = "deleted=false")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(value = EnumType.STRING)
    private ROLE role;
    private String password;
    private boolean deleted = Boolean.FALSE;


    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Order> orders;
}

