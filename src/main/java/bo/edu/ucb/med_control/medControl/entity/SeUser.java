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
@Table(name = "se_user")
@NamedQueries({
    @NamedQuery(name = "SeUser.findAll", query = "SELECT s FROM SeUser s"),
    @NamedQuery(name = "SeUser.findByUserId", query = "SELECT s FROM SeUser s WHERE s.userId = :userId"),
    @NamedQuery(name = "SeUser.findByUsername", query = "SELECT s FROM SeUser s WHERE s.username = :username"),
    @NamedQuery(name = "SeUser.findBySecret", query = "SELECT s FROM SeUser s WHERE s.secret = :secret"),
    @NamedQuery(name = "SeUser.findByUserPictureId", query = "SELECT s FROM SeUser s WHERE s.userPictureId = :userPictureId"),
    @NamedQuery(name = "SeUser.findByVersion", query = "SELECT s FROM SeUser s WHERE s.version = :version"),
    @NamedQuery(name = "SeUser.findByStatus", query = "SELECT s FROM SeUser s WHERE s.status = :status"),
    @NamedQuery(name = "SeUser.findByTxUser", query = "SELECT s FROM SeUser s WHERE s.txUser = :txUser"),
    @NamedQuery(name = "SeUser.findByTxHost", query = "SELECT s FROM SeUser s WHERE s.txHost = :txHost"),
    @NamedQuery(name = "SeUser.findByTxDate", query = "SELECT s FROM SeUser s WHERE s.txDate = :txDate")})
public class SeUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "user_id")
    private Integer userId;
    @Basic(optional = false)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Column(name = "secret")
    private String secret;
    @Basic(optional = false)
    @Column(name = "user_picture_id")
    private int userPictureId;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId", fetch = FetchType.LAZY)
    private List<SePrescription> sePrescriptionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctorId", fetch = FetchType.LAZY)
    private List<SePrescription> sePrescriptionList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    private List<SeDoctor> seDoctorList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId", fetch = FetchType.LAZY)
    private List<DoctorPatient> doctorPatientList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    private List<SeUserGroup> seUserGroupList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "doctorId", fetch = FetchType.LAZY)
    private List<MaAppointment> maAppointmentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId", fetch = FetchType.LAZY)
    private List<MaAppointment> maAppointmentList1;
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SePerson personId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    private List<SeUserMedicine> seUserMedicineList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userId", fetch = FetchType.LAZY)
    private List<SePatient> sePatientList;

    public SeUser() {
    }

    public SeUser(Integer userId) {
        this.userId = userId;
    }

    public SeUser(Integer userId, String username, String secret, int userPictureId, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.userId = userId;
        this.username = username;
        this.secret = secret;
        this.userPictureId = userPictureId;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public int getUserPictureId() {
        return userPictureId;
    }

    public void setUserPictureId(int userPictureId) {
        this.userPictureId = userPictureId;
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

    public List<SePrescription> getSePrescriptionList() {
        return sePrescriptionList;
    }

    public void setSePrescriptionList(List<SePrescription> sePrescriptionList) {
        this.sePrescriptionList = sePrescriptionList;
    }

    public List<SePrescription> getSePrescriptionList1() {
        return sePrescriptionList1;
    }

    public void setSePrescriptionList1(List<SePrescription> sePrescriptionList1) {
        this.sePrescriptionList1 = sePrescriptionList1;
    }

    public List<SeDoctor> getSeDoctorList() {
        return seDoctorList;
    }

    public void setSeDoctorList(List<SeDoctor> seDoctorList) {
        this.seDoctorList = seDoctorList;
    }

    public List<DoctorPatient> getDoctorPatientList() {
        return doctorPatientList;
    }

    public void setDoctorPatientList(List<DoctorPatient> doctorPatientList) {
        this.doctorPatientList = doctorPatientList;
    }

    public List<SeUserGroup> getSeUserGroupList() {
        return seUserGroupList;
    }

    public void setSeUserGroupList(List<SeUserGroup> seUserGroupList) {
        this.seUserGroupList = seUserGroupList;
    }

    public List<MaAppointment> getMaAppointmentList() {
        return maAppointmentList;
    }

    public void setMaAppointmentList(List<MaAppointment> maAppointmentList) {
        this.maAppointmentList = maAppointmentList;
    }

    public List<MaAppointment> getMaAppointmentList1() {
        return maAppointmentList1;
    }

    public void setMaAppointmentList1(List<MaAppointment> maAppointmentList1) {
        this.maAppointmentList1 = maAppointmentList1;
    }

    public SePerson getPersonId() {
        return personId;
    }

    public void setPersonId(SePerson personId) {
        this.personId = personId;
    }

    public List<SeUserMedicine> getSeUserMedicineList() {
        return seUserMedicineList;
    }

    public void setSeUserMedicineList(List<SeUserMedicine> seUserMedicineList) {
        this.seUserMedicineList = seUserMedicineList;
    }

    public List<SePatient> getSePatientList() {
        return sePatientList;
    }

    public void setSePatientList(List<SePatient> sePatientList) {
        this.sePatientList = sePatientList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SeUser)) {
            return false;
        }
        SeUser other = (SeUser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.SeUser[ userId=" + userId + " ]";
    }
    
}
