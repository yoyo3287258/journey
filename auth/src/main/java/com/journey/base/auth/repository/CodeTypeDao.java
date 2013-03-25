package com.journey.base.auth.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.journey.base.auth.entity.CodeType;

public interface CodeTypeDao extends PagingAndSortingRepository<CodeType, String> {
	List<CodeType> findByGroupNameIsNull(Pageable pageable);
	
	@Query("select count(c) from CodeType c where groupName is null")
	Long countByGroupNameIsNull();
}
