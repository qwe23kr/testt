package com.example.demo.mapper;

import java.util.List;

import com.example.demo.vo.CustTblVO;

public interface CustTblMapper {
	List<CustTblVO> selectCustTblList(CustTblVO cust);
}
