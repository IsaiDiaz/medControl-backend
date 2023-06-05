package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.DoctorPatient;
import bo.edu.ucb.med_control.medControl.entity.SeDoctor;
import bo.edu.ucb.med_control.medControl.entity.SeUser;

import java.util.Date;

public class DoctorPatientDTO {
    private Integer doctorPatients;
    private int version;
    private boolean status;
    private int txUser;
    private String txHost;
    private Date txDate;
    private SeDoctor doctorId;
    private SeUser patientId;

    public DoctorPatientDTO() {
    }

    public DoctorPatientDTO(DoctorPatient doctorPatient) {
        this.doctorPatients = doctorPatient.getDoctorPatients();
        this.version = doctorPatient.getVersion();
        this.status = doctorPatient.getStatus();
        this.txUser = doctorPatient.getTxUser();
        this.txHost = doctorPatient.getTxHost();
        this.txDate = doctorPatient.getTxDate();
        this.doctorId = doctorPatient.getDoctorId();
        this.patientId = doctorPatient.getPatientId();
    }

    public DoctorPatient toEntity() {
        DoctorPatient doctorPatient = new DoctorPatient();
        doctorPatient.setDoctorPatients(this.doctorPatients);
        doctorPatient.setVersion(this.version);
        doctorPatient.setStatus(this.status);
        doctorPatient.setTxUser(this.txUser);
        doctorPatient.setTxHost(this.txHost);
        doctorPatient.setTxDate(this.txDate);
        doctorPatient.setDoctorId(this.doctorId);
        doctorPatient.setPatientId(this.patientId);
        return doctorPatient;
    }

    // Getters and setters

    public Integer getDoctorPatients() {
        return doctorPatients;
    }

    public void setDoctorPatients(Integer doctorPatients) {
        this.doctorPatients = doctorPatients;
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

    public SeDoctor getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(SeDoctor doctorId) {
        this.doctorId = doctorId;
    }

    public SeUser getPatientId() {
        return patientId;
    }

    public void setPatientId(SeUser patientId) {
        this.patientId = patientId;
    }

    @Override
    public String toString() {
        return "DoctorPatientDTO{" +
                "doctorPatients=" + doctorPatients +
                ", version=" + version +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                ", doctorId=" + doctorId +
                ", patientId=" + patientId +
                '}';
    }
}
