package com.journey.base.auth.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.journey.base.auth.entity.Resource;

public interface ResourceDao extends PagingAndSortingRepository<Resource, String> {
	
}
