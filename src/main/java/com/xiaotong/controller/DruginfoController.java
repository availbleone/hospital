package com.xiaotong.controller;

import java.util.List;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.xiaotong.model.Druginfo;
import com.xiaotong.service.IDruginfoService;
import com.xiaotong.service.IFeeinfoService;

@Controller
@RequestMapping("/druginfo")
@CrossOrigin
@ServerEndpoint("/RefreshDrug/{count}")
public class DruginfoController {
	@Autowired
	private IDruginfoService ids;
	
	@RequestMapping("/insert")
	@ResponseBody
	public String insert(Druginfo d) {
		String result = "0";
		try {
			ids.insert(d);
			result = "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(Druginfo d) {
		String result = "0";
		try {
			ids.update(d);
			result = "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(String did) {
		String result = "0";
		try {
			ids.delete(did);;
			result = "1";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	@RequestMapping("/selectOne")
	@ResponseBody
	public Druginfo selectOne(String did) {
		Druginfo d = null;
		try {
			d = ids.selectOne(did);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}
	
	@RequestMapping("/selectList")
	@ResponseBody
	public List selectList() {
		List list = null;
		try {
			list = ids.selectList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@RequestMapping("/selectYp")
	@ResponseBody
	public List selectYp(String value) {
		List list = null;
		try {
			list = ids.selectYp(value);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**查询费用表数据如果有变更，推送到页面
	 * @param count
	 * @param session
	 */
	@OnOpen
	public void sayHello(@PathParam("count")Integer count,Session session){
		WebApplicationContext beans = ContextLoader.getCurrentWebApplicationContext();
		IFeeinfoService ifs = (IFeeinfoService) beans.getBean("feeinfoServiceImpl");
		try {
			while (true) {
				Thread.sleep(10000);
				//若价格改变，推送到客户端
				int count1 = ifs.selectBytime();
				if(count==count1){
					continue;
				}
				session.getBasicRemote().sendText(count1+"");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
