package com.avaya.plds.email.service;

import com.avaya.plds.beans.User;

public interface NotificationEmailService {
	
	public String sendNotificationEmail(User user);
}
