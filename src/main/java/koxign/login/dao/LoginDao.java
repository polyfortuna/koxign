package koxign.login.dao;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

import koxign.login.service.LoginVO;


@Mapper
public interface LoginDao {

	
	@Autowired
	
	 // 01_01. ȸ�� �α��� üũ
	public boolean actionLogin(LoginVO vo); 
	// 01_02. ȸ�� �α��� ����
	public  LoginVO viewLogin(LoginVO vo);
	    // 02. ȸ�� �α׾ƿ�
	public void logout(HttpSession session);
	
}
