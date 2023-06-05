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
@Table(name = "mdi_medical_speciality")
@NamedQueries({
    @NamedQuery(name = "MdiMedicalSpeciality.findAll", query = "SELECT m FROM MdiMedicalSpeciality m"),
    @NamedQuery(name = "MdiMedicalSpeciality.findByMedicalSpecialityId", query = "SELECT m FROM MdiMedicalSpeciality m WHERE m.medicalSpecialityId = :medicalSpecialityId"),
    @NamedQuery(name = "MdiMedicalSpeciality.findByMedicalSpecialityName", query = "SELECT m FROM MdiMedicalSpeciality m WHERE m.medicalSpecialityName = :medicalSpecialityName"),
    @NamedQuery(name = "MdiMedicalSpeciality.findByMedicalSpecialityDescription", query = "SELECT m FROM MdiMedicalSpeciality m WHERE m.medicalSpecialityDescription = :medicalSpecialityDescription"),
    @NamedQuery(name = "MdiMedicalSpeciality.findByVersion", query = "SELECT m FROM MdiMedicalSpeciality m WHERE m.version = :version"),
    @NamedQuery(name = "MdiMedicalSpeciality.findByStatus", query = "SELECT m FROM MdiMedicalSpeciality m WHERE m.status = :status"),
    @NamedQuery(name = "MdiMedicalSpeciality.findByTxUser", query = "SELECT m FROM MdiMedicalSpeciality m WHERE m.txUser = :txUser"),
    @NamedQuery(name = "MdiMedicalSpeciality.findByTxHost", query = "SELECT m FROM MdiMedicalSpeciality m WHERE m.txHost = :txHost"),
    @NamedQuery(name = "MdiMedicalSpeciality.findByTxDate", query = "SELECT m FROM MdiMedicalSpeciality m WHERE m.txDate = :txDate")})
public class MdiMedicalSpeciality implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "medical_speciality_id")
    private Integer medicalSpecialityId;
    @Basic(optional = false)
    @Column(name = "medical_speciality_name")
    private String medicalSpecialityName;
    @Basic(optional = false)
    @Column(name = "medical_speciality_description")
    private String medicalSpecialityDescription;
    @Version
    @Basic(optional = false)
    @Column(name = "version")
    private int version;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicalSpecialityId", fetch = FetchType.LAZY)
    private List<MdiDoctorMedicalSpeciality> mdiDoctorMedicalSpecialityList;

    public MdiMedicalSpeciality() {
    }

    public MdiMedicalSpeciality(Integer medicalSpecialityId) {
        this.medicalSpecialityId = medicalSpecialityId;
    }

    public MdiMedicalSpeciality(Integer medicalSpecialityId, String medicalSpecialityName, String medicalSpecialityDescription, int version, int status, int txUser, String txHost, Date txDate) {
        this.medicalSpecialityId = medicalSpecialityId;
        this.medicalSpecialityName = medicalSpecialityName;
        this.medicalSpecialityDescription = medicalSpecialityDescription;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getMedicalSpecialityId() {
        return medicalSpecialityId;
    }

    public void setMedicalSpecialityId(Integer medicalSpecialityId) {
        this.medicalSpecialityId = medicalSpecialityId;
    }

    public String getMedicalSpecialityName() {
        return medicalSpecialityName;
    }

    public void setMedicalSpecialityName(String medicalSpecialityName) {
        this.medicalSpecialityName = medicalSpecialityName;
    }

    public String getMedicalSpecialityDescription() {
        return medicalSpecialityDescription;
    }

    public void setMedicalSpecialityDescription(String medicalSpecialityDescription) {
        this.medicalSpecialityDescription = medicalSpecialityDescription;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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

    public List<MdiDoctorMedicalSpeciality> getMdiDoctorMedicalSpecialityList() {
        return mdiDoctorMedicalSpecialityList;
    }

    public void setMdiDoctorMedicalSpecialityList(List<MdiDoctorMedicalSpeciality> mdiDoctorMedicalSpecialityList) {
        this.mdiDoctorMedicalSpecialityList = mdiDoctorMedicalSpecialityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medicalSpecialityId != null ? medicalSpecialityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MdiMedicalSpeciality)) {
            return false;
        }
        MdiMedicalSpeciality other = (MdiMedicalSpeciality) object;
        if ((this.medicalSpecialityId == null && other.medicalSpecialityId != null) || (this.medicalSpecialityId != null && !this.medicalSpecialityId.equals(other.medicalSpecialityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.MdiMedicalSpeciality[ medicalSpecialityId=" + medicalSpecialityId + " ]";
    }
    
}
