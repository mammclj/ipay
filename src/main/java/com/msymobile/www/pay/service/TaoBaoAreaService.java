package com.msymobile.www.pay.service;

import com.msymobile.www.pay.model.master.MasterCity;
import com.msymobile.www.pay.model.master.MasterCountry;
import com.msymobile.www.pay.model.master.MasterIP;
import com.msymobile.www.pay.model.master.MasterRegion;
import com.msymobile.www.pay.model.master.MasterSP;
import com.msymobile.www.pay.model.master.MasterTaoBaoArea;

public interface TaoBaoAreaService {
	//操作总表数据
	MasterTaoBaoArea selectTaoBaoAreaByIp(String Ip);
	MasterTaoBaoArea selectTaoBaoAreaByIp2(String Ip);
	int insertTaoBaoArea(MasterTaoBaoArea taoBaoArea);
	//分表数据
	//sp表
	int insertSP(MasterSP sp);
	int insertCity(MasterCity city);
	int insertRegion(MasterRegion region);
	int insertCountry(MasterCountry country);
	int insertIP(MasterIP ip);
	
	MasterIP selectByPrimaryKey(String ip);
	int insertTaoBaoAreaAndChildTable(MasterTaoBaoArea taoBaoArea) throws Exception;
	
}
