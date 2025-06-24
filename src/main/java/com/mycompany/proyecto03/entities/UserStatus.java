/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyecto03.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author jcgom
 */
@Entity
@Table(name = "user_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserStatus.findAll", query = "SELECT u FROM UserStatus u"),
    @NamedQuery(name = "UserStatus.findByStatusId", query = "SELECT u FROM UserStatus u WHERE u.statusId = :statusId"),
    @NamedQuery(name = "UserStatus.findByStatusName", query = "SELECT u FROM UserStatus u WHERE u.statusName = :statusName")})
public class UserStatus implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "status_id")
    private Integer statusId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "status_name")
    private String statusName;
    @OneToMany(mappedBy = "statusId")
    private Collection<Users> usersCollection;

    public UserStatus() {
    }

    public UserStatus(Integer statusId) {
        this.statusId = statusId;
    }

    public UserStatus(Integer statusId, String statusName) {
        this.statusId = statusId;
        this.statusName = statusName;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statusId != null ? statusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserStatus)) {
            return false;
        }
        UserStatus other = (UserStatus) object;
        if ((this.statusId == null && other.statusId != null) || (this.statusId != null && !this.statusId.equals(other.statusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.proyecto03.entities.UserStatus[ statusId=" + statusId + " ]";
    }
    
}
