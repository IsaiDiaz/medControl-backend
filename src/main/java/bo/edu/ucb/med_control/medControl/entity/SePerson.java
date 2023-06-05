/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bo.edu.ucb.med_control.medControl.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import jakarta.persistence.*;

/**
 *
 * @author isai
 */
@Entity
@Table(name = "se_person")
@NamedQueries({
    @NamedQuery(name = "SePerson.findAll", query = "SELECT s FROM SePerson s"),
    @NamedQuery(name = "SePerson.findByPersonId", query = "SELECT s FROM SePerson s WHERE s.personId = :personId"),
    @NamedQuery(name = "SePerson.findByPersonName", query = "SELECT s FROM SePerson s WHERE s.personName = :personName"),
    @NamedQuery(name = "SePerson.findByPersonEmail", query = "SELECT s FROM SePerson s WHERE s.personEmail = :personEmail"),
    @NamedQuery(name = "SePerson.findByPersonPhone", query = "SELECT s FROM SePerson s WHERE s.personPhone = :personPhone"),
    @NamedQuery(name = "SePerson.findByVersion", query = "SELECT s FROM SePerson s WHERE s.version = :version"),
    @NamedQuery(name = "SePerson.findByStatus", query = "SELECT s FROM SePerson s WHERE s.status = :status"),
    @NamedQuery(name = "SePerson.findByTxUser", query = "SELECT s FROM SePerson s WHERE s.txUser = :txUser"),
    @NamedQuery(name = "SePerson.findByTxHost", query = "SELECT s FROM SePerson s WHERE s.txHost = :txHost"),
    @NamedQuery(name = "SePerson.findByTxDate", query = "SELECT s FROM SePerson s WHERE s.txDate = :txDate")})
public class SePerson implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "person_id")
    private Integer personId;
    @Basic(optional = false)
    @Column(name = "person_name")
    private String personName;
    @Basic(optional = false)
    @Column(name = "person_email")
    private String personEmail;
    @Basic(optional = false)
    @Column(name = "person_phone")
    private String personPhone;
    @Version
    @Basic(optional = false)
    @Column(name = "version")
    private int version;
    @Basic(optional = false)
    @Column(name = "status")
    private boolean status;
    @Basic(optional = false)
    @Column(name = "tx_user")
    private int txUser;
    @Basic(optional = false)
    @Column(name = "tx_host")
    private String txHost;
    @Basic(optional = false)
    @Column(name = "tx_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date txDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "personId", fetch = FetchType.LAZY)
    private List<SeUser> seUserList;

    public SePerson() {
    }

    public SePerson(Integer personId) {
        this.personId = personId;
    }

    public SePerson(Integer personId, String personName, String personEmail, String personPhone, int version, boolean status, int txUser, String txHost, Date txDate) {
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

    public boolean getStatus() {
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

    public List<SeUser> getSeUserList() {
        return seUserList;
    }

    public void setSeUserList(List<SeUser> seUserList) {
        this.seUserList = seUserList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personId != null ? personId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SePerson)) {
            return false;
        }
        SePerson other = (SePerson) object;
        if ((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.SePerson[ personId=" + personId + " ]";
    }
    
}
