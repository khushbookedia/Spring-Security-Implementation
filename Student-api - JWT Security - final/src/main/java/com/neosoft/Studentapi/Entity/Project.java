package com.neosoft.Studentapi.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Project {
    @Column(name = "project_id")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int projectId;

    @NotNull
    private String projectName;

    @NotNull
    private int duration;


}
