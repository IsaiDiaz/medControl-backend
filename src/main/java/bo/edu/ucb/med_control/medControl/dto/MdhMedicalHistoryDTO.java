package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.MdhKinship;
import bo.edu.ucb.med_control.medControl.entity.MdhMedicalHistory;
import bo.edu.ucb.med_control.medControl.entity.MdhMedicalHistoryType;
import bo.edu.ucb.med_control.medControl.entity.SePatient;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class MdhMedicalHistoryDTO implements Serializable {
    private Integer medicalHistory;
    private String relativesName;
    private int medicalHistoryDocumentId;
    private int version;
    private boolean status;
    private int txUser;
    private String txHost;
    private Date txDate;
    private MdhKinshipDTO kinshipId;
    private MdhMedicalHistoryTypeDTO medicalHistoryTypeId;
    private SePatientDTO patientId;

    public MdhMedicalHistoryDTO() {
    }

    public MdhMedicalHistoryDTO(Integer medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public MdhMedicalHistoryDTO(Integer medicalHistory, String relativesName, int medicalHistoryDocumentId, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.medicalHistory = medicalHistory;
        this.relativesName = relativesName;
        this.medicalHistoryDocumentId = medicalHistoryDocumentId;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public MdhMedicalHistoryDTO(MdhMedicalHistory medicalHistory) {
        this.medicalHistory = medicalHistory.getMedicalHistory();
        this.relativesName = medicalHistory.getRelativesName();
        this.medicalHistoryDocumentId = medicalHistory.getMedicalHistoryDocumentId();
        this.version = medicalHistory.getVersion();
        this.status = medicalHistory.getStatus();
        this.txUser = medicalHistory.getTxUser();
        this.txHost = medicalHistory.getTxHost();
        this.txDate = medicalHistory.getTxDate();
    }

    // Getters and setters

    public Integer getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(Integer medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getRelativesName() {
        return relativesName;
    }

    public void setRelativesName(String relativesName) {
        this.relativesName = relativesName;
    }

    public int getMedicalHistoryDocumentId() {
        return medicalHistoryDocumentId;
    }

    public void setMedicalHistoryDocumentId(int medicalHistoryDocumentId) {
        this.medicalHistoryDocumentId = medicalHistoryDocumentId;
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

    public MdhKinshipDTO getKinshipId() {
        return kinshipId;
    }

    public void setKinshipId(MdhKinshipDTO kinshipId) {
        this.kinshipId = kinshipId;
    }

    public MdhMedicalHistoryTypeDTO getMedicalHistoryTypeId() {
        return medicalHistoryTypeId;
    }

    public void setMedicalHistoryTypeId(MdhMedicalHistoryTypeDTO medicalHistoryTypeId) {
        this.medicalHistoryTypeId = medicalHistoryTypeId;
    }

    public SePatientDTO getPatientId() {
        return patientId;
    }

    public void setPatientId(SePatientDTO patientId) {
        this.patientId = patientId;
    }

    public MdhMedicalHistory toEntity() {
        MdhMedicalHistory entity = new MdhMedicalHistory();
        entity.setMedicalHistory(this.medicalHistory);
        entity.setRelativesName(this.relativesName);
        entity.setMedicalHistoryDocumentId(this.medicalHistoryDocumentId);
        entity.setVersion(this.version);
        entity.setStatus(this.status);
        entity.setTxUser(this.txUser);
        entity.setTxHost(this.txHost);
        entity.setTxDate(this.txDate);

        // Convertir la referencia a MdhKinship de DTO a Entity
        if (this.kinshipId != null) {
            MdhKinship kinship = new MdhKinship();
            kinship.setKinshipId(this.kinshipId.getKinshipId());
            entity.setKinshipId(kinship);
        }

        // Convertir la referencia a MdhMedicalHistoryType de DTO a Entity
        if (this.medicalHistoryTypeId != null) {
            MdhMedicalHistoryType historyType = new MdhMedicalHistoryType();
            historyType.setMedicalHistoryTypeId(this.medicalHistoryTypeId.getMedicalHistoryTypeId());
            entity.setMedicalHistoryTypeId(historyType);
        }

        // Convertir la referencia a SePatient de DTO a Entity
        if (this.patientId != null) {
            SePatient patient = new SePatient();
            patient.setPatientId(this.patientId.getPatientId());
            entity.setPatientId(patient);
        }

        return entity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medicalHistory != null ? medicalHistory.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof MdhMedicalHistoryDTO)) {
            return false;
        }
        MdhMedicalHistoryDTO other = (MdhMedicalHistoryDTO) object;
        if ((this.medicalHistory == null && other.medicalHistory != null) || (this.medicalHistory != null && !this.medicalHistory.equals(other.medicalHistory))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MdhMedicalHistoryDTO{" +
                "medicalHistory=" + medicalHistory +
                ", relativesName='" + relativesName + '\'' +
                ", medicalHistoryDocumentId=" + medicalHistoryDocumentId +
                ", version=" + version +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                ", kinshipId=" + kinshipId +
                ", medicalHistoryTypeId=" + medicalHistoryTypeId +
                ", patientId=" + patientId +
                '}';
    }

    public static List<MdhMedicalHistoryDTO> fromList(List<MdhMedicalHistory> list) {
        //Converitr de Entity a DTO
        List<MdhMedicalHistoryDTO> newList = new java.util.ArrayList<>(list.size());
        for (MdhMedicalHistory mdhMedicalHistory : list) {
            newList.add(new MdhMedicalHistoryDTO(mdhMedicalHistory));
        }

        return newList;
    }

    public static List<MdhMedicalHistory> toEntityList(List<MdhMedicalHistoryDTO> list) {
        //Converitr de DTO a Entity
        List<MdhMedicalHistory> newList = new java.util.ArrayList<>(list.size());
        for (MdhMedicalHistoryDTO mdhMedicalHistoryDTO : list) {
            newList.add(mdhMedicalHistoryDTO.toEntity());
        }

        return newList;
    }
}
