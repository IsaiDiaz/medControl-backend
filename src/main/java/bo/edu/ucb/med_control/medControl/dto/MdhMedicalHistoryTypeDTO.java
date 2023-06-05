package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.MdhMedicalHistoryType;
import java.util.Date;
import java.util.List;

public class MdhMedicalHistoryTypeDTO {
    private Integer medicalHistoryTypeId;
    private String medicalHistoryName;
    private int version;
    private boolean status;
    private int txUser;
    private String txHost;
    private Date txDate;
    private List<MdhMedicalHistoryDTO> mdhMedicalHistoryList;

    public MdhMedicalHistoryTypeDTO() {
    }

    public MdhMedicalHistoryTypeDTO(Integer medicalHistoryTypeId, String medicalHistoryName, int version, boolean status,
                                    int txUser, String txHost, Date txDate, List<MdhMedicalHistoryDTO> mdhMedicalHistoryList) {
        this.medicalHistoryTypeId = medicalHistoryTypeId;
        this.medicalHistoryName = medicalHistoryName;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
        this.mdhMedicalHistoryList = mdhMedicalHistoryList;
    }

    public MdhMedicalHistoryTypeDTO(MdhMedicalHistoryType medicalHistoryType) {
        this.medicalHistoryTypeId = medicalHistoryType.getMedicalHistoryTypeId();
        this.medicalHistoryName = medicalHistoryType.getMedicalHistoryName();
        this.version = medicalHistoryType.getVersion();
        this.status = medicalHistoryType.getStatus();
        this.txUser = medicalHistoryType.getTxUser();
        this.txHost = medicalHistoryType.getTxHost();
        this.txDate = medicalHistoryType.getTxDate();
    }

    public Integer getMedicalHistoryTypeId() {
        return medicalHistoryTypeId;
    }

    public void setMedicalHistoryTypeId(Integer medicalHistoryTypeId) {
        this.medicalHistoryTypeId = medicalHistoryTypeId;
    }

    public String getMedicalHistoryName() {
        return medicalHistoryName;
    }

    public void setMedicalHistoryName(String medicalHistoryName) {
        this.medicalHistoryName = medicalHistoryName;
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

    public List<MdhMedicalHistoryDTO> getMdhMedicalHistoryList() {
        return mdhMedicalHistoryList;
    }

    public void setMdhMedicalHistoryList(List<MdhMedicalHistoryDTO> mdhMedicalHistoryList) {
        this.mdhMedicalHistoryList = mdhMedicalHistoryList;
    }

    public MdhMedicalHistoryType toEntity() {
        MdhMedicalHistoryType medicalHistoryType = new MdhMedicalHistoryType();
        medicalHistoryType.setMedicalHistoryTypeId(this.medicalHistoryTypeId);
        medicalHistoryType.setMedicalHistoryName(this.medicalHistoryName);
        medicalHistoryType.setVersion(this.version);
        medicalHistoryType.setStatus(this.status);
        medicalHistoryType.setTxUser(this.txUser);
        medicalHistoryType.setTxHost(this.txHost);
        medicalHistoryType.setTxDate(this.txDate);
        return medicalHistoryType;
    }

    @Override
    public String toString() {
        return "MdhMedicalHistoryTypeDTO{" +
                "medicalHistoryTypeId=" + medicalHistoryTypeId +
                ", medicalHistoryName='" + medicalHistoryName + '\'' +
                ", version=" + version +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                ", mdhMedicalHistoryList=" + mdhMedicalHistoryList +
                '}';
    }
}
