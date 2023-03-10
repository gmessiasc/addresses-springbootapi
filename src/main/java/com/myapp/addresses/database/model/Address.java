package com.myapp.addresses.database.model;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity @Table(name="endereços") 
@Builder
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Address implements Serializable {

  @Serial
  private static final long serialVersionUID = 1L;
  
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  
  @Column(name = "CEP", nullable = false)
  private String zipCode;

  @Column(name = "Logradouro", nullable = false)
  private String streetAddress;

  @Column(name = "Número", nullable = false)
  private Integer number;

  @Column(name = "Cidade", nullable = false)
  private String city;

  @ManyToMany(fetch = FetchType.LAZY)
  private List<Person> residents;
 
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
    result = prime * result + ((streetAddress == null) ? 0 : streetAddress.hashCode());
    result = prime * result + ((number == null) ? 0 : number.hashCode());
    result = prime * result + ((city == null) ? 0 : city.hashCode());
    result = prime * result + ((residents == null) ? 0 : residents.hashCode());
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
    Address other = (Address) obj;
    if (zipCode == null) {
      if (other.zipCode != null)
        return false;
    } else if (!zipCode.equals(other.zipCode))
      return false;
    if (streetAddress == null) {
      if (other.streetAddress != null)
        return false;
    } else if (!streetAddress.equals(other.streetAddress))
      return false;
    if (number == null) {
      if (other.number != null)
        return false;
    } else if (!number.equals(other.number))
      return false;
    if (city == null) {
      if (other.city != null)
        return false;
    } else if (!city.equals(other.city))
      return false;
    if (residents == null) {
      if (other.residents != null)
        return false;
    } else if (!residents.equals(other.residents))
      return false;
    return true;
  }


  @Override
  public String toString() {
    return number + ", " + streetAddress + " - " + city + ", " + zipCode;
  }
  
}