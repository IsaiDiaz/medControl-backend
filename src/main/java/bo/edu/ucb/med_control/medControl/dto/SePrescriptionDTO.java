package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.SePrescription;
import java.util.Date;
import java.util.List;

public class SePrescriptionDTO {
    private Integer prescriptionId;
    private int medicineId;
    private int prescriptionDosage;
    private String prescriptionDosageUnit;
    private int prescriptionFrecuency;
    private int version;
    private boolean status;
    private int txUser;
    private String txHost;
    private Date txDate;
    private SeUserDTO patientId;
    private SeUserDTO doctorId;
    private List<SeUserMedicineDTO> seUserMedicineList;

    public SePrescriptionDTO() {
    }

    public SePrescriptionDTO(SePrescription sePrescription) {
        this.prescriptionId = sePrescription.getPrescriptionId();
        this.medicineId = sePrescription.getMedicineId();
        this.prescriptionDosage = sePrescription.getPrescriptionDosage();
        this.prescriptionDosageUnit = sePrescription.getPrescriptionDosageUnit();
        this.prescriptionFrecuency = sePrescription.getPrescriptionFrecuency();
        this.version = sePrescription.getVersion();
        this.status = sePrescription.getStatus();
        this.txUser = sePrescription.getTxUser();
        this.txHost = sePrescription.getTxHost();
        this.txDate = sePrescription.getTxDate();
        this.patientId = new SeUserDTO(sePrescription.getPatientId());
        this.doctorId = new SeUserDTO(sePrescription.getDoctorId());
    }

    public SePrescriptionDTO(Integer prescriptionId, int medicineId, int prescriptionDosage, String prescriptionDosageUnit,
                             int prescriptionFrecuency, int version, boolean status, int txUser, String txHost, Date txDate,
                             SeUserDTO patientId, SeUserDTO doctorId) {
        this.prescriptionId = prescriptionId;
        this.medicineId = medicineId;
        this.prescriptionDosage = prescriptionDosage;
        this.prescriptionDosageUnit = prescriptionDosageUnit;
        this.prescriptionFrecuency = prescriptionFrecuency;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
        this.patientId = patientId;
        this.doctorId = doctorId;
    }

    public SePrescription toEntity() {
        SePrescription sePrescription = new SePrescription();
        sePrescription.setPrescriptionId(this.prescriptionId);
        sePrescription.setMedicineId(this.medicineId);
        sePrescription.setPrescriptionDosage(this.prescriptionDosage);
        sePrescription.setPrescriptionDosageUnit(this.prescriptionDosageUnit);
        sePrescription.setPrescriptionFrecuency(this.prescriptionFrecuency);
        sePrescription.setVersion(this.version);
        sePrescription.setStatus(this.status);
        sePrescription.setTxUser(this.txUser);
        sePrescription.setTxHost(this.txHost);
        sePrescription.setTxDate(this.txDate);
        sePrescription.setPatientId(this.patientId.toEntity());
        sePrescription.setDoctorId(this.doctorId.toEntity());
        return sePrescription;
    }

    // Getters and setters

    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public int getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }

    public int getPrescriptionDosage() {
        return prescriptionDosage;
    }

    public void setPrescriptionDosage(int prescriptionDosage) {
        this.prescriptionDosage = prescriptionDosage;
    }

    public String getPrescriptionDosageUnit() {
        return prescriptionDosageUnit;
    }

    public void setPrescriptionDosageUnit(String prescriptionDosageUnit) {
        this.prescriptionDosageUnit = prescriptionDosageUnit;
    }

    public int getPrescriptionFrecuency() {
        return prescriptionFrecuency;
    }

    public void setPrescriptionFrecuency(int prescriptionFrecuency) {
        this.prescriptionFrecuency = prescriptionFrecuency;
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

    public SeUserDTO getPatientId() {
        return patientId;
    }

    public void setPatientId(SeUserDTO patientId) {
        this.patientId = patientId;
    }

    public SeUserDTO getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(SeUserDTO doctorId) {
        this.doctorId = doctorId;
    }

    public List<SeUserMedicineDTO> getSeUserMedicineList() {
        return seUserMedicineList;
    }

    public void setSeUserMedicineList(List<SeUserMedicineDTO> seUserMedicineList) {
        this.seUserMedicineList = seUserMedicineList;
    }

    @Override
    public String toString() {
        return "SePrescriptionDTO{" +
                "prescriptionId=" + prescriptionId +
                ", medicineId=" + medicineId +
                ", prescriptionDosage=" + prescriptionDosage +
                ", prescriptionDosageUnit='" + prescriptionDosageUnit + '\'' +
                ", prescriptionFrecuency=" + prescriptionFrecuency +
                ", version=" + version +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                ", patientId=" + patientId +
                ", doctorId=" + doctorId +
                ", seUserMedicineList=" + seUserMedicineList +
                '}';
    }
}
