package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class SeDoctorDTO {

    private Integer doctorId;
    private String doctorRegistrationNumber;
    private BigDecimal doctorAppointmentPrice;
    private String doctorHospitalName;
    private String doctorHospitalDirecction;
    private Date doctorOpenTime;
    private Date doctorCloseTime;
    private int doctorProfessionalTitleId;
    private List<MdiCertificationDTO> mdiCertificationList;
    private List<MdiDoctorMedicalSpecialityDTO> mdiDoctorMedicalSpecialityList;
    private List<MdiDoctorAtentionDayDTO> mdiDoctorAtentionDayList;
    private SeUserDTO userId;
    private List<DoctorPatientDTO> doctorPatientList;
    private int version;
    private boolean status;
    private int txUser;
    private String txHost;
    private Date txDate;

    public SeDoctorDTO() {}
    public SeDoctorDTO(SeDoctor seDoctor) {
        this.doctorId = seDoctor.getDoctorId();
        this.doctorRegistrationNumber = seDoctor.getDoctorRegistrationNumber();
        this.doctorAppointmentPrice = seDoctor.getDoctorAppointmentPrice();
        this.doctorHospitalName = seDoctor.getDoctorHospitalName();
        this.doctorHospitalDirecction = seDoctor.getDoctorHospitalDirecction();
        this.doctorOpenTime = seDoctor.getDoctorOpenTime();
        this.doctorCloseTime = seDoctor.getDoctorCloseTime();
        this.doctorProfessionalTitleId = seDoctor.getDoctorProfessionalTitleId();
        this.mdiCertificationList = seDoctor.getMdiCertificationList().stream().map(MdiCertificationDTO::new).collect(Collectors.toList());
        this.mdiDoctorMedicalSpecialityList = seDoctor.getMdiDoctorMedicalSpecialityList().stream().map(MdiDoctorMedicalSpecialityDTO::new).collect(Collectors.toList());
        this.mdiDoctorAtentionDayList = seDoctor.getMdiDoctorAtentionDayList().stream().map(MdiDoctorAtentionDayDTO::new).collect(Collectors.toList());
        this.userId = new SeUserDTO(seDoctor.getUserId());
        this.doctorPatientList = seDoctor.getDoctorPatientList().stream().map(DoctorPatientDTO::new).collect(Collectors.toList());
        this.version = seDoctor.getVersion();
        this.status = seDoctor.getStatus();
        this.txUser = seDoctor.getTxUser();
        this.txHost = seDoctor.getTxHost();
        this.txDate = seDoctor.getTxDate();
    }

    public SeDoctorDTO(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public SeDoctorDTO(Integer doctorId, String doctorRegistrationNumber, BigDecimal doctorAppointmentPrice, String doctorHospitalName, String doctorHospitalDirecction, Date doctorOpenTime, Date doctorCloseTime, int doctorProfessionalTitleId, int version, boolean status, int txUser, String txHost, Date txDate) {
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

    public List<MdiCertificationDTO> getMdiCertificationList() {
        return mdiCertificationList;
    }

    public void setMdiCertificationList(List<MdiCertificationDTO> mdiCertificationList) {
        this.mdiCertificationList = mdiCertificationList;
    }

    public List<MdiDoctorMedicalSpecialityDTO> getMdiDoctorMedicalSpecialityList() {
        return mdiDoctorMedicalSpecialityList;
    }

    public void setMdiDoctorMedicalSpecialityList(List<MdiDoctorMedicalSpecialityDTO> mdiDoctorMedicalSpecialityList) {
        this.mdiDoctorMedicalSpecialityList = mdiDoctorMedicalSpecialityList;
    }

    public List<MdiDoctorAtentionDayDTO> getMdiDoctorAtentionDayList() {
        return mdiDoctorAtentionDayList;
    }

    public void setMdiDoctorAtentionDayList(List<MdiDoctorAtentionDayDTO> mdiDoctorAtentionDayList) {
        this.mdiDoctorAtentionDayList = mdiDoctorAtentionDayList;
    }

    public SeUserDTO getUserId() {
        return userId;
    }

    public void setUserId(SeUserDTO userId) {
        this.userId = userId;
    }

    public List<DoctorPatientDTO> getDoctorPatientList() {
        return doctorPatientList;
    }

    public void setDoctorPatientList(List<DoctorPatientDTO> doctorPatientList) {
        this.doctorPatientList = doctorPatientList;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public boolean isStatus() {
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

    public SeDoctor toEntity() {
        SeDoctor seDoctor = new SeDoctor();
        seDoctor.setDoctorId(doctorId);
        seDoctor.setDoctorRegistrationNumber(doctorRegistrationNumber);
        seDoctor.setDoctorAppointmentPrice(doctorAppointmentPrice);
        seDoctor.setDoctorHospitalName(doctorHospitalName);
        seDoctor.setDoctorHospitalDirecction(doctorHospitalDirecction);
        seDoctor.setDoctorOpenTime(doctorOpenTime);
        seDoctor.setDoctorCloseTime(doctorCloseTime);
        seDoctor.setDoctorProfessionalTitleId(doctorProfessionalTitleId);
        seDoctor.setMdiCertificationList(mdiCertificationList.stream().map(MdiCertificationDTO::toEntity).collect(Collectors.toList()));
        seDoctor.setMdiDoctorMedicalSpecialityList(mdiDoctorMedicalSpecialityList.stream().map(MdiDoctorMedicalSpecialityDTO::toEntity).collect(Collectors.toList()));
        seDoctor.setMdiDoctorAtentionDayList(mdiDoctorAtentionDayList.stream().map(MdiDoctorAtentionDayDTO::toEntity).collect(Collectors.toList()));
        seDoctor.setUserId(userId.toEntity());
        seDoctor.setDoctorPatientList(doctorPatientList.stream().map(DoctorPatientDTO::toEntity).collect(Collectors.toList()));
        seDoctor.setVersion(version);
        seDoctor.setStatus(status);
        seDoctor.setTxUser(txUser);
        seDoctor.setTxHost(txHost);
        seDoctor.setTxDate(txDate);

        return seDoctor;
    }

    @Override
    public String toString() {
        return "SeDoctorDTO{" +
                "doctorId=" + doctorId +
                ", doctorRegistrationNumber='" + doctorRegistrationNumber + '\'' +
                ", doctorAppointmentPrice=" + doctorAppointmentPrice +
                ", doctorHospitalName='" + doctorHospitalName + '\'' +
                ", doctorHospitalDirecction='" + doctorHospitalDirecction + '\'' +
                ", doctorOpenTime=" + doctorOpenTime +
                ", doctorCloseTime=" + doctorCloseTime +
                ", doctorProfessionalTitleId=" + doctorProfessionalTitleId +
                ", mdiCertificationList=" + mdiCertificationList +
                ", mdiDoctorMedicalSpecialityList=" + mdiDoctorMedicalSpecialityList +
                ", mdiDoctorAtentionDayList=" + mdiDoctorAtentionDayList +
                ", userId=" + userId +
                ", doctorPatientList=" + doctorPatientList +
                ", version=" + version +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                '}';
    }
}
