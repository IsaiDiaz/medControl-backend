package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.MdhKinship;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MdhKinshipDTO {
    private Integer kinshipId;
    private String kinshipName;
    private String kinshipDescription;
    @JsonIgnore
    private int version;
    @JsonIgnore
    private boolean status;
    @JsonIgnore
    private int txUser;
    @JsonIgnore
    private String txHost;
    @JsonIgnore
    private Date txDate;
    private List<MdhMedicalHistoryDTO> mdhMedicalHistoryList;

    public MdhKinshipDTO() {
    }

    public MdhKinshipDTO(Integer kinshipId) {
        this.kinshipId = kinshipId;
    }

    public MdhKinshipDTO(Integer kinshipId, String kinshipName, String kinshipDescription, int version, boolean status,
                         int txUser, String txHost, Date txDate, List<MdhMedicalHistoryDTO> mdhMedicalHistoryList) {
        this.kinshipId = kinshipId;
        this.kinshipName = kinshipName;
        this.kinshipDescription = kinshipDescription;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
        this.mdhMedicalHistoryList = mdhMedicalHistoryList;
    }

    public MdhKinshipDTO(MdhKinship kinship) {
        this.kinshipId = kinship.getKinshipId();
        this.kinshipName = kinship.getKinshipName();
        this.kinshipDescription = kinship.getKinshipDescription();
        this.version = kinship.getVersion();
        this.status = kinship.getStatus();
        this.txUser = kinship.getTxUser();
        this.txHost = kinship.getTxHost();
        this.txDate = kinship.getTxDate();
    }

    public Integer getKinshipId() {
        return kinshipId;
    }

    public void setKinshipId(Integer kinshipId) {
        this.kinshipId = kinshipId;
    }

    public String getKinshipName() {
        return kinshipName;
    }

    public void setKinshipName(String kinshipName) {
        this.kinshipName = kinshipName;
    }

    public String getKinshipDescription() {
        return kinshipDescription;
    }

    public void setKinshipDescription(String kinshipDescription) {
        this.kinshipDescription = kinshipDescription;
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

    public MdhKinship toEntity() {
        MdhKinship kinship = new MdhKinship();
        kinship.setKinshipId(this.kinshipId);
        kinship.setKinshipName(this.kinshipName);
        kinship.setKinshipDescription(this.kinshipDescription);
        kinship.setVersion(this.version);
        kinship.setStatus(this.status);
        kinship.setTxUser(this.txUser);
        kinship.setTxHost(this.txHost);
        kinship.setTxDate(this.txDate);
        return kinship;
    }

    public static List<MdhKinshipDTO> fromList(List<MdhKinship> list) {
        List<MdhKinshipDTO> newList = new ArrayList<>();
        for (MdhKinship mdhKinship : list) {
            MdhKinshipDTO kinshipDTO = new MdhKinshipDTO();
            kinshipDTO.setKinshipId(mdhKinship.getKinshipId());
            // Establecer otras propiedades de kinshipDTO si es necesario
            newList.add(kinshipDTO);
        }
        return newList;
    }

    @Override
    public String toString() {
        return "MdhKinshipDTO{" +
                "kinshipId=" + kinshipId +
                ", kinshipName='" + kinshipName + '\'' +
                ", kinshipDescription='" + kinshipDescription + '\'' +
                ", version=" + version +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                ", mdhMedicalHistoryList=" + mdhMedicalHistoryList +
                '}';
    }
}

