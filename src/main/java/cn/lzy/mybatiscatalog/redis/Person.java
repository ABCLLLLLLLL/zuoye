package cn.lzy.mybatiscatalog.redis;

import  cn.lzy.mybatiscatalog.redis.Address;
import org.hibernate.type.descriptor.sql.JdbcTypeFamilyInformation;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import java.util.List;

public class Person {
    @Id
    private String id;
    @Indexed
    private String firstname;
    @Indexed
    private String lastname;
    private Address address;
    private List<cn.lzy.mybatiscatalog.redis.Family> familyList;

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", address=" + address +
                ", familyList=" + familyList +
                '}';
    }

    public Person() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<cn.lzy.mybatiscatalog.redis.Family> getFamilyList() {
        return familyList;
    }

    public void setFamilyList(List<cn.lzy.mybatiscatalog.redis.Family> familyList) {
        this.familyList = familyList;
    }
}
