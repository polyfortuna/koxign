package koxign.login.web;


import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import koxign.join.service.JoinVO;
import koxign.login.service.LoginService;
import koxign.login.service.LoginVO;
 


@Controller // ���� Ŭ������ ���������� �����ϴ� ��Ʈ�ѷ� bean���� ����
public class LoginController {
	
	
    @Autowired						
    LoginService loginService;
    
    
    // 01. �α��� ȭ��
    @GetMapping("/main/login.do")
    public String login(){
        return "/login/Login";    // views/login/Login.jsp�� ������
    }
    
    //02. �α��� ó��
    
    @PostMapping("/login/actionLogin.do")
	public String actionLogin(@ModelAttribute LoginVO vo, HttpServletRequest request, ModelMap model) throws Exception {
    	
//    //SNS �α���
//    if(!StringUtils.isEmpty(vo.getLoginType())) {
//    	if(vo.getLoginType() == "1") 
//    		vo.setLoginType("kakao");
//    		
//    	else if(vo.getLoginType() == "2")
//    			vo.setLoginType("naver");
//    		
//    	else if(vo.getLoginType() == "3")
//    			vo.setLoginType("google");
//    	
//    	}
    	
    LoginVO resultVO = loginService.actionLogin(vo);
   
	if(resultVO != null && resultVO.getPartnerEmail() != null && !resultVO.getPartnerEmail().equals("")) {
		request.getSession().setAttribute("LoginVO", resultVO);
		return "redirect:/main";
	} else {
		model.addAttribute("loginMessage","�α��� ������ �ùٸ����ʽ��ϴ�"); //�α��� ������ �ùٸ��� �ʽ��ϴ�.
		return "redirect:/login/login";
	}
	
}
    
  //�α׾ƿ�
    
    @GetMapping("/login/actionLogout.do")
    public String actionLogout(HttpServletRequest request, ModelMap model) throws Exception {
    	request.getSession().invalidate(); // ������ ��ȿȭ ��Ű�� �Լ�
    	return "forward:/main";
    }
    
  

}

 