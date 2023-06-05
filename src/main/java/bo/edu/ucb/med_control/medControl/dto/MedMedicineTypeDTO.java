package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.MedMedicineType;
import bo.edu.ucb.med_control.medControl.entity.MedMedicineCategorie;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class MedMedicineTypeDTO {

    private Integer medicineTypeId;
    private String medicineTypeName;
    private int version;
    private boolean status;
    private int txUser;
    private String txHost;
    private Date txDate;
    private List<MedMedicineCategorieDTO> medMedicineCategorieList;

    public MedMedicineTypeDTO() {}

    public MedMedicineTypeDTO(MedMedicineType medMedicineType) {
        this.medicineTypeId = medMedicineType.getMedicineTypeId();
        this.medicineTypeName = medMedicineType.getMedicineTypeName();
        this.version = medMedicineType.getVersion();
        this.status = medMedicineType.getStatus();
        this.txUser = medMedicineType.getTxUser();
        this.txHost = medMedicineType.getTxHost();
        this.txDate = medMedicineType.getTxDate();
        this.medMedicineCategorieList = medMedicineType.getMedMedicineCategorieList().stream()
                .map(MedMedicineCategorieDTO::new)
                .collect(Collectors.toList());
    }

    public MedMedicineTypeDTO(Integer medicineTypeId) {
        this.medicineTypeId = medicineTypeId;
    }

    public MedMedicineTypeDTO(Integer medicineTypeId, String medicineTypeName, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.medicineTypeId = medicineTypeId;
        this.medicineTypeName = medicineTypeName;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    // Getters and setters...

    public Integer getMedicineTypeId() {
        return medicineTypeId;
    }

    public void setMedicineTypeId(Integer medicineTypeId) {
        this.medicineTypeId = medicineTypeId;
    }

    public String getMedicineTypeName() {
        return medicineTypeName;
    }

    public void setMedicineTypeName(String medicineTypeName) {
        this.medicineTypeName = medicineTypeName;
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

    public List<MedMedicineCategorieDTO> getMedMedicineCategorieList() {
        return medMedicineCategorieList;
    }

    public void setMedMedicineCategorieList(List<MedMedicineCategorieDTO> medMedicineCategorieList) {
        this.medMedicineCategorieList = medMedicineCategorieList;
    }

    public MedMedicineType toEntity() {
        MedMedicineType medMedicineType = new MedMedicineType();
        medMedicineType.setMedicineTypeId(this.medicineTypeId);
        medMedicineType.setMedicineTypeName(this.medicineTypeName);
        medMedicineType.setVersion(this.version);
        medMedicineType.setStatus(this.status);
        medMedicineType.setTxUser(this.txUser);
        medMedicineType.setTxHost(this.txHost);
        medMedicineType.setTxDate(this.txDate);

        List<MedMedicineCategorie> medMedicineCategories = this.medMedicineCategorieList.stream()
                .map(MedMedicineCategorieDTO::toEntity)
                .collect(Collectors.toList());
        medMedicineType.setMedMedicineCategorieList(medMedicineCategories);

        return medMedicineType;
    }

    @Override
    public String toString() {
        return "MedMedicineTypeDTO{" +
                "medicineTypeId=" + medicineTypeId +
                ", medicineTypeName='" + medicineTypeName + '\'' +
                ", version=" + version +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                ", medMedicineCategorieList=" + medMedicineCategorieList +
                '}';
    }
}
