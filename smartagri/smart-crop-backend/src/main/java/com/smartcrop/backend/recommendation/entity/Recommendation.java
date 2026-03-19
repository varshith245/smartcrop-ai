
package com.smartcrop.backend.recommendation.entity;
import jakarta.persistence.*;
@Entity
public class Recommendation {
 @Id @GeneratedValue
 private Long id;
 public Long getId(){return id;}
 public void setId(Long id){this.id=id;}
}
