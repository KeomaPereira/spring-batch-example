package com.example.springbatchexample.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.springbatchexample.entity.UserEntity;

@Configuration
@EnableBatchProcessing
public class JobConfig {

	@Bean
	public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
				   ItemReader<UserEntity> itemReader, ItemProcessor<UserEntity, UserEntity> itemProcessor, ItemWriter<UserEntity> itemWriter) {

		Step step = stepBuilderFactory.get("ETL-STEP-IMPORT-USERS").<UserEntity, UserEntity>chunk(100).reader(itemReader)
				.processor(itemProcessor).writer(itemWriter).build();

		Job job = jobBuilderFactory.get("ETL-JOB-IMPORT-USERS").incrementer(new RunIdIncrementer()).start(step).build();

		return job;
	}

}
