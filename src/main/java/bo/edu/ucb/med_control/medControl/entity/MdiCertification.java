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
@Table(name = "mdi_certification")
@NamedQueries({
    @NamedQuery(name = "MdiCertification.findAll", query = "SELECT m FROM MdiCertification m"),
    @NamedQuery(name = "MdiCertification.findByCertificationId", query = "SELECT m FROM MdiCertification m WHERE m.certificationId = :certificationId"),
    @NamedQuery(name = "MdiCertification.findByCertificationDocumentId", query = "SELECT m FROM MdiCertification m WHERE m.certificationDocumentId = :certificationDocumentId"),
    @NamedQuery(name = "MdiCertification.findByVersion", query = "SELECT m FROM MdiCertification m WHERE m.version = :version"),
    @NamedQuery(name = "MdiCertification.findByStatus", query = "SELECT m FROM MdiCertification m WHERE m.status = :status"),
    @NamedQuery(name = "MdiCertification.findByTxUser", query = "SELECT m FROM MdiCertification m WHERE m.txUser = :txUser"),
    @NamedQuery(name = "MdiCertification.findByTxHost", query = "SELECT m FROM MdiCertification m WHERE m.txHost = :txHost"),
    @NamedQuery(name = "MdiCertification.findByTxDate", query = "SELECT m FROM MdiCertification m WHERE m.txDate = :txDate")})
public class MdiCertification implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "certification_id")
    private Integer certificationId;
    @Basic(optional = false)
    @Column(name = "certification_document_id")
    private int certificationDocumentId;
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

    public MdiCertification() {
    }

    public MdiCertification(Integer certificationId) {
        this.certificationId = certificationId;
    }

    public MdiCertification(Integer certificationId, int certificationDocumentId, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.certificationId = certificationId;
        this.certificationDocumentId = certificationDocumentId;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getCertificationId() {
        return certificationId;
    }

    public void setCertificationId(Integer certificationId) {
        this.certificationId = certificationId;
    }

    public int getCertificationDocumentId() {
        return certificationDocumentId;
    }

    public void setCertificationDocumentId(int certificationDocumentId) {
        this.certificationDocumentId = certificationDocumentId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (certificationId != null ? certificationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MdiCertification)) {
            return false;
        }
        MdiCertification other = (MdiCertification) object;
        if ((this.certificationId == null && other.certificationId != null) || (this.certificationId != null && !this.certificationId.equals(other.certificationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.MdiCertification[ certificationId=" + certificationId + " ]";
    }
    
}
