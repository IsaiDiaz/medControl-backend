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
@Table(name = "user_secondary_efect")
@NamedQueries({
    @NamedQuery(name = "UserSecondaryEfect.findAll", query = "SELECT u FROM UserSecondaryEfect u"),
    @NamedQuery(name = "UserSecondaryEfect.findBySecondaryEfectId", query = "SELECT u FROM UserSecondaryEfect u WHERE u.secondaryEfectId = :secondaryEfectId"),
    @NamedQuery(name = "UserSecondaryEfect.findBySecondaryEfectName", query = "SELECT u FROM UserSecondaryEfect u WHERE u.secondaryEfectName = :secondaryEfectName"),
    @NamedQuery(name = "UserSecondaryEfect.findBySecondaryEfectDesc", query = "SELECT u FROM UserSecondaryEfect u WHERE u.secondaryEfectDesc = :secondaryEfectDesc"),
    @NamedQuery(name = "UserSecondaryEfect.findByVersion", query = "SELECT u FROM UserSecondaryEfect u WHERE u.version = :version"),
    @NamedQuery(name = "UserSecondaryEfect.findByStatus", query = "SELECT u FROM UserSecondaryEfect u WHERE u.status = :status"),
    @NamedQuery(name = "UserSecondaryEfect.findByTxUser", query = "SELECT u FROM UserSecondaryEfect u WHERE u.txUser = :txUser"),
    @NamedQuery(name = "UserSecondaryEfect.findByTxHost", query = "SELECT u FROM UserSecondaryEfect u WHERE u.txHost = :txHost"),
    @NamedQuery(name = "UserSecondaryEfect.findByTxDate", query = "SELECT u FROM UserSecondaryEfect u WHERE u.txDate = :txDate")})
public class UserSecondaryEfect implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "secondary_efect_id")
    private Integer secondaryEfectId;
    @Basic(optional = false)
    @Column(name = "secondary_efect_name")
    private String secondaryEfectName;
    @Basic(optional = false)
    @Column(name = "secondary_efect_desc")
    private String secondaryEfectDesc;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "secondaryEfectId", fetch = FetchType.LAZY)
    private List<UserSymptoms> userSymptomsList;

    public UserSecondaryEfect() {
    }

    public UserSecondaryEfect(Integer secondaryEfectId) {
        this.secondaryEfectId = secondaryEfectId;
    }

    public UserSecondaryEfect(Integer secondaryEfectId, String secondaryEfectName, String secondaryEfectDesc, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.secondaryEfectId = secondaryEfectId;
        this.secondaryEfectName = secondaryEfectName;
        this.secondaryEfectDesc = secondaryEfectDesc;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getSecondaryEfectId() {
        return secondaryEfectId;
    }

    public void setSecondaryEfectId(Integer secondaryEfectId) {
        this.secondaryEfectId = secondaryEfectId;
    }

    public String getSecondaryEfectName() {
        return secondaryEfectName;
    }

    public void setSecondaryEfectName(String secondaryEfectName) {
        this.secondaryEfectName = secondaryEfectName;
    }

    public String getSecondaryEfectDesc() {
        return secondaryEfectDesc;
    }

    public void setSecondaryEfectDesc(String secondaryEfectDesc) {
        this.secondaryEfectDesc = secondaryEfectDesc;
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

    public List<UserSymptoms> getUserSymptomsList() {
        return userSymptomsList;
    }

    public void setUserSymptomsList(List<UserSymptoms> userSymptomsList) {
        this.userSymptomsList = userSymptomsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (secondaryEfectId != null ? secondaryEfectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserSecondaryEfect)) {
            return false;
        }
        UserSecondaryEfect other = (UserSecondaryEfect) object;
        if ((this.secondaryEfectId == null && other.secondaryEfectId != null) || (this.secondaryEfectId != null && !this.secondaryEfectId.equals(other.secondaryEfectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.UserSecondaryEfect[ secondaryEfectId=" + secondaryEfectId + " ]";
    }
    
}
