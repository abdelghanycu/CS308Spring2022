package com.sci.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "movie", schema = "hr")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

  @Id
  @Column(name = "id")
  private Integer id;
  @Column(name = "name")
  private String name;

//  @ManyToMany(fetch = FetchType.LAZY)
//  @JoinTable(name = "hr.actor_movie",
//      joinColumns = {@JoinColumn(name = "movie_id")},
//      inverseJoinColumns = {@JoinColumn(name = "actor_id")}
//  )
//  private List<Actor> actors;
}
