package com.office.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Major {

  private long id;
  private String major_name;
  private String major_time;
  private String major_date;
  private long major_type;
  private long major_delete;
  //扩展字段  对象
  private Majortype majortype;

}

//  public long getId() {
//    return id;
//  }
//
//  public void setId(long id) {
//    this.id = id;
//  }
//
//
//  public String getMajorName() {
//    return majorName;
//  }
//
//  public void setMajorName(String majorName) {
//    this.majorName = majorName;
//  }
//
//
//  public String getMajorTime() {
//    return majorTime;
//  }
//
//  public void setMajorTime(String majorTime) {
//    this.majorTime = majorTime;
//  }
//
//
//  public java.sql.Date getMajorDate() {
//    return majorDate;
//  }
//
//  public void setMajorDate(java.sql.Date majorDate) {
//    this.majorDate = majorDate;
//  }
//
//
//  public long getMajorType() {
//    return majorType;
//  }
//
//  public void setMajorType(long majorType) {
//    this.majorType = majorType;
//  }
//
//
//  public long getMajorDelete() {
//    return majorDelete;
//  }
//
//  public void setMajorDelete(long majorDelete) {
//    this.majorDelete = majorDelete;
//  }

