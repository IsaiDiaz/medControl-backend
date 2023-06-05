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
@Table(name = "mdh_kinship")
@NamedQueries({
    @NamedQuery(name = "MdhKinship.findAll", query = "SELECT m FROM MdhKinship m"),
    @NamedQuery(name = "MdhKinship.findByKinshipId", query = "SELECT m FROM MdhKinship m WHERE m.kinshipId = :kinshipId"),
    @NamedQuery(name = "MdhKinship.findByKinshipName", query = "SELECT m FROM MdhKinship m WHERE m.kinshipName = :kinshipName"),
    @NamedQuery(name = "MdhKinship.findByKinshipDescription", query = "SELECT m FROM MdhKinship m WHERE m.kinshipDescription = :kinshipDescription"),
    @NamedQuery(name = "MdhKinship.findByVersion", query = "SELECT m FROM MdhKinship m WHERE m.version = :version"),
    @NamedQuery(name = "MdhKinship.findByStatus", query = "SELECT m FROM MdhKinship m WHERE m.status = :status"),
    @NamedQuery(name = "MdhKinship.findByTxUser", query = "SELECT m FROM MdhKinship m WHERE m.txUser = :txUser"),
    @NamedQuery(name = "MdhKinship.findByTxHost", query = "SELECT m FROM MdhKinship m WHERE m.txHost = :txHost"),
    @NamedQuery(name = "MdhKinship.findByTxDate", query = "SELECT m FROM MdhKinship m WHERE m.txDate = :txDate")})
public class MdhKinship implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "kinship_id")
    private Integer kinshipId;
    @Basic(optional = false)
    @Column(name = "kinship_name")
    private String kinshipName;
    @Basic(optional = false)
    @Column(name = "kinship_description")
    private String kinshipDescription;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kinshipId", fetch = FetchType.LAZY)
    private List<MdhMedicalHistory> mdhMedicalHistoryList;

    public MdhKinship() {
    }

    public MdhKinship(Integer kinshipId) {
        this.kinshipId = kinshipId;
    }

    public MdhKinship(Integer kinshipId, String kinshipName, String kinshipDescription, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.kinshipId = kinshipId;
        this.kinshipName = kinshipName;
        this.kinshipDescription = kinshipDescription;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getKinshipId() {
        return kinshipId;
    }

    public void setKinshipId(Integer kinshipId) {
        this.kinshipId = kinshipId;
    }

    public String getKinshipName() {
        return kinshipName;
    }

    public void setKinshipName(String kinshipName) {
        this.kinshipName = kinshipName;
    }

    public String getKinshipDescription() {
        return kinshipDescription;
    }

    public void setKinshipDescription(String kinshipDescription) {
        this.kinshipDescription = kinshipDescription;
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
        hash += (kinshipId != null ? kinshipId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MdhKinship)) {
            return false;
        }
        MdhKinship other = (MdhKinship) object;
        if ((this.kinshipId == null && other.kinshipId != null) || (this.kinshipId != null && !this.kinshipId.equals(other.kinshipId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.MdhKinship[ kinshipId=" + kinshipId + " ]";
    }
    
}
