package com.xuwei.security.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 * @TableName sys_user
 */
public class SysUser implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 账号
     */
    private String account;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 上一次登录时间
     */
    private Date lastLoginTime;

    /**
     * 账号是否可用。默认为1（可用）
     */
    private Boolean enabled;

    /**
     * 是否过期。默认为1（没有过期）
     */
    private Boolean accountNonExpired;

    /**
     * 账号是否锁定。默认为1（没有锁定）
     */
    private Boolean accountNonLocked;

    /**
     * 证书（密码）是否过期。默认为1（没有过期）
     */
    private Boolean credentialsNonExpired;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 创建人
     */
    private Integer createUser;

    /**
     * 修改人
     */
    private Integer updateUser;

    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 账号
     */
    public String getAccount() {
        return account;
    }

    /**
     * 账号
     */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
     * 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 用户密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 用户密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 上一次登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 上一次登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 账号是否可用。默认为1（可用）
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * 账号是否可用。默认为1（可用）
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * 是否过期。默认为1（没有过期）
     */
    public Boolean getAccountNonExpired() {
        return accountNonExpired;
    }

    /**
     * 是否过期。默认为1（没有过期）
     */
    public void setAccountNonExpired(Boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    /**
     * 账号是否锁定。默认为1（没有锁定）
     */
    public Boolean getAccountNonLocked() {
        return accountNonLocked;
    }

    /**
     * 账号是否锁定。默认为1（没有锁定）
     */
    public void setAccountNonLocked(Boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    /**
     * 证书（密码）是否过期。默认为1（没有过期）
     */
    public Boolean getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    /**
     * 证书（密码）是否过期。默认为1（没有过期）
     */
    public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 创建人
     */
    public Integer getCreateUser() {
        return createUser;
    }

    /**
     * 创建人
     */
    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    /**
     * 修改人
     */
    public Integer getUpdateUser() {
        return updateUser;
    }

    /**
     * 修改人
     */
    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
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
        SysUser other = (SysUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
            && (this.getUserName() == null ? other.getUserName() == null : this.getUserName().equals(other.getUserName()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getLastLoginTime() == null ? other.getLastLoginTime() == null : this.getLastLoginTime().equals(other.getLastLoginTime()))
            && (this.getEnabled() == null ? other.getEnabled() == null : this.getEnabled().equals(other.getEnabled()))
            && (this.getAccountNonExpired() == null ? other.getAccountNonExpired() == null : this.getAccountNonExpired().equals(other.getAccountNonExpired()))
            && (this.getAccountNonLocked() == null ? other.getAccountNonLocked() == null : this.getAccountNonLocked().equals(other.getAccountNonLocked()))
            && (this.getCredentialsNonExpired() == null ? other.getCredentialsNonExpired() == null : this.getCredentialsNonExpired().equals(other.getCredentialsNonExpired()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getUserName() == null) ? 0 : getUserName().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getLastLoginTime() == null) ? 0 : getLastLoginTime().hashCode());
        result = prime * result + ((getEnabled() == null) ? 0 : getEnabled().hashCode());
        result = prime * result + ((getAccountNonExpired() == null) ? 0 : getAccountNonExpired().hashCode());
        result = prime * result + ((getAccountNonLocked() == null) ? 0 : getAccountNonLocked().hashCode());
        result = prime * result + ((getCredentialsNonExpired() == null) ? 0 : getCredentialsNonExpired().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", account=").append(account);
        sb.append(", userName=").append(userName);
        sb.append(", password=").append(password);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", enabled=").append(enabled);
        sb.append(", accountNonExpired=").append(accountNonExpired);
        sb.append(", accountNonLocked=").append(accountNonLocked);
        sb.append(", credentialsNonExpired=").append(credentialsNonExpired);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createUser=").append(createUser);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}