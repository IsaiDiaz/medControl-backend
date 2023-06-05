package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class MdiAtentionDayDTO {

    private Integer atentionDayId;
    private String atentionDayName;
    private int version;
    private boolean status;
    private int txUser;
    private String txHost;
    private Date txDate;
    private List<MdiDoctorAtentionDay> mdiDoctorAtentionDayList;

    public MdiAtentionDayDTO() {}

    public MdiAtentionDayDTO(MdiAtentionDay atentionDay) {
        this.atentionDayId = atentionDay.getAtentioinDayId();
        this.atentionDayName = atentionDay.getAtentionDayName();
        this.version = atentionDay.getVersion();
        this.status = atentionDay.getStatus();
        this.txUser = atentionDay.getTxUser();
        this.txHost = atentionDay.getTxHost();
        this.txDate = atentionDay.getTxDate();
        this.mdiDoctorAtentionDayList = atentionDay.getMdiDoctorAtentionDayList();
    }

    public MdiAtentionDayDTO(Integer atentionDayId) {
        this.atentionDayId = atentionDayId;
    }

    public MdiAtentionDayDTO(Integer atentionDayId, String atentionDayName, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.atentionDayId = atentionDayId;
        this.atentionDayName = atentionDayName;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    // Getters and setters...


    public Integer getAtentionDayId() {
        return atentionDayId;
    }

    public void setAtentionDayId(Integer atentionDayId) {
        this.atentionDayId = atentionDayId;
    }

    public String getAtentionDayName() {
        return atentionDayName;
    }

    public void setAtentionDayName(String atentionDayName) {
        this.atentionDayName = atentionDayName;
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

    public List<MdiDoctorAtentionDay> getMdiDoctorAtentionDayList() {
        return mdiDoctorAtentionDayList;
    }

    public void setMdiDoctorAtentionDayList(List<MdiDoctorAtentionDay> mdiDoctorAtentionDayList) {
        this.mdiDoctorAtentionDayList = mdiDoctorAtentionDayList;
    }

    public MdiAtentionDay toEntity() {
        MdiAtentionDay atentionDay = new MdiAtentionDay();
        atentionDay.setAtentioinDayId(this.atentionDayId);
        atentionDay.setAtentionDayName(this.atentionDayName);
        atentionDay.setVersion(this.version);
        atentionDay.setStatus(this.status);
        atentionDay.setTxUser(this.txUser);
        atentionDay.setTxHost(this.txHost);
        atentionDay.setTxDate(this.txDate);
        atentionDay.setMdiDoctorAtentionDayList(this.mdiDoctorAtentionDayList);
        return atentionDay;
    }

    @Override
    public String toString() {
        return "MdiAtentionDayDTO{" +
                "atentionDayId=" + atentionDayId +
                ", atentionDayName='" + atentionDayName + '\'' +
                ", version=" + version +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                ", mdiDoctorAtentionDayList=" + mdiDoctorAtentionDayList +
                '}';
    }
}
