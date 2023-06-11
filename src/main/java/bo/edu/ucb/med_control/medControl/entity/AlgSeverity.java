/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.edu.ucb.med_control.medControl.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
/**
 *
 * @author isai
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "alg_severity")
@NamedQueries({
    @NamedQuery(name = "AlgSeverity.findAll", query = "SELECT a FROM AlgSeverity a"),
    @NamedQuery(name = "AlgSeverity.findBySeverityId", query = "SELECT a FROM AlgSeverity a WHERE a.severityId = :severityId"),
    @NamedQuery(name = "AlgSeverity.findBySeverityName", query = "SELECT a FROM AlgSeverity a WHERE a.severityName = :severityName"),
    @NamedQuery(name = "AlgSeverity.findByVersion", query = "SELECT a FROM AlgSeverity a WHERE a.version = :version"),
    @NamedQuery(name = "AlgSeverity.findByStatus", query = "SELECT a FROM AlgSeverity a WHERE a.status = :status"),
    @NamedQuery(name = "AlgSeverity.findByTxUser", query = "SELECT a FROM AlgSeverity a WHERE a.txUser = :txUser"),
    @NamedQuery(name = "AlgSeverity.findByTxHost", query = "SELECT a FROM AlgSeverity a WHERE a.txHost = :txHost"),
    @NamedQuery(name = "AlgSeverity.findByTxDate", query = "SELECT a FROM AlgSeverity a WHERE a.txDate = :txDate")})
public class AlgSeverity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "severity_id")
    private Integer severityId;
    @Basic(optional = false)
    @Column(name = "severity_name")
    private String severityName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "severityId", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<AlgPatientAllergy> algPatientAllergyList;

    public AlgSeverity() {
    }

    public AlgSeverity(Integer severityId) {
        this.severityId = severityId;
    }

    public AlgSeverity(Integer severityId, String severityName, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.severityId = severityId;
        this.severityName = severityName;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getSeverityId() {
        return severityId;
    }

    public void setSeverityId(Integer severityId) {
        this.severityId = severityId;
    }

    public String getSeverityName() {
        return severityName;
    }

    public void setSeverityName(String severityName) {
        this.severityName = severityName;
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

    public List<AlgPatientAllergy> getAlgPatientAllergyList() {
        return algPatientAllergyList;
    }

    public void setAlgPatientAllergyList(List<AlgPatientAllergy> algPatientAllergyList) {
        this.algPatientAllergyList = algPatientAllergyList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (severityId != null ? severityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlgSeverity)) {
            return false;
        }
        AlgSeverity other = (AlgSeverity) object;
        if ((this.severityId == null && other.severityId != null) || (this.severityId != null && !this.severityId.equals(other.severityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.AlgSeverity[ severityId=" + severityId + " ]";
    }
    
}
