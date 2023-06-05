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
@Table(name = "ill_patient_illness")
@NamedQueries({
    @NamedQuery(name = "IllPatientIllness.findAll", query = "SELECT i FROM IllPatientIllness i"),
    @NamedQuery(name = "IllPatientIllness.findByUserIllnessId", query = "SELECT i FROM IllPatientIllness i WHERE i.userIllnessId = :userIllnessId"),
    @NamedQuery(name = "IllPatientIllness.findByIllnessDocumentId", query = "SELECT i FROM IllPatientIllness i WHERE i.illnessDocumentId = :illnessDocumentId"),
    @NamedQuery(name = "IllPatientIllness.findByPatientIllnessDiagnosticDate", query = "SELECT i FROM IllPatientIllness i WHERE i.patientIllnessDiagnosticDate = :patientIllnessDiagnosticDate"),
    @NamedQuery(name = "IllPatientIllness.findByVersion", query = "SELECT i FROM IllPatientIllness i WHERE i.version = :version"),
    @NamedQuery(name = "IllPatientIllness.findByStatus", query = "SELECT i FROM IllPatientIllness i WHERE i.status = :status"),
    @NamedQuery(name = "IllPatientIllness.findByTxDate", query = "SELECT i FROM IllPatientIllness i WHERE i.txDate = :txDate"),
    @NamedQuery(name = "IllPatientIllness.findByTxUser", query = "SELECT i FROM IllPatientIllness i WHERE i.txUser = :txUser"),
    @NamedQuery(name = "IllPatientIllness.findByTxHost", query = "SELECT i FROM IllPatientIllness i WHERE i.txHost = :txHost")})
public class IllPatientIllness implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_illness_id")
    private Integer userIllnessId;
    @Basic(optional = false)
    @Column(name = "illness_document_id")
    private int illnessDocumentId;
    @Basic(optional = false)
    @Column(name = "patient_illness_diagnostic_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date patientIllnessDiagnosticDate;
    @Version
    @Basic(optional = false)
    @Column(name = "version")
    private int version;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    @Basic(optional = false)
    @Column(name = "tx_date")
    private int txDate;
    @Basic(optional = false)
    @Column(name = "tx_user")
    private int txUser;
    @Basic(optional = false)
    @Column(name = "tx_host")
    private String txHost;
    @JoinColumn(name = "illness_id", referencedColumnName = "illness_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private IllIllness illnessId;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SePatient patientId;

    public IllPatientIllness() {
    }

    public IllPatientIllness(Integer userIllnessId) {
        this.userIllnessId = userIllnessId;
    }

    public IllPatientIllness(Integer userIllnessId, int illnessDocumentId, Date patientIllnessDiagnosticDate, int version, boolean status, int txDate, int txUser, String txHost) {
        this.userIllnessId = userIllnessId;
        this.illnessDocumentId = illnessDocumentId;
        this.patientIllnessDiagnosticDate = patientIllnessDiagnosticDate;
        this.version = version;
        this.status = status;
        this.txDate = txDate;
        this.txUser = txUser;
        this.txHost = txHost;
    }

    public Integer getUserIllnessId() {
        return userIllnessId;
    }

    public void setUserIllnessId(Integer userIllnessId) {
        this.userIllnessId = userIllnessId;
    }

    public int getIllnessDocumentId() {
        return illnessDocumentId;
    }

    public void setIllnessDocumentId(int illnessDocumentId) {
        this.illnessDocumentId = illnessDocumentId;
    }

    public Date getPatientIllnessDiagnosticDate() {
        return patientIllnessDiagnosticDate;
    }

    public void setPatientIllnessDiagnosticDate(Date patientIllnessDiagnosticDate) {
        this.patientIllnessDiagnosticDate = patientIllnessDiagnosticDate;
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

    public int getTxDate() {
        return txDate;
    }

    public void setTxDate(int txDate) {
        this.txDate = txDate;
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

    public IllIllness getIllnessId() {
        return illnessId;
    }

    public void setIllnessId(IllIllness illnessId) {
        this.illnessId = illnessId;
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
        hash += (userIllnessId != null ? userIllnessId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IllPatientIllness)) {
            return false;
        }
        IllPatientIllness other = (IllPatientIllness) object;
        if ((this.userIllnessId == null && other.userIllnessId != null) || (this.userIllnessId != null && !this.userIllnessId.equals(other.userIllnessId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.IllPatientIllness[ userIllnessId=" + userIllnessId + " ]";
    }
    
}
