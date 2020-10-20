package com.example.demo.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("cust")
public class CustTblVO {
private Integer custNo;
private String custName;
private String custId;
private String custPwd;
private String custEmail;
private String custBirth;
private String custJoindate;

}
