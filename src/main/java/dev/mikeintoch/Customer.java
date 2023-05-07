
package dev.mikeintoch;

import java.util.Objects;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.GenericGenerator;

@Entity
@NamedQuery(name = "findAll", query = "SELECT p FROM Customer p")
public class Customer {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    UUID id;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    private String name;
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    private String phone;
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Customer() { 
    }

    public Customer(String name, String email, String phone, String country) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Customer)) {
            return false;
        }

        Customer other = (Customer) obj;

        return Objects.equals(other.name, this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    @Override
    public String toString() {
        return "Person{" +
               "id='" + id.toString() + '\'' + 
               ", name='" + name + '\'' +
               ", email='" + email + '\'' + 
               ", phone='" + phone + '\'' + 
               ", country='" + country +  '\'' +
               '}';
    }
}
