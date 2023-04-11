package com.gwen.minibolt.model;

import com.gwen.minibolt.enums.GENERAL_STATUS;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;

@Data
@Entity
@Table(name = "foods")
@SQLDelete(sql = "UPDATE users SET deleted = true WHERE id=?")
//@Where(clause = "deleted=false")
public class Food {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    private String id;
    private String name;
    private double price;
    private String description;
    private GENERAL_STATUS status;

    private boolean deleted = Boolean.FALSE;

    //food foreign key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

}
