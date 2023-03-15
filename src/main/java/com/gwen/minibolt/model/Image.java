package com.gwen.minibolt.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table
public class Image {

    @Id
    @GeneratedValue
    Long id;

    @Lob
    Byte[] content;

    String name;

}

