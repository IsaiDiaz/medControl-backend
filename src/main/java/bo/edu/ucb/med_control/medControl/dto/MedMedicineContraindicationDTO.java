package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.MedMedicineContraindication;
import bo.edu.ucb.med_control.medControl.entity.SeMedicine;
import java.util.Date;

public class MedMedicineContraindicationDTO {

    private Integer medicineContraindicationId;
    private int version;
    private boolean status;
    private int txUser;
    private String txHost;
    private Date txDate;
    private Integer medicineFirstId;
    private Integer medicineSecondId;

    public MedMedicineContraindicationDTO() {}

    public MedMedicineContraindicationDTO(MedMedicineContraindication medMedicineContraindication) {
        this.medicineContraindicationId = medMedicineContraindication.getMedicineContraindicationId();
        this.version = medMedicineContraindication.getVersion();
        this.status = medMedicineContraindication.getStatus();
        this.txUser = medMedicineContraindication.getTxUser();
        this.txHost = medMedicineContraindication.getTxHost();
        this.txDate = medMedicineContraindication.getTxDate();
        this.medicineFirstId = medMedicineContraindication.getMedicineFirstId().getMedicineId();
        this.medicineSecondId = medMedicineContraindication.getMedicineSecondId().getMedicineId();
    }

    public MedMedicineContraindicationDTO(Integer medicineContraindicationId) {
        this.medicineContraindicationId = medicineContraindicationId;
    }

    public MedMedicineContraindicationDTO(Integer medicineContraindicationId, int version, boolean status, int txUser, String txHost, Date txDate, Integer medicineFirstId, Integer medicineSecondId) {
        this.medicineContraindicationId = medicineContraindicationId;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
        this.medicineFirstId = medicineFirstId;
        this.medicineSecondId = medicineSecondId;
    }

    // Getters and setters...

    public Integer getMedicineContraindicationId() {
        return medicineContraindicationId;
    }

    public void setMedicineContraindicationId(Integer medicineContraindicationId) {
        this.medicineContraindicationId = medicineContraindicationId;
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

    public Integer getMedicineFirstId() {
        return medicineFirstId;
    }

    public void setMedicineFirstId(Integer medicineFirstId) {
        this.medicineFirstId = medicineFirstId;
    }

    public Integer getMedicineSecondId() {
        return medicineSecondId;
    }

    public void setMedicineSecondId(Integer medicineSecondId) {
        this.medicineSecondId = medicineSecondId;
    }

    public MedMedicineContraindication toEntity() {
        MedMedicineContraindication medMedicineContraindication = new MedMedicineContraindication();
        medMedicineContraindication.setMedicineContraindicationId(this.medicineContraindicationId);
        medMedicineContraindication.setVersion(this.version);
        medMedicineContraindication.setStatus(this.status);
        medMedicineContraindication.setTxUser(this.txUser);
        medMedicineContraindication.setTxHost(this.txHost);
        medMedicineContraindication.setTxDate(this.txDate);

        SeMedicine medicineFirst = new SeMedicine();
        medicineFirst.setMedicineId(this.medicineFirstId);
        medMedicineContraindication.setMedicineFirstId(medicineFirst);

        SeMedicine medicineSecond = new SeMedicine();
        medicineSecond.setMedicineId(this.medicineSecondId);
        medMedicineContraindication.setMedicineSecondId(medicineSecond);

        return medMedicineContraindication;
    }

    @Override
    public String toString() {
        return "MedMedicineContraindicationDTO{" +
                "medicineContraindicationId=" + medicineContraindicationId +
                ", version=" + version +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                ", medicineFirstId=" + medicineFirstId +
                ", medicineSecondId=" + medicineSecondId +
                '}';
    }
}
