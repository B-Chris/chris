/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.chris.data;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author User2
 */
@Entity
@Table(name = "consultantorganisation")
@NamedQueries({
    @NamedQuery(name = "Consultantorganisation.findAll", query = "SELECT c FROM Consultantorganisation c"),
    @NamedQuery(name = "Consultantorganisation.findByConsultantOrganisationID", query = "SELECT c FROM Consultantorganisation c WHERE c.consultantOrganisationID = :consultantOrganisationID")})
public class Consultantorganisation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "consultantOrganisationID")
    private Integer consultantOrganisationID;
    @JoinColumn(name = "consultantID", referencedColumnName = "consultantID")
    @ManyToOne(optional = false)
    private Consultant consultantID;
    @JoinColumn(name = "organisationID", referencedColumnName = "organisationID")
    @ManyToOne(optional = false)
    private Organisation organisationID;

    public Consultantorganisation() {
    }

    public Consultantorganisation(Integer consultantOrganisationID) {
        this.consultantOrganisationID = consultantOrganisationID;
    }

    public Integer getConsultantOrganisationID() {
        return consultantOrganisationID;
    }

    public void setConsultantOrganisationID(Integer consultantOrganisationID) {
        this.consultantOrganisationID = consultantOrganisationID;
    }

    public Consultant getConsultantID() {
        return consultantID;
    }

    public void setConsultantID(Consultant consultantID) {
        this.consultantID = consultantID;
    }

    public Organisation getOrganisationID() {
        return organisationID;
    }

    public void setOrganisationID(Organisation organisationID) {
        this.organisationID = organisationID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (consultantOrganisationID != null ? consultantOrganisationID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Consultantorganisation)) {
            return false;
        }
        Consultantorganisation other = (Consultantorganisation) object;
        if ((this.consultantOrganisationID == null && other.consultantOrganisationID != null) || (this.consultantOrganisationID != null && !this.consultantOrganisationID.equals(other.consultantOrganisationID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.chris.data.Consultantorganisation[ consultantOrganisationID=" + consultantOrganisationID + " ]";
    }
    
}
