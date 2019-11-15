package com.brewin.common.entity;

import java.io.Serializable;

import java.security.Timestamp;
import java.util.ArrayList;
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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedDate;




/**
 * 
 * @ClassName:  Department   
 * @Description:部门实体
 * @author: brewin
 * @date:   2019年11月15日 下午3:01:15   
 *
 */
@Entity
@Table(name = "department")
public class Department implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id // 主键
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
	private Long id;
	/**
	 * 简称
	 */
	private String simplename;
	/**
	 * 全称
	 */
	@NotEmpty(message = "全称不能为空")
	@Column(nullable = false) // 映射为字段，值不能为空
	private String fullname;
	/**
	 * 
	 */
	@OneToMany(mappedBy = "department")
    private List<Role> roles;
	/**
	 * 父部门
	 */
	@ManyToOne
	Department parentDepartment;
	/**
	 * 子部门
	 */
	@OneToMany(mappedBy = "parentDepartment")
	private List<Department> sonDepartment;
	
	public List<Department> getSonDepartment() {
		return sonDepartment;
	}
	public void setSonDepartment(List<Department> sonDepartment) {
		this.sonDepartment = sonDepartment;
	}
	@ManyToMany(mappedBy = "departments")
	private List<User> users;
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	/**
	 * 提示
	 */
	private String tips;
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
	public String getSimplename() {
		return simplename;
	}
	public void setSimplename(String simplename) {
		this.simplename = simplename;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getTips() {
		return tips;
	}
	public void setTips(String tips) {
		this.tips = tips;
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
	public Department getParentDepartment() {
		return parentDepartment;
	}
	public void setParentDepartment(Department parentDepartment) {
		this.parentDepartment = parentDepartment;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", simplename=" + simplename + ", fullname=" + fullname + ", tips=" + tips
				+ ", createTime=" + createTime + ", version=" + version + "]";
	}
	

}
