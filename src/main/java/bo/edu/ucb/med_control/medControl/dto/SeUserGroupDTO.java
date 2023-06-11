package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.*;
import java.util.Date;

public class SeUserGroupDTO {

    private Integer userGroupId;
    private int version;
    private boolean status;
    private int txUser;
    private String txHost;
    private Date txDate;
    private SeGroupDTO groupId;
    private SeUserDTO userId;

    public SeUserGroupDTO() {}

    public SeUserGroupDTO(SeUserGroup userGroup) {
        this.userGroupId = userGroup.getUserGroupId();
        this.version = userGroup.getVersion();
        this.status = userGroup.getStatus();
        this.txUser = userGroup.getTxUser();
        this.txHost = userGroup.getTxHost();
        this.txDate = userGroup.getTxDate();
    }

    public SeUserGroupDTO(Integer userGroupId) {
        this.userGroupId = userGroupId;
    }

    public SeUserGroupDTO(Integer userGroupId, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.userGroupId = userGroupId;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    // Getters and setters...


    public Integer getUserGroupId() {
        return userGroupId;
    }

    public void setUserGroupId(Integer userGroupId) {
        this.userGroupId = userGroupId;
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

    public SeUserDTO getUserId() {
        return userId;
    }

    public void setUserId(SeUserDTO userId) {
        this.userId = userId;
    }

    public SeUserGroup toEntity() {
        SeUserGroup userGroup = new SeUserGroup();
        userGroup.setUserGroupId(this.userGroupId);
        userGroup.setVersion(this.version);
        userGroup.setStatus(this.status);
        userGroup.setTxUser(this.txUser);
        userGroup.setTxHost(this.txHost);
        userGroup.setTxDate(this.txDate);
        userGroup.setGroupId(this.groupId.toEntity());
        userGroup.setUserId(this.userId.toEntity());
        return userGroup;
    }

    @Override
    public String toString() {
        return "SeUserGroupDTO{" +
                "userGroupId=" + userGroupId +
                ", version=" + version +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                ", groupId=" + groupId +
                ", userId=" + userId +
                '}';
    }
}
