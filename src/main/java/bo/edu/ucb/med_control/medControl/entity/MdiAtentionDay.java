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
@Table(name = "mdi_atention_day")
@NamedQueries({
    @NamedQuery(name = "MdiAtentionDay.findAll", query = "SELECT m FROM MdiAtentionDay m"),
    @NamedQuery(name = "MdiAtentionDay.findByAtentioinDayId", query = "SELECT m FROM MdiAtentionDay m WHERE m.atentioinDayId = :atentioinDayId"),
    @NamedQuery(name = "MdiAtentionDay.findByAtentionDayName", query = "SELECT m FROM MdiAtentionDay m WHERE m.atentionDayName = :atentionDayName"),
    @NamedQuery(name = "MdiAtentionDay.findByVersion", query = "SELECT m FROM MdiAtentionDay m WHERE m.version = :version"),
    @NamedQuery(name = "MdiAtentionDay.findByStatus", query = "SELECT m FROM MdiAtentionDay m WHERE m.status = :status"),
    @NamedQuery(name = "MdiAtentionDay.findByTxUser", query = "SELECT m FROM MdiAtentionDay m WHERE m.txUser = :txUser"),
    @NamedQuery(name = "MdiAtentionDay.findByTxHost", query = "SELECT m FROM MdiAtentionDay m WHERE m.txHost = :txHost"),
    @NamedQuery(name = "MdiAtentionDay.findByTxDate", query = "SELECT m FROM MdiAtentionDay m WHERE m.txDate = :txDate")})
public class MdiAtentionDay implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "atentioin_day_id")
    private Integer atentioinDayId;
    @Basic(optional = false)
    @Column(name = "atention_day_name")
    private String atentionDayName;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "atentionDayId", fetch = FetchType.LAZY)
    private List<MdiDoctorAtentionDay> mdiDoctorAtentionDayList;

    public MdiAtentionDay() {
    }

    public MdiAtentionDay(Integer atentioinDayId) {
        this.atentioinDayId = atentioinDayId;
    }

    public MdiAtentionDay(Integer atentioinDayId, String atentionDayName, int version, boolean status, int txUser, String txHost, Date txDate) {
        this.atentioinDayId = atentioinDayId;
        this.atentionDayName = atentionDayName;
        this.version = version;
        this.status = status;
        this.txUser = txUser;
        this.txHost = txHost;
        this.txDate = txDate;
    }

    public Integer getAtentioinDayId() {
        return atentioinDayId;
    }

    public void setAtentioinDayId(Integer atentioinDayId) {
        this.atentioinDayId = atentioinDayId;
    }

    public String getAtentionDayName() {
        return atentionDayName;
    }

    public void setAtentionDayName(String atentionDayName) {
        this.atentionDayName = atentionDayName;
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

    public List<MdiDoctorAtentionDay> getMdiDoctorAtentionDayList() {
        return mdiDoctorAtentionDayList;
    }

    public void setMdiDoctorAtentionDayList(List<MdiDoctorAtentionDay> mdiDoctorAtentionDayList) {
        this.mdiDoctorAtentionDayList = mdiDoctorAtentionDayList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (atentioinDayId != null ? atentioinDayId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MdiAtentionDay)) {
            return false;
        }
        MdiAtentionDay other = (MdiAtentionDay) object;
        if ((this.atentioinDayId == null && other.atentioinDayId != null) || (this.atentioinDayId != null && !this.atentioinDayId.equals(other.atentioinDayId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bo.edu.ucb.med_control.medControl.entity.MdiAtentionDay[ atentioinDayId=" + atentioinDayId + " ]";
    }
    
}
