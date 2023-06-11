package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class SeUserDTO {

    @JsonProperty("userId")
    private Integer userId;
    private String username;
    @JsonIgnore
    private String secret;
    @JsonIgnore
    private int userPictureId;
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
    @JsonIgnore
    private List<SePrescriptionDTO> sePrescriptionList;
    @JsonIgnore
    private List<SePrescriptionDTO> sePrescriptionList1;
    @JsonIgnore
    private List<SeDoctorDTO> seDoctorList;
    @JsonIgnore
    private List<DoctorPatientDTO> doctorPatientList;
    @JsonIgnore
    private List<SeUserGroupDTO> seUserGroupList;
    @JsonIgnore
    private List<MaAppointmentDTO> maAppointmentList;
    @JsonIgnore
    private List<MaAppointmentDTO> maAppointmentList1;
    private SePersonDTO personId;
    @JsonIgnore
    private List<SeUserMedicineDTO> seUserMedicineList;
    @JsonIgnore
    private List<SePatientDTO> sePatientList;

    public SeUserDTO() {
        this.sePrescriptionList = new ArrayList<>();
        this.sePrescriptionList1 = new ArrayList<>();
        this.seDoctorList = new ArrayList<>();
        this.doctorPatientList = new ArrayList<>();
        this.seUserGroupList = new ArrayList<>();
        this.maAppointmentList = new ArrayList<>();
        this.maAppointmentList1 = new ArrayList<>();
        this.seUserMedicineList = new ArrayList<>();
        this.sePatientList = new ArrayList<>();
    }

    public SeUserDTO(SeUser seUser) {
        this.userId = seUser.getUserId();
        this.username = seUser.getUsername();
        this.secret = seUser.getSecret();
        this.userPictureId = seUser.getUserPictureId();
        this.version = seUser.getVersion();
        this.status = seUser.getStatus();
        this.txUser = seUser.getTxUser();
        this.txHost = seUser.getTxHost();
        this.txDate = seUser.getTxDate();
        this.personId = new SePersonDTO(seUser.getPersonId());
    }

    private List<SePrescriptionDTO> mapSePrescriptionList(List<SePrescription> sePrescriptions) {
        if (sePrescriptions != null) {
            return sePrescriptions.stream()
                    .map(SePrescriptionDTO::new)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private List<SeDoctorDTO> mapSeDoctorList(List<SeDoctor> seDoctors) {
        if (seDoctors != null) {
            return seDoctors.stream()
                    .map(SeDoctorDTO::new)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private List<DoctorPatientDTO> mapDoctorPatientList(List<DoctorPatient> doctorPatients) {
        if (doctorPatients != null) {
            return doctorPatients.stream()
                    .map(DoctorPatientDTO::new)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private List<SeUserGroupDTO> mapSeUserGroupList(List<SeUserGroup> seUserGroups) {
        if (seUserGroups != null) {
            return seUserGroups.stream()
                    .map(SeUserGroupDTO::new)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private List<MaAppointmentDTO> mapMaAppointmentList(List<MaAppointment> maAppointments) {
        if (maAppointments != null) {
            return maAppointments.stream()
                    .map(MaAppointmentDTO::new)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private List<SeUserMedicineDTO> mapSeUserMedicineList(List<SeUserMedicine> seUserMedicines) {
        if (seUserMedicines != null) {
            return seUserMedicines.stream()
                    .map(SeUserMedicineDTO::new)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private List<SePatientDTO> mapSePatientList(List<SePatient> sePatients) {
        if (sePatients != null) {
            return sePatients.stream()
                    .map(SePatientDTO::new)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public SeUserDTO(Integer userId, String username, String secret, int userPictureId, int version, boolean status, int txUser, String txHost, Date txDate, List<SePrescriptionDTO> sePrescriptionList, List<SePrescriptionDTO> sePrescriptionList1, List<SeDoctorDTO> seDoctorList, List<DoctorPatientDTO> doctorPatientList, List<SeUserGroupDTO> seUserGroupList, List<MaAppointmentDTO> maAppointmentList, List<MaAppointmentDTO> maAppointmentList1, SePersonDTO personId, List<SeUserMedicineDTO> seUserMedicineList, List<SePatientDTO> sePatientList) {
        this.userId = userId;
        this.username = username;
        this.secret = secret;
        this.userPictureId = userPictureId;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
        this.sePrescriptionList = sePrescriptionList;
        this.sePrescriptionList1 = sePrescriptionList1;
        this.seDoctorList = seDoctorList;
        this.doctorPatientList = doctorPatientList;
        this.seUserGroupList = seUserGroupList;
        this.maAppointmentList = maAppointmentList;
        this.maAppointmentList1 = maAppointmentList1;
        this.personId = personId;
        this.seUserMedicineList = seUserMedicineList;
        this.sePatientList = sePatientList;
    }

    public SeUserDTO (Integer userId){
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public int getUserPictureId() {
        return userPictureId;
    }

    public void setUserPictureId(int userPictureId) {
        this.userPictureId = userPictureId;
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

    public List<SePrescriptionDTO> getSePrescriptionList() {
        return sePrescriptionList;
    }

    public void setSePrescriptionList(List<SePrescriptionDTO> sePrescriptionList) {
        this.sePrescriptionList = sePrescriptionList;
    }

    public List<SePrescriptionDTO> getSePrescriptionList1() {
        return sePrescriptionList1;
    }

    public void setSePrescriptionList1(List<SePrescriptionDTO> sePrescriptionList1) {
        this.sePrescriptionList1 = sePrescriptionList1;
    }

    public List<SeDoctorDTO> getSeDoctorList() {
        return seDoctorList;
    }

    public void setSeDoctorList(List<SeDoctorDTO> seDoctorList) {
        this.seDoctorList = seDoctorList;
    }

    public List<DoctorPatientDTO> getDoctorPatientList() {
        return doctorPatientList;
    }

    public void setDoctorPatientList(List<DoctorPatientDTO> doctorPatientList) {
        this.doctorPatientList = doctorPatientList;
    }

    public List<SeUserGroupDTO> getSeUserGroupList() {
        return seUserGroupList;
    }

    public void setSeUserGroupList(List<SeUserGroupDTO> seUserGroupList) {
        this.seUserGroupList = seUserGroupList;
    }

    public List<MaAppointmentDTO> getMaAppointmentList() {
        return maAppointmentList;
    }

    public void setMaAppointmentList(List<MaAppointmentDTO> maAppointmentList) {
        this.maAppointmentList = maAppointmentList;
    }

    public List<MaAppointmentDTO> getMaAppointmentList1() {
        return maAppointmentList1;
    }

    public void setMaAppointmentList1(List<MaAppointmentDTO> maAppointmentList1) {
        this.maAppointmentList1 = maAppointmentList1;
    }

    public SePersonDTO getPersonId() {
        return personId;
    }

    public void setPersonId(SePersonDTO personId) {
        this.personId = personId;
    }

    public List<SeUserMedicineDTO> getSeUserMedicineList() {
        return seUserMedicineList;
    }

    public void setSeUserMedicineList(List<SeUserMedicineDTO> seUserMedicineList) {
        this.seUserMedicineList = seUserMedicineList;
    }

    public List<SePatientDTO> getSePatientList() {
        return sePatientList;
    }

    public void setSePatientList(List<SePatientDTO> sePatientList) {
        this.sePatientList = sePatientList;
    }

    // Getters and setters...

    public SeUser toEntity() {
        SeUser seUser = new SeUser();
        seUser.setUserId(this.userId);
        seUser.setUsername(this.username);
        seUser.setSecret(this.secret);
        seUser.setUserPictureId(this.userPictureId);
        seUser.setVersion(this.version);
        seUser.setStatus(this.status);
        seUser.setTxUser(this.txUser);
        seUser.setTxHost(this.txHost);
        seUser.setTxDate(this.txDate);

        seUser.setSePrescriptionList(mapSePrescriptionDTOList(this.sePrescriptionList));
        seUser.setSePrescriptionList1(mapSePrescriptionDTOList(this.sePrescriptionList1));
        seUser.setSeDoctorList(mapSeDoctorDTOList(this.seDoctorList));
        seUser.setDoctorPatientList(mapDoctorPatientDTOList(this.doctorPatientList));
        seUser.setSeUserGroupList(mapSeUserGroupDTOList(this.seUserGroupList));
        seUser.setMaAppointmentList(mapMaAppointmentDTOList(this.maAppointmentList));
        seUser.setMaAppointmentList1(mapMaAppointmentDTOList(this.maAppointmentList1));
        if (this.personId != null){
            seUser.setPersonId(this.personId.toEntity());
        }
        seUser.setSeUserMedicineList(mapSeUserMedicineDTOList(this.seUserMedicineList));
        seUser.setSePatientList(mapSePatientDTOList(this.sePatientList));


        return seUser;
    }

    private List<SePrescription> mapSePrescriptionDTOList(List<SePrescriptionDTO> sePrescriptionDTOs) {
        if (sePrescriptionDTOs != null) {
            return sePrescriptionDTOs.stream()
                    .map(SePrescriptionDTO::toEntity)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private List<SeDoctor> mapSeDoctorDTOList(List<SeDoctorDTO> seDoctorDTOs) {
        if (seDoctorDTOs != null) {
            return seDoctorDTOs.stream()
                    .map(SeDoctorDTO::toEntity)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private List<DoctorPatient> mapDoctorPatientDTOList(List<DoctorPatientDTO> doctorPatientDTOs) {
        if (doctorPatientDTOs != null) {
            return doctorPatientDTOs.stream()
                    .map(DoctorPatientDTO::toEntity)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private List<SeUserGroup> mapSeUserGroupDTOList(List<SeUserGroupDTO> seUserGroupDTOs) {
        if (seUserGroupDTOs != null) {
            return seUserGroupDTOs.stream()
                    .map(SeUserGroupDTO::toEntity)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private List<MaAppointment> mapMaAppointmentDTOList(List<MaAppointmentDTO> maAppointmentDTOs) {
        if (maAppointmentDTOs != null) {
            return maAppointmentDTOs.stream()
                    .map(MaAppointmentDTO::toEntity)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private List<SeUserMedicine> mapSeUserMedicineDTOList(List<SeUserMedicineDTO> seUserMedicineDTOs) {
        if (seUserMedicineDTOs != null) {
            return seUserMedicineDTOs.stream()
                    .map(SeUserMedicineDTO::toEntity)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    private List<SePatient> mapSePatientDTOList(List<SePatientDTO> sePatientDTOs) {
        if (sePatientDTOs != null) {
            return sePatientDTOs.stream()
                    .map(SePatientDTO::toEntity)
                    .collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    @Override
    public String toString() {
        return "SeUserDTO{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", secret='" + secret + '\'' +
                ", userPictureId=" + userPictureId +
                ", version=" + version +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                ", sePrescriptionList=" + sePrescriptionList +
                ", sePrescriptionList1=" + sePrescriptionList1 +
                ", seDoctorList=" + seDoctorList +
                ", doctorPatientList=" + doctorPatientList +
                ", seUserGroupList=" + seUserGroupList +
                ", maAppointmentList=" + maAppointmentList +
                ", maAppointmentList1=" + maAppointmentList1 +
                ", personId=" + personId +
                ", seUserMedicineList=" + seUserMedicineList +
                ", sePatientList=" + sePatientList +
                '}';
    }
}
