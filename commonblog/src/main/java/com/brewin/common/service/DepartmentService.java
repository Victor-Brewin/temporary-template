package com.brewin.common.service;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.brewin.common.entity.Department;

public interface DepartmentService {
	/**
	 * 保存部门
	 * @param department
	 * @return
	 */
	Department saveDepartment(Department department);
	
	/**
	 * 删除部门
	 * @param id
	 * @return
	 */
	void removeDepartment(Long id);
	
	/**
	 * 删除列表里面的部门
	 * @param departments
	 * @return
	 */
	void removeDepartmentsInBatch(List<Department> departments);
	
	/**
	 * 更新部门
	 * @param department
	 * @return
	 */
	Department updateDepartment(Department department);
	
	/**
	 * 根据id获取部门
	 * @param id
	 * @return
	 */
	Department getDepartmentById(Long id);
	
	/**
	 * 获取部门列表
	 * @return
	 */
	List<Department> listDepartments();
	
	/**
	 * 根据部门名进行分页模糊查询
	 * @param simpname
	 * @param pageable
	 * @return
	 */
	Page<Department> listDepartmentsBySimplenameLike(String simplename, Pageable pageable);
	
	/**
	 * 根据名称列表查询
	 * @param departmentnames
	 * @return
	 */
	List<Department> listDepartmentsBySimplenames(Collection<String> simplenames);
}
