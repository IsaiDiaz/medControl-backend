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
@Table(name = "med_medicine_type")
@NamedQueries({
    @NamedQuery(name = "MedMedicineType.findAll", query = "SELECT m FROM MedMedicineType m"),
    @NamedQuery(name = "MedMedicineType.findByMedicineTypeId", query = "SELECT m FROM MedMedicineType m WHERE m.medicineTypeId = :medicineTypeId"),
    @NamedQuery(name = "MedMedicineType.findByMedicineTypeName", query = "SELECT m FROM MedMedicineType m WHERE m.medicineTypeName = :medicineTypeName"),
    @NamedQuery(name = "MedMedicineType.findByVersion", query = "SELECT m FROM MedMedicineType m WHERE m.version = :version"),
    @NamedQuery(name = "MedMedicineType.findByStatus", query = "SELECT m FROM MedMedicineType m WHERE m.status = :status"),
    @NamedQuery(name = "MedMedicineType.findByTxUser", query = "SELECT m FROM MedMedicineType m WHERE m.txUser = :txUser"),
    @NamedQuery(name = "MedMedicineType.findByTxHost", query = "SELECT m FROM MedMedicineType m WHERE m.txHost = :txHost"),
    @NamedQuery(name = "MedMedicineType.findByTxDate", query = "SELECT m FROM MedMedicineType m WHERE m.txDate = :txDate")})
public class MedMedicineType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "medicine_type_id")
    private Integer medicineTypeId;
    @Basic(optional = false)
    @Column(name = "medicine_type_name")
    private String medicineTypeName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "medicineTypeId", fetch = FetchType.LAZY)
    private List<MedMedicineCategorie> medMedicineCategorieList;

    public MedMedicineType() {
    }

    public MedMedicineType(Integer medicineTypeId) {
        this.medicineTypeId = medicineTypeId;
    }

    public MedMedicineType(Integer medicineTypeId, String medicineTypeName, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.medicineTypeId = medicineTypeId;
        this.medicineTypeName = medicineTypeName;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getMedicineTypeId() {
        return medicineTypeId;
    }

    public void setMedicineTypeId(Integer medicineTypeId) {
        this.medicineTypeId = medicineTypeId;
    }

    public String getMedicineTypeName() {
        return medicineTypeName;
    }

    public void setMedicineTypeName(String medicineTypeName) {
        this.medicineTypeName = medicineTypeName;
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

    public List<MedMedicineCategorie> getMedMedicineCategorieList() {
        return medMedicineCategorieList;
    }

    public void setMedMedicineCategorieList(List<MedMedicineCategorie> medMedicineCategorieList) {
        this.medMedicineCategorieList = medMedicineCategorieList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medicineTypeId != null ? medicineTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedMedicineType)) {
            return false;
        }
        MedMedicineType other = (MedMedicineType) object;
        if ((this.medicineTypeId == null && other.medicineTypeId != null) || (this.medicineTypeId != null && !this.medicineTypeId.equals(other.medicineTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.MedMedicineType[ medicineTypeId=" + medicineTypeId + " ]";
    }
    
}
