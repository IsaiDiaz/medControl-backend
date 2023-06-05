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
@Table(name = "mdi_doctor_atention_day")
@NamedQueries({
    @NamedQuery(name = "MdiDoctorAtentionDay.findAll", query = "SELECT m FROM MdiDoctorAtentionDay m"),
    @NamedQuery(name = "MdiDoctorAtentionDay.findByDoctorAtentionDay", query = "SELECT m FROM MdiDoctorAtentionDay m WHERE m.doctorAtentionDay = :doctorAtentionDay"),
    @NamedQuery(name = "MdiDoctorAtentionDay.findByVersion", query = "SELECT m FROM MdiDoctorAtentionDay m WHERE m.version = :version"),
    @NamedQuery(name = "MdiDoctorAtentionDay.findByStatus", query = "SELECT m FROM MdiDoctorAtentionDay m WHERE m.status = :status"),
    @NamedQuery(name = "MdiDoctorAtentionDay.findByTxUser", query = "SELECT m FROM MdiDoctorAtentionDay m WHERE m.txUser = :txUser"),
    @NamedQuery(name = "MdiDoctorAtentionDay.findByTxHost", query = "SELECT m FROM MdiDoctorAtentionDay m WHERE m.txHost = :txHost"),
    @NamedQuery(name = "MdiDoctorAtentionDay.findByTxDate", query = "SELECT m FROM MdiDoctorAtentionDay m WHERE m.txDate = :txDate")})
public class MdiDoctorAtentionDay implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "doctor_atention_day")
    private Integer doctorAtentionDay;
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
    @JoinColumn(name = "atention_day_id", referencedColumnName = "atentioin_day_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MdiAtentionDay atentionDayId;
    @JoinColumn(name = "doctor_id", referencedColumnName = "doctor_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SeDoctor doctorId;

    public MdiDoctorAtentionDay() {
    }

    public MdiDoctorAtentionDay(Integer doctorAtentionDay) {
        this.doctorAtentionDay = doctorAtentionDay;
    }

    public MdiDoctorAtentionDay(Integer doctorAtentionDay, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.doctorAtentionDay = doctorAtentionDay;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getDoctorAtentionDay() {
        return doctorAtentionDay;
    }

    public void setDoctorAtentionDay(Integer doctorAtentionDay) {
        this.doctorAtentionDay = doctorAtentionDay;
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

    public MdiAtentionDay getAtentionDayId() {
        return atentionDayId;
    }

    public void setAtentionDayId(MdiAtentionDay atentionDayId) {
        this.atentionDayId = atentionDayId;
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
        hash += (doctorAtentionDay != null ? doctorAtentionDay.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MdiDoctorAtentionDay)) {
            return false;
        }
        MdiDoctorAtentionDay other = (MdiDoctorAtentionDay) object;
        if ((this.doctorAtentionDay == null && other.doctorAtentionDay != null) || (this.doctorAtentionDay != null && !this.doctorAtentionDay.equals(other.doctorAtentionDay))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.MdiDoctorAtentionDay[ doctorAtentionDay=" + doctorAtentionDay + " ]";
    }
    
}
