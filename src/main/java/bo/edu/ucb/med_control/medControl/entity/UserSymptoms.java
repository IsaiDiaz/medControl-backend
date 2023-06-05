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
@Table(name = "user_symptoms")
@NamedQueries({
    @NamedQuery(name = "UserSymptoms.findAll", query = "SELECT u FROM UserSymptoms u"),
    @NamedQuery(name = "UserSymptoms.findByUserSymptomsId", query = "SELECT u FROM UserSymptoms u WHERE u.userSymptomsId = :userSymptomsId"),
    @NamedQuery(name = "UserSymptoms.findByVersion", query = "SELECT u FROM UserSymptoms u WHERE u.version = :version"),
    @NamedQuery(name = "UserSymptoms.findByStatus", query = "SELECT u FROM UserSymptoms u WHERE u.status = :status"),
    @NamedQuery(name = "UserSymptoms.findByTxUser", query = "SELECT u FROM UserSymptoms u WHERE u.txUser = :txUser"),
    @NamedQuery(name = "UserSymptoms.findByTxHost", query = "SELECT u FROM UserSymptoms u WHERE u.txHost = :txHost"),
    @NamedQuery(name = "UserSymptoms.findByTxDate", query = "SELECT u FROM UserSymptoms u WHERE u.txDate = :txDate")})
public class UserSymptoms implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_symptoms_id")
    private Integer userSymptomsId;
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
    @JoinColumn(name = "user_medicine_id", referencedColumnName = "user_medicine_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SeUserMedicine userMedicineId;
    @JoinColumn(name = "secondary_efect_id", referencedColumnName = "secondary_efect_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private UserSecondaryEfect secondaryEfectId;

    public UserSymptoms() {
    }

    public UserSymptoms(Integer userSymptomsId) {
        this.userSymptomsId = userSymptomsId;
    }

    public UserSymptoms(Integer userSymptomsId, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.userSymptomsId = userSymptomsId;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getUserSymptomsId() {
        return userSymptomsId;
    }

    public void setUserSymptomsId(Integer userSymptomsId) {
        this.userSymptomsId = userSymptomsId;
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

    public SeUserMedicine getUserMedicineId() {
        return userMedicineId;
    }

    public void setUserMedicineId(SeUserMedicine userMedicineId) {
        this.userMedicineId = userMedicineId;
    }

    public UserSecondaryEfect getSecondaryEfectId() {
        return secondaryEfectId;
    }

    public void setSecondaryEfectId(UserSecondaryEfect secondaryEfectId) {
        this.secondaryEfectId = secondaryEfectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userSymptomsId != null ? userSymptomsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserSymptoms)) {
            return false;
        }
        UserSymptoms other = (UserSymptoms) object;
        if ((this.userSymptomsId == null && other.userSymptomsId != null) || (this.userSymptomsId != null && !this.userSymptomsId.equals(other.userSymptomsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.UserSymptoms[ userSymptomsId=" + userSymptomsId + " ]";
    }
    
}
