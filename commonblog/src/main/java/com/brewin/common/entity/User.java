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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.CreatedDate;

/**
 * 
 * @ClassName:  User   
 * @Description:用户实体 
 * @author: brewin
 * @date:   2019年11月15日 下午3:01:05   
 *
 */
@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id // 主键
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
	private Long id;
	/**
	 * 昵称
	 */
	@NotEmpty(message = "姓名不能为空")
	@Size(min = 2, max = 20)
	@Column(nullable = false, length = 20) // 映射为字段，值不能为空
	private String name;
	/**
	 * 邮箱
	 */
	@NotEmpty(message = "邮箱不能为空")
	@Size(max = 50)
	@Email(message = "邮箱格式不对")
	@Column(nullable = false, length = 50, unique = true)
	private String email;
	/**
	 * 账号
	 */
	@NotEmpty(message = "账号不能为空")
	@Size(min = 3, max = 20)
	@Column(nullable = false, length = 20, unique = true)
	private String username; // 用户账号，用户登录时的唯一标识
	/**
	 * 密码
	 */
	@NotEmpty(message = "密码不能为空")
	@Size(max = 100)
	@Column(length = 100)
	private String password; // 登录时密码
	/**
	 * 头像
	 */
	@Column(length = 200)
	private String avatar; // 头像图片地址
	/**
	 * 角色，一个人可以担任多个角色，角色也可为多个人担任
	 */
	@ManyToMany(cascade = { CascadeType.PERSIST })
	private List<Role> roles;
	/**
	 * 一个人可以在多个部门
	 */

	@ManyToMany(cascade = { CascadeType.PERSIST })
	private List<Department> departments;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public List<Department> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Department> departments) {
		this.departments = departments;
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
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", username=" + username + ", password="
				+ password + ", avatar=" + avatar + ", roles=" + roles + ", departments=" + departments + ", status="
				+ status + ", createTime=" + createTime + ", version=" + version + "]";
	}
	

}
