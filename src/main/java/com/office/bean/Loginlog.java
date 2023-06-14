package com.office.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Loginlog {

  private long id;
  private String ip;
  private String no;
  private String createtime;
  private String location;

  public Loginlog(String ip, String no, String location) {
    this.ip=ip;
    this.no=no;
    this.location=location;
  }


}
