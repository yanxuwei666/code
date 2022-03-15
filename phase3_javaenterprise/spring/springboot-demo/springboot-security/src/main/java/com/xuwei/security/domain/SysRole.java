package com.xuwei.security.domain;

import java.io.Serializable;

/**
 * 用户角色表
 * @TableName sys_role
 */
public class SysRole implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 角色名
     */
    private String roleName;

    /**
     * 角色说明
     */
    private String roleDescription;

    /**
     * 
     */
    private String roleCode;

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 角色名
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 角色名
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 角色说明
     */
    public String getRoleDescription() {
        return roleDescription;
    }

    /**
     * 角色说明
     */
    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    /**
     * 
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * 
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        SysRole other = (SysRole) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getRoleName() == null ? other.getRoleName() == null : this.getRoleName().equals(other.getRoleName()))
            && (this.getRoleDescription() == null ? other.getRoleDescription() == null : this.getRoleDescription().equals(other.getRoleDescription()))
            && (this.getRoleCode() == null ? other.getRoleCode() == null : this.getRoleCode().equals(other.getRoleCode()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getRoleName() == null) ? 0 : getRoleName().hashCode());
        result = prime * result + ((getRoleDescription() == null) ? 0 : getRoleDescription().hashCode());
        result = prime * result + ((getRoleCode() == null) ? 0 : getRoleCode().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleName=").append(roleName);
        sb.append(", roleDescription=").append(roleDescription);
        sb.append(", roleCode=").append(roleCode);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}