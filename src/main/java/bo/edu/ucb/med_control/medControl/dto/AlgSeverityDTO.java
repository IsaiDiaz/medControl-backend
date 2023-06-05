package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.AlgPatientAllergy;
import bo.edu.ucb.med_control.medControl.entity.AlgSeverity;

import java.util.Date;
import java.util.List;

public class AlgSeverityDTO {
    private Integer severityId;
    private String severityName;
    private int version;
    private boolean status;
    private int txUser;
    private String txHost;
    private Date txDate;
    private List<AlgPatientAllergy> algPatientAllergyList;

    public AlgSeverityDTO() {
    }

    public AlgSeverityDTO(AlgSeverity algSeverity) {
        this.severityId = algSeverity.getSeverityId();
        this.severityName = algSeverity.getSeverityName();
        this.version = algSeverity.getVersion();
        this.status = algSeverity.getStatus();
        this.txUser = algSeverity.getTxUser();
        this.txHost = algSeverity.getTxHost();
        this.txDate = algSeverity.getTxDate();
        this.algPatientAllergyList = algSeverity.getAlgPatientAllergyList();
    }

    public AlgSeverity toEntity() {
        AlgSeverity algSeverity = new AlgSeverity();
        algSeverity.setSeverityId(this.severityId);
        algSeverity.setSeverityName(this.severityName);
        algSeverity.setVersion(this.version);
        algSeverity.setStatus(this.status);
        algSeverity.setTxUser(this.txUser);
        algSeverity.setTxHost(this.txHost);
        algSeverity.setTxDate(this.txDate);
        algSeverity.setAlgPatientAllergyList(this.algPatientAllergyList);
        return algSeverity;
    }

    // Getters and setters

    public Integer getSeverityId() {
        return severityId;
    }

    public void setSeverityId(Integer severityId) {
        this.severityId = severityId;
    }

    public String getSeverityName() {
        return severityName;
    }

    public void setSeverityName(String severityName) {
        this.severityName = severityName;
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

    public List<AlgPatientAllergy> getAlgPatientAllergyList() {
        return algPatientAllergyList;
    }

    public void setAlgPatientAllergyList(List<AlgPatientAllergy> algPatientAllergyList) {
        this.algPatientAllergyList = algPatientAllergyList;
    }

    @Override
    public String toString() {
        return "AlgSeverityDTO{" +
                "severityId=" + severityId +
                ", severityName='" + severityName + '\'' +
                ", version=" + version +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                ", algPatientAllergyList=" + algPatientAllergyList +
                '}';
    }
}
