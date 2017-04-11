package com.msymobile.www.pay.model.master;

public class MasterSP {
    private Integer spId;

    private String spName;

    public Integer getSpId() {
        return spId;
    }

    public void setSpId(Integer spId) {
        this.spId = spId;
    }

    public String getSpName() {
        return spName;
    }

    public void setSpName(String spName) {
        this.spName = spName == null ? null : spName.trim();
    }

	public MasterSP() {
		super();
	}

	public MasterSP(Integer spId, String spName) {
		super();
		this.spId = spId;
		this.spName = spName;
	}

	@Override
	public String toString() {
		return "SP [spId=" + spId + ", spName=" + spName + "]";
	}
    
    
    
}