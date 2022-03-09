package com.xuwei.security.domain;

import java.io.Serializable;

/**
 * 路径权限关联表
 * @TableName sys_request_path_permission_relation
 */
public class SysRequestPathPermissionRelation implements Serializable {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 请求路径id
     */
    private Integer urlId;

    /**
     * 权限id
     */
    private Integer permissionId;

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
     * 请求路径id
     */
    public Integer getUrlId() {
        return urlId;
    }

    /**
     * 请求路径id
     */
    public void setUrlId(Integer urlId) {
        this.urlId = urlId;
    }

    /**
     * 权限id
     */
    public Integer getPermissionId() {
        return permissionId;
    }

    /**
     * 权限id
     */
    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
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
        SysRequestPathPermissionRelation other = (SysRequestPathPermissionRelation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUrlId() == null ? other.getUrlId() == null : this.getUrlId().equals(other.getUrlId()))
            && (this.getPermissionId() == null ? other.getPermissionId() == null : this.getPermissionId().equals(other.getPermissionId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUrlId() == null) ? 0 : getUrlId().hashCode());
        result = prime * result + ((getPermissionId() == null) ? 0 : getPermissionId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", urlId=").append(urlId);
        sb.append(", permissionId=").append(permissionId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}