package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.*;
import java.util.Date;

public class MdiDoctorMedicalSpecialityDTO {

    private Integer doctorMedicalSpeciality;
    private int doctorMedicalSpecialityTitleId;
    private int version;
    private boolean status;
    private int txUser;
    private String txHost;
    private Date txDate;
    private MdiMedicalSpecialityDTO medicalSpecialityId;
    private SeDoctorDTO doctorId;

    public MdiDoctorMedicalSpecialityDTO() {}

    public MdiDoctorMedicalSpecialityDTO(MdiDoctorMedicalSpeciality doctorMedicalSpeciality) {
        this.doctorMedicalSpeciality = doctorMedicalSpeciality.getDoctorMedicalSpeciality();
        this.doctorMedicalSpecialityTitleId = doctorMedicalSpeciality.getDoctorMedicalSpecialityTitleId();
        this.version = doctorMedicalSpeciality.getVersion();
        this.status = doctorMedicalSpeciality.getStatus();
        this.txUser = doctorMedicalSpeciality.getTxUser();
        this.txHost = doctorMedicalSpeciality.getTxHost();
        this.txDate = doctorMedicalSpeciality.getTxDate();
        this.medicalSpecialityId = new MdiMedicalSpecialityDTO(doctorMedicalSpeciality.getMedicalSpecialityId());
        this.doctorId = new SeDoctorDTO(doctorMedicalSpeciality.getDoctorId());
    }

    public Integer getDoctorMedicalSpeciality() {
        return doctorMedicalSpeciality;
    }

    public void setDoctorMedicalSpeciality(Integer doctorMedicalSpeciality) {
        this.doctorMedicalSpeciality = doctorMedicalSpeciality;
    }

    public int getDoctorMedicalSpecialityTitleId() {
        return doctorMedicalSpecialityTitleId;
    }

    public void setDoctorMedicalSpecialityTitleId(int doctorMedicalSpecialityTitleId) {
        this.doctorMedicalSpecialityTitleId = doctorMedicalSpecialityTitleId;
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

    public MdiMedicalSpecialityDTO getMedicalSpecialityId() {
        return medicalSpecialityId;
    }

    public void setMedicalSpecialityId(MdiMedicalSpecialityDTO medicalSpecialityId) {
        this.medicalSpecialityId = medicalSpecialityId;
    }

    public SeDoctorDTO getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(SeDoctorDTO doctorId) {
        this.doctorId = doctorId;
    }

    public MdiDoctorMedicalSpeciality toEntity() {
        MdiDoctorMedicalSpeciality doctorMedicalSpeciality = new MdiDoctorMedicalSpeciality();
        doctorMedicalSpeciality.setDoctorMedicalSpeciality(this.doctorMedicalSpeciality);
        doctorMedicalSpeciality.setDoctorMedicalSpecialityTitleId(this.doctorMedicalSpecialityTitleId);
        doctorMedicalSpeciality.setVersion(this.version);
        doctorMedicalSpeciality.setStatus(this.status);
        doctorMedicalSpeciality.setTxUser(this.txUser);
        doctorMedicalSpeciality.setTxHost(this.txHost);
        doctorMedicalSpeciality.setTxDate(this.txDate);
        doctorMedicalSpeciality.setMedicalSpecialityId(this.medicalSpecialityId.toEntity());
        doctorMedicalSpeciality.setDoctorId(this.doctorId.toEntity());
        return doctorMedicalSpeciality;
    }
}
