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
@Table(name = "mdi_doctor_medical_speciality")
@NamedQueries({
    @NamedQuery(name = "MdiDoctorMedicalSpeciality.findAll", query = "SELECT m FROM MdiDoctorMedicalSpeciality m"),
    @NamedQuery(name = "MdiDoctorMedicalSpeciality.findByDoctorMedicalSpeciality", query = "SELECT m FROM MdiDoctorMedicalSpeciality m WHERE m.doctorMedicalSpeciality = :doctorMedicalSpeciality"),
    @NamedQuery(name = "MdiDoctorMedicalSpeciality.findByDoctorMedicalSpecialityTitleId", query = "SELECT m FROM MdiDoctorMedicalSpeciality m WHERE m.doctorMedicalSpecialityTitleId = :doctorMedicalSpecialityTitleId"),
    @NamedQuery(name = "MdiDoctorMedicalSpeciality.findByVersion", query = "SELECT m FROM MdiDoctorMedicalSpeciality m WHERE m.version = :version"),
    @NamedQuery(name = "MdiDoctorMedicalSpeciality.findByStatus", query = "SELECT m FROM MdiDoctorMedicalSpeciality m WHERE m.status = :status"),
    @NamedQuery(name = "MdiDoctorMedicalSpeciality.findByTxUser", query = "SELECT m FROM MdiDoctorMedicalSpeciality m WHERE m.txUser = :txUser"),
    @NamedQuery(name = "MdiDoctorMedicalSpeciality.findByTxHost", query = "SELECT m FROM MdiDoctorMedicalSpeciality m WHERE m.txHost = :txHost"),
    @NamedQuery(name = "MdiDoctorMedicalSpeciality.findByTxDate", query = "SELECT m FROM MdiDoctorMedicalSpeciality m WHERE m.txDate = :txDate")})
public class MdiDoctorMedicalSpeciality implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "doctor_medical_speciality")
    private Integer doctorMedicalSpeciality;
    @Basic(optional = false)
    @Column(name = "doctor_medical_speciality_title_id")
    private int doctorMedicalSpecialityTitleId;
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
    @JoinColumn(name = "medical_speciality_id", referencedColumnName = "medical_speciality_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MdiMedicalSpeciality medicalSpecialityId;
    @JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SeDoctor doctorId;

    public MdiDoctorMedicalSpeciality() {
    }

    public MdiDoctorMedicalSpeciality(Integer doctorMedicalSpeciality) {
        this.doctorMedicalSpeciality = doctorMedicalSpeciality;
    }

    public MdiDoctorMedicalSpeciality(Integer doctorMedicalSpeciality, int doctorMedicalSpecialityTitleId, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.doctorMedicalSpeciality = doctorMedicalSpeciality;
        this.doctorMedicalSpecialityTitleId = doctorMedicalSpecialityTitleId;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getDoctorMedicalSpeciality() {
        return doctorMedicalSpeciality;
    }

    public void setDoctorMedicalSpeciality(Integer doctorMedicalSpeciality) {
        this.doctorMedicalSpeciality = doctorMedicalSpeciality;
    }

    public int getDoctorMedicalSpecialityTitleId() {
        return doctorMedicalSpecialityTitleId;
    }

    public void setDoctorMedicalSpecialityTitleId(int doctorMedicalSpecialityTitleId) {
        this.doctorMedicalSpecialityTitleId = doctorMedicalSpecialityTitleId;
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

    public MdiMedicalSpeciality getMedicalSpecialityId() {
        return medicalSpecialityId;
    }

    public void setMedicalSpecialityId(MdiMedicalSpeciality medicalSpecialityId) {
        this.medicalSpecialityId = medicalSpecialityId;
    }

    public SeDoctor getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(SeDoctor doctorId) {
        this.doctorId = doctorId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doctorMedicalSpeciality != null ? doctorMedicalSpeciality.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MdiDoctorMedicalSpeciality)) {
            return false;
        }
        MdiDoctorMedicalSpeciality other = (MdiDoctorMedicalSpeciality) object;
        if ((this.doctorMedicalSpeciality == null && other.doctorMedicalSpeciality != null) || (this.doctorMedicalSpeciality != null && !this.doctorMedicalSpeciality.equals(other.doctorMedicalSpeciality))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.MdiDoctorMedicalSpeciality[ doctorMedicalSpeciality=" + doctorMedicalSpeciality + " ]";
    }
    
}
