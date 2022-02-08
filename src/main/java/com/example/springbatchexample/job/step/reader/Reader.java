package com.example.springbatchexample.job.step.reader;

import com.example.springbatchexample.entity.UserEntity;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component
public class Reader {

	@Bean
	public FlatFileItemReader<UserEntity> itemReader(@Value("${input-file}") Resource resource) {
		FlatFileItemReader<UserEntity> flatFileItemReader = new FlatFileItemReader<UserEntity>();
		flatFileItemReader.setResource(resource);
		flatFileItemReader.setName("CSV-READER");
		flatFileItemReader.setLinesToSkip(1);
		flatFileItemReader.setLineMapper(lineMapper());
		return flatFileItemReader;
	}

	@Bean
	public LineMapper<UserEntity> lineMapper() {
		DefaultLineMapper<UserEntity> lineMapper = new DefaultLineMapper<UserEntity>();
		DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
		lineTokenizer.setNames(new String[] { "id", "name", "dept", "salary" });
		BeanWrapperFieldSetMapper<UserEntity> fieldSetMapper = new BeanWrapperFieldSetMapper<UserEntity>();
		fieldSetMapper.setTargetType(UserEntity.class);
		lineMapper.setLineTokenizer(lineTokenizer);
		lineMapper.setFieldSetMapper(fieldSetMapper);
		return lineMapper;
	}
}
