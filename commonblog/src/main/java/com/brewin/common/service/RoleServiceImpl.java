package com.brewin.common.service;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.brewin.common.dao.RoleRepository;
import com.brewin.common.entity.Role;
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleRepository roleRepository;
	
	@Transactional
	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	@Transactional
	@Override
	public void removeRole(Long id) {
		roleRepository.delete(id);
	}

	@Transactional
	@Override
	public void removeRolesInBatch(List<Role> roles) {
		roleRepository.deleteInBatch(roles);
	}
	
	@Transactional
	@Override
	public Role updateRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Role getRoleById(Long id) {
		return roleRepository.getOne(id);
	}

	@Override
	public List<Role> listRoles() {
		return roleRepository.findAll();
	}

	@Override
	public Page<Role> listRolesByNameLike(String name, Pageable pageable) {
		// 模糊查询
		name = "%" + name + "%";
		Page<Role> roles = roleRepository.findByNameLike(name, pageable);
		return roles;
	}

	public Role loadRoleByRolename(String name){
		return roleRepository.findByName(name);
	}

	@Override
	public List<Role> listRolesByNames(Collection<String> names) {
		return roleRepository.findByNameIn(names);
	}

}
