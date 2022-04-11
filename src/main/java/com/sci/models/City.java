package com.sci.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "city", schema = "hr")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

  @Id
  @Column(name = "id")
  private Integer id;
  @Column(name = "name")
  private String name;

//  @OneToMany(fetch = FetchType.LAZY)
//  @JoinColumn(name = "city_id", insertable = false, updatable = false)
//  private List<Actor> actors;
}
