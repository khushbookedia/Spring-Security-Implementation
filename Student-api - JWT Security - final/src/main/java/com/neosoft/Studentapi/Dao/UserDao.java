package com.neosoft.Studentapi.Dao;

import com.neosoft.Studentapi.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
}
