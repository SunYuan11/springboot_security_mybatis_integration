package com.sb_ss_myb.frame.service;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb_ss_myb.frame.dao.MenuDao;
import com.sb_ss_myb.frame.domain.SbssMenu;

@Service("menuService")
public class MenuService {
	
	@Autowired
	MenuDao menuDao;
	
	/*
	 * 查询请求所需要的权限
	 */
	public List<Map<String, Object>> queryAllAuthorities () {
		
		return menuDao.queryAllAuthorities();
	}
	
	/*
	 * 根据username查询相应的菜单
	 */
	public JSONArray queryUserMenuByUsername (String username) {
		List<SbssMenu> list = menuDao.queryUserMenuByUsername(username);
		JSONArray jsonarray = JSONArray.fromObject(list);
		
		JSONArray treeMenuList = treeMenuList(jsonarray, "-1");
		return treeMenuList;
	}
	
	// 菜单树形结构
	private JSONArray treeMenuList(JSONArray menuList, String parentId) {
		JSONArray childMenu = new JSONArray();
		
		for (Object object : menuList) {
			JSONObject menuItem = JSONObject.fromObject(object);
			String menuItemId = menuItem.getString("id");
			String menuItemPid = menuItem.getString("parentmenuid");
			
			if (parentId.equals(menuItemPid)) {
				JSONArray chdMenu = treeMenuList(menuList, menuItemId);
				menuItem.put("childMenu", chdMenu);
				childMenu.add(menuItem);
			}
		}
		
		return childMenu;
	}

}
