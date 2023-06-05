/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.edu.ucb.med_control.medControl.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import jakarta.persistence.*;

/**
 *
 * @author isai
 */
@Entity
@Table(name = "se_doctor")
@NamedQueries({
    @NamedQuery(name = "SeDoctor.findAll", query = "SELECT s FROM SeDoctor s"),
    @NamedQuery(name = "SeDoctor.findByDoctorId", query = "SELECT s FROM SeDoctor s WHERE s.doctorId = :doctorId"),
    @NamedQuery(name = "SeDoctor.findByDoctorRegistrationNumber", query = "SELECT s FROM SeDoctor s WHERE s.doctorRegistrationNumber = :doctorRegistrationNumber"),
    @NamedQuery(name = "SeDoctor.findByDoctorAppointmentPrice", query = "SELECT s FROM SeDoctor s WHERE s.doctorAppointmentPrice = :doctorAppointmentPrice"),
    @NamedQuery(name = "SeDoctor.findByDoctorHospitalName", query = "SELECT s FROM SeDoctor s WHERE s.doctorHospitalName = :doctorHospitalName"),
    @NamedQuery(name = "SeDoctor.findByDoctorHospitalDirecction", query = "SELECT s FROM SeDoctor s WHERE s.doctorHospitalDirecction = :doctorHospitalDirecction"),
    @NamedQuery(name = "SeDoctor.findByDoctorOpenTime", query = "SELECT s FROM SeDoctor s WHERE s.doctorOpenTime = :doctorOpenTime"),
    @NamedQuery(name = "SeDoctor.findByDoctorCloseTime", query = "SELECT s FROM SeDoctor s WHERE s.doctorCloseTime = :doctorCloseTime"),
    @NamedQuery(name = "SeDoctor.findByDoctorProfessionalTitleId", query = "SELECT s FROM SeDoctor s WHERE s.doctorProfessionalTitleId = :doctorProfessionalTitleId"),
    @NamedQuery(name = "SeDoctor.findByVersion", query = "SELECT s FROM SeDoctor s WHERE s.version = :version"),
    @NamedQuery(name = "SeDoctor.findByStatus", query = "SELECT s FROM SeDoctor s WHERE s.status = :status"),
    @NamedQuery(name = "SeDoctor.findByTxUser", query = "SELECT s FROM SeDoctor s WHERE s.txUser = :txUser"),
    @NamedQuery(name = "SeDoctor.findByTxHost", query = "SELECT s FROM SeDoctor s WHERE s.txHost = :txHost"),
    @NamedQuery(name = "SeDoctor.findByTxDate", query = "SELECT s FROM SeDoctor s WHERE s.txDate = :txDate")})
public class SeDoctor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "doctor_id")
    private Integer doctorId;
    @Basic(optional = false)
    @Column(name = "doctor_registration_number")
    private String doctorRegistrationNumber;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "doctor_appointment_price")
    private BigDecimal doctorAppointmentPrice;
    @Basic(optional = false)
    @Column(name = "doctor_hospital_name")
    private String doctorHospitalName;
    @Basic(optional = false)
    @Column(name = "doctor_hospital_direcction")
    private String doctorHospitalDirecction;
    @Basic(optional = false)
    @Column(name = "doctor_open_time")
    @Temporal(TemporalType.TIME)
    private Date doctorOpenTime;
    @Basic(optional = false)
    @Column(name = "doctor_close_time")
    @Temporal(TemporalType.TIME)
    private Date doctorCloseTime;
    @Basic(optional = false)
    @Column(name = "doctor_professional_title_id")
    private int doctorProfessionalTitleId;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctorId", fetch = FetchType.LAZY)
    private List<MdiCertification> mdiCertificationList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctorId", fetch = FetchType.LAZY)
    private List<MdiDoctorMedicalSpeciality> mdiDoctorMedicalSpecialityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctorId", fetch = FetchType.LAZY)
    private List<MdiDoctorAtentionDay> mdiDoctorAtentionDayList;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SeUser userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctorId", fetch = FetchType.LAZY)
    private List<DoctorPatient> doctorPatientList;

    public SeDoctor() {
    }

    public SeDoctor(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public SeDoctor(Integer doctorId, String doctorRegistrationNumber, BigDecimal doctorAppointmentPrice, String doctorHospitalName, String doctorHospitalDirecction, Date doctorOpenTime, Date doctorCloseTime, int doctorProfessionalTitleId, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.doctorId = doctorId;
        this.doctorRegistrationNumber = doctorRegistrationNumber;
        this.doctorAppointmentPrice = doctorAppointmentPrice;
        this.doctorHospitalName = doctorHospitalName;
        this.doctorHospitalDirecction = doctorHospitalDirecction;
        this.doctorOpenTime = doctorOpenTime;
        this.doctorCloseTime = doctorCloseTime;
        this.doctorProfessionalTitleId = doctorProfessionalTitleId;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getDoctorRegistrationNumber() {
        return doctorRegistrationNumber;
    }

    public void setDoctorRegistrationNumber(String doctorRegistrationNumber) {
        this.doctorRegistrationNumber = doctorRegistrationNumber;
    }

    public BigDecimal getDoctorAppointmentPrice() {
        return doctorAppointmentPrice;
    }

    public void setDoctorAppointmentPrice(BigDecimal doctorAppointmentPrice) {
        this.doctorAppointmentPrice = doctorAppointmentPrice;
    }

    public String getDoctorHospitalName() {
        return doctorHospitalName;
    }

    public void setDoctorHospitalName(String doctorHospitalName) {
        this.doctorHospitalName = doctorHospitalName;
    }

    public String getDoctorHospitalDirecction() {
        return doctorHospitalDirecction;
    }

    public void setDoctorHospitalDirecction(String doctorHospitalDirecction) {
        this.doctorHospitalDirecction = doctorHospitalDirecction;
    }

    public Date getDoctorOpenTime() {
        return doctorOpenTime;
    }

    public void setDoctorOpenTime(Date doctorOpenTime) {
        this.doctorOpenTime = doctorOpenTime;
    }

    public Date getDoctorCloseTime() {
        return doctorCloseTime;
    }

    public void setDoctorCloseTime(Date doctorCloseTime) {
        this.doctorCloseTime = doctorCloseTime;
    }

    public int getDoctorProfessionalTitleId() {
        return doctorProfessionalTitleId;
    }

    public void setDoctorProfessionalTitleId(int doctorProfessionalTitleId) {
        this.doctorProfessionalTitleId = doctorProfessionalTitleId;
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

    public List<MdiCertification> getMdiCertificationList() {
        return mdiCertificationList;
    }

    public void setMdiCertificationList(List<MdiCertification> mdiCertificationList) {
        this.mdiCertificationList = mdiCertificationList;
    }

    public List<MdiDoctorMedicalSpeciality> getMdiDoctorMedicalSpecialityList() {
        return mdiDoctorMedicalSpecialityList;
    }

    public void setMdiDoctorMedicalSpecialityList(List<MdiDoctorMedicalSpeciality> mdiDoctorMedicalSpecialityList) {
        this.mdiDoctorMedicalSpecialityList = mdiDoctorMedicalSpecialityList;
    }

    public List<MdiDoctorAtentionDay> getMdiDoctorAtentionDayList() {
        return mdiDoctorAtentionDayList;
    }

    public void setMdiDoctorAtentionDayList(List<MdiDoctorAtentionDay> mdiDoctorAtentionDayList) {
        this.mdiDoctorAtentionDayList = mdiDoctorAtentionDayList;
    }

    public SeUser getUserId() {
        return userId;
    }

    public void setUserId(SeUser userId) {
        this.userId = userId;
    }

    public List<DoctorPatient> getDoctorPatientList() {
        return doctorPatientList;
    }

    public void setDoctorPatientList(List<DoctorPatient> doctorPatientList) {
        this.doctorPatientList = doctorPatientList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doctorId != null ? doctorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeDoctor)) {
            return false;
        }
        SeDoctor other = (SeDoctor) object;
        if ((this.doctorId == null && other.doctorId != null) || (this.doctorId != null && !this.doctorId.equals(other.doctorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.SeDoctor[ doctorId=" + doctorId + " ]";
    }
    
}
