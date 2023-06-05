package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.MedMedicineCategorie;
import bo.edu.ucb.med_control.medControl.entity.MedMedicineContraindication;
import bo.edu.ucb.med_control.medControl.entity.SeMedicine;
import bo.edu.ucb.med_control.medControl.entity.SeUserMedicine;
import java.util.Date;
import java.util.List;

public class SeMedicineDTO {
    private Integer medicineId;
    private String medicineName;
    private String medicineDesc;
    private int medicinaDosage;
    private int version;
    private boolean status;
    private int txUser;
    private String txHost;
    private Date txDate;
    private List<MedMedicineContraindication> medMedicineContraindicationList;
    private List<MedMedicineContraindication> medMedicineContraindicationList1;
    private List<SeUserMedicine> seUserMedicineList;
    private List<MedMedicineCategorie> medMedicineCategorieList;

    public SeMedicineDTO() {
    }

    public SeMedicineDTO(SeMedicine seMedicine) {
        this.medicineId = seMedicine.getMedicineId();
        this.medicineName = seMedicine.getMedicineName();
        this.medicineDesc = seMedicine.getMedicineDesc();
        this.medicinaDosage = seMedicine.getMedicinaDosage();
        this.version = seMedicine.getVersion();
        this.status = seMedicine.getStatus();
        this.txUser = seMedicine.getTxUser();
        this.txHost = seMedicine.getTxHost();
        this.txDate = seMedicine.getTxDate();
        this.medMedicineContraindicationList = seMedicine.getMedMedicineContraindicationList();
        this.medMedicineContraindicationList1 = seMedicine.getMedMedicineContraindicationList1();
        this.seUserMedicineList = seMedicine.getSeUserMedicineList();
        this.medMedicineCategorieList = seMedicine.getMedMedicineCategorieList();
    }

    public SeMedicineDTO(Integer medicineId, String medicineName, String medicineDesc, int medicinaDosage,
                         int version, boolean status, int txUser, String txHost, Date txDate,
                         List<MedMedicineContraindication> medMedicineContraindicationList,
                         List<MedMedicineContraindication> medMedicineContraindicationList1,
                         List<SeUserMedicine> seUserMedicineList, List<MedMedicineCategorie> medMedicineCategorieList) {
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.medicineDesc = medicineDesc;
        this.medicinaDosage = medicinaDosage;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
        this.medMedicineContraindicationList = medMedicineContraindicationList;
        this.medMedicineContraindicationList1 = medMedicineContraindicationList1;
        this.seUserMedicineList = seUserMedicineList;
        this.medMedicineCategorieList = medMedicineCategorieList;
    }

    public SeMedicine toEntity() {
        SeMedicine seMedicine = new SeMedicine();
        seMedicine.setMedicineId(this.medicineId);
        seMedicine.setMedicineName(this.medicineName);
        seMedicine.setMedicineDesc(this.medicineDesc);
        seMedicine.setMedicinaDosage(this.medicinaDosage);
        seMedicine.setVersion(this.version);
        seMedicine.setStatus(this.status);
        seMedicine.setTxUser(this.txUser);
        seMedicine.setTxHost(this.txHost);
        seMedicine.setTxDate(this.txDate);
        seMedicine.setMedMedicineContraindicationList(this.medMedicineContraindicationList);
        seMedicine.setMedMedicineContraindicationList1(this.medMedicineContraindicationList1);
        seMedicine.setSeUserMedicineList(this.seUserMedicineList);
        seMedicine.setMedMedicineCategorieList(this.medMedicineCategorieList);
        return seMedicine;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getMedicineDesc() {
        return medicineDesc;
    }

    public void setMedicineDesc(String medicineDesc) {
        this.medicineDesc = medicineDesc;
    }

    public int getMedicinaDosage() {
        return medicinaDosage;
    }

    public void setMedicinaDosage(int medicinaDosage) {
        this.medicinaDosage = medicinaDosage;
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

    public List<MedMedicineContraindication> getMedMedicineContraindicationList() {
        return medMedicineContraindicationList;
    }

    public void setMedMedicineContraindicationList(List<MedMedicineContraindication> medMedicineContraindicationList) {
        this.medMedicineContraindicationList = medMedicineContraindicationList;
    }

    public List<MedMedicineContraindication> getMedMedicineContraindicationList1() {
        return medMedicineContraindicationList1;
    }

    public void setMedMedicineContraindicationList1(List<MedMedicineContraindication> medMedicineContraindicationList1) {
        this.medMedicineContraindicationList1 = medMedicineContraindicationList1;
    }

    public List<SeUserMedicine> getSeUserMedicineList() {
        return seUserMedicineList;
    }

    public void setSeUserMedicineList(List<SeUserMedicine> seUserMedicineList) {
        this.seUserMedicineList = seUserMedicineList;
    }

    public List<MedMedicineCategorie> getMedMedicineCategorieList() {
        return medMedicineCategorieList;
    }

    public void setMedMedicineCategorieList(List<MedMedicineCategorie> medMedicineCategorieList) {
        this.medMedicineCategorieList = medMedicineCategorieList;
    }

    @Override
    public String toString() {
        return "SeMedicineDTO{" +
                "medicineId=" + medicineId +
                ", medicineName='" + medicineName + '\'' +
                ", medicineDesc='" + medicineDesc + '\'' +
                ", medicinaDosage=" + medicinaDosage +
                ", version=" + version +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                ", medMedicineContraindicationList=" + medMedicineContraindicationList +
                ", medMedicineContraindicationList1=" + medMedicineContraindicationList1 +
                ", seUserMedicineList=" + seUserMedicineList +
                ", medMedicineCategorieList=" + medMedicineCategorieList +
                '}';
    }
}
