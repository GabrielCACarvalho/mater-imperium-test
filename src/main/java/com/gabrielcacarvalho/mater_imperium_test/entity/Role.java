package com.gabrielcacarvalho.mater_imperium_test.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Role {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String name;
}
