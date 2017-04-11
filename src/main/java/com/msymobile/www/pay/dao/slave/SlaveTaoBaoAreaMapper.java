package com.msymobile.www.pay.dao.slave;

import com.msymobile.www.pay.dao.BaseMapper;
import com.msymobile.www.pay.model.slave.SlaveTaoBaoArea;

public interface SlaveTaoBaoAreaMapper extends BaseMapper<SlaveTaoBaoArea> {
	SlaveTaoBaoArea selectTaoBaoAreaByIp(String ip);
	SlaveTaoBaoArea selectTaoBaoAreaByIp2(String ip);
}