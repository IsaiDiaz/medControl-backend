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
@Table(name = "doctor_patient")
@NamedQueries({
    @NamedQuery(name = "DoctorPatient.findAll", query = "SELECT d FROM DoctorPatient d"),
    @NamedQuery(name = "DoctorPatient.findByDoctorPatients", query = "SELECT d FROM DoctorPatient d WHERE d.doctorPatients = :doctorPatients"),
    @NamedQuery(name = "DoctorPatient.findByVersion", query = "SELECT d FROM DoctorPatient d WHERE d.version = :version"),
    @NamedQuery(name = "DoctorPatient.findByStatus", query = "SELECT d FROM DoctorPatient d WHERE d.status = :status"),
    @NamedQuery(name = "DoctorPatient.findByTxUser", query = "SELECT d FROM DoctorPatient d WHERE d.txUser = :txUser"),
    @NamedQuery(name = "DoctorPatient.findByTxHost", query = "SELECT d FROM DoctorPatient d WHERE d.txHost = :txHost"),
    @NamedQuery(name = "DoctorPatient.findByTxDate", query = "SELECT d FROM DoctorPatient d WHERE d.txDate = :txDate")})
public class DoctorPatient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "doctor_patients")
    private Integer doctorPatients;
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
    @JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SeDoctor doctorId;
    @JoinColumn(name = "patient_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SeUser patientId;

    public DoctorPatient() {
    }

    public DoctorPatient(Integer doctorPatients) {
        this.doctorPatients = doctorPatients;
    }

    public DoctorPatient(Integer doctorPatients, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.doctorPatients = doctorPatients;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getDoctorPatients() {
        return doctorPatients;
    }

    public void setDoctorPatients(Integer doctorPatients) {
        this.doctorPatients = doctorPatients;
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

    public SeDoctor getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(SeDoctor doctorId) {
        this.doctorId = doctorId;
    }

    public SeUser getPatientId() {
        return patientId;
    }

    public void setPatientId(SeUser patientId) {
        this.patientId = patientId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doctorPatients != null ? doctorPatients.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DoctorPatient)) {
            return false;
        }
        DoctorPatient other = (DoctorPatient) object;
        if ((this.doctorPatients == null && other.doctorPatients != null) || (this.doctorPatients != null && !this.doctorPatients.equals(other.doctorPatients))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.DoctorPatient[ doctorPatients=" + doctorPatients + " ]";
    }
    
}
