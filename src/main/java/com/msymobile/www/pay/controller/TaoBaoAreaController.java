package com.msymobile.www.pay.controller;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.msymobile.www.commons.utils.IPUtils.IPUtil;
import com.msymobile.www.commons.utils.vo.Json;
import com.msymobile.www.commons.utils.vo.TaoBaoAreaData;
import com.msymobile.www.pay.model.master.MasterIP;
import com.msymobile.www.pay.model.master.MasterTaoBaoArea;
import com.msymobile.www.pay.service.TaoBaoAreaService;


@Controller
@RequestMapping("/taoBaoAreaController")
public class TaoBaoAreaController {
	
	private static Logger logger = Logger.getLogger(TaoBaoAreaController.class);
	private static final String SUCCESS = "showUser";
	@Autowired
	private TaoBaoAreaService taoBaoAreaWriteService;
	@RequestMapping("/showAreaInfoByIp")
	public String showAreaInfoByIp(HttpServletRequest request,HttpServletResponse response){
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = null;
		Json json = new Json(true,"",null);
		boolean success = true;
		Map<String,Object> map = new HashMap<String,Object>();
		String message = "查询失败！";
		TaoBaoAreaData taoBaoAreaData = new TaoBaoAreaData();
		try {
			out = response.getWriter();
			String ip = IPUtil.getRealIp(request);
			ip = "101.254.183.41"; 
			logger.info("请求地址真实ip是---------------------------------> "+ip);
//			ip = ip.substring(0, ip.lastIndexOf("."))+".0";
//			logger.info("只要获取ip的前三段就可以确定所属地信息了，此参数ip为--------> ip:"+ip);
			//查看数据库中是否有此ip
			MasterIP ipModel = this.taoBaoAreaWriteService.selectByPrimaryKey(ip);
			if(ipModel!=null){
				map.put("regionId", ipModel.getRegionId());
				map.put("cityId", ipModel.getCityId());
				message = "查询成功！";
			}else{
				String result = IPUtil.getAddressByIP(ip);
				if(result!=null && !"".equals(result.trim())){
					result = result.replaceAll("_id", "Id").replace("data", "masterTaoBaoArea");
					//json转对象
					taoBaoAreaData = JSON.toJavaObject(JSON.parseObject(result), TaoBaoAreaData.class);
					if(taoBaoAreaData.getCode() == 0){
						MasterTaoBaoArea masterTaoBaoArea = taoBaoAreaData.getMasterTaoBaoArea();
						if(masterTaoBaoArea!=null){
							masterTaoBaoArea.setId(UUID.randomUUID().toString().replaceAll("-", ""));
							if(this.taoBaoAreaWriteService.insertTaoBaoAreaAndChildTable(masterTaoBaoArea)==1){
								map.put("regionId", masterTaoBaoArea.getRegionId());
								map.put("cityId", masterTaoBaoArea.getCityId());
								message = "查询成功！";
							}
						}
					}
				}
			}
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
		}finally{
			if(out !=null){
				json.setSuccess(success);
				json.setObj(map);
				json.setMessage(message);
				out.print(JSON.toJSONString(json));
				out.close();
			}
		}
		return null;
	}
}