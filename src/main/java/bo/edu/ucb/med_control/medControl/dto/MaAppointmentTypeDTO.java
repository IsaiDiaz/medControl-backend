package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.MaAppointmentType;
import java.util.Date;

public class MaAppointmentTypeDTO {

    private Integer appointmentTypeId;
    private String appointmentTypeName;
    private int version;
    private boolean status;
    private int txUser;
    private String txHost;
    private Date txDate;

    public MaAppointmentTypeDTO() {}

    public MaAppointmentTypeDTO(MaAppointmentType appointmentType) {
        this.appointmentTypeId = appointmentType.getAppointmentTypeId();
        this.appointmentTypeName = appointmentType.getAppointmentTypeName();
        this.version = appointmentType.getVersion();
        this.status = appointmentType.getStatus();
        this.txUser = appointmentType.getTxUser();
        this.txHost = appointmentType.getTxHost();
        this.txDate = appointmentType.getTxDate();
    }

    public MaAppointmentTypeDTO(Integer appointmentTypeId) {
        this.appointmentTypeId = appointmentTypeId;
    }

    public MaAppointmentTypeDTO(Integer appointmentTypeId, String appointmentTypeName, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.appointmentTypeId = appointmentTypeId;
        this.appointmentTypeName = appointmentTypeName;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    // Getters and setters...

    public Integer getAppointmentTypeId() {
        return appointmentTypeId;
    }

    public void setAppointmentTypeId(Integer appointmentTypeId) {
        this.appointmentTypeId = appointmentTypeId;
    }

    public String getAppointmentTypeName() {
        return appointmentTypeName;
    }

    public void setAppointmentTypeName(String appointmentTypeName) {
        this.appointmentTypeName = appointmentTypeName;
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

    public MaAppointmentType toEntity() {
        MaAppointmentType appointmentType = new MaAppointmentType();
        appointmentType.setAppointmentTypeId(this.appointmentTypeId);
        appointmentType.setAppointmentTypeName(this.appointmentTypeName);
        appointmentType.setVersion(this.version);
        appointmentType.setStatus(this.status);
        appointmentType.setTxUser(this.txUser);
        appointmentType.setTxHost(this.txHost);
        appointmentType.setTxDate(this.txDate);
        return appointmentType;
    }

    @Override
    public String toString() {
        return "MaAppointmentTypeDTO{" +
                "appointmentTypeId=" + appointmentTypeId +
                ", appointmentTypeName='" + appointmentTypeName + '\'' +
                ", version=" + version +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                '}';
    }
}
