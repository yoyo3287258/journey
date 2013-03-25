package com.journey.base.auth.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.journey.base.auth.entity.CodeInfo;

public interface CodeInfoDao extends PagingAndSortingRepository<CodeInfo, String> {
	List<CodeInfo> findByCodeType(String codeType,Pageable pageable);
	
	@Query("select count(c) from CodeInfo c where codeType =?1")
	Long countByCodeType(String codeType);
}
