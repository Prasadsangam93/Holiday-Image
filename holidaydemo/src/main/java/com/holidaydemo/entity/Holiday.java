package com.holidaydemo.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "ImageTable")
public class Holiday {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private  Long id;
    private  String name;
    private String description;
    private String fulldate;
    @Lob
    private  byte[] image;


    }
