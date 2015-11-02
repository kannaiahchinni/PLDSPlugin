package com.avaya.plds.service;

import java.util.List;

import com.avaya.plds.beans.AppList;
import com.avaya.plds.beans.ApplicationInfo;
import com.avaya.plds.beans.User;


public interface PLDSPluginService {
	
	public List<AppList> getApplicationList();
	public ApplicationInfo getApplicationInfo(int appId,int version);
	public int update(ApplicationInfo appInfo);
	public int save(ApplicationInfo appInfo);
	public int deleteApplication(int appId);
	public User login(User user);
	public int requestLogin(User user);
}
