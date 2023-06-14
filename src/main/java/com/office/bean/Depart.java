package com.office.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Depart {

  private long id;
  private String name;
  private String createtime;
  private long del;
//员工人数
  private long empCount;


}
