package com.example.springbatchexample.job.step.processor;

import java.util.Date;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.example.springbatchexample.entity.UserEntity;

@Component
public class Processor implements ItemProcessor<UserEntity, UserEntity> {

	@Override
	public UserEntity process(UserEntity userEntity) throws Exception {
		userEntity.setTimestamp(new Date());
		return userEntity;
	}

}
