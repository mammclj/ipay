package com.msymobile.www.pay.service.write;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msymobile.www.pay.dao.master.MasterCityMapper;
import com.msymobile.www.pay.dao.master.MasterCountryMapper;
import com.msymobile.www.pay.dao.master.MasterIPMapper;
import com.msymobile.www.pay.dao.master.MasterRegionMapper;
import com.msymobile.www.pay.dao.master.MasterSPMapper;
import com.msymobile.www.pay.dao.master.MasterTaoBaoAreaMapper;
import com.msymobile.www.pay.model.master.MasterCity;
import com.msymobile.www.pay.model.master.MasterCountry;
import com.msymobile.www.pay.model.master.MasterIP;
import com.msymobile.www.pay.model.master.MasterRegion;
import com.msymobile.www.pay.model.master.MasterSP;
import com.msymobile.www.pay.model.master.MasterTaoBaoArea;
import com.msymobile.www.pay.service.TaoBaoAreaService;

@Service("taoBaoAreaWriteService")
public class TaoBaoAreaServiceImpl implements TaoBaoAreaService {

	@Autowired
	private MasterTaoBaoAreaMapper taoBaoAreaMapper;
	@Autowired
	private MasterIPMapper ipMapper;
	@Autowired
	private MasterCountryMapper countryMapper;
	@Autowired
	private MasterRegionMapper regionMapper;
	@Autowired
	private MasterCityMapper cityMapper;
	@Autowired
	private MasterSPMapper spMapper;

	@Override
	public MasterTaoBaoArea selectTaoBaoAreaByIp(String ip) {
		return this.taoBaoAreaMapper.selectTaoBaoAreaByIp(ip);
	}
	
	@Override
	public MasterTaoBaoArea selectTaoBaoAreaByIp2(String ip) {
		MasterIP ipModel = this.ipMapper.selectByPrimaryKey(ip);
		MasterTaoBaoArea taoBaoArea = new MasterTaoBaoArea();
		taoBaoArea.setCityId(ipModel.getCountryId());
		taoBaoArea.setCountryId(ipModel.getCountryId());
		return taoBaoArea;
	}

	@Override
	public int insertTaoBaoArea(MasterTaoBaoArea taoBaoArea) {
		return this.taoBaoAreaMapper.insert(taoBaoArea);
	}

	@Override
	public int insertSP(MasterSP sp) {
		return this.spMapper.insert(sp);
	}

	@Override
	public int insertCity(MasterCity city) {
		return this.cityMapper.insert(city);
	}
	
	@Override
	public int insertRegion(MasterRegion region) {
		return this.regionMapper.insert(region);
	}

	@Override
	public int insertCountry(MasterCountry country) {
		return this.countryMapper.insert(country);
	}

	@Override
	public int insertIP(MasterIP ip) {
		return this.ipMapper.insert(ip);
	}

	@Override
	public MasterIP selectByPrimaryKey(String ip) {
		return this.ipMapper.selectByPrimaryKey(ip);
	}

	@Override
	public int insertTaoBaoAreaAndChildTable(MasterTaoBaoArea taoBaoArea) throws Exception {
		this.taoBaoAreaMapper.insert(taoBaoArea);
		int result = 0;
		String countryId = taoBaoArea.getCountryId();
		String regionId = taoBaoArea.getRegionId();
		String cityId = taoBaoArea.getCityId();
		int ispId = Integer.parseInt(taoBaoArea.getIspId());
		String ip = taoBaoArea.getIp();
		MasterCountry country = this.countryMapper.selectByPrimaryKey(countryId);
		if(country==null){
			country = new MasterCountry(countryId,taoBaoArea.getCountry());
			result = this.countryMapper.insert(country);
		}
		
		MasterRegion region = this.regionMapper.selectByPrimaryKey(regionId);
		if(region==null){
			region = new MasterRegion(regionId,taoBaoArea.getRegion());
			result = this.regionMapper.insert(region);
		}
		MasterCity city = this.cityMapper.selectByPrimaryKey(cityId);
		if(city==null){
			city = new MasterCity(cityId,taoBaoArea.getCity());
			result = this.cityMapper.insert(city);
		}
		
		MasterSP sp = this.spMapper.selectByPrimaryKey(ispId);
		if(sp==null){
			sp = new MasterSP(ispId,taoBaoArea.getIsp());
			result = this.spMapper.insert(sp);
		}
		
		MasterIP ipModel = this.ipMapper.selectByPrimaryKey(taoBaoArea.getIp());
		if(ipModel==null){
			ipModel = new MasterIP(ip,countryId,regionId,cityId,ispId);
			result = this.ipMapper.insert(ipModel);
		}
		return result;
	}

}
