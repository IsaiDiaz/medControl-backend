package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.UserSymptoms;
import java.util.Date;

public class UserSymptomsDTO {
    private Integer userSymptomsId;
    private int version;
    private boolean status;
    private int txUser;
    private String txHost;
    private Date txDate;
    private SeUserMedicineDTO userMedicineId;
    private UserSecondaryEfectDTO secondaryEfectId;

    public UserSymptomsDTO() {
    }

    public UserSymptomsDTO(UserSymptoms userSymptoms) {
        this.userSymptomsId = userSymptoms.getUserSymptomsId();
        this.version = userSymptoms.getVersion();
        this.status = userSymptoms.getStatus();
        this.txUser = userSymptoms.getTxUser();
        this.txHost = userSymptoms.getTxHost();
        this.txDate = userSymptoms.getTxDate();
        this.userMedicineId = new SeUserMedicineDTO(userSymptoms.getUserMedicineId());
        this.secondaryEfectId = new UserSecondaryEfectDTO(userSymptoms.getSecondaryEfectId());
    }

    public UserSymptomsDTO(Integer userSymptomsId, int version, boolean status, int txUser, String txHost, Date txDate,
                           SeUserMedicineDTO userMedicineId, UserSecondaryEfectDTO secondaryEfectId) {
        this.userSymptomsId = userSymptomsId;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
        this.userMedicineId = userMedicineId;
        this.secondaryEfectId = secondaryEfectId;
    }

    public UserSymptoms toEntity() {
        UserSymptoms userSymptoms = new UserSymptoms();
        userSymptoms.setUserSymptomsId(this.userSymptomsId);
        userSymptoms.setVersion(this.version);
        userSymptoms.setStatus(this.status);
        userSymptoms.setTxUser(this.txUser);
        userSymptoms.setTxHost(this.txHost);
        userSymptoms.setTxDate(this.txDate);
        userSymptoms.setUserMedicineId(this.userMedicineId.toEntity());
        userSymptoms.setSecondaryEfectId(this.secondaryEfectId.toEntity());
        return userSymptoms;
    }

    // Getters and setters

    public Integer getUserSymptomsId() {
        return userSymptomsId;
    }

    public void setUserSymptomsId(Integer userSymptomsId) {
        this.userSymptomsId = userSymptomsId;
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

    public SeUserMedicineDTO getUserMedicineId() {
        return userMedicineId;
    }

    public void setUserMedicineId(SeUserMedicineDTO userMedicineId) {
        this.userMedicineId = userMedicineId;
    }

    public UserSecondaryEfectDTO getSecondaryEfectId() {
        return secondaryEfectId;
    }

    public void setSecondaryEfectId(UserSecondaryEfectDTO secondaryEfectId) {
        this.secondaryEfectId = secondaryEfectId;
    }

    @Override
    public String toString() {
        return "UserSymptomsDTO{" +
                "userSymptomsId=" + userSymptomsId +
                ", version=" + version +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                ", userMedicineId=" + userMedicineId +
                ", secondaryEfectId=" + secondaryEfectId +
                '}';
    }
}
