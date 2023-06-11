package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.IllIllness;
import bo.edu.ucb.med_control.medControl.entity.IllPatientIllness;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;
import java.util.List;

public class IllIllnessDTO {
    private Integer illnessId;
    private String illnessName;
    private String illnesDescription;
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
    private List<IllPatientIllness> illPatientIllnessList;

    public IllIllnessDTO() {
    }

    public IllIllnessDTO(Integer illnessId){
        this.illnessId = illnessId;
    }

    public IllIllnessDTO(IllIllness illness) {
        this.illnessId = illness.getIllnessId();
        this.illnessName = illness.getIllnessName();
        this.illnesDescription = illness.getIllnesDescription();
        this.version = illness.getVersion();
        this.status = illness.getStatus();
        this.txUser = illness.getTxUser();
        this.txHost = illness.getTxHost();
        this.txDate = illness.getTxDate();
    }

    public IllIllness toEntity() {
        IllIllness illness = new IllIllness();
        illness.setIllnessId(this.illnessId);
        illness.setIllnessName(this.illnessName);
        illness.setIllnesDescription(this.illnesDescription);
        illness.setVersion(this.version);
        illness.setStatus(this.status);
        illness.setTxUser(this.txUser);
        illness.setTxHost(this.txHost);
        illness.setTxDate(this.txDate);
        return illness;
    }

    // Getters and setters

    public Integer getIllnessId() {
        return illnessId;
    }

    public void setIllnessId(Integer illnessId) {
        this.illnessId = illnessId;
    }

    public String getIllnessName() {
        return illnessName;
    }

    public void setIllnessName(String illnessName) {
        this.illnessName = illnessName;
    }

    public String getIllnesDescription() {
        return illnesDescription;
    }

    public void setIllnesDescription(String illnesDescription) {
        this.illnesDescription = illnesDescription;
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

    public List<IllPatientIllness> getIllPatientIllnessList() {
        return illPatientIllnessList;
    }

    public void setIllPatientIllnessList(List<IllPatientIllness> illPatientIllnessList) {
        this.illPatientIllnessList = illPatientIllnessList;
    }

    @Override
    public String toString() {
        return "IllIllnessDTO{" +
                "illnessId=" + illnessId +
                ", illnessName='" + illnessName + '\'' +
                ", illnesDescription='" + illnesDescription + '\'' +
                ", version=" + version +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                ", illPatientIllnessList=" + illPatientIllnessList +
                '}';
    }
}
