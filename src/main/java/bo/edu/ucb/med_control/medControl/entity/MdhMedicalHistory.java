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
@Table(name = "mdh_medical_history")
@NamedQueries({
    @NamedQuery(name = "MdhMedicalHistory.findAll", query = "SELECT m FROM MdhMedicalHistory m"),
    @NamedQuery(name = "MdhMedicalHistory.findByMedicalHistory", query = "SELECT m FROM MdhMedicalHistory m WHERE m.medicalHistory = :medicalHistory"),
    @NamedQuery(name = "MdhMedicalHistory.findByRelativesName", query = "SELECT m FROM MdhMedicalHistory m WHERE m.relativesName = :relativesName"),
    @NamedQuery(name = "MdhMedicalHistory.findByMedicalHistoryDocumentId", query = "SELECT m FROM MdhMedicalHistory m WHERE m.medicalHistoryDocumentId = :medicalHistoryDocumentId"),
    @NamedQuery(name = "MdhMedicalHistory.findByVersion", query = "SELECT m FROM MdhMedicalHistory m WHERE m.version = :version"),
    @NamedQuery(name = "MdhMedicalHistory.findByStatus", query = "SELECT m FROM MdhMedicalHistory m WHERE m.status = :status"),
    @NamedQuery(name = "MdhMedicalHistory.findByTxUser", query = "SELECT m FROM MdhMedicalHistory m WHERE m.txUser = :txUser"),
    @NamedQuery(name = "MdhMedicalHistory.findByTxHost", query = "SELECT m FROM MdhMedicalHistory m WHERE m.txHost = :txHost"),
    @NamedQuery(name = "MdhMedicalHistory.findByTxDate", query = "SELECT m FROM MdhMedicalHistory m WHERE m.txDate = :txDate")})
public class MdhMedicalHistory implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "medical_history")
    private Integer medicalHistory;
    @Basic(optional = false)
    @Column(name = "relatives_name")
    private String relativesName;
    @Basic(optional = false)
    @Column(name = "medical_history_document_id")
    private int medicalHistoryDocumentId;
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
    @JoinColumn(name = "kinship_id", referencedColumnName = "kinship_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MdhKinship kinshipId;
    @JoinColumn(name = "medical_history_type_id", referencedColumnName = "medical_history_type_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MdhMedicalHistoryType medicalHistoryTypeId;
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SePatient patientId;

    public MdhMedicalHistory() {
    }

    public MdhMedicalHistory(Integer medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public MdhMedicalHistory(Integer medicalHistory, String relativesName, int medicalHistoryDocumentId, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.medicalHistory = medicalHistory;
        this.relativesName = relativesName;
        this.medicalHistoryDocumentId = medicalHistoryDocumentId;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(Integer medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getRelativesName() {
        return relativesName;
    }

    public void setRelativesName(String relativesName) {
        this.relativesName = relativesName;
    }

    public int getMedicalHistoryDocumentId() {
        return medicalHistoryDocumentId;
    }

    public void setMedicalHistoryDocumentId(int medicalHistoryDocumentId) {
        this.medicalHistoryDocumentId = medicalHistoryDocumentId;
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

    public MdhKinship getKinshipId() {
        return kinshipId;
    }

    public void setKinshipId(MdhKinship kinshipId) {
        this.kinshipId = kinshipId;
    }

    public MdhMedicalHistoryType getMedicalHistoryTypeId() {
        return medicalHistoryTypeId;
    }

    public void setMedicalHistoryTypeId(MdhMedicalHistoryType medicalHistoryTypeId) {
        this.medicalHistoryTypeId = medicalHistoryTypeId;
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
        hash += (medicalHistory != null ? medicalHistory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MdhMedicalHistory)) {
            return false;
        }
        MdhMedicalHistory other = (MdhMedicalHistory) object;
        if ((this.medicalHistory == null && other.medicalHistory != null) || (this.medicalHistory != null && !this.medicalHistory.equals(other.medicalHistory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.MdhMedicalHistory[ medicalHistory=" + medicalHistory + " ]";
    }
    
}
