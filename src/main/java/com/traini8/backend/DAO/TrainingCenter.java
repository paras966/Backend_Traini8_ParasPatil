package com.traini8.backend.DAO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "training_center")
public class TrainingCenter {

    public Long getId() {
        return id;
    }

    public String getCenterName() {
        return centerName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCenterName(String centerName) {
        this.centerName = centerName;
    }

    public void setCenterCode(String centerCode) {
        this.centerCode = centerCode;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setStudentCapacity(Integer studentCapacity) {
        this.studentCapacity = studentCapacity;
    }

    public void setCoursesOffered(String coursesOffered) {
        this.coursesOffered = coursesOffered;
    }

    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getCenterCode() {
        return centerCode;
    }

    public Address getAddress() {
        return address;
    }

    public Integer getStudentCapacity() {
        return studentCapacity;
    }

    public String getCoursesOffered() {
        return coursesOffered;
    }

    public Long getCreatedOn() {
        return createdOn;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Center Name is mandatory")
    @Size(max = 40, message = "Center Name should be less than 40 characters")
    private String centerName;

    @NotBlank(message = "Center Code is mandatory")
    @Pattern(regexp = "^[a-zA-Z0-9]{12}$", message = "Center Code must be exactly 12 alphanumeric characters")
    private String centerCode;

    @Embedded
    @Valid
    private Address address;

    private Integer studentCapacity;

    private String coursesOffered;

    private Long createdOn;

    @Email(message = "Invalid email format")
    private String contactEmail;

    @NotBlank(message = "Contact Phone is mandatory")
    @Pattern(regexp = "^\\d{10}$", message = "Contact Phone must be a valid 10-digit number")
    private String contactPhone;
}

@Embeddable
class Address {

    @NotBlank(message = "Detailed Address is mandatory")
    private String detailedAddress;

    @NotBlank(message = "City is mandatory")
    private String city;

    @NotBlank(message = "State is mandatory")
    private String state;

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    @NotBlank(message = "Pincode is mandatory")
    @Pattern(regexp = "^\\d{6}$", message = "Pincode must be a valid 6-digit number")
    private String pincode;
}
