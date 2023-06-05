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
@Table(name = "med_medicine_contraindication")
@NamedQueries({
    @NamedQuery(name = "MedMedicineContraindication.findAll", query = "SELECT m FROM MedMedicineContraindication m"),
    @NamedQuery(name = "MedMedicineContraindication.findByMedicineContraindicationId", query = "SELECT m FROM MedMedicineContraindication m WHERE m.medicineContraindicationId = :medicineContraindicationId"),
    @NamedQuery(name = "MedMedicineContraindication.findByVersion", query = "SELECT m FROM MedMedicineContraindication m WHERE m.version = :version"),
    @NamedQuery(name = "MedMedicineContraindication.findByStatus", query = "SELECT m FROM MedMedicineContraindication m WHERE m.status = :status"),
    @NamedQuery(name = "MedMedicineContraindication.findByTxUser", query = "SELECT m FROM MedMedicineContraindication m WHERE m.txUser = :txUser"),
    @NamedQuery(name = "MedMedicineContraindication.findByTxHost", query = "SELECT m FROM MedMedicineContraindication m WHERE m.txHost = :txHost"),
    @NamedQuery(name = "MedMedicineContraindication.findByTxDate", query = "SELECT m FROM MedMedicineContraindication m WHERE m.txDate = :txDate")})
public class MedMedicineContraindication implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "medicine_contraindication_id")
    private Integer medicineContraindicationId;
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
    @JoinColumn(name = "medicine_first_id", referencedColumnName = "medicine_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SeMedicine medicineFirstId;
    @JoinColumn(name = "medicine_second_id", referencedColumnName = "medicine_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SeMedicine medicineSecondId;

    public MedMedicineContraindication() {
    }

    public MedMedicineContraindication(Integer medicineContraindicationId) {
        this.medicineContraindicationId = medicineContraindicationId;
    }

    public MedMedicineContraindication(Integer medicineContraindicationId, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.medicineContraindicationId = medicineContraindicationId;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getMedicineContraindicationId() {
        return medicineContraindicationId;
    }

    public void setMedicineContraindicationId(Integer medicineContraindicationId) {
        this.medicineContraindicationId = medicineContraindicationId;
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

    public SeMedicine getMedicineFirstId() {
        return medicineFirstId;
    }

    public void setMedicineFirstId(SeMedicine medicineFirstId) {
        this.medicineFirstId = medicineFirstId;
    }

    public SeMedicine getMedicineSecondId() {
        return medicineSecondId;
    }

    public void setMedicineSecondId(SeMedicine medicineSecondId) {
        this.medicineSecondId = medicineSecondId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medicineContraindicationId != null ? medicineContraindicationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MedMedicineContraindication)) {
            return false;
        }
        MedMedicineContraindication other = (MedMedicineContraindication) object;
        if ((this.medicineContraindicationId == null && other.medicineContraindicationId != null) || (this.medicineContraindicationId != null && !this.medicineContraindicationId.equals(other.medicineContraindicationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.MedMedicineContraindication[ medicineContraindicationId=" + medicineContraindicationId + " ]";
    }
    
}
