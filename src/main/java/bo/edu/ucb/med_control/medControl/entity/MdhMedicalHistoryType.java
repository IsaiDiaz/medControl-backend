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
@Table(name = "mdh_medical_history_type")
@NamedQueries({
    @NamedQuery(name = "MdhMedicalHistoryType.findAll", query = "SELECT m FROM MdhMedicalHistoryType m"),
    @NamedQuery(name = "MdhMedicalHistoryType.findByMedicalHistoryTypeId", query = "SELECT m FROM MdhMedicalHistoryType m WHERE m.medicalHistoryTypeId = :medicalHistoryTypeId"),
    @NamedQuery(name = "MdhMedicalHistoryType.findByMedicalHistoryName", query = "SELECT m FROM MdhMedicalHistoryType m WHERE m.medicalHistoryName = :medicalHistoryName"),
    @NamedQuery(name = "MdhMedicalHistoryType.findByVersion", query = "SELECT m FROM MdhMedicalHistoryType m WHERE m.version = :version"),
    @NamedQuery(name = "MdhMedicalHistoryType.findByStatus", query = "SELECT m FROM MdhMedicalHistoryType m WHERE m.status = :status"),
    @NamedQuery(name = "MdhMedicalHistoryType.findByTxUser", query = "SELECT m FROM MdhMedicalHistoryType m WHERE m.txUser = :txUser"),
    @NamedQuery(name = "MdhMedicalHistoryType.findByTxHost", query = "SELECT m FROM MdhMedicalHistoryType m WHERE m.txHost = :txHost"),
    @NamedQuery(name = "MdhMedicalHistoryType.findByTxDate", query = "SELECT m FROM MdhMedicalHistoryType m WHERE m.txDate = :txDate")})
public class MdhMedicalHistoryType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "medical_history_type_id")
    private Integer medicalHistoryTypeId;
    @Basic(optional = false)
    @Column(name = "medical_history_name")
    private String medicalHistoryName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicalHistoryTypeId", fetch = FetchType.LAZY)
    private List<MdhMedicalHistory> mdhMedicalHistoryList;

    public MdhMedicalHistoryType() {
    }

    public MdhMedicalHistoryType(Integer medicalHistoryTypeId) {
        this.medicalHistoryTypeId = medicalHistoryTypeId;
    }

    public MdhMedicalHistoryType(Integer medicalHistoryTypeId, String medicalHistoryName, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.medicalHistoryTypeId = medicalHistoryTypeId;
        this.medicalHistoryName = medicalHistoryName;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getMedicalHistoryTypeId() {
        return medicalHistoryTypeId;
    }

    public void setMedicalHistoryTypeId(Integer medicalHistoryTypeId) {
        this.medicalHistoryTypeId = medicalHistoryTypeId;
    }

    public String getMedicalHistoryName() {
        return medicalHistoryName;
    }

    public void setMedicalHistoryName(String medicalHistoryName) {
        this.medicalHistoryName = medicalHistoryName;
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

    public List<MdhMedicalHistory> getMdhMedicalHistoryList() {
        return mdhMedicalHistoryList;
    }

    public void setMdhMedicalHistoryList(List<MdhMedicalHistory> mdhMedicalHistoryList) {
        this.mdhMedicalHistoryList = mdhMedicalHistoryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medicalHistoryTypeId != null ? medicalHistoryTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MdhMedicalHistoryType)) {
            return false;
        }
        MdhMedicalHistoryType other = (MdhMedicalHistoryType) object;
        if ((this.medicalHistoryTypeId == null && other.medicalHistoryTypeId != null) || (this.medicalHistoryTypeId != null && !this.medicalHistoryTypeId.equals(other.medicalHistoryTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.MdhMedicalHistoryType[ medicalHistoryTypeId=" + medicalHistoryTypeId + " ]";
    }
    
}
