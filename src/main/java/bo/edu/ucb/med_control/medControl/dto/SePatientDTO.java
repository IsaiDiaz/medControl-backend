package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.IllPatientIllness;
import bo.edu.ucb.med_control.medControl.entity.MdhMedicalHistory;
import bo.edu.ucb.med_control.medControl.entity.SePatient;
import bo.edu.ucb.med_control.medControl.entity.SeUser;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class SePatientDTO {
    private Integer patientId;
    private BigDecimal patientHeight;
    private BigDecimal patientWeight;
    private String patientGender;
    @JsonIgnore
    private int version;
    @JsonIgnore
    private boolean status;
    @JsonIgnore
    private int txUser;
    @JsonIgnore
    private String txHost;
    @JsonIgnore
    private Date txDate;
    @JsonIgnore
    private List<IllPatientIllnessDTO> illPatientIllnessList;
    @JsonIgnore
    private List<MdhMedicalHistoryDTO> mdhMedicalHistoryList;
    private SeUserDTO userId;
    @JsonIgnore
    private List<AlgPatientAllergyDTO> algPatientAllergyList;

    public SePatientDTO() {

    }

    public SePatientDTO(SePatient patient) {
        this.patientId = patient.getPatientId();
        this.patientHeight = patient.getPatientHeight();
        this.patientWeight = patient.getPatientWeight();
        this.patientGender = patient.getPatientGender();
        this.version = patient.getVersion();
        this.status = patient.getStatus();
        this.txUser = patient.getTxUser();
        this.txHost = patient.getTxHost();
        this.txDate = patient.getTxDate();
    }

    public SePatient toEntity() {
        SePatient patient = new SePatient();
        patient.setPatientId(this.patientId);
        patient.setPatientHeight(this.patientHeight);
        patient.setPatientWeight(this.patientWeight);
        patient.setPatientGender(this.patientGender);
        patient.setVersion(this.version);
        patient.setStatus(this.status);
        patient.setTxUser(this.txUser);
        patient.setTxHost(this.txHost);
        patient.setTxDate(this.txDate);
        patient.setUserId(this.userId.toEntity());
        return patient;
    }

    // Getters and setters

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public BigDecimal getPatientHeight() {
        return patientHeight;
    }

    public void setPatientHeight(BigDecimal patientHeight) {
        this.patientHeight = patientHeight;
    }

    public BigDecimal getPatientWeight() {
        return patientWeight;
    }

    public void setPatientWeight(BigDecimal patientWeight) {
        this.patientWeight = patientWeight;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
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

    public List<IllPatientIllnessDTO> getIllPatientIllnessList() {
        return illPatientIllnessList;
    }

    public void setIllPatientIllnessList(List<IllPatientIllnessDTO> illPatientIllnessList) {
        this.illPatientIllnessList = illPatientIllnessList;
    }

    public List<MdhMedicalHistoryDTO> getMdhMedicalHistoryList() {
        return mdhMedicalHistoryList;
    }

    public void setMdhMedicalHistoryList(List<MdhMedicalHistoryDTO> mdhMedicalHistoryList) {
        this.mdhMedicalHistoryList = mdhMedicalHistoryList;
    }

    public SeUserDTO getUserId() {
        return userId;
    }

    public void setUserId(SeUserDTO userId) {
        this.userId = userId;
    }

    public List<AlgPatientAllergyDTO> getAlgPatientAllergyList() {
        return algPatientAllergyList;
    }

    public void setAlgPatientAllergyList(List<AlgPatientAllergyDTO> algPatientAllergyList) {
        this.algPatientAllergyList = algPatientAllergyList;
    }

    @Override
    public String toString() {
        return "SePatientDTO{" +
                "patientId=" + patientId +
                ", patientHeight=" + patientHeight +
                ", patientWeight=" + patientWeight +
                ", patientGender='" + patientGender + '\'' +
                ", version=" + version +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                ", illPatientIllnessList=" + illPatientIllnessList +
                ", mdhMedicalHistoryList=" + mdhMedicalHistoryList +
                ", userId=" + userId +
                ", algPatientAllergyList=" + algPatientAllergyList +
                '}';
    }
}
