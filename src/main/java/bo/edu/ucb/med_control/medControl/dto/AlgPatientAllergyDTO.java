package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.AlgAllergy;
import bo.edu.ucb.med_control.medControl.entity.AlgPatientAllergy;
import bo.edu.ucb.med_control.medControl.entity.AlgSeverity;
import bo.edu.ucb.med_control.medControl.entity.SePatient;

import java.util.Date;
import java.util.List;

public class AlgPatientAllergyDTO{
    private Integer userAllergyId;
    private Date patientAllergyDiagnosticDate;
    private int version;
    private boolean status;
    private int txUser;
    private String txHost;
    private Date txDate;
    private AlgAllergy allergyId;
    private AlgSeverity severityId;
    private SePatient patientId;

    public AlgPatientAllergyDTO() {
    }

    public AlgPatientAllergyDTO(AlgPatientAllergy algPatientAllergy) {
        this.userAllergyId = algPatientAllergy.getUserAllergyId();
        this.patientAllergyDiagnosticDate = algPatientAllergy.getPatientAllergyDiagnosticDate();
        this.version = algPatientAllergy.getVersion();
        this.status = algPatientAllergy.getStatus();
        this.txUser = algPatientAllergy.getTxUser();
        this.txHost = algPatientAllergy.getTxHost();
        this.txDate = algPatientAllergy.getTxDate();
        this.allergyId = algPatientAllergy.getAllergyId();
        this.severityId = algPatientAllergy.getSeverityId();
        this.patientId = algPatientAllergy.getPatientId();
    }

    public AlgPatientAllergyDTO(Integer userAllergyId, Date patientAllergyDiagnosticDate, int version, boolean status,
                                int txUser, String txHost, Date txDate, AlgAllergy allergyId, AlgSeverity severityId,
                                SePatient patientId) {
        this.userAllergyId = userAllergyId;
        this.patientAllergyDiagnosticDate = patientAllergyDiagnosticDate;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
        this.allergyId = allergyId;
        this.severityId = severityId;
        this.patientId = patientId;
    }

    public AlgPatientAllergy toEntity() {
        AlgPatientAllergy algPatientAllergy = new AlgPatientAllergy();
        algPatientAllergy.setUserAllergyId(this.userAllergyId);
        algPatientAllergy.setPatientAllergyDiagnosticDate(this.patientAllergyDiagnosticDate);
        algPatientAllergy.setVersion(this.version);
        algPatientAllergy.setStatus(this.status);
        algPatientAllergy.setTxUser(this.txUser);
        algPatientAllergy.setTxHost(this.txHost);
        algPatientAllergy.setTxDate(this.txDate);
        algPatientAllergy.setAllergyId(this.allergyId);
        algPatientAllergy.setSeverityId(this.severityId);
        algPatientAllergy.setPatientId(this.patientId);
        return algPatientAllergy;
    }

    // Getters and setters

    public Integer getUserAllergyId() {
        return userAllergyId;
    }

    public void setUserAllergyId(Integer userAllergyId) {
        this.userAllergyId = userAllergyId;
    }

    public Date getPatientAllergyDiagnosticDate() {
        return patientAllergyDiagnosticDate;
    }

    public void setPatientAllergyDiagnosticDate(Date patientAllergyDiagnosticDate) {
        this.patientAllergyDiagnosticDate = patientAllergyDiagnosticDate;
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

    public AlgAllergy getAllergyId() {
        return allergyId;
    }

    public void setAllergyId(AlgAllergy allergyId) {
        this.allergyId = allergyId;
    }

    public AlgSeverity getSeverityId() {
        return severityId;
    }

    public void setSeverityId(AlgSeverity severityId) {
        this.severityId = severityId;
    }

    public SePatient getPatientId() {
        return patientId;
    }

    public void setPatientId(SePatient patientId) {
        this.patientId = patientId;
    }

    public static List<AlgPatientAllergyDTO> fromList(List<AlgPatientAllergy> algPatientAllergyList) {
        List<AlgPatientAllergyDTO> list = new java.util.ArrayList<>(algPatientAllergyList.size());
        for (AlgPatientAllergy algPatientAllergy : algPatientAllergyList) {
            list.add(new AlgPatientAllergyDTO(algPatientAllergy));
        }
        return list;
    }

    public static List<AlgPatientAllergy> toEntityList(List<AlgPatientAllergyDTO> algPatientAllergyDTOList) {
        List<AlgPatientAllergy> list = new java.util.ArrayList<>(algPatientAllergyDTOList.size());
        for (AlgPatientAllergyDTO algPatientAllergyDTO : algPatientAllergyDTOList) {
            list.add(algPatientAllergyDTO.toEntity());
        }
        return list;
    }

    @Override
    public String toString() {
        return "AlgPatientAllergyDTO{" +
                "userAllergyId=" + userAllergyId +
                ", patientAllergyDiagnosticDate=" + patientAllergyDiagnosticDate +
                ", version=" + version +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                ", allergyId=" + allergyId +
                ", severityId=" + severityId +
                ", patientId=" + patientId +
                '}';
    }
}