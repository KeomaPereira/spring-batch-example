package com.example.springbatchexample.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springbatchexample.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

}
