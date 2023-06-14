package com.office.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Majortype {

  private long id;
  private String majortype;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getMajortype() {
    return majortype;
  }

  public void setMajortype(String majortype) {
    this.majortype = majortype;
  }

}
