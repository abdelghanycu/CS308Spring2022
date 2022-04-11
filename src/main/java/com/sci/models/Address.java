package com.sci.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "address", schema = "hr")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {

  @Id
  @Column(name = "id")
  private Integer id;
  @Column(name = "street")
  private String street;
}
