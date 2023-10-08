package koxign.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import koxign.login.service.LoginService;
import koxign.login.service.LoginVO;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private LoginMapper loginMapper;
	
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
	//ȸ���α���
	public LoginVO actionLogin(LoginVO vo)throws Exception{
		
//		// �Է��� ��й��� ��ȣȭ�Ѵ�.
//		String encodedPassword = passwordEncoder.encode(vo.getPartnerPwd());
//		vo.setPartnerPwd(encodedPassword);
		
		//���̵�� ��ȣȭ�� ��й�ȣ�� DB�� ��ġ�ϴ��� Ȯ���Ѵ�.
		LoginVO loginVO = loginMapper.actionLogin(vo);
		
		if (loginVO != null && !loginVO.getPartnerEmail().equals("") && !loginVO.getPartnerPwd().equals("")) {
			return loginVO;
		} else {
			loginVO = new LoginVO();
		}
		
		return loginVO;
	}
				
}