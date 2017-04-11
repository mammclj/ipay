package com.msymobile.www.pay.dao.master;

import com.msymobile.www.pay.dao.BaseMapper;
import com.msymobile.www.pay.model.master.MasterTaoBaoArea;

public interface MasterTaoBaoAreaMapper extends BaseMapper<MasterTaoBaoArea> {
	MasterTaoBaoArea selectTaoBaoAreaByIp(String ip);
	MasterTaoBaoArea selectTaoBaoAreaByIp2(String ip);
}