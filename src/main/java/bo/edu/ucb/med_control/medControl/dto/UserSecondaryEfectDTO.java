package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.UserSecondaryEfect;
import java.util.Date;

public class UserSecondaryEfectDTO {
    private Integer secondaryEfectId;
    private String secondaryEfectName;
    private String secondaryEfectDesc;
    private int version;
    private boolean status;
    private int txUser;
    private String txHost;
    private Date txDate;

    public UserSecondaryEfectDTO() {
    }

    public UserSecondaryEfectDTO(UserSecondaryEfect userSecondaryEfect) {
        this.secondaryEfectId = userSecondaryEfect.getSecondaryEfectId();
        this.secondaryEfectName = userSecondaryEfect.getSecondaryEfectName();
        this.secondaryEfectDesc = userSecondaryEfect.getSecondaryEfectDesc();
        this.version = userSecondaryEfect.getVersion();
        this.status = userSecondaryEfect.getStatus();
        this.txUser = userSecondaryEfect.getTxUser();
        this.txHost = userSecondaryEfect.getTxHost();
        this.txDate = userSecondaryEfect.getTxDate();
    }

    public UserSecondaryEfectDTO(Integer secondaryEfectId, String secondaryEfectName, String secondaryEfectDesc,
                                 int version, boolean status, int txUser, String txHost, Date txDate) {
        this.secondaryEfectId = secondaryEfectId;
        this.secondaryEfectName = secondaryEfectName;
        this.secondaryEfectDesc = secondaryEfectDesc;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public UserSecondaryEfect toEntity() {
        UserSecondaryEfect userSecondaryEfect = new UserSecondaryEfect();
        userSecondaryEfect.setSecondaryEfectId(this.secondaryEfectId);
        userSecondaryEfect.setSecondaryEfectName(this.secondaryEfectName);
        userSecondaryEfect.setSecondaryEfectDesc(this.secondaryEfectDesc);
        userSecondaryEfect.setVersion(this.version);
        userSecondaryEfect.setStatus(this.status);
        userSecondaryEfect.setTxUser(this.txUser);
        userSecondaryEfect.setTxHost(this.txHost);
        userSecondaryEfect.setTxDate(this.txDate);
        return userSecondaryEfect;
    }

    // Getters and setters

    public Integer getSecondaryEfectId() {
        return secondaryEfectId;
    }

    public void setSecondaryEfectId(Integer secondaryEfectId) {
        this.secondaryEfectId = secondaryEfectId;
    }

    public String getSecondaryEfectName() {
        return secondaryEfectName;
    }

    public void setSecondaryEfectName(String secondaryEfectName) {
        this.secondaryEfectName = secondaryEfectName;
    }

    public String getSecondaryEfectDesc() {
        return secondaryEfectDesc;
    }

    public void setSecondaryEfectDesc(String secondaryEfectDesc) {
        this.secondaryEfectDesc = secondaryEfectDesc;
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

    @Override
    public String toString() {
        return "UserSecondaryEfectDTO{" +
                "secondaryEfectId=" + secondaryEfectId +
                ", secondaryEfectName='" + secondaryEfectName + '\'' +
                ", secondaryEfectDesc='" + secondaryEfectDesc + '\'' +
                ", version=" + version +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                '}';
    }
}
