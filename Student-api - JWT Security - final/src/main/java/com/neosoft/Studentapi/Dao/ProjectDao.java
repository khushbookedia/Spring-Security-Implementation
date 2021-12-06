package com.neosoft.Studentapi.Dao;

import com.neosoft.Studentapi.Entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectDao extends JpaRepository<Project, Integer> {

}
