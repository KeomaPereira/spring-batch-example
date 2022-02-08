package com.example.springbatchexample.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user")
public class UserEntity {

	@Id
	private Integer id;
	private String name;
	private String dept;
	private Integer salary;
	private Date timestamp;
	
}
