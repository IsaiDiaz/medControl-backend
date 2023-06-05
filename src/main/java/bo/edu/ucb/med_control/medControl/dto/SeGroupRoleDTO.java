package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.*;
import java.util.Date;

public class SeGroupRoleDTO {

    private Integer groupRoleId;
    private int version;
    private boolean status;
    private int txUser;
    private String txHost;
    private Date txDate;
    private SeGroupDTO groupId;
    private SeRoleDTO roleId;

    public SeGroupRoleDTO() {}

    public SeGroupRoleDTO(SeGroupRole groupRole) {
        this.groupRoleId = groupRole.getGroupRoleId();
        this.version = groupRole.getVersion();
        this.status = groupRole.getStatus();
        this.txUser = groupRole.getTxUser();
        this.txHost = groupRole.getTxHost();
        this.txDate = groupRole.getTxDate();
        this.groupId = new SeGroupDTO(groupRole.getGroupId());
        this.roleId = new SeRoleDTO(groupRole.getRoleId());
    }

    public SeGroupRoleDTO(Integer groupRoleId) {
        this.groupRoleId = groupRoleId;
    }

    public SeGroupRoleDTO(Integer groupRoleId, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.groupRoleId = groupRoleId;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    // Getters and setters...

    public Integer getGroupRoleId() {
        return groupRoleId;
    }

    public void setGroupRoleId(Integer groupRoleId) {
        this.groupRoleId = groupRoleId;
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

    public SeGroupDTO getGroupId() {
        return groupId;
    }

    public void setGroupId(SeGroupDTO groupId) {
        this.groupId = groupId;
    }

    public SeRoleDTO getRoleId() {
        return roleId;
    }

    public void setRoleId(SeRoleDTO roleId) {
        this.roleId = roleId;
    }

    public SeGroupRole toEntity() {
        SeGroupRole groupRole = new SeGroupRole();
        groupRole.setGroupRoleId(this.groupRoleId);
        groupRole.setVersion(this.version);
        groupRole.setStatus(this.status);
        groupRole.setTxUser(this.txUser);
        groupRole.setTxHost(this.txHost);
        groupRole.setTxDate(this.txDate);
        groupRole.setGroupId(this.groupId.toEntity());
        groupRole.setRoleId(this.roleId.toEntity());
        return groupRole;
    }

    @Override
    public String toString() {
        return "SeGroupRoleDTO{" +
                "groupRoleId=" + groupRoleId +
                ", version=" + version +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                ", groupId=" + groupId +
                ", roleId=" + roleId +
                '}';
    }
}
