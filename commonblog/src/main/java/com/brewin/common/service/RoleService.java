package com.brewin.common.service;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.brewin.common.entity.Role;

public interface RoleService {

	/**
	 * 保存角色
	 * @param role
	 * @return
	 */
	Role saveRole(Role role);
	
	/**
	 * 删除角色
	 * @param id
	 * @return
	 */
	void removeRole(Long id);
	
	/**
	 * 删除列表里面的角色
	 * @param roles
	 * @return
	 */
	void removeRolesInBatch(List<Role> roles);
	
	/**
	 * 更新角色
	 * @param role
	 * @return
	 */
	Role updateRole(Role role);
	
	/**
	 * 根据id获取角色
	 * @param id
	 * @return
	 */
	Role getRoleById(Long id);
	
	/**
	 * 获取角色列表
	 * @return
	 */
	List<Role> listRoles();
	
	/**
	 * 根据角色名进行分页模糊查询
	 * @param name
	 * @param pageable
	 * @return
	 */
	Page<Role> listRolesByNameLike(String name, Pageable pageable);
	
	/**
	 * 更具名称列表查询
	 * @param names
	 * @return
	 */
	List<Role> listRolesByNames(Collection<String> names);
}

