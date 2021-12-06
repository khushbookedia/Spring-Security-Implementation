package com.neosoft.Studentapi.Dao;

import com.neosoft.Studentapi.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role,Integer> {
}
