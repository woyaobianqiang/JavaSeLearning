package com.example.aoplog.api;

import com.example.aoplog.dto.BusinessLogUser;

/**
 * 扩展业务日志插件接口
 * 
 * @author mxzgn
 *
 */
public interface IExtBusinessLogUser {

	/**
	 * 获取用户信息，id和名称
	 * 
	 * @return
	 */
	BusinessLogUser getUser();

}
