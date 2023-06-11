package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.AlgAllergy;
import bo.edu.ucb.med_control.medControl.entity.AlgPatientAllergy;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;

public class AlgAllergyDTO {
    private Integer allergyId;
    private String allergyName;
    private String allergyDescription;
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
    private List<AlgPatientAllergy> algPatientAllergyList;

    public AlgAllergyDTO() {
    }

    public AlgAllergyDTO(Integer allergyId){
        this.allergyId = allergyId;
    }

    public AlgAllergyDTO(AlgAllergy algAllergy) {
        this.allergyId = algAllergy.getAllergyId();
        this.allergyName = algAllergy.getAllergyName();
        this.allergyDescription = algAllergy.getAllergyDescription();
        this.version = algAllergy.getVersion();
        this.status = algAllergy.getStatus();
        this.txUser = algAllergy.getTxUser();
        this.txHost = algAllergy.getTxHost();
        this.txDate = algAllergy.getTxDate();

    }

    public AlgAllergy toEntity() {
        AlgAllergy algAllergy = new AlgAllergy();
        algAllergy.setAllergyId(this.allergyId);
        algAllergy.setAllergyName(this.allergyName);
        algAllergy.setAllergyDescription(this.allergyDescription);
        algAllergy.setVersion(this.version);
        algAllergy.setStatus(this.status);
        algAllergy.setTxUser(this.txUser);
        algAllergy.setTxHost(this.txHost);
        algAllergy.setTxDate(this.txDate);
        return algAllergy;
    }

    // Getters and setters

    public Integer getAllergyId() {
        return allergyId;
    }

    public void setAllergyId(Integer allergyId) {
        this.allergyId = allergyId;
    }

    public String getAllergyName() {
        return allergyName;
    }

    public void setAllergyName(String allergyName) {
        this.allergyName = allergyName;
    }

    public String getAllergyDescription() {
        return allergyDescription;
    }

    public void setAllergyDescription(String allergyDescription) {
        this.allergyDescription = allergyDescription;
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
        return "AlgAllergyDTO{" +
                "allergyId=" + allergyId +
                ", allergyName='" + allergyName + '\'' +
                ", allergyDescription='" + allergyDescription + '\'' +
                ", version=" + version +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                ", algPatientAllergyList=" + algPatientAllergyList +
                '}';
    }
}