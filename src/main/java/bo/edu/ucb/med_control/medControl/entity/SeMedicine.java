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
@Table(name = "se_medicine")
@NamedQueries({
    @NamedQuery(name = "SeMedicine.findAll", query = "SELECT s FROM SeMedicine s"),
    @NamedQuery(name = "SeMedicine.findByMedicineId", query = "SELECT s FROM SeMedicine s WHERE s.medicineId = :medicineId"),
    @NamedQuery(name = "SeMedicine.findByMedicineName", query = "SELECT s FROM SeMedicine s WHERE s.medicineName = :medicineName"),
    @NamedQuery(name = "SeMedicine.findByMedicineDesc", query = "SELECT s FROM SeMedicine s WHERE s.medicineDesc = :medicineDesc"),
    @NamedQuery(name = "SeMedicine.findByMedicinaDosage", query = "SELECT s FROM SeMedicine s WHERE s.medicinaDosage = :medicinaDosage"),
    @NamedQuery(name = "SeMedicine.findByVersion", query = "SELECT s FROM SeMedicine s WHERE s.version = :version"),
    @NamedQuery(name = "SeMedicine.findByStatus", query = "SELECT s FROM SeMedicine s WHERE s.status = :status"),
    @NamedQuery(name = "SeMedicine.findByTxUser", query = "SELECT s FROM SeMedicine s WHERE s.txUser = :txUser"),
    @NamedQuery(name = "SeMedicine.findByTxHost", query = "SELECT s FROM SeMedicine s WHERE s.txHost = :txHost"),
    @NamedQuery(name = "SeMedicine.findByTxDate", query = "SELECT s FROM SeMedicine s WHERE s.txDate = :txDate")})
public class SeMedicine implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "medicine_id")
    private Integer medicineId;
    @Basic(optional = false)
    @Column(name = "medicine_name")
    private String medicineName;
    @Basic(optional = false)
    @Column(name = "medicine_desc")
    private String medicineDesc;
    @Basic(optional = false)
    @Column(name = "medicina_dosage")
    private int medicinaDosage;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicineFirstId", fetch = FetchType.LAZY)
    private List<MedMedicineContraindication> medMedicineContraindicationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicineSecondId", fetch = FetchType.LAZY)
    private List<MedMedicineContraindication> medMedicineContraindicationList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicineId", fetch = FetchType.LAZY)
    private List<SeUserMedicine> seUserMedicineList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicineId", fetch = FetchType.LAZY)
    private List<MedMedicineCategorie> medMedicineCategorieList;

    public SeMedicine() {
    }

    public SeMedicine(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public SeMedicine(Integer medicineId, String medicineName, String medicineDesc, int medicinaDosage, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.medicineDesc = medicineDesc;
        this.medicinaDosage = medicinaDosage;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineDesc() {
        return medicineDesc;
    }

    public void setMedicineDesc(String medicineDesc) {
        this.medicineDesc = medicineDesc;
    }

    public int getMedicinaDosage() {
        return medicinaDosage;
    }

    public void setMedicinaDosage(int medicinaDosage) {
        this.medicinaDosage = medicinaDosage;
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

    public List<MedMedicineContraindication> getMedMedicineContraindicationList() {
        return medMedicineContraindicationList;
    }

    public void setMedMedicineContraindicationList(List<MedMedicineContraindication> medMedicineContraindicationList) {
        this.medMedicineContraindicationList = medMedicineContraindicationList;
    }

    public List<MedMedicineContraindication> getMedMedicineContraindicationList1() {
        return medMedicineContraindicationList1;
    }

    public void setMedMedicineContraindicationList1(List<MedMedicineContraindication> medMedicineContraindicationList1) {
        this.medMedicineContraindicationList1 = medMedicineContraindicationList1;
    }

    public List<SeUserMedicine> getSeUserMedicineList() {
        return seUserMedicineList;
    }

    public void setSeUserMedicineList(List<SeUserMedicine> seUserMedicineList) {
        this.seUserMedicineList = seUserMedicineList;
    }

    public List<MedMedicineCategorie> getMedMedicineCategorieList() {
        return medMedicineCategorieList;
    }

    public void setMedMedicineCategorieList(List<MedMedicineCategorie> medMedicineCategorieList) {
        this.medMedicineCategorieList = medMedicineCategorieList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medicineId != null ? medicineId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeMedicine)) {
            return false;
        }
        SeMedicine other = (SeMedicine) object;
        if ((this.medicineId == null && other.medicineId != null) || (this.medicineId != null && !this.medicineId.equals(other.medicineId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.SeMedicine[ medicineId=" + medicineId + " ]";
    }
    
}
