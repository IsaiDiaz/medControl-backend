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
@Table(name = "se_prescription")
@NamedQueries({
    @NamedQuery(name = "SePrescription.findAll", query = "SELECT s FROM SePrescription s"),
    @NamedQuery(name = "SePrescription.findByPrescriptionId", query = "SELECT s FROM SePrescription s WHERE s.prescriptionId = :prescriptionId"),
    @NamedQuery(name = "SePrescription.findByMedicineId", query = "SELECT s FROM SePrescription s WHERE s.medicineId = :medicineId"),
    @NamedQuery(name = "SePrescription.findByPrescriptionDosage", query = "SELECT s FROM SePrescription s WHERE s.prescriptionDosage = :prescriptionDosage"),
    @NamedQuery(name = "SePrescription.findByPrescriptionDosageUnit", query = "SELECT s FROM SePrescription s WHERE s.prescriptionDosageUnit = :prescriptionDosageUnit"),
    @NamedQuery(name = "SePrescription.findByPrescriptionFrecuency", query = "SELECT s FROM SePrescription s WHERE s.prescriptionFrecuency = :prescriptionFrecuency"),
    @NamedQuery(name = "SePrescription.findByVersion", query = "SELECT s FROM SePrescription s WHERE s.version = :version"),
    @NamedQuery(name = "SePrescription.findByStatus", query = "SELECT s FROM SePrescription s WHERE s.status = :status"),
    @NamedQuery(name = "SePrescription.findByTxUser", query = "SELECT s FROM SePrescription s WHERE s.txUser = :txUser"),
    @NamedQuery(name = "SePrescription.findByTxHost", query = "SELECT s FROM SePrescription s WHERE s.txHost = :txHost"),
    @NamedQuery(name = "SePrescription.findByTxDate", query = "SELECT s FROM SePrescription s WHERE s.txDate = :txDate")})
public class SePrescription implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "prescription_id")
    private Integer prescriptionId;
    @Basic(optional = false)
    @Column(name = "medicine_id")
    private int medicineId;
    @Basic(optional = false)
    @Column(name = "prescription_dosage")
    private int prescriptionDosage;
    @Basic(optional = false)
    @Column(name = "prescription_dosage_unit")
    private String prescriptionDosageUnit;
    @Basic(optional = false)
    @Column(name = "prescription_frecuency")
    private int prescriptionFrecuency;
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
    @JoinColumn(name = "patient_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SeUser patientId;
    @JoinColumn(name = "doctor_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SeUser doctorId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sePrescriptionPrescriptionId", fetch = FetchType.LAZY)
    private List<SeUserMedicine> seUserMedicineList;

    public SePrescription() {
    }

    public SePrescription(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public SePrescription(Integer prescriptionId, int medicineId, int prescriptionDosage, String prescriptionDosageUnit, int prescriptionFrecuency, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.prescriptionId = prescriptionId;
        this.medicineId = medicineId;
        this.prescriptionDosage = prescriptionDosage;
        this.prescriptionDosageUnit = prescriptionDosageUnit;
        this.prescriptionFrecuency = prescriptionFrecuency;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public int getPrescriptionDosage() {
        return prescriptionDosage;
    }

    public void setPrescriptionDosage(int prescriptionDosage) {
        this.prescriptionDosage = prescriptionDosage;
    }

    public String getPrescriptionDosageUnit() {
        return prescriptionDosageUnit;
    }

    public void setPrescriptionDosageUnit(String prescriptionDosageUnit) {
        this.prescriptionDosageUnit = prescriptionDosageUnit;
    }

    public int getPrescriptionFrecuency() {
        return prescriptionFrecuency;
    }

    public void setPrescriptionFrecuency(int prescriptionFrecuency) {
        this.prescriptionFrecuency = prescriptionFrecuency;
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

    public SeUser getPatientId() {
        return patientId;
    }

    public void setPatientId(SeUser patientId) {
        this.patientId = patientId;
    }

    public SeUser getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(SeUser doctorId) {
        this.doctorId = doctorId;
    }

    public List<SeUserMedicine> getSeUserMedicineList() {
        return seUserMedicineList;
    }

    public void setSeUserMedicineList(List<SeUserMedicine> seUserMedicineList) {
        this.seUserMedicineList = seUserMedicineList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (prescriptionId != null ? prescriptionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SePrescription)) {
            return false;
        }
        SePrescription other = (SePrescription) object;
        if ((this.prescriptionId == null && other.prescriptionId != null) || (this.prescriptionId != null && !this.prescriptionId.equals(other.prescriptionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.SePrescription[ prescriptionId=" + prescriptionId + " ]";
    }
    
}
