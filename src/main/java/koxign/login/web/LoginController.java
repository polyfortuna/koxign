package koxign.login.web;



import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import koxign.login.service.LoginService;
import koxign.login.service.LoginVO;
 
 

@Controller // ���� Ŭ������ ���������� �����ϴ� ��Ʈ�ѷ� bean���� ����
public class LoginController {
	
	
    @Autowired						
    LoginService loginService;
    
    
//    @Autowired ������̼�: ������ �����ӿ�ũ���� ����ϴ� ������̼� �� �ϳ���, �ڵ����� �ʵ�, ������, �޼��� �Ǵ� ���� �޼��忡 �������� �����մϴ�. 
//	  @Autowired�� ����ϸ� ������ �����̳ʰ� �ش� Ŭ������ ��ü�� ã�Ƽ� �����մϴ�.
//
//    LoginService: @Autowired�� �����Ϸ��� Ŭ���� �Ǵ� ���� Ÿ���Դϴ�. �� ��� LoginService Ŭ������ �ν��Ͻ��� �����Ϸ��� �մϴ�.
//
//    ������ ����(Dependency Injection): ��ü ���� ���α׷��ֿ��� �ٸ� ��ü�� �����ϴ� ��ü�� �����ϰų� ����� ��, 
//    �� ���� ���踦 Ŭ���� ���ο��� ���� �����ϴ� ���� �ƴ϶� �ܺο��� ���Թ޾� ����ϴ� ����Դϴ�. �̷��� �ϸ� �ڵ��� �������� �׽�Ʈ ���̼��� ����ų �� �ֽ��ϴ�.
//
//    @Autowired�� ����Ͽ� �������� �����ϸ� ������ �����̳ʰ� �ش� Ÿ���� ���� ã�Ƽ� �����մϴ�. 
//    �̷ν� LoginService Ŭ������ �޼��峪 �ʵ带 ���� Ŭ�������� ����� �� �ְ� �˴ϴ�. 
//    �̰��� �������� IoC (Inversion of Control) ��Ģ�� ������ ��� �� �ϳ��̸�, ������ ���ø����̼ǿ��� �������� �����ϴ� �� ������ �˴ϴ�..
//    
    
    
    // 01. �α��� ȭ�� 
    @RequestMapping("/main/login.do")
    public String login(){
        return "/login/Login";    // views/login/Login.jsp�� ������
    }
    
    //02. �α��� ó��

    @RequestMapping(value = "/login/actionLogin.do")
	public String actionLogin(@ModelAttribute("loginVO") LoginVO loginVO, HttpServletRequest request, ModelMap model) throws Exception {
	
    // �α��� ó�� 	actionLogin �޼��带 ����� ( LoginVO�� @ModelAttribute �� ���� loginVO�� �����Ѵ�.== ��밡���ϴ�. Http  ��û, model(����������) �����ϴ�.
    	  	
    	
    LoginVO resultVO = loginService.actionLogin(loginVO);
   // ���� �� �ڵ�� loginService�� actionLogin �޼��带 ȣ���Ͽ� ����ڰ� �Է��� �α��� ����(loginVO)�� �����ϰ�, 
   //�α��� ����� resultVO�� �����ϴ� �ڵ��Դϴ�. ��������� resultVO���� �α��ο� ���õ� ������ ��� ���� ���̸�, �����ڴ� �� ������ ����Ͽ� �α��� ���� �۾��� ������ �� �ֽ��ϴ�.
    
	if(resultVO != null && resultVO.getPartnerEmail() != null && !resultVO.getPartnerEmail().equals("")) {
		request.getSession().setAttribute("LoginVO", resultVO);
		return "forward:/main";
	} else {
		model.addAttribute("loginMessage","�α��� ������ �ùٸ����ʽ��ϴ�"); //�α��� ������ �ùٸ��� �ʽ��ϴ�.
		return "forward:/login/Login.do";
	}
	
//		resultVO�� null�� �ƴϰ�, resultVO�� partnerEmail�� ��� ���� �ʰ�, ��� ���� ���� ���ڿ��� ���:
//
//		���ǿ� LoginVO ��ü�� �����մϴ�. �̰��� �α����� ������� ������ ���ǿ� �����Ͽ� ���߿� ����� �� �ֵ��� �ϴ� ���Դϴ�.
//		"forward:/main"���� �����̷����մϴ�. �̰��� �α��� ���� �� ����ڸ� ���� �������� �����̷����մϴ�.
//		�׷��� ���� ��� (��, resultVO�� null�̰ų� resultVO�� partnerEmail�� ��� �ְų� ��� ���� ���� ���ڿ��� �ƴ� ���):
//
//		model ��ü�� "�α��� ������ �ùٸ��� �ʽ��ϴ�"��� �޽����� �߰��մϴ�.
//		"forward:/login/Login.do"���� �����̷����մϴ�. �̰��� �α��� ������ �ùٸ��� ���� ��� ����ڸ� �ٽ� �α��� �������� �����̷����մϴ�.
//		���� ����, �� �ڵ�� �α����� �����ϸ� ���� �������� �̵��ϰ�, �����ϸ� �ٽ� �α��� �������� ���ư��� �α��� ������ �����ϰ� �ֽ��ϴ�. �α��� ���� ���δ� resultVO ��ü�� partnerEmail �Ӽ��� ���� Ȯ�ε˴ϴ�.
//	
	
}
    
  //�α׾ƿ�
  	@RequestMapping(value = "/login/actionLogout.do")
  	public String actionLogout(HttpServletRequest request, ModelMap model) throws Exception {
  		
  		request.getSession().invalidate(); // ������ ��ȿȭ ��Ű�� �Լ�
  		return "forward:main";
  	}
}
 