package com.msymobile.www.commons.utils.vo;

import com.msymobile.www.pay.model.master.MasterTaoBaoArea;

public class TaoBaoAreaData {
	private int code;
	private MasterTaoBaoArea masterTaoBaoArea;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public MasterTaoBaoArea getMasterTaoBaoArea() {
		return masterTaoBaoArea;
	}
	public void setMasterTaoBaoArea(MasterTaoBaoArea masterTaoBaoArea) {
		this.masterTaoBaoArea = masterTaoBaoArea;
	}
	@Override
	public String toString() {
		return "TaoBaoAreaData [code=" + code + ", masterTaoBaoArea=" + masterTaoBaoArea + "]";
	}
	
	
	
	
}
