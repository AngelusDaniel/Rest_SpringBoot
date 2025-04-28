package AngelusDaniel.data.dto.v2;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonFilter("PersonFilterDTO")
@JsonPropertyOrder({ "id", "firstName", "lastName", "birthDate", "address", "gender"})
public class PersonDTOV2 implements Serializable{

  private static final long serialVersionUID = 1L;


  private Long id;
  private String firstName;

  @JsonInclude(JsonInclude.Include.NON_NULL)
  private String lastName;

  @JsonInclude(JsonInclude.Include.NON_EMPTY)
  private String phoneNumber;
  @JsonFormat(pattern = "dd/MM/yyyy")
  private Date birthDate;
  private String address;

  private String gender;

  private String sensitiveData;


  public PersonDTOV2() {
  }


  public static long getSerialversionuid() {
    return serialVersionUID;
  }


  public Long getId() {
    return id;
  }


  public void setId(Long id) {
    this.id = id;
  }


  public String getFirstName() {
    return firstName;
  }


  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }


  public String getLastName() {
    return lastName;
  }


  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  public String getAddress() {
    return address;
  }


  public void setAddress(String address) {
    this.address = address;
  }


  public String getGender() {
    return gender;
  }


  public void setGender(String gender) {
    this.gender = gender;
  }


  public Date getBirthDate() {
    return birthDate;
  }


  public void setBirthDate(Date birthDate) {
    this.birthDate = birthDate;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }


  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }


  public String getSensitiveData() {
    return sensitiveData;
  }


  public void setSensitiveData(String sensitiveData) {
    this.sensitiveData = sensitiveData;
  }


  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
    result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
    result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
    result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
    result = prime * result + ((address == null) ? 0 : address.hashCode());
    result = prime * result + ((gender == null) ? 0 : gender.hashCode());
    result = prime * result + ((sensitiveData == null) ? 0 : sensitiveData.hashCode());
    return result;
  }


  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    PersonDTOV2 other = (PersonDTOV2) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (firstName == null) {
      if (other.firstName != null)
        return false;
    } else if (!firstName.equals(other.firstName))
      return false;
    if (lastName == null) {
      if (other.lastName != null)
        return false;
    } else if (!lastName.equals(other.lastName))
      return false;
    if (phoneNumber == null) {
      if (other.phoneNumber != null)
        return false;
    } else if (!phoneNumber.equals(other.phoneNumber))
      return false;
    if (birthDate == null) {
      if (other.birthDate != null)
        return false;
    } else if (!birthDate.equals(other.birthDate))
      return false;
    if (address == null) {
      if (other.address != null)
        return false;
    } else if (!address.equals(other.address))
      return false;
    if (gender == null) {
      if (other.gender != null)
        return false;
    } else if (!gender.equals(other.gender))
      return false;
    if (sensitiveData == null) {
      if (other.sensitiveData != null)
        return false;
    } else if (!sensitiveData.equals(other.sensitiveData))
      return false;
    return true;
  }











  


}