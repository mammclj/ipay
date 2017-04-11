package com.msymobile.www.pay.model.master;

public class MasterCountry {
    private String countryId;

    private String cn;

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId == null ? null : countryId.trim();
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn == null ? null : cn.trim();
    }

    
	public MasterCountry() {
		super();
	}

	public MasterCountry(String countryId, String cn) {
		super();
		this.countryId = countryId;
		this.cn = cn;
	}

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", cn=" + cn + "]";
	}
    
    
}