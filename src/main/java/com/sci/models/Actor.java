package com.sci.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "actor", schema = "hr")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Actor {

  @Id
  @Column(name = "id")
  private Integer id;
  @Column(name = "name")
  private String name;
  @Column(name = "address_id")
  private Integer addressId;
  @Column(name = "city_id")
  private Integer cityId;

  @OneToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "address_id", insertable = false, updatable = false)
  private Address address;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "city_id", insertable = false, updatable = false)
  private City city;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "hr.actor_movie",
      joinColumns = {@JoinColumn(name = "actor_id")},
      inverseJoinColumns = {@JoinColumn(name = "movie_id")}
  )
  private List<Movie> movies;
}
