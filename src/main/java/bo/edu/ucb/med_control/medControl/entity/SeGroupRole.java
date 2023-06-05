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
@Table(name = "se_group_role")
@NamedQueries({
    @NamedQuery(name = "SeGroupRole.findAll", query = "SELECT s FROM SeGroupRole s"),
    @NamedQuery(name = "SeGroupRole.findByGroupRoleId", query = "SELECT s FROM SeGroupRole s WHERE s.groupRoleId = :groupRoleId"),
    @NamedQuery(name = "SeGroupRole.findByVersion", query = "SELECT s FROM SeGroupRole s WHERE s.version = :version"),
    @NamedQuery(name = "SeGroupRole.findByStatus", query = "SELECT s FROM SeGroupRole s WHERE s.status = :status"),
    @NamedQuery(name = "SeGroupRole.findByTxUser", query = "SELECT s FROM SeGroupRole s WHERE s.txUser = :txUser"),
    @NamedQuery(name = "SeGroupRole.findByTxHost", query = "SELECT s FROM SeGroupRole s WHERE s.txHost = :txHost"),
    @NamedQuery(name = "SeGroupRole.findByTxDate", query = "SELECT s FROM SeGroupRole s WHERE s.txDate = :txDate")})
public class SeGroupRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "group_role_id")
    private Integer groupRoleId;
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
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SeRole roleId;

    public SeGroupRole() {
    }

    public SeGroupRole(Integer groupRoleId) {
        this.groupRoleId = groupRoleId;
    }

    public SeGroupRole(Integer groupRoleId, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.groupRoleId = groupRoleId;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

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

    public SeRole getRoleId() {
        return roleId;
    }

    public void setRoleId(SeRole roleId) {
        this.roleId = roleId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupRoleId != null ? groupRoleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeGroupRole)) {
            return false;
        }
        SeGroupRole other = (SeGroupRole) object;
        if ((this.groupRoleId == null && other.groupRoleId != null) || (this.groupRoleId != null && !this.groupRoleId.equals(other.groupRoleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.SeGroupRole[ groupRoleId=" + groupRoleId + " ]";
    }
    
}
