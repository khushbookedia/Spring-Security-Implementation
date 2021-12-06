package com.neosoft.Studentapi.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
    @Column(name = "student_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private String mobileNo;

    @Email
    @Column(unique = true)
    private String emailId;


    //@JoinColumn(name = "project_id")
    @OneToMany(targetEntity = Project.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "student_project", joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id", nullable = true),
           inverseJoinColumns = @JoinColumn(name = "project_id", referencedColumnName = "project_id", nullable = true))
    private List<Project> project;




}
