package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.*;
import java.util.Date;

public class MdiCertificationDTO {

    private Integer certificationId;
    private int certificationDocumentId;
    private int version;
    private boolean status;
    private int txUser;
    private String txHost;
    private Date txDate;
    private SeDoctorDTO doctorId;

    public MdiCertificationDTO() {}

    public MdiCertificationDTO(MdiCertification mdiCertification) {
        this.certificationId = mdiCertification.getCertificationId();
        this.certificationDocumentId = mdiCertification.getCertificationDocumentId();
        this.version = mdiCertification.getVersion();
        this.status = mdiCertification.getStatus();
        this.txUser = mdiCertification.getTxUser();
        this.txHost = mdiCertification.getTxHost();
        this.txDate = mdiCertification.getTxDate();
        this.doctorId = new SeDoctorDTO(mdiCertification.getDoctorId());
    }

    public MdiCertificationDTO(Integer certificationId) {
        this.certificationId = certificationId;
    }

    public MdiCertificationDTO(Integer certificationId, int certificationDocumentId, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.certificationId = certificationId;
        this.certificationDocumentId = certificationDocumentId;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getCertificationId() {
        return certificationId;
    }

    public void setCertificationId(Integer certificationId) {
        this.certificationId = certificationId;
    }

    public int getCertificationDocumentId() {
        return certificationDocumentId;
    }

    public void setCertificationDocumentId(int certificationDocumentId) {
        this.certificationDocumentId = certificationDocumentId;
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

    public SeDoctorDTO getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(SeDoctorDTO doctorId) {
        this.doctorId = doctorId;
    }

    public MdiCertification toEntity() {
        MdiCertification mdiCertification = new MdiCertification();
        mdiCertification.setCertificationId(certificationId);
        mdiCertification.setCertificationDocumentId(certificationDocumentId);
        mdiCertification.setVersion(version);
        mdiCertification.setStatus(status);
        mdiCertification.setTxUser(txUser);
        mdiCertification.setTxHost(txHost);
        mdiCertification.setTxDate(txDate);
        mdiCertification.setDoctorId(doctorId.toEntity());

        return mdiCertification;
    }

    @Override
    public String toString() {
        return "MdiCertificationDTO{" +
                "certificationId=" + certificationId +
                ", certificationDocumentId=" + certificationDocumentId +
                ", version=" + version +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                ", doctorId=" + doctorId +
                '}';
    }
}
