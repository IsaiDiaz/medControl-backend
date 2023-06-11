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
@Table(name = "alg_allergy")
@NamedQueries({
    @NamedQuery(name = "AlgAllergy.findAll", query = "SELECT a FROM AlgAllergy a"),
    @NamedQuery(name = "AlgAllergy.findByAllergyId", query = "SELECT a FROM AlgAllergy a WHERE a.allergyId = :allergyId"),
    @NamedQuery(name = "AlgAllergy.findByAllergyName", query = "SELECT a FROM AlgAllergy a WHERE a.allergyName = :allergyName"),
    @NamedQuery(name = "AlgAllergy.findByAllergyDescription", query = "SELECT a FROM AlgAllergy a WHERE a.allergyDescription = :allergyDescription"),
    @NamedQuery(name = "AlgAllergy.findByVersion", query = "SELECT a FROM AlgAllergy a WHERE a.version = :version"),
    @NamedQuery(name = "AlgAllergy.findByStatus", query = "SELECT a FROM AlgAllergy a WHERE a.status = :status"),
    @NamedQuery(name = "AlgAllergy.findByTxUser", query = "SELECT a FROM AlgAllergy a WHERE a.txUser = :txUser"),
    @NamedQuery(name = "AlgAllergy.findByTxHost", query = "SELECT a FROM AlgAllergy a WHERE a.txHost = :txHost"),
    @NamedQuery(name = "AlgAllergy.findByTxDate", query = "SELECT a FROM AlgAllergy a WHERE a.txDate = :txDate")})
public class AlgAllergy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "allergy_id")
    private Integer allergyId;
    @Basic(optional = false)
    @Column(name = "allergy_name")
    private String allergyName;
    @Basic(optional = false)
    @Column(name = "allergy_description")
    private String allergyDescription;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "allergyId", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<AlgPatientAllergy> algPatientAllergyList;

    public AlgAllergy() {
    }

    public AlgAllergy(Integer allergyId) {
        this.allergyId = allergyId;
    }

    public AlgAllergy(Integer allergyId, String allergyName, String allergyDescription, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.allergyId = allergyId;
        this.allergyName = allergyName;
        this.allergyDescription = allergyDescription;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getAllergyId() {
        return allergyId;
    }

    public void setAllergyId(Integer allergyId) {
        this.allergyId = allergyId;
    }

    public String getAllergyName() {
        return allergyName;
    }

    public void setAllergyName(String allergyName) {
        this.allergyName = allergyName;
    }

    public String getAllergyDescription() {
        return allergyDescription;
    }

    public void setAllergyDescription(String allergyDescription) {
        this.allergyDescription = allergyDescription;
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
        hash += (allergyId != null ? allergyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlgAllergy)) {
            return false;
        }
        AlgAllergy other = (AlgAllergy) object;
        if ((this.allergyId == null && other.allergyId != null) || (this.allergyId != null && !this.allergyId.equals(other.allergyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.AlgAllergy[ allergyId=" + allergyId + " ]";
    }
    
}
