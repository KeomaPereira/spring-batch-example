package com.example.springbatchexample.job.step.writer;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springbatchexample.entity.UserEntity;
import com.example.springbatchexample.repository.UserRepository;

@Component
public class DBWriter implements ItemWriter<UserEntity> {

	@Autowired
	private UserRepository UserRepository;

	@Override
	public void write(List<? extends UserEntity> users) throws Exception {
		UserRepository.saveAll(users);
	}

}
