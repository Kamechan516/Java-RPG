package com.rpg.fried_shrimp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.rpg.fried_shrimp.model.Job;

@Mapper
public interface JobMapper {
	
	public List<Job> getAllJob();

}
