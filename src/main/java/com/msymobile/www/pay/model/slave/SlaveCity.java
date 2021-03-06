package com.msymobile.www.pay.model.slave;

public class SlaveCity {
    private String cityId;

    private String name;

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId == null ? null : cityId.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    
	public SlaveCity() {
		super();
	}

	public SlaveCity(String cityId, String name) {
		super();
		this.cityId = cityId;
		this.name = name;
	}

	@Override
	public String toString() {
		return "City [cityId=" + cityId + ", name=" + name + "]";
	}
    
}