package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.*;
import java.util.Date;

public class MdiDoctorAtentionDayDTO {

    private Integer doctorAtentionDay;
    private int version;
    private boolean status;
    private int txUser;
    private String txHost;
    private Date txDate;
    private MdiAtentionDayDTO atentionDayId;
    private SeDoctorDTO doctorId;

    public MdiDoctorAtentionDayDTO() {}

    public MdiDoctorAtentionDayDTO(MdiDoctorAtentionDay doctorAtentionDay) {
        this.doctorAtentionDay = doctorAtentionDay.getDoctorAtentionDay();
        this.version = doctorAtentionDay.getVersion();
        this.status = doctorAtentionDay.getStatus();
        this.txUser = doctorAtentionDay.getTxUser();
        this.txHost = doctorAtentionDay.getTxHost();
        this.txDate = doctorAtentionDay.getTxDate();
        this.atentionDayId = new MdiAtentionDayDTO(doctorAtentionDay.getAtentionDayId());
        this.doctorId = new SeDoctorDTO(doctorAtentionDay.getDoctorId());
    }

    public MdiDoctorAtentionDayDTO(Integer doctorAtentionDay) {
        this.doctorAtentionDay = doctorAtentionDay;
    }

    public MdiDoctorAtentionDayDTO(Integer doctorAtentionDay, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.doctorAtentionDay = doctorAtentionDay;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getDoctorAtentionDay() {
        return doctorAtentionDay;
    }

    public void setDoctorAtentionDay(Integer doctorAtentionDay) {
        this.doctorAtentionDay = doctorAtentionDay;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public boolean getStatus() {
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

    public MdiAtentionDayDTO getAtentionDayId() {
        return atentionDayId;
    }

    public void setAtentionDayId(MdiAtentionDayDTO atentionDayId) {
        this.atentionDayId = atentionDayId;
    }

    public SeDoctorDTO getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(SeDoctorDTO doctorId) {
        this.doctorId = doctorId;
    }

    public MdiDoctorAtentionDay toEntity() {
        MdiDoctorAtentionDay doctorAtentionDayEntity = new MdiDoctorAtentionDay();
        doctorAtentionDayEntity.setDoctorAtentionDay(this.doctorAtentionDay);
        doctorAtentionDayEntity.setVersion(this.version);
        doctorAtentionDayEntity.setStatus(this.status);
        doctorAtentionDayEntity.setTxUser(this.txUser);
        doctorAtentionDayEntity.setTxHost(this.txHost);
        doctorAtentionDayEntity.setTxDate(this.txDate);
        doctorAtentionDayEntity.setAtentionDayId(this.atentionDayId.toEntity());
        doctorAtentionDayEntity.setDoctorId(this.doctorId.toEntity());
        return doctorAtentionDayEntity;
    }

    @Override
    public String toString() {
        return "MdiDoctorAtentionDayDTO{" +
                "doctorAtentionDay=" + doctorAtentionDay +
                ", version=" + version +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                ", atentionDayId=" + atentionDayId +
                ", doctorId=" + doctorId +
                '}';
    }
}
