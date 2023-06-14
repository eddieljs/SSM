package com.office.bean;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classes {

  private long id;
  private long major_id;
  private String class_name;
  private String class_date;
  private String class_time;
  private String class_address;
  private long class_delete;
  //扩展字段
  private Major major;
  //学生人数
  private long studentCount;
}
