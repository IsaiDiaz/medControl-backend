package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class SeGroupDTO {

    private Integer groupId;
    private String groupName;
    private String groupDescription;
    private int version;
    private boolean status;
    private int txUser;
    private String txHost;
    private Date txDate;
    private List<SeGroupRoleDTO> seGroupRoleList;
    private List<SeUserGroupDTO> seUserGroupList;

    public SeGroupDTO() {
        this.seGroupRoleList = new ArrayList<>();
        this.seUserGroupList = new ArrayList<>();
    }

    public SeGroupDTO(SeGroup group) {
        this.groupId = group.getGroupId();
        this.groupName = group.getGroupName();
        this.groupDescription = group.getGroupDescription();
        this.version = group.getVersion();
        this.status = group.getStatus();
        this.txUser = group.getTxUser();
        this.txHost = group.getTxHost();
        this.txDate = group.getTxDate();
    }

    public SeGroupDTO(Integer groupId) {
        this.groupId = groupId;
    }

    public SeGroupDTO(Integer groupId, String groupName, String groupDescription, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    // Getters and setters...

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
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

    public List<SeGroupRoleDTO> getSeGroupRoleList() {
        return seGroupRoleList;
    }

    public void setSeGroupRoleList(List<SeGroupRoleDTO> seGroupRoleList) {
        this.seGroupRoleList = seGroupRoleList;
    }

    public List<SeUserGroupDTO> getSeUserGroupList() {
        return seUserGroupList;
    }

    public void setSeUserGroupList(List<SeUserGroupDTO> seUserGroupList) {
        this.seUserGroupList = seUserGroupList;
    }

    public SeGroup toEntity() {
        SeGroup group = new SeGroup();
        group.setGroupId(this.groupId);
        group.setGroupName(this.groupName);
        group.setGroupDescription(this.groupDescription);
        group.setVersion(this.version);
        group.setStatus(this.status);
        group.setTxUser(this.txUser);
        group.setTxHost(this.txHost);
        group.setTxDate(this.txDate);
        // Verificar si seGroupRoleList es nula y asignar una lista vacía en su lugar
        if (this.seGroupRoleList == null) {
            this.seGroupRoleList = new ArrayList<>();
        }
        group.setSeGroupRoleList(this.seGroupRoleList.stream()
                .map(SeGroupRoleDTO::toEntity)
                .collect(Collectors.toList()));

        // Verificar si seUserGroupList es nula y asignar una lista vacía en su lugar
        if (this.seUserGroupList == null) {
            this.seUserGroupList = new ArrayList<>();
        }
        group.setSeUserGroupList(this.seUserGroupList.stream()
                .map(SeUserGroupDTO::toEntity)
                .collect(Collectors.toList()));
        return group;
    }

    @Override
    public String toString() {
        return "SeGroupDTO{" +
                "groupId=" + groupId +
                ", groupName='" + groupName + '\'' +
                ", groupDescription='" + groupDescription + '\'' +
                ", version=" + version +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                ", seGroupRoleList=" + seGroupRoleList +
                ", seUserGroupList=" + seUserGroupList +
                '}';
    }
}
