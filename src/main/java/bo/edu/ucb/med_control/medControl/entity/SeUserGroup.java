/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.edu.ucb.med_control.medControl.entity;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;

/**
 *
 * @author isai
 */
@Entity
@Table(name = "se_user_group")
@NamedQueries({
    @NamedQuery(name = "SeUserGroup.findAll", query = "SELECT s FROM SeUserGroup s"),
    @NamedQuery(name = "SeUserGroup.findByUserGroupId", query = "SELECT s FROM SeUserGroup s WHERE s.userGroupId = :userGroupId"),
    @NamedQuery(name = "SeUserGroup.findByVersion", query = "SELECT s FROM SeUserGroup s WHERE s.version = :version"),
    @NamedQuery(name = "SeUserGroup.findByStatus", query = "SELECT s FROM SeUserGroup s WHERE s.status = :status"),
    @NamedQuery(name = "SeUserGroup.findByTxUser", query = "SELECT s FROM SeUserGroup s WHERE s.txUser = :txUser"),
    @NamedQuery(name = "SeUserGroup.findByTxHost", query = "SELECT s FROM SeUserGroup s WHERE s.txHost = :txHost"),
    @NamedQuery(name = "SeUserGroup.findByTxDate", query = "SELECT s FROM SeUserGroup s WHERE s.txDate = :txDate")})
public class SeUserGroup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_group_id")
    private Integer userGroupId;
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
    @JoinColumn(name = "group_id", referencedColumnName = "group_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SeGroup groupId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SeUser userId;

    public SeUserGroup() {
    }

    public SeUserGroup(Integer userGroupId) {
        this.userGroupId = userGroupId;
    }

    public SeUserGroup(Integer userGroupId, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.userGroupId = userGroupId;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

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

    public SeGroup getGroupId() {
        return groupId;
    }

    public void setGroupId(SeGroup groupId) {
        this.groupId = groupId;
    }

    public SeUser getUserId() {
        return userId;
    }

    public void setUserId(SeUser userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userGroupId != null ? userGroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeUserGroup)) {
            return false;
        }
        SeUserGroup other = (SeUserGroup) object;
        if ((this.userGroupId == null && other.userGroupId != null) || (this.userGroupId != null && !this.userGroupId.equals(other.userGroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.SeUserGroup[ userGroupId=" + userGroupId + " ]";
    }
    
}
