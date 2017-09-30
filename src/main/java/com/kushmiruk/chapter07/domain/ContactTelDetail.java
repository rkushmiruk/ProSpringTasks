package com.kushmiruk.chapter07.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contact_tel_detail")
public class ContactTelDetail implements Serializable {
    private Long id;
    private int version;
    private String telType;
    private String telNumber;
    private Contact contact;

    public ContactTelDetail() {

    }

    public ContactTelDetail(String telType, String telNumber) {
        this.telType = telType;
        this.telNumber = telNumber;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Version
    @Column(name = "VERSION")
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Column(name = "TEL_TYPE")
    public String getTelType() {
        return telType;
    }

    public void setTelType(String telType) {
        this.telType = telType;
    }

    @Column(name = "TEL_NUMBER")
    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    @ManyToOne
    @JoinColumn(name = "CONTACT_ID")
    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactTelDetail that = (ContactTelDetail) o;

        if (version != that.version) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (telType != null ? !telType.equals(that.telType) : that.telType != null) return false;
        return telNumber != null ? telNumber.equals(that.telNumber) : that.telNumber == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + version;
        result = 31 * result + (telType != null ? telType.hashCode() : 0);
        result = 31 * result + (telNumber != null ? telNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ContactTelDetail{" +
                "id=" + id +
                ", version=" + version +
                ", telType='" + telType + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", contact=" + contact.getId() +
                '}';
    }
}
