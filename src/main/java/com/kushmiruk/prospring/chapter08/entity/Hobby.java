package com.kushmiruk.prospring.chapter08.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hobby")
public class Hobby {
    private String hoobyId;
    private Set<Contact> contacts = new HashSet<>();

    @Id
    @Column(name = "HOBBY_ID")
    public String getHoobyId() {
        return hoobyId;
    }

    public void setHoobyId(String hoobyId) {
        this.hoobyId = hoobyId;
    }

    @ManyToMany
    @JoinTable(name = "contact_hobby_detail",
            joinColumns = @JoinColumn(name = "HOBBY_ID"),
            inverseJoinColumns = @JoinColumn(name = "CONTACT_ID"))
    public Set<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hobby hobby = (Hobby) o;

        return hoobyId != null ? hoobyId.equals(hobby.hoobyId) : hobby.hoobyId == null;
    }

    @Override
    public int hashCode() {
        return hoobyId != null ? hoobyId.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Hobby{" +
                "hoobyId='" + hoobyId + '\'' +
                '}';
    }
}
