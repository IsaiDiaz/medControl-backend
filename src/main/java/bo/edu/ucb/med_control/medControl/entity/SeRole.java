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
@Table(name = "se_role")
@NamedQueries({
    @NamedQuery(name = "SeRole.findAll", query = "SELECT s FROM SeRole s"),
    @NamedQuery(name = "SeRole.findByRoleId", query = "SELECT s FROM SeRole s WHERE s.roleId = :roleId"),
    @NamedQuery(name = "SeRole.findByRoleName", query = "SELECT s FROM SeRole s WHERE s.roleName = :roleName"),
    @NamedQuery(name = "SeRole.findByRoleDescription", query = "SELECT s FROM SeRole s WHERE s.roleDescription = :roleDescription"),
    @NamedQuery(name = "SeRole.findByVersion", query = "SELECT s FROM SeRole s WHERE s.version = :version"),
    @NamedQuery(name = "SeRole.findByStatus", query = "SELECT s FROM SeRole s WHERE s.status = :status"),
    @NamedQuery(name = "SeRole.findByTxUser", query = "SELECT s FROM SeRole s WHERE s.txUser = :txUser"),
    @NamedQuery(name = "SeRole.findByTxHost", query = "SELECT s FROM SeRole s WHERE s.txHost = :txHost"),
    @NamedQuery(name = "SeRole.findByTxDate", query = "SELECT s FROM SeRole s WHERE s.txDate = :txDate")})
public class SeRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "role_id")
    private Integer roleId;
    @Basic(optional = false)
    @Column(name = "role_name")
    private String roleName;
    @Basic(optional = false)
    @Column(name = "role_description")
    private String roleDescription;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleId", fetch = FetchType.LAZY)
    private List<SeGroupRole> seGroupRoleList;

    public SeRole() {
    }

    public SeRole(Integer roleId) {
        this.roleId = roleId;
    }

    public SeRole(Integer roleId, String roleName, String roleDescription, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDescription = roleDescription;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleId != null ? roleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeRole)) {
            return false;
        }
        SeRole other = (SeRole) object;
        if ((this.roleId == null && other.roleId != null) || (this.roleId != null && !this.roleId.equals(other.roleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.SeRole[ roleId=" + roleId + " ]";
    }
    
}
