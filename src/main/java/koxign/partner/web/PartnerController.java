package koxign.partner.web;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import koxign.partner.service.PartnerService;
import koxign.partner.service.PartnerVO;



@Controller
@RequestMapping("/partner")
public class PartnerController {
	final String path ="partner/";
	
	@Autowired
	PartnerService service;
	
	@GetMapping("/findId.do")
	public String findId(@ModelAttribute("searchVO")PartnerVO vo, ModelMap model,
			HttpSession session)throws Exception{
		
		return "/partner/FindId";
	}
	
	
}