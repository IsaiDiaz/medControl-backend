package bo.edu.ucb.med_control.medControl.dto;

import bo.edu.ucb.med_control.medControl.entity.*;
import java.util.Date;

public class SePersonDTO {

    private Integer personId;
    private String personName;
    private String personEmail;
    private String personPhone;
    private int version;
    private boolean status;
    private int txUser;
    private String txHost;
    private Date txDate;

    public SePersonDTO() {}

    public SePersonDTO(SePerson person) {
        this.personId = person.getPersonId();
        this.personName = person.getPersonName();
        this.personEmail = person.getPersonEmail();
        this.personPhone = person.getPersonPhone();
        this.version = person.getVersion();
        this.status = person.getStatus();
        this.txUser = person.getTxUser();
        this.txHost = person.getTxHost();
        this.txDate = person.getTxDate();
    }

    public SePersonDTO(Integer personId) {
        this.personId = personId;
    }

    public SePersonDTO(Integer personId, String personName, String personEmail, String personPhone, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.personId = personId;
        this.personName = personName;
        this.personEmail = personEmail;
        this.personPhone = personPhone;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }
    // Getters and setters...


    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonEmail() {
        return personEmail;
    }

    public void setPersonEmail(String personEmail) {
        this.personEmail = personEmail;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
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

    public SePerson toEntity() {
        SePerson person = new SePerson();
        person.setPersonId(this.personId);
        person.setPersonName(this.personName);
        person.setPersonEmail(this.personEmail);
        person.setPersonPhone(this.personPhone);
        person.setVersion(this.version);
        person.setStatus(this.status);
        person.setTxUser(this.txUser);
        person.setTxHost(this.txHost);
        person.setTxDate(this.txDate);
        return person;
    }

    @Override
    public String toString() {
        return "SePersonDTO{" +
                "personId=" + personId +
                ", personName='" + personName + '\'' +
                ", personEmail='" + personEmail + '\'' +
                ", personPhone='" + personPhone + '\'' +
                ", version=" + version +
                ", status=" + status +
                ", txUser=" + txUser +
                ", txHost='" + txHost + '\'' +
                ", txDate=" + txDate +
                '}';
    }
}
