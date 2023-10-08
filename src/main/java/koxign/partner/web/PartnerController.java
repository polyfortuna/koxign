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
public class PartnerController {
	final String path ="partner/";
	
	@Autowired
	PartnerService service;
	
	//ȸ�� IDã��
	@RequestMapping("/partner/findId.do")
	//@RequestMapping�پ��� ����(GET, POST, PUT, DELETE ��)�� HTTP ��û�� �޼��带 �����ϴ� �� ����� �� �ִ� ���� �Ϲ����� �뵵�� �ּ��Դϴ�.
	//@GetMappingHTTP GET ��û�� ��Ʈ�ѷ��� Ư�� �޼��忡 �����ϴ� �� ���˴ϴ�.
	//@RequestMapping(method = RequestMethod.GET), HTTP GET ��û�� ��������� ó���Ѵٴ� �ǹ��Դϴ�.
	public String findId(@ModelAttribute("searchVO")PartnerVO vo, ModelMap model,
			HttpSession session)throws Exception{
		
		return "/partner/FindId";
	}
	
	//ȸ�� IDã�� �Ϸ�
	@RequestMapping("/partner/findIdComplete.do")
	public String findIdComplete(@ModelAttribute("searchVO")PartnerVO vo, ModelMap model,
			HttpSession session)throws Exception{
		
		PartnerVO result = service.findpartnerEmail(vo);
		if(result == null || result.getPartnerEmail().isEmpty()) {
			model.addAttribute("message","���Ե� ȸ�������� �����ϴ�.");
			
			 return "forward:/partner/findId.do";
		}
		model.addAttribute("result",result);
		
		return "/partner/FindIdComplete";
		
	}
	
	//ȸ����й�ȣ ã��
	@RequestMapping("/partner/findPassword.do")
	public String findPassword(@ModelAttribute("searchVO")PartnerVO vo, ModelMap model,
			HttpSession session)throws Exception{
		
		return "/partner/FindPassword";
	}
	
	//ȸ����й�ȣ ����
	@RequestMapping("//partnerfindPasswordRegist.do")
	public String findPasswordRegist(@ModelAttribute("searchVO")PartnerVO vo, ModelMap model,
			HttpSession session)throws Exception{
		
		PartnerVO result = service.findpartnerPwd(vo);
		if(result == null || result.getPartnerEmail().isEmpty()) {
			model.addAttribute("message","���Ե� ȸ�������� �����ϴ�.");
			
			 return "forward:/partner/findPasswordRegist.do";
		}
		model.addAttribute("result",result);
		
		
		return "/partner/FindPasswordRegist";
	}
	
	//ȸ����й�ȣ ������Ʈ
	@RequestMapping("/partner/findPasswordComplete.do")
	public String findPasswordComplete(@ModelAttribute("searchVO")PartnerVO vo, ModelMap model,
			HttpSession session)throws Exception{
		service.partnerPwdUpdate(vo);
		model.addAttribute("loginMessage","��й�ȣ�� ������Ʈ �Ǿ����ϴ�.");
		
		return "forward:/login/login.do";
	}
	
	
	
	
}