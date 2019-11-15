package com.brewin.common.dao;

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.brewin.common.entity.Role;
import com.brewin.common.entity.User;

public interface RoleRepository extends JpaRepository<Role, Long>{
	/**
	 * 根据角色名称分页查询用户列表
	 * @param name
	 * @param pageable
	 * @return
	 */
	Page<Role> findByNameLike(String name, Pageable pageable);
	/**
	 * 根据名称查询
	 * @param username
	 * @return
	 */
	Role findByName(String name);
	/**
	 * 根据名称列表查询
	 * @param usernames
	 * @return
	 */
	List<Role> findByNameIn(Collection<String> names);
}
