/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.edu.ucb.med_control.medControl.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.persistence.*;

/**
 *
 * @author isai
 */
@Entity
@Table(name = "se_group")
@NamedQueries({
    @NamedQuery(name = "SeGroup.findAll", query = "SELECT s FROM SeGroup s"),
    @NamedQuery(name = "SeGroup.findByGroupId", query = "SELECT s FROM SeGroup s WHERE s.groupId = :groupId"),
    @NamedQuery(name = "SeGroup.findByGroupName", query = "SELECT s FROM SeGroup s WHERE s.groupName = :groupName"),
    @NamedQuery(name = "SeGroup.findByGroupDescription", query = "SELECT s FROM SeGroup s WHERE s.groupDescription = :groupDescription"),
    @NamedQuery(name = "SeGroup.findByVersion", query = "SELECT s FROM SeGroup s WHERE s.version = :version"),
    @NamedQuery(name = "SeGroup.findByStatus", query = "SELECT s FROM SeGroup s WHERE s.status = :status"),
    @NamedQuery(name = "SeGroup.findByTxUser", query = "SELECT s FROM SeGroup s WHERE s.txUser = :txUser"),
    @NamedQuery(name = "SeGroup.findByTxHost", query = "SELECT s FROM SeGroup s WHERE s.txHost = :txHost"),
    @NamedQuery(name = "SeGroup.findByTxDate", query = "SELECT s FROM SeGroup s WHERE s.txDate = :txDate")})
public class SeGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "group_id")
    private Integer groupId;
    @Basic(optional = false)
    @Column(name = "group_name")
    private String groupName;
    @Basic(optional = false)
    @Column(name = "group_description")
    private String groupDescription;
    @Version
    @Basic(optional = false)
    @Column(name = "version")
    private int version;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    @Basic(optional = false)
    @Column(name = "tx_user")
    private int txUser;
    @Basic(optional = false)
    @Column(name = "tx_host")
    private String txHost;
    @Basic(optional = false)
    @Column(name = "tx_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date txDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId", fetch = FetchType.LAZY)
    private List<SeGroupRole> seGroupRoleList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupId", fetch = FetchType.LAZY)
    private List<SeUserGroup> seUserGroupList;

    public SeGroup() {
    }

    public SeGroup(Integer groupId) {
        this.groupId = groupId;
    }

    public SeGroup(Integer groupId, String groupName, String groupDescription, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

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

    public boolean getStatus() {
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

    public List<SeGroupRole> getSeGroupRoleList() {
        return seGroupRoleList;
    }

    public void setSeGroupRoleList(List<SeGroupRole> seGroupRoleList) {
        this.seGroupRoleList = seGroupRoleList;
    }

    public List<SeUserGroup> getSeUserGroupList() {
        return seUserGroupList;
    }

    public void setSeUserGroupList(List<SeUserGroup> seUserGroupList) {
        this.seUserGroupList = seUserGroupList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupId != null ? groupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeGroup)) {
            return false;
        }
        SeGroup other = (SeGroup) object;
        if ((this.groupId == null && other.groupId != null) || (this.groupId != null && !this.groupId.equals(other.groupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.SeGroup[ groupId=" + groupId + " ]";
    }
    
}
