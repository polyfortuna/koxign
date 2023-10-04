package koxign.partner.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import koxign.partner.service.PartnerService;
import koxign.partner.service.PartnerVO;

@Service
public class PartnerServiceImpl implements PartnerService {
	
	@Autowired
	private PartnerMapper partenerMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	   //ȸ�� IDã��
		public PartnerVO findpartnerEmail(PartnerVO vo) throws Exception{
		   return findpartnerEmail(vo);
	   }
	   
	   //ȸ����й�ȣ ã��
		public PartnerVO findpartnerPwd(PartnerVO vo) throws Exception{
		   return findpartnerPwd(vo);
	   }
	   
		//ȸ����й�ȣ������Ʈ
		public void partnerPwdUpdate(PartnerVO vo) throws Exception{
			//�Է��� ��й�ȣ�� ��ȣȭ�Ѵ�
			String encodedPassword = passwordEncoder.encode(vo.getPartnerPwd());			
			vo.setPartnerPwd(encodedPassword);
			
			partnerPwdUpdate(vo);
		}
		
		//ȸ�����
		public List selectpartnerList(PartnerVO vo) throws Exception{
			return selectpartnerList(vo);
		}
		
			
		//ȸ����� ��
		public int selectPartnerListCnt (PartnerVO vo) throws Exception{
			return selectPartnerListCnt(vo);
		}
		
		//ȸ����
		public ModelMap selectpartner (PartnerVO vo) throws Exception{
			return selectpartner(vo);
		}

}
