package com.office.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {

  private long id;
  private String no;
  private String pass;
  private String name;
  private long did;
  private long flag;
  private String sex;
  private String email;
  private String qq;
  private String phone;
  private java.sql.Date createdate;
  private String photo;
  private long del;
  private Depart depart;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getNo() {
    return no;
  }

  public void setNo(String no) {
    this.no = no;
  }


  public String getPass() {
    return pass;
  }

  public void setPass(String pass) {
    this.pass = pass;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public long getDid() {
    return did;
  }

  public void setDid(long did) {
    this.did = did;
  }


  public long getFlag() {
    return flag;
  }

  public void setFlag(long flag) {
    this.flag = flag;
  }


  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public String getQq() {
    return qq;
  }

  public void setQq(String qq) {
    this.qq = qq;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public java.sql.Date getCreatedate() {
    return createdate;
  }

  public void setCreatedate(java.sql.Date createdate) {
    this.createdate = createdate;
  }


  public String getPhoto() {
    return photo;
  }

  public void setPhoto(String photo) {
    this.photo = photo;
  }


  public long getDel() {
    return del;
  }

  public void setDel(long del) {
    this.del = del;
  }

  @Override
  public String toString() {
    return "Emp{" +
            "id=" + id +
            ", no='" + no + '\'' +
            ", pass='" + pass + '\'' +
            ", name='" + name + '\'' +
            ", did=" + did +
            ", flag=" + flag +
            ", sex='" + sex + '\'' +
            ", email='" + email + '\'' +
            ", qq='" + qq + '\'' +
            ", phone='" + phone + '\'' +
            ", createdate=" + createdate +
            ", photo='" + photo + '\'' +
            ", del=" + del +
            '}';
  }
}
