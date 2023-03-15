package com.gwen.minibolt.model;

import com.gwen.minibolt.enums.Role;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    @Enumerated(value = EnumType.STRING)
    private Role role;
    private String password;

}
