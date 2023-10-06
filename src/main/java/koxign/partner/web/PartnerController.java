package koxign.partner.web;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import koxign.partner.service.PartnerService;
import koxign.partner.service.PartnerVO;



@Controller
@RequestMapping("/partner")//@RequestMapping�پ��� ����(GET, POST, PUT, DELETE ��)�� HTTP ��û�� �޼��带
//�����ϴ� �� ����� �� �ִ� ���� �Ϲ����� �뵵�� �ּ��Դϴ�.
public class PartnerController {
	final String path ="partner/";
	
	@Autowired
	PartnerService service;
	
	//ȸ�� IDã��
	@GetMapping("/findId.do")//@GetMappingHTTP GET ��û�� ��Ʈ�ѷ��� Ư�� �޼��忡 �����ϴ� �� ���˴ϴ�.
	//@RequestMapping(method = RequestMethod.GET), HTTP GET ��û�� ��������� ó���Ѵٴ� �ǹ��Դϴ�.
	public String findId(@ModelAttribute("searchVO")PartnerVO vo, ModelMap model,
			HttpSession session)throws Exception{
		
		return "/partner/FindId";
	}
	
	//ȸ�� IDã�� �Ϸ�
	@GetMapping("/findIdComplete.do")
	public String findIdComplete(@ModelAttribute("searchVO")PartnerVO vo, ModelMap model,
			HttpSession session)throws Exception{
		PartnerVO result = service.findpartnerEmail(vo);
		if(result == null || result.getPartnerEmail().isEmpty()) {
			model.addAttribute("message","���Ա� ȸ�������� �����ϴ�.");
			
			 return "forward:/partner/findId.do";
		}
		model.addAttribute("result",result);
		
		
		return "/partner/FindIdComplete";
		
	}
	
	//ȸ����й�ȣ ã��
	@GetMapping("/findPassword.do")
	public String findPassword(@ModelAttribute("searchVO")PartnerVO vo, ModelMap model,
			HttpSession session)throws Exception{
		
		return "/partner/FindPassword";
	}
	
	//ȸ����й�ȣ ����
	@GetMapping("/findPasswordRegist.do")
	public String findPasswordRegist(@ModelAttribute("searchVO")PartnerVO vo, ModelMap model,
			HttpSession session)throws Exception{
		
		
		
		return "forward:/login/login.do";
	}
	
	//ȸ����й�ȣ ������Ʈ
	@GetMapping("/findPasswordComplete.do")
	public String findPasswordComplete(@ModelAttribute("searchVO")PartnerVO vo, ModelMap model,
			HttpSession session)throws Exception{
		service.partnerPwdUpdate(vo);
		model.addAttribute("loginMessage","��й�ȣ�� ������Ʈ �Ǿ����ϴ�.");
		
		return "/partner/FindPasswordRegist";
	}
	
	
	
	
}