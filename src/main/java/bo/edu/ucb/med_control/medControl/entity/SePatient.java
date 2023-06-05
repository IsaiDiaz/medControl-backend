/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.edu.ucb.med_control.medControl.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import jakarta.persistence.*;

/**
 *
 * @author isai
 */
@Entity
@Table(name = "se_patient")
@NamedQueries({
    @NamedQuery(name = "SePatient.findAll", query = "SELECT s FROM SePatient s"),
    @NamedQuery(name = "SePatient.findByPatientId", query = "SELECT s FROM SePatient s WHERE s.patientId = :patientId"),
    @NamedQuery(name = "SePatient.findByPatientHeight", query = "SELECT s FROM SePatient s WHERE s.patientHeight = :patientHeight"),
    @NamedQuery(name = "SePatient.findByPatientWeight", query = "SELECT s FROM SePatient s WHERE s.patientWeight = :patientWeight"),
    @NamedQuery(name = "SePatient.findByPatientGender", query = "SELECT s FROM SePatient s WHERE s.patientGender = :patientGender"),
    @NamedQuery(name = "SePatient.findByVersion", query = "SELECT s FROM SePatient s WHERE s.version = :version"),
    @NamedQuery(name = "SePatient.findByStatus", query = "SELECT s FROM SePatient s WHERE s.status = :status"),
    @NamedQuery(name = "SePatient.findByTxUser", query = "SELECT s FROM SePatient s WHERE s.txUser = :txUser"),
    @NamedQuery(name = "SePatient.findByTxHost", query = "SELECT s FROM SePatient s WHERE s.txHost = :txHost"),
    @NamedQuery(name = "SePatient.findByTxDate", query = "SELECT s FROM SePatient s WHERE s.txDate = :txDate")})
public class SePatient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "patient_id")
    private Integer patientId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "patient_height")
    private BigDecimal patientHeight;
    @Basic(optional = false)
    @Column(name = "patient_weight")
    private BigDecimal patientWeight;
    @Basic(optional = false)
    @Column(name = "patient_gender")
    private String patientGender;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId", fetch = FetchType.LAZY)
    private List<IllPatientIllness> illPatientIllnessList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId", fetch = FetchType.LAZY)
    private List<MdhMedicalHistory> mdhMedicalHistoryList;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SeUser userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId", fetch = FetchType.LAZY)
    private List<AlgPatientAllergy> algPatientAllergyList;

    public SePatient() {
    }

    public SePatient(Integer patientId) {
        this.patientId = patientId;
    }

    public SePatient(Integer patientId, BigDecimal patientHeight, BigDecimal patientWeight, String patientGender, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.patientId = patientId;
        this.patientHeight = patientHeight;
        this.patientWeight = patientWeight;
        this.patientGender = patientGender;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public BigDecimal getPatientHeight() {
        return patientHeight;
    }

    public void setPatientHeight(BigDecimal patientHeight) {
        this.patientHeight = patientHeight;
    }

    public BigDecimal getPatientWeight() {
        return patientWeight;
    }

    public void setPatientWeight(BigDecimal patientWeight) {
        this.patientWeight = patientWeight;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
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

    public List<IllPatientIllness> getIllPatientIllnessList() {
        return illPatientIllnessList;
    }

    public void setIllPatientIllnessList(List<IllPatientIllness> illPatientIllnessList) {
        this.illPatientIllnessList = illPatientIllnessList;
    }

    public List<MdhMedicalHistory> getMdhMedicalHistoryList() {
        return mdhMedicalHistoryList;
    }

    public void setMdhMedicalHistoryList(List<MdhMedicalHistory> mdhMedicalHistoryList) {
        this.mdhMedicalHistoryList = mdhMedicalHistoryList;
    }

    public SeUser getUserId() {
        return userId;
    }

    public void setUserId(SeUser userId) {
        this.userId = userId;
    }

    public List<AlgPatientAllergy> getAlgPatientAllergyList() {
        return algPatientAllergyList;
    }

    public void setAlgPatientAllergyList(List<AlgPatientAllergy> algPatientAllergyList) {
        this.algPatientAllergyList = algPatientAllergyList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientId != null ? patientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SePatient)) {
            return false;
        }
        SePatient other = (SePatient) object;
        if ((this.patientId == null && other.patientId != null) || (this.patientId != null && !this.patientId.equals(other.patientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.SePatient[ patientId=" + patientId + " ]";
    }
    
}
