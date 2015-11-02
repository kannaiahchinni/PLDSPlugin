package com.avaya.plds.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.avaya.plds.beans.AppInfo;
import com.avaya.plds.beans.AppList;
import com.avaya.plds.beans.Features;
import com.avaya.plds.beans.ProductInfo;
import com.avaya.plds.beans.Rules;
import com.avaya.plds.beans.User;


public interface PLDSPluginDAO {

	public List<AppList> getApplicationList();
	
	public AppInfo getApplicationInfo(int appId);
	public ProductInfo getProductInfo(@Param("appId") int appId, @Param("version") int version);
	public List<Features> getFeatures(@Param("appId") int appId, @Param("version") int version);
	public List<Rules> getRules(@Param("appId") int appId, @Param("version") int version);

	public int updateAppData(AppInfo appInfo);
	public int updateProductInfo(ProductInfo productInfo);
	public int updateFeatures(@Param("feature") Features feature);
	public int updateRules(@Param("rule") Rules rule);
	
	
	public int saveAppData(AppInfo appInfo);
	public int saveProductInfo(ProductInfo productInfo);
	public int saveProductInfo1(ProductInfo productInfo);
	public int saveFeatures(@Param("feature") Features feature);
	public int saveRules(@Param("rule") Rules rule);
	
	
	public int deleteFeatures(@Param("appId") String appId, @Param("version") String version);
	public int deleteRules(@Param("appId") String appId, @Param("version") String version);
	
	public User login(User user);
	public int requestLogin(User user);
	
}
