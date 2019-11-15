package com.brewin.common.service;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.brewin.common.dao.DepartmentRepository;
import com.brewin.common.entity.Department;
@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Transactional
	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Transactional
	@Override
	public void removeDepartment(Long id) {
		departmentRepository.delete(id);
	}

	@Transactional
	@Override
	public void removeDepartmentsInBatch(List<Department> departments) {
		departmentRepository.deleteInBatch(departments);
	}
	
	@Transactional
	@Override
	public Department updateDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public Department getDepartmentById(Long id) {
		return departmentRepository.getOne(id);
	}

	@Override
	public List<Department> listDepartments() {
		return departmentRepository.findAll();
	}

	public Page<Department> listDepartmentsBySimplenameLike(String simplename, Pageable pageable) {
		// 模糊查询
		simplename = "%" + simplename + "%";
		Page<Department> departments = departmentRepository.findBySimplenameLike(simplename, pageable);
		return departments;
	}

	public Department loadDepartmentByFullname(String fullname){
		return departmentRepository.findByFullname(fullname);
	}

	@Override
	public List<Department> listDepartmentsBySimplenames(Collection<String> simplenames) {
		return departmentRepository.findBySimplenameIn(simplenames);
	}

	

}
