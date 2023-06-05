package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class MdiMedicalSpecialityDTO {

    private Integer medicalSpecialityId;
    private String medicalSpecialityName;
    private String medicalSpecialityDescription;
    private int version;
    private int status;
    private int txUser;
    private String txHost;
    private Date txDate;
    private List<MdiDoctorMedicalSpecialityDTO> mdiDoctorMedicalSpecialityList;

    public MdiMedicalSpecialityDTO() {}

    public MdiMedicalSpecialityDTO(MdiMedicalSpeciality medicalSpeciality) {
        this.medicalSpecialityId = medicalSpeciality.getMedicalSpecialityId();
        this.medicalSpecialityName = medicalSpeciality.getMedicalSpecialityName();
        this.medicalSpecialityDescription = medicalSpeciality.getMedicalSpecialityDescription();
        this.version = medicalSpeciality.getVersion();
        this.status = medicalSpeciality.getStatus();
        this.txUser = medicalSpeciality.getTxUser();
        this.txHost = medicalSpeciality.getTxHost();
        this.txDate = medicalSpeciality.getTxDate();
        this.mdiDoctorMedicalSpecialityList = medicalSpeciality.getMdiDoctorMedicalSpecialityList().stream()
                .map(MdiDoctorMedicalSpecialityDTO::new)
                .collect(Collectors.toList());
    }

    public MdiMedicalSpecialityDTO(Integer medicalSpecialityId, String medicalSpecialityName, String medicalSpecialityDescription, int version, int status, int txUser, String txHost, Date txDate, List<MdiDoctorMedicalSpecialityDTO> mdiDoctorMedicalSpecialityList) {
        this.medicalSpecialityId = medicalSpecialityId;
        this.medicalSpecialityName = medicalSpecialityName;
        this.medicalSpecialityDescription = medicalSpecialityDescription;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
        this.mdiDoctorMedicalSpecialityList = mdiDoctorMedicalSpecialityList;
    }

    public Integer getMedicalSpecialityId() {
        return medicalSpecialityId;
    }

    public void setMedicalSpecialityId(Integer medicalSpecialityId) {
        this.medicalSpecialityId = medicalSpecialityId;
    }

    public String getMedicalSpecialityName() {
        return medicalSpecialityName;
    }

    public void setMedicalSpecialityName(String medicalSpecialityName) {
        this.medicalSpecialityName = medicalSpecialityName;
    }

    public String getMedicalSpecialityDescription() {
        return medicalSpecialityDescription;
    }

    public void setMedicalSpecialityDescription(String medicalSpecialityDescription) {
        this.medicalSpecialityDescription = medicalSpecialityDescription;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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

    public List<MdiDoctorMedicalSpecialityDTO> getMdiDoctorMedicalSpecialityList() {
        return mdiDoctorMedicalSpecialityList;
    }

    public void setMdiDoctorMedicalSpecialityList(List<MdiDoctorMedicalSpecialityDTO> mdiDoctorMedicalSpecialityList) {
        this.mdiDoctorMedicalSpecialityList = mdiDoctorMedicalSpecialityList;
    }

    public MdiMedicalSpeciality toEntity() {
        MdiMedicalSpeciality medicalSpeciality = new MdiMedicalSpeciality();
        medicalSpeciality.setMedicalSpecialityId(this.medicalSpecialityId);
        medicalSpeciality.setMedicalSpecialityName(this.medicalSpecialityName);
        medicalSpeciality.setMedicalSpecialityDescription(this.medicalSpecialityDescription);
        medicalSpeciality.setVersion(this.version);
        medicalSpeciality.setStatus(this.status);
        medicalSpeciality.setTxUser(this.txUser);
        medicalSpeciality.setTxHost(this.txHost);
        medicalSpeciality.setTxDate(this.txDate);
        medicalSpeciality.setMdiDoctorMedicalSpecialityList(this.mdiDoctorMedicalSpecialityList.stream()
                .map(MdiDoctorMedicalSpecialityDTO::toEntity)
                .collect(Collectors.toList()));
        return medicalSpeciality;
    }
}
