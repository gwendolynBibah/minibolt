package com.gwen.minibolt.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gwen.minibolt.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "users")
public class MiniboltUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "miniboltUser", fetch = FetchType.LAZY)
    private List<Order> orders;

}
