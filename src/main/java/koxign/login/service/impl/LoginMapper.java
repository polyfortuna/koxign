package koxign.login.service.impl;

import org.apache.ibatis.annotations.Mapper;

import koxign.login.service.LoginVO;

@Mapper
public interface LoginMapper{

	//�Ϲ� �α����� ó���Ѵ�
	public LoginVO actionLogin(LoginVO vo) throws Exception;
}
