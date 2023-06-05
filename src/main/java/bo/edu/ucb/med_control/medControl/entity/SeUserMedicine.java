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
@Table(name = "se_user_medicine")
@NamedQueries({
    @NamedQuery(name = "SeUserMedicine.findAll", query = "SELECT s FROM SeUserMedicine s"),
    @NamedQuery(name = "SeUserMedicine.findByUserMedicineId", query = "SELECT s FROM SeUserMedicine s WHERE s.userMedicineId = :userMedicineId"),
    @NamedQuery(name = "SeUserMedicine.findByDose", query = "SELECT s FROM SeUserMedicine s WHERE s.dose = :dose"),
    @NamedQuery(name = "SeUserMedicine.findByFrecuency", query = "SELECT s FROM SeUserMedicine s WHERE s.frecuency = :frecuency"),
    @NamedQuery(name = "SeUserMedicine.findByVersion", query = "SELECT s FROM SeUserMedicine s WHERE s.version = :version"),
    @NamedQuery(name = "SeUserMedicine.findByStatus", query = "SELECT s FROM SeUserMedicine s WHERE s.status = :status"),
    @NamedQuery(name = "SeUserMedicine.findByTxUser", query = "SELECT s FROM SeUserMedicine s WHERE s.txUser = :txUser"),
    @NamedQuery(name = "SeUserMedicine.findByTxHost", query = "SELECT s FROM SeUserMedicine s WHERE s.txHost = :txHost"),
    @NamedQuery(name = "SeUserMedicine.findByTxDate", query = "SELECT s FROM SeUserMedicine s WHERE s.txDate = :txDate")})
public class SeUserMedicine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_medicine_id")
    private Integer userMedicineId;
    @Basic(optional = false)
    @Column(name = "dose")
    private int dose;
    @Basic(optional = false)
    @Column(name = "frecuency")
    private int frecuency;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userMedicineId", fetch = FetchType.LAZY)
    private List<UserSymptoms> userSymptomsList;
    @JoinColumn(name = "medicine_id", referencedColumnName = "medicine_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SeMedicine medicineId;
    @JoinColumn(name = "se_prescription_prescription_id", referencedColumnName = "prescription_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SePrescription sePrescriptionPrescriptionId;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SeUser userId;

    public SeUserMedicine() {
    }

    public SeUserMedicine(Integer userMedicineId) {
        this.userMedicineId = userMedicineId;
    }

    public SeUserMedicine(Integer userMedicineId, int dose, int frecuency, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.userMedicineId = userMedicineId;
        this.dose = dose;
        this.frecuency = frecuency;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getUserMedicineId() {
        return userMedicineId;
    }

    public void setUserMedicineId(Integer userMedicineId) {
        this.userMedicineId = userMedicineId;
    }

    public int getDose() {
        return dose;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public int getFrecuency() {
        return frecuency;
    }

    public void setFrecuency(int frecuency) {
        this.frecuency = frecuency;
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

    public List<UserSymptoms> getUserSymptomsList() {
        return userSymptomsList;
    }

    public void setUserSymptomsList(List<UserSymptoms> userSymptomsList) {
        this.userSymptomsList = userSymptomsList;
    }

    public SeMedicine getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(SeMedicine medicineId) {
        this.medicineId = medicineId;
    }

    public SePrescription getSePrescriptionPrescriptionId() {
        return sePrescriptionPrescriptionId;
    }

    public void setSePrescriptionPrescriptionId(SePrescription sePrescriptionPrescriptionId) {
        this.sePrescriptionPrescriptionId = sePrescriptionPrescriptionId;
    }

    public SeUser getUserId() {
        return userId;
    }

    public void setUserId(SeUser userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userMedicineId != null ? userMedicineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeUserMedicine)) {
            return false;
        }
        SeUserMedicine other = (SeUserMedicine) object;
        if ((this.userMedicineId == null && other.userMedicineId != null) || (this.userMedicineId != null && !this.userMedicineId.equals(other.userMedicineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.SeUserMedicine[ userMedicineId=" + userMedicineId + " ]";
    }
    
}
