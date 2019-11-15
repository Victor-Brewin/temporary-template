package com.brewin.common.entity;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

/**
 * 
 * @ClassName:  Role   
 * @Description:角色实体 
 * @author: brewin
 * @date:   2019年11月15日 下午3:00:37   
 *
 */
@Entity
@Table(name = "role")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id // 主键
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
	private Long id;
	/**
     * 角色名称
     */
	private String name;
	/**
	 * 角色权限
	 */
	private String authorities;
	/**
	 * 所属部门,多个角色属于一个部门
	 */
	@ManyToOne
	private Department department;
	@ManyToMany(mappedBy = "roles")
	private List<User> users;
	/**
     * 状态(1：启用  2：冻结  3：删除）
     */
	private Integer status;
	/**
	 * 创建时间
	 */
	@Column(nullable = false) // 映射为字段，值不能为空
	@CreatedDate  // 由数据库自动创建时间
	private Timestamp createTime;
	/**
	 * 版本（乐观锁保留字段）
	 */
	private Integer version;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthorities() {
		return authorities;
	}
	public void setAuthorities(String authorities) {
		this.authorities = authorities;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", authorities=" + authorities + ", department=" + department
				+ ", status=" + status + ", createTime=" + createTime + ", version=" + version + "]";
	}
	

}
