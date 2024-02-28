package com.example.Library_Management.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    private Integer Id;
    @NotEmpty
    private String Name;
    @NotEmpty
    private String Author;
    @NotEmpty
    private String Publisher;
    private Integer PublishedYear;
    private String Isbn;
    @ManyToOne
    @JoinColumn(name = "User_Id")
    private User user;
}
