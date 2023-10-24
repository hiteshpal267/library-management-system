package com.example.lbms.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@Column(name = "name")
    private String name;

    //@Column(name = "country")
    private String country;

    //@Column(name = "age")
    private int age;

    @Column(/*name = "email",*/ unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY) // One author can have multiple books; Bi-directional Mapping
    private List<Book> bookList;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;
}
