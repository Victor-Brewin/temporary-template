package com.brewin.common.dao;

import java.util.Collection;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.brewin.common.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{
	/**
	 * 根据简称分页查询用户列表
	 * @param simplename
	 * @param pageable
	 * @return
	 */
	Page<Department> findBySimplenameLike(String simplename, Pageable pageable);
	/**
	 * 根据全称查询
	 * @param fullname
	 * @return
	 */
	Department findByFullname(String fullname);
	/**
	 * 根据简称查询
	 * @param simplename
	 * @return
	 */
	Department findBySimplename(String simplename);
	/**
	 * 根据名称列表查询
	 * @param simplenames
	 * @return
	 */
	List<Department> findBySimplenameIn(Collection<String> simplenames);
}
