package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.*;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class SeUserDTO {

    private Integer userId;
    private String username;
    private String secret;
    private int userPictureId;
    private int version;
    private boolean status;
    private int txUser;
    private String txHost;
    private Date txDate;
    private List<SePrescriptionDTO> sePrescriptionList;
    private List<SePrescriptionDTO> sePrescriptionList1;
    private List<SeDoctorDTO> seDoctorList;
    private List<DoctorPatientDTO> doctorPatientList;
    private List<SeUserGroupDTO> seUserGroupList;
    private List<MaAppointmentDTO> maAppointmentList;
    private List<MaAppointmentDTO> maAppointmentList1;
    private SePersonDTO personId;
    private List<SeUserMedicineDTO> seUserMedicineList;
    private List<SePatientDTO> sePatientList;

    public SeUserDTO() {}

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
        this.sePrescriptionList = seUser.getSePrescriptionList().stream()
                .map(SePrescriptionDTO::new)
                .collect(Collectors.toList());
        this.sePrescriptionList1 = seUser.getSePrescriptionList1().stream()
                .map(SePrescriptionDTO::new)
                .collect(Collectors.toList());
        this.seDoctorList = seUser.getSeDoctorList().stream()
                .map(SeDoctorDTO::new)
                .collect(Collectors.toList());
        this.doctorPatientList = seUser.getDoctorPatientList().stream()
                .map(DoctorPatientDTO::new)
                .collect(Collectors.toList());
        this.seUserGroupList = seUser.getSeUserGroupList().stream()
                .map(SeUserGroupDTO::new)
                .collect(Collectors.toList());
        this.maAppointmentList = seUser.getMaAppointmentList().stream()
                .map(MaAppointmentDTO::new)
                .collect(Collectors.toList());
        this.maAppointmentList1 = seUser.getMaAppointmentList1().stream()
                .map(MaAppointmentDTO::new)
                .collect(Collectors.toList());
        this.personId = new SePersonDTO(seUser.getPersonId());
        this.seUserMedicineList = seUser.getSeUserMedicineList().stream()
                .map(SeUserMedicineDTO::new)
                .collect(Collectors.toList());
        this.sePatientList = seUser.getSePatientList().stream()
                .map(SePatientDTO::new)
                .collect(Collectors.toList());
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

        List<SePrescription> sePrescriptions = this.sePrescriptionList.stream()
                .map(SePrescriptionDTO::toEntity)
                .collect(Collectors.toList());
        seUser.setSePrescriptionList(sePrescriptions);

        List<SePrescription> sePrescriptions1 = this.sePrescriptionList1.stream()
                .map(SePrescriptionDTO::toEntity)
                .collect(Collectors.toList());
        seUser.setSePrescriptionList1(sePrescriptions1);

        List<SeDoctor> seDoctors = this.seDoctorList.stream()
                .map(SeDoctorDTO::toEntity)
                .collect(Collectors.toList());
        seUser.setSeDoctorList(seDoctors);

        List<DoctorPatient> doctorPatients = this.doctorPatientList.stream()
                .map(DoctorPatientDTO::toEntity)
                .collect(Collectors.toList());
        seUser.setDoctorPatientList(doctorPatients);

        List<SeUserGroup> seUserGroups = this.seUserGroupList.stream()
                .map(SeUserGroupDTO::toEntity)
                .collect(Collectors.toList());
        seUser.setSeUserGroupList(seUserGroups);

        List<MaAppointment> maAppointments = this.maAppointmentList.stream()
                .map(MaAppointmentDTO::toEntity)
                .collect(Collectors.toList());
        seUser.setMaAppointmentList(maAppointments);

        List<MaAppointment> maAppointments1 = this.maAppointmentList1.stream()
                .map(MaAppointmentDTO::toEntity)
                .collect(Collectors.toList());
        seUser.setMaAppointmentList1(maAppointments1);

        seUser.setPersonId(this.personId.toEntity());

        List<SeUserMedicine> seUserMedicines = this.seUserMedicineList.stream()
                .map(SeUserMedicineDTO::toEntity)
                .collect(Collectors.toList());
        seUser.setSeUserMedicineList(seUserMedicines);

        List<SePatient> sePatients = this.sePatientList.stream()
                .map(SePatientDTO::toEntity)
                .collect(Collectors.toList());
        seUser.setSePatientList(sePatients);

        return seUser;
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
