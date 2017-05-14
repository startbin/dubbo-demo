package com.dongao.data.demo.bean.dto;


public class SysUserDto implements java.io.Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Long organizationId;

	private String username;

	private String password;

	private String salt;

	private String roleIds;

	private Boolean locked;

	/**
	 * @return id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return organization_id
	 */
	public Long getOrganizationId() {
		return organizationId;
	}

	/**
	 * @param organizationId
	 */
	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	/**
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return salt
	 */
	public String getSalt() {
		return salt;
	}

	/**
	 * @param salt
	 */
	public void setSalt(String salt) {
		this.salt = salt;
	}

	/**
	 * @return role_ids
	 */
	public String getRoleIds() {
		return roleIds;
	}

	/**
	 * @param roleIds
	 */
	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	/**
	 * @return locked
	 */
	public Boolean getLocked() {
		return locked;
	}

	/**
	 * @param locked
	 */
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}
}
