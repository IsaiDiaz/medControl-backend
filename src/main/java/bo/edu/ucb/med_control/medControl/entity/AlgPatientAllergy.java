/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.edu.ucb.med_control.medControl.entity;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

/**
 *
 * @author isai
 */
@Entity
@Table(name = "alg_patient_allergy")
@NamedQueries({
    @NamedQuery(name = "AlgPatientAllergy.findAll", query = "SELECT a FROM AlgPatientAllergy a"),
    @NamedQuery(name = "AlgPatientAllergy.findByUserAllergyId", query = "SELECT a FROM AlgPatientAllergy a WHERE a.userAllergyId = :userAllergyId"),
    @NamedQuery(name = "AlgPatientAllergy.findByPatientAllergyDiagnosticDate", query = "SELECT a FROM AlgPatientAllergy a WHERE a.patientAllergyDiagnosticDate = :patientAllergyDiagnosticDate"),
    @NamedQuery(name = "AlgPatientAllergy.findByVersion", query = "SELECT a FROM AlgPatientAllergy a WHERE a.version = :version"),
    @NamedQuery(name = "AlgPatientAllergy.findByStatus", query = "SELECT a FROM AlgPatientAllergy a WHERE a.status = :status"),
    @NamedQuery(name = "AlgPatientAllergy.findByTxUser", query = "SELECT a FROM AlgPatientAllergy a WHERE a.txUser = :txUser"),
    @NamedQuery(name = "AlgPatientAllergy.findByTxHost", query = "SELECT a FROM AlgPatientAllergy a WHERE a.txHost = :txHost"),
    @NamedQuery(name = "AlgPatientAllergy.findByTxDate", query = "SELECT a FROM AlgPatientAllergy a WHERE a.txDate = :txDate")})
public class AlgPatientAllergy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_allergy_id")
    private Integer userAllergyId;
    @Basic(optional = false)
    @Column(name = "patient_allergy_diagnostic_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date patientAllergyDiagnosticDate;
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
    @JoinColumn(name = "allergy_id", referencedColumnName = "allergy_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonManagedReference
    private AlgAllergy allergyId;
    @JoinColumn(name = "severity_id", referencedColumnName = "severity_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonManagedReference
    private AlgSeverity severityId;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SePatient patientId;

    public AlgPatientAllergy() {
    }

    public AlgPatientAllergy(Integer userAllergyId) {
        this.userAllergyId = userAllergyId;
    }

    public AlgPatientAllergy(Integer userAllergyId, Date patientAllergyDiagnosticDate, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.userAllergyId = userAllergyId;
        this.patientAllergyDiagnosticDate = patientAllergyDiagnosticDate;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getUserAllergyId() {
        return userAllergyId;
    }

    public void setUserAllergyId(Integer userAllergyId) {
        this.userAllergyId = userAllergyId;
    }

    public Date getPatientAllergyDiagnosticDate() {
        return patientAllergyDiagnosticDate;
    }

    public void setPatientAllergyDiagnosticDate(Date patientAllergyDiagnosticDate) {
        this.patientAllergyDiagnosticDate = patientAllergyDiagnosticDate;
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

    public AlgAllergy getAllergyId() {
        return allergyId;
    }

    public void setAllergyId(AlgAllergy allergyId) {
        this.allergyId = allergyId;
    }

    public AlgSeverity getSeverityId() {
        return severityId;
    }

    public void setSeverityId(AlgSeverity severityId) {
        this.severityId = severityId;
    }

    public SePatient getPatientId() {
        return patientId;
    }

    public void setPatientId(SePatient patientId) {
        this.patientId = patientId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userAllergyId != null ? userAllergyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlgPatientAllergy)) {
            return false;
        }
        AlgPatientAllergy other = (AlgPatientAllergy) object;
        if ((this.userAllergyId == null && other.userAllergyId != null) || (this.userAllergyId != null && !this.userAllergyId.equals(other.userAllergyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.AlgPatientAllergy[ userAllergyId=" + userAllergyId + " ]";
    }
    
}
