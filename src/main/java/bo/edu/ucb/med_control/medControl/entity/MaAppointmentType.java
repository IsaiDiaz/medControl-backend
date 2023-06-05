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
@Table(name = "ma_appointment_type")
@NamedQueries({
    @NamedQuery(name = "MaAppointmentType.findAll", query = "SELECT m FROM MaAppointmentType m"),
    @NamedQuery(name = "MaAppointmentType.findByAppointmentTypeId", query = "SELECT m FROM MaAppointmentType m WHERE m.appointmentTypeId = :appointmentTypeId"),
    @NamedQuery(name = "MaAppointmentType.findByAppointmentTypeName", query = "SELECT m FROM MaAppointmentType m WHERE m.appointmentTypeName = :appointmentTypeName"),
    @NamedQuery(name = "MaAppointmentType.findByVersion", query = "SELECT m FROM MaAppointmentType m WHERE m.version = :version"),
    @NamedQuery(name = "MaAppointmentType.findByStatus", query = "SELECT m FROM MaAppointmentType m WHERE m.status = :status"),
    @NamedQuery(name = "MaAppointmentType.findByTxUser", query = "SELECT m FROM MaAppointmentType m WHERE m.txUser = :txUser"),
    @NamedQuery(name = "MaAppointmentType.findByTxHost", query = "SELECT m FROM MaAppointmentType m WHERE m.txHost = :txHost"),
    @NamedQuery(name = "MaAppointmentType.findByTxDate", query = "SELECT m FROM MaAppointmentType m WHERE m.txDate = :txDate")})
public class MaAppointmentType implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "appointment_type_id")
    private Integer appointmentTypeId;
    @Basic(optional = false)
    @Column(name = "appointment_type_name")
    private String appointmentTypeName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "appointmentTypeId", fetch = FetchType.LAZY)
    private List<MaAppointment> maAppointmentList;

    public MaAppointmentType() {
    }

    public MaAppointmentType(Integer appointmentTypeId) {
        this.appointmentTypeId = appointmentTypeId;
    }

    public MaAppointmentType(Integer appointmentTypeId, String appointmentTypeName, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.appointmentTypeId = appointmentTypeId;
        this.appointmentTypeName = appointmentTypeName;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getAppointmentTypeId() {
        return appointmentTypeId;
    }

    public void setAppointmentTypeId(Integer appointmentTypeId) {
        this.appointmentTypeId = appointmentTypeId;
    }

    public String getAppointmentTypeName() {
        return appointmentTypeName;
    }

    public void setAppointmentTypeName(String appointmentTypeName) {
        this.appointmentTypeName = appointmentTypeName;
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

    public List<MaAppointment> getMaAppointmentList() {
        return maAppointmentList;
    }

    public void setMaAppointmentList(List<MaAppointment> maAppointmentList) {
        this.maAppointmentList = maAppointmentList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (appointmentTypeId != null ? appointmentTypeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaAppointmentType)) {
            return false;
        }
        MaAppointmentType other = (MaAppointmentType) object;
        if ((this.appointmentTypeId == null && other.appointmentTypeId != null) || (this.appointmentTypeId != null && !this.appointmentTypeId.equals(other.appointmentTypeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.MaAppointmentType[ appointmentTypeId=" + appointmentTypeId + " ]";
    }
    
}
