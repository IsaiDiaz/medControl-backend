package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.SeUserMedicine;
import java.util.Date;
import java.util.List;

public class SeUserMedicineDTO {
    private Integer userMedicineId;
    private int dose;
    private int frecuency;
    private int version;
    private boolean status;
    private int txUser;
    private String txHost;
    private Date txDate;
    private List<UserSymptomsDTO> userSymptomsList;
    private SeMedicineDTO medicineId;
    private SePrescriptionDTO sePrescriptionPrescriptionId;
    private SeUserDTO userId;

    public SeUserMedicineDTO() {
    }

    public SeUserMedicineDTO(SeUserMedicine seUserMedicine) {
        this.userMedicineId = seUserMedicine.getUserMedicineId();
        this.dose = seUserMedicine.getDose();
        this.frecuency = seUserMedicine.getFrecuency();
        this.version = seUserMedicine.getVersion();
        this.status = seUserMedicine.getStatus();
        this.txUser = seUserMedicine.getTxUser();
        this.txHost = seUserMedicine.getTxHost();
        this.txDate = seUserMedicine.getTxDate();
        this.medicineId = new SeMedicineDTO(seUserMedicine.getMedicineId());
        this.sePrescriptionPrescriptionId = new SePrescriptionDTO(seUserMedicine.getSePrescriptionPrescriptionId());
        this.userId = new SeUserDTO(seUserMedicine.getUserId());
    }

    public SeUserMedicineDTO(Integer userMedicineId, int dose, int frecuency, int version, boolean status, int txUser,
                             String txHost, Date txDate, SeMedicineDTO medicineId, SePrescriptionDTO sePrescriptionPrescriptionId,
                             SeUserDTO userId) {
        this.userMedicineId = userMedicineId;
        this.dose = dose;
        this.frecuency = frecuency;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
        this.medicineId = medicineId;
        this.sePrescriptionPrescriptionId = sePrescriptionPrescriptionId;
        this.userId = userId;
    }

    public SeUserMedicine toEntity() {
        SeUserMedicine seUserMedicine = new SeUserMedicine();
        seUserMedicine.setUserMedicineId(this.userMedicineId);
        seUserMedicine.setDose(this.dose);
        seUserMedicine.setFrecuency(this.frecuency);
        seUserMedicine.setVersion(this.version);
        seUserMedicine.setStatus(this.status);
        seUserMedicine.setTxUser(this.txUser);
        seUserMedicine.setTxHost(this.txHost);
        seUserMedicine.setTxDate(this.txDate);
        seUserMedicine.setMedicineId(this.medicineId.toEntity());
        seUserMedicine.setSePrescriptionPrescriptionId(this.sePrescriptionPrescriptionId.toEntity());
        seUserMedicine.setUserId(this.userId.toEntity());
        return seUserMedicine;
    }

    // Getters and setters

    public Integer getUserMedicineId() {
        return userMedicineId;
    }

    public void setUserMedicineId(Integer userMedicineId) {
        this.userMedicineId = userMedicineId;
    }

    public int getDose() {
        return dose;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public int getFrecuency() {
        return frecuency;
    }

    public void setFrecuency(int frecuency) {
        this.frecuency = frecuency;
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

    public List<UserSymptomsDTO> getUserSymptomsList() {
        return userSymptomsList;
    }

    public void setUserSymptomsList(List<UserSymptomsDTO> userSymptomsList) {
        this.userSymptomsList = userSymptomsList;
    }

    public SeMedicineDTO getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(SeMedicineDTO medicineId) {
        this.medicineId = medicineId;
    }

    public SePrescriptionDTO getSePrescriptionPrescriptionId() {
        return sePrescriptionPrescriptionId;
    }

    public void setSePrescriptionPrescriptionId(SePrescriptionDTO sePrescriptionPrescriptionId) {
        this.sePrescriptionPrescriptionId = sePrescriptionPrescriptionId;
    }

    public SeUserDTO getUserId() {
        return userId;
    }

    public void setUserId(SeUserDTO userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "SeUserMedicineDTO{" +
                "userMedicineId=" + userMedicineId +
                ", dose=" + dose +
                ", frecuency=" + frecuency +
                ", version=" + version +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                ", medicineId=" + medicineId +
                ", sePrescriptionPrescriptionId=" + sePrescriptionPrescriptionId +
                ", userId=" + userId +
                '}';
    }
}
