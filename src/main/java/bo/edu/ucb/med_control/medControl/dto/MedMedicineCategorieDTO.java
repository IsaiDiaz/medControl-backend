package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.MedMedicineCategorie;
import bo.edu.ucb.med_control.medControl.entity.MedMedicineType;
import bo.edu.ucb.med_control.medControl.entity.SeMedicine;

import java.util.Date;

public class MedMedicineCategorieDTO {

    private Integer medicineCategorieId;
    private int version;
    private boolean status;
    private int txUser;
    private String txHost;
    private Date txDate;
    private Integer medicineTypeId;
    private Integer medicineId;

    public MedMedicineCategorieDTO() {}

    public MedMedicineCategorieDTO(MedMedicineCategorie medMedicineCategorie) {
        this.medicineCategorieId = medMedicineCategorie.getMedicineCategorieId();
        this.version = medMedicineCategorie.getVersion();
        this.status = medMedicineCategorie.getStatus();
        this.txUser = medMedicineCategorie.getTxUser();
        this.txHost = medMedicineCategorie.getTxHost();
        this.txDate = medMedicineCategorie.getTxDate();
        this.medicineTypeId = medMedicineCategorie.getMedicineTypeId().getMedicineTypeId();
        this.medicineId = medMedicineCategorie.getMedicineId().getMedicineId();
    }

    public MedMedicineCategorieDTO(Integer medicineCategorieId) {
        this.medicineCategorieId = medicineCategorieId;
    }

    public MedMedicineCategorieDTO(Integer medicineCategorieId, int version, boolean status, int txUser, String txHost, Date txDate, Integer medicineTypeId, Integer medicineId) {
        this.medicineCategorieId = medicineCategorieId;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
        this.medicineTypeId = medicineTypeId;
        this.medicineId = medicineId;
    }

    // Getters and setters...

    public Integer getMedicineCategorieId() {
        return medicineCategorieId;
    }

    public void setMedicineCategorieId(Integer medicineCategorieId) {
        this.medicineCategorieId = medicineCategorieId;
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

    public Integer getMedicineTypeId() {
        return medicineTypeId;
    }

    public void setMedicineTypeId(Integer medicineTypeId) {
        this.medicineTypeId = medicineTypeId;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public MedMedicineCategorie toEntity() {
        MedMedicineCategorie medMedicineCategorie = new MedMedicineCategorie();
        medMedicineCategorie.setMedicineCategorieId(this.medicineCategorieId);
        medMedicineCategorie.setVersion(this.version);
        medMedicineCategorie.setStatus(this.status);
        medMedicineCategorie.setTxUser(this.txUser);
        medMedicineCategorie.setTxHost(this.txHost);
        medMedicineCategorie.setTxDate(this.txDate);

        MedMedicineType medicineType = new MedMedicineType();
        medicineType.setMedicineTypeId(this.medicineTypeId);
        medMedicineCategorie.setMedicineTypeId(medicineType);

        SeMedicine seMedicine = new SeMedicine();
        seMedicine.setMedicineId(this.medicineId);
        medMedicineCategorie.setMedicineId(seMedicine);

        return medMedicineCategorie;
    }

    @Override
    public String toString() {
        return "MedMedicineCategorieDTO{" +
                "medicineCategorieId=" + medicineCategorieId +
                ", version=" + version +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                ", medicineTypeId=" + medicineTypeId +
                ", medicineId=" + medicineId +
                '}';
    }
}
