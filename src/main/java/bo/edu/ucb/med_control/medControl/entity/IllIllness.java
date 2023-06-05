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
@Table(name = "ill_illness")
@NamedQueries({
    @NamedQuery(name = "IllIllness.findAll", query = "SELECT i FROM IllIllness i"),
    @NamedQuery(name = "IllIllness.findByIllnessId", query = "SELECT i FROM IllIllness i WHERE i.illnessId = :illnessId"),
    @NamedQuery(name = "IllIllness.findByIllnessName", query = "SELECT i FROM IllIllness i WHERE i.illnessName = :illnessName"),
    @NamedQuery(name = "IllIllness.findByIllnesDescription", query = "SELECT i FROM IllIllness i WHERE i.illnesDescription = :illnesDescription"),
    @NamedQuery(name = "IllIllness.findByVersion", query = "SELECT i FROM IllIllness i WHERE i.version = :version"),
    @NamedQuery(name = "IllIllness.findByStatus", query = "SELECT i FROM IllIllness i WHERE i.status = :status"),
    @NamedQuery(name = "IllIllness.findByTxUser", query = "SELECT i FROM IllIllness i WHERE i.txUser = :txUser"),
    @NamedQuery(name = "IllIllness.findByTxHost", query = "SELECT i FROM IllIllness i WHERE i.txHost = :txHost"),
    @NamedQuery(name = "IllIllness.findByTxDate", query = "SELECT i FROM IllIllness i WHERE i.txDate = :txDate")})
public class IllIllness implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "illness_id")
    private Integer illnessId;
    @Basic(optional = false)
    @Column(name = "illness_name")
    private String illnessName;
    @Basic(optional = false)
    @Column(name = "illnes_description")
    private String illnesDescription;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "illnessId", fetch = FetchType.LAZY)
    private List<IllPatientIllness> illPatientIllnessList;

    public IllIllness() {
    }

    public IllIllness(Integer illnessId) {
        this.illnessId = illnessId;
    }

    public IllIllness(Integer illnessId, String illnessName, String illnesDescription, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.illnessId = illnessId;
        this.illnessName = illnessName;
        this.illnesDescription = illnesDescription;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getIllnessId() {
        return illnessId;
    }

    public void setIllnessId(Integer illnessId) {
        this.illnessId = illnessId;
    }

    public String getIllnessName() {
        return illnessName;
    }

    public void setIllnessName(String illnessName) {
        this.illnessName = illnessName;
    }

    public String getIllnesDescription() {
        return illnesDescription;
    }

    public void setIllnesDescription(String illnesDescription) {
        this.illnesDescription = illnesDescription;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (illnessId != null ? illnessId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IllIllness)) {
            return false;
        }
        IllIllness other = (IllIllness) object;
        if ((this.illnessId == null && other.illnessId != null) || (this.illnessId != null && !this.illnessId.equals(other.illnessId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.IllIllness[ illnessId=" + illnessId + " ]";
    }
    
}
