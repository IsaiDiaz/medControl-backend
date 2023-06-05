package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.*;
import java.math.BigDecimal;
import java.util.Date;

public class MaAppointmentDTO {

    private Integer appointmentId;
    private BigDecimal appointmentPrice;
    private String appointmentState;
    private Date appointmentDate;
    private int version;
    private boolean status;
    private int txUser;
    private String txHost;
    private Date txDate;

    public MaAppointmentDTO() {}

    public MaAppointmentDTO(MaAppointment appointment) {
        this.appointmentId = appointment.getAppointmentId();
        this.appointmentPrice = appointment.getAppointmentPrice();
        this.appointmentState = appointment.getAppointmentState();
        this.appointmentDate = appointment.getAppointmentDate();
        this.version = appointment.getVersion();
        this.status = appointment.getStatus();
        this.txUser = appointment.getTxUser();
        this.txHost = appointment.getTxHost();
        this.txDate = appointment.getTxDate();
    }

    public MaAppointmentDTO(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public MaAppointmentDTO(Integer appointmentId, BigDecimal appointmentPrice, String appointmentState, Date appointmentDate, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.appointmentId = appointmentId;
        this.appointmentPrice = appointmentPrice;
        this.appointmentState = appointmentState;
        this.appointmentDate = appointmentDate;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }
    // Getters and setters...

    public Integer getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Integer appointmentId) {
        this.appointmentId = appointmentId;
    }

    public BigDecimal getAppointmentPrice() {
        return appointmentPrice;
    }

    public void setAppointmentPrice(BigDecimal appointmentPrice) {
        this.appointmentPrice = appointmentPrice;
    }

    public String getAppointmentState() {
        return appointmentState;
    }

    public void setAppointmentState(String appointmentState) {
        this.appointmentState = appointmentState;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
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

    public MaAppointment toEntity() {
        MaAppointment appointment = new MaAppointment();
        appointment.setAppointmentId(this.appointmentId);
        appointment.setAppointmentPrice(this.appointmentPrice);
        appointment.setAppointmentState(this.appointmentState);
        appointment.setAppointmentDate(this.appointmentDate);
        appointment.setVersion(this.version);
        appointment.setStatus(this.status);
        appointment.setTxUser(this.txUser);
        appointment.setTxHost(this.txHost);
        appointment.setTxDate(this.txDate);
        return appointment;
    }

    @Override
    public String toString() {
        return "MaAppointmentDTO{" +
                "appointmentId=" + appointmentId +
                ", appointmentPrice=" + appointmentPrice +
                ", appointmentState='" + appointmentState + '\'' +
                ", appointmentDate=" + appointmentDate +
                ", version=" + version +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                '}';
    }
}
