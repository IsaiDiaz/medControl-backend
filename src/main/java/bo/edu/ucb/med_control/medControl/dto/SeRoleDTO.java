package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.*;
import java.util.Date;

public class SeRoleDTO {

    private Integer roleId;
    private String roleName;
    private String roleDescription;
    private int version;
    private boolean status;
    private int txUser;
    private String txHost;
    private Date txDate;

    public SeRoleDTO() {}

    public SeRoleDTO(SeRole role) {
        this.roleId = role.getRoleId();
        this.roleName = role.getRoleName();
        this.roleDescription = role.getRoleDescription();
        this.version = role.getVersion();
        this.status = role.getStatus();
        this.txUser = role.getTxUser();
        this.txHost = role.getTxHost();
        this.txDate = role.getTxDate();
    }

    public SeRoleDTO(Integer roleId) {
        this.roleId = roleId;
    }

    public SeRoleDTO(Integer roleId, String roleName, String roleDescription, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    // Getters and setters...

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getTxUser() {
        return txUser;
    }

    public void setTxUser(int txUser) {
        this.txUser = txUser;
    }

    public String getTxHost() {
        return txHost;
    }

    public void setTxHost(String txHost) {
        this.txHost = txHost;
    }

    public Date getTxDate() {
        return txDate;
    }

    public void setTxDate(Date txDate) {
        this.txDate = txDate;
    }

    public SeRole toEntity() {
        SeRole role = new SeRole();
        role.setRoleId(this.roleId);
        role.setRoleName(this.roleName);
        role.setRoleDescription(this.roleDescription);
        role.setVersion(this.version);
        role.setStatus(this.status);
        role.setTxUser(this.txUser);
        role.setTxHost(this.txHost);
        role.setTxDate(this.txDate);
        return role;
    }

    @Override
    public String toString() {
        return "SeRoleDTO{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDescription='" + roleDescription + '\'' +
                ", version=" + version +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                '}';
    }
}
