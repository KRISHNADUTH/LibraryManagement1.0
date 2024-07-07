package com.krishna.LibraryManageMent.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @NotEmpty(message = "Title cannot be empty.")
    private String title;
    
    @Size(min = 13, message = "ISBN number should contain atleast 13 characters.")
    private String isbn;

    @Column(length = 999)
    private String summary;
    private Boolean isBorrowed;
//    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
//    private Author author;
//    @ManyToMany
//    private Set<User> borrowers;


}
