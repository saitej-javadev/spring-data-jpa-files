package com.saitej.springdatajpafiles.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Data
@Entity
public class Image {

    @Id
    private Long id;
    private String name;
    @Lob
    private byte[] data;
}
