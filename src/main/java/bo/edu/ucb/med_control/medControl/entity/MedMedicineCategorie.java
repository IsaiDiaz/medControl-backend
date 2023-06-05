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
@Table(name = "med_medicine_categorie")
@NamedQueries({
    @NamedQuery(name = "MedMedicineCategorie.findAll", query = "SELECT m FROM MedMedicineCategorie m"),
    @NamedQuery(name = "MedMedicineCategorie.findByMedicineCategorieId", query = "SELECT m FROM MedMedicineCategorie m WHERE m.medicineCategorieId = :medicineCategorieId"),
    @NamedQuery(name = "MedMedicineCategorie.findByVersion", query = "SELECT m FROM MedMedicineCategorie m WHERE m.version = :version"),
    @NamedQuery(name = "MedMedicineCategorie.findByStatus", query = "SELECT m FROM MedMedicineCategorie m WHERE m.status = :status"),
    @NamedQuery(name = "MedMedicineCategorie.findByTxUser", query = "SELECT m FROM MedMedicineCategorie m WHERE m.txUser = :txUser"),
    @NamedQuery(name = "MedMedicineCategorie.findByTxHost", query = "SELECT m FROM MedMedicineCategorie m WHERE m.txHost = :txHost"),
    @NamedQuery(name = "MedMedicineCategorie.findByTxDate", query = "SELECT m FROM MedMedicineCategorie m WHERE m.txDate = :txDate")})
public class MedMedicineCategorie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "medicine_categorie_id")
    private Integer medicineCategorieId;
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
    @JoinColumn(name = "medicine_type_id", referencedColumnName = "medicine_type_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MedMedicineType medicineTypeId;
    @JoinColumn(name = "medicine_id", referencedColumnName = "medicine_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SeMedicine medicineId;

    public MedMedicineCategorie() {
    }

    public MedMedicineCategorie(Integer medicineCategorieId) {
        this.medicineCategorieId = medicineCategorieId;
    }

    public MedMedicineCategorie(Integer medicineCategorieId, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.medicineCategorieId = medicineCategorieId;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getMedicineCategorieId() {
        return medicineCategorieId;
    }

    public void setMedicineCategorieId(Integer medicineCategorieId) {
        this.medicineCategorieId = medicineCategorieId;
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

    public MedMedicineType getMedicineTypeId() {
        return medicineTypeId;
    }

    public void setMedicineTypeId(MedMedicineType medicineTypeId) {
        this.medicineTypeId = medicineTypeId;
    }

    public SeMedicine getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(SeMedicine medicineId) {
        this.medicineId = medicineId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medicineCategorieId != null ? medicineCategorieId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedMedicineCategorie)) {
            return false;
        }
        MedMedicineCategorie other = (MedMedicineCategorie) object;
        if ((this.medicineCategorieId == null && other.medicineCategorieId != null) || (this.medicineCategorieId != null && !this.medicineCategorieId.equals(other.medicineCategorieId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.MedMedicineCategorie[ medicineCategorieId=" + medicineCategorieId + " ]";
    }
    
}
