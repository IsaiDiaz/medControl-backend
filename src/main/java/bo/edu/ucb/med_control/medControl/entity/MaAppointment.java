/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.edu.ucb.med_control.medControl.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import jakarta.persistence.*;
/**
 *
 * @author isai
 */
@Entity
@Table(name = "ma_appointment")
@NamedQueries({
    @NamedQuery(name = "MaAppointment.findAll", query = "SELECT m FROM MaAppointment m"),
    @NamedQuery(name = "MaAppointment.findByAppointmentId", query = "SELECT m FROM MaAppointment m WHERE m.appointmentId = :appointmentId"),
    @NamedQuery(name = "MaAppointment.findByAppointmentPrice", query = "SELECT m FROM MaAppointment m WHERE m.appointmentPrice = :appointmentPrice"),
    @NamedQuery(name = "MaAppointment.findByAppointmentState", query = "SELECT m FROM MaAppointment m WHERE m.appointmentState = :appointmentState"),
    @NamedQuery(name = "MaAppointment.findByAppointmentDate", query = "SELECT m FROM MaAppointment m WHERE m.appointmentDate = :appointmentDate"),
    @NamedQuery(name = "MaAppointment.findByVersion", query = "SELECT m FROM MaAppointment m WHERE m.version = :version"),
    @NamedQuery(name = "MaAppointment.findByStatus", query = "SELECT m FROM MaAppointment m WHERE m.status = :status"),
    @NamedQuery(name = "MaAppointment.findByTxUser", query = "SELECT m FROM MaAppointment m WHERE m.txUser = :txUser"),
    @NamedQuery(name = "MaAppointment.findByTxHost", query = "SELECT m FROM MaAppointment m WHERE m.txHost = :txHost"),
    @NamedQuery(name = "MaAppointment.findByTxDate", query = "SELECT m FROM MaAppointment m WHERE m.txDate = :txDate")})
public class MaAppointment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "appointment_id")
    private Integer appointmentId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "appointment_price")
    private BigDecimal appointmentPrice;
    @Basic(optional = false)
    @Column(name = "appointment_state")
    private String appointmentState;
    @Basic(optional = false)
    @Column(name = "appointment_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date appointmentDate;
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
    @JoinColumn(name = "appointment_type_id", referencedColumnName = "appointment_type_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MaAppointmentType appointmentTypeId;
    @JoinColumn(name = "doctor_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SeUser doctorId;
    @JoinColumn(name = "patient_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SeUser patientId;

    public MaAppointment() {
    }

    public MaAppointment(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public MaAppointment(Integer appointmentId, BigDecimal appointmentPrice, String appointmentState, Date appointmentDate, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.appointmentId = appointmentId;
        this.appointmentPrice = appointmentPrice;
        this.appointmentState = appointmentState;
        this.appointmentDate = appointmentDate;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public BigDecimal getAppointmentPrice() {
        return appointmentPrice;
    }

    public void setAppointmentPrice(BigDecimal appointmentPrice) {
        this.appointmentPrice = appointmentPrice;
    }

    public String getAppointmentState() {
        return appointmentState;
    }

    public void setAppointmentState(String appointmentState) {
        this.appointmentState = appointmentState;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
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

    public MaAppointmentType getAppointmentTypeId() {
        return appointmentTypeId;
    }

    public void setAppointmentTypeId(MaAppointmentType appointmentTypeId) {
        this.appointmentTypeId = appointmentTypeId;
    }

    public SeUser getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(SeUser doctorId) {
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
        hash += (appointmentId != null ? appointmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaAppointment)) {
            return false;
        }
        MaAppointment other = (MaAppointment) object;
        if ((this.appointmentId == null && other.appointmentId != null) || (this.appointmentId != null && !this.appointmentId.equals(other.appointmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.MaAppointment[ appointmentId=" + appointmentId + " ]";
    }
    
}
