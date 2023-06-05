package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.IllIllness;
import bo.edu.ucb.med_control.medControl.entity.IllPatientIllness;
import bo.edu.ucb.med_control.medControl.entity.SePatient;

import java.util.Date;
import java.util.List;

public class IllPatientIllnessDTO {
    private Integer userIllnessId;
    private int illnessDocumentId;
    private Date patientIllnessDiagnosticDate;
    private int version;
    private boolean status;
    private int txDate;
    private int txUser;
    private String txHost;
    private IllIllnessDTO illnessId;
    private SePatientDTO patientId;

    public IllPatientIllnessDTO() {
    }

    public IllPatientIllnessDTO(Integer userIllnessId, int illnessDocumentId, Date patientIllnessDiagnosticDate, int version, boolean status, int txDate, int txUser, String txHost, IllIllnessDTO illnessId, SePatientDTO patientId) {
        this.userIllnessId = userIllnessId;
        this.illnessDocumentId = illnessDocumentId;
        this.patientIllnessDiagnosticDate = patientIllnessDiagnosticDate;
        this.version = version;
        this.status = status;
        this.txDate = txDate;
        this.txUser = txUser;
        this.txHost = txHost;
        this.illnessId = illnessId;
        this.patientId = patientId;
    }

    public IllPatientIllnessDTO(IllPatientIllness patientIllness) {
        this.userIllnessId = patientIllness.getUserIllnessId();
        this.illnessDocumentId = patientIllness.getIllnessDocumentId();
        this.patientIllnessDiagnosticDate = patientIllness.getPatientIllnessDiagnosticDate();
        this.version = patientIllness.getVersion();
        this.status = patientIllness.getStatus();
        this.txDate = patientIllness.getTxDate();
        this.txUser = patientIllness.getTxUser();
        this.txHost = patientIllness.getTxHost();
        this.illnessId = new IllIllnessDTO(patientIllness.getIllnessId());
        this.patientId = new SePatientDTO(patientIllness.getPatientId());
    }

    public IllPatientIllness toEntity() {
        IllPatientIllness patientIllness = new IllPatientIllness();
        patientIllness.setUserIllnessId(this.userIllnessId);
        patientIllness.setIllnessDocumentId(this.illnessDocumentId);
        patientIllness.setPatientIllnessDiagnosticDate(this.patientIllnessDiagnosticDate);
        patientIllness.setVersion(this.version);
        patientIllness.setStatus(this.status);
        patientIllness.setTxDate(this.txDate);
        patientIllness.setTxUser(this.txUser);
        patientIllness.setTxHost(this.txHost);
        patientIllness.setIllnessId(this.illnessId.toEntity());
        patientIllness.setPatientId(this.patientId.toEntity());
        return patientIllness;
    }

    // Getters and setters

    public Integer getUserIllnessId() {
        return userIllnessId;
    }

    public void setUserIllnessId(Integer userIllnessId) {
        this.userIllnessId = userIllnessId;
    }

    public int getIllnessDocumentId() {
        return illnessDocumentId;
    }

    public void setIllnessDocumentId(int illnessDocumentId) {
        this.illnessDocumentId = illnessDocumentId;
    }

    public Date getPatientIllnessDiagnosticDate() {
        return patientIllnessDiagnosticDate;
    }

    public void setPatientIllnessDiagnosticDate(Date patientIllnessDiagnosticDate) {
        this.patientIllnessDiagnosticDate = patientIllnessDiagnosticDate;
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

    public int getTxDate() {
        return txDate;
    }

    public void setTxDate(int txDate) {
        this.txDate = txDate;
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

    public IllIllnessDTO getIllnessId() {
        return illnessId;
    }

    public void setIllnessId(IllIllnessDTO illnessId) {
        this.illnessId = illnessId;
    }

    public SePatientDTO getPatientId() {
        return patientId;
    }

    public void setPatientId(SePatientDTO patientId) {
        this.patientId = patientId;
    }

    public static List<IllPatientIllnessDTO> fromList(List<IllPatientIllness> list) {
        List<IllPatientIllnessDTO> output = new java.util.ArrayList<>(list.size());
        for (IllPatientIllness patientIllness : list) {
            output.add(new IllPatientIllnessDTO(patientIllness));
        }
        return output;
    }

    public static List<IllPatientIllness> toEntityList(List<IllPatientIllnessDTO> list){
        List<IllPatientIllness> output = new java.util.ArrayList<>(list.size());
        for (IllPatientIllnessDTO patientIllnessDTO : list) {
            output.add(patientIllnessDTO.toEntity());
        }
        return output;
    }

    @Override
    public String toString() {
        return "IllPatientIllnessDTO{" +
                "userIllnessId=" + userIllnessId +
                ", illnessDocumentId=" + illnessDocumentId +
                ", patientIllnessDiagnosticDate=" + patientIllnessDiagnosticDate +
                ", version=" + version +
                ", status=" + status +
                ", txDate=" + txDate +
                ", txUser=" + txUser +
                ", txHost='" + txHost + '\'' +
                ", illnessId=" + illnessId +
                ", patientId=" + patientId +
                '}';
    }
}
