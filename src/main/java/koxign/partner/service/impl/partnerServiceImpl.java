package koxign.partner.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import koxign.partner.dao.PartnerDao;
import koxign.partner.service.PartnerVO;

@Service
public class partnerServiceImpl {
	@Autowired
	PartnerDao dao;
	
	   //ȸ�� IDã��
		public PartnerVO findpartnerEmail(PartnerVO vo) throws Exception{
		   return memberMapper.findId(vo);
	   }
	   
	   //ȸ����й�ȣ ã��
		public PartnerVO findpartnerPwd(PartnerVO vo) throws Exception{
		   return memberMapper.findPassword(vo);
	   }
	   
		//ȸ����й�ȣ������Ʈ
		public void partnerPwdUpdate(PartnerVO vo) throws Exception{
			//�Է��� ��й�ȣ�� ��ȣȭ�Ѵ�
			String enpassword = EgovFileScrty.encryptPassword(vo.getPassword(),vo.getEmplyrId());
			vo.setPassword(enpassword);
			
			memberMapper.passwordUpdate(vo);
		}
		
		//ȸ�����
		public List selectpartnerList(PartnerVO vo) throws Exception{
			return memberMapper.selectMberList(vo);
		}
		
			
		//ȸ����� ��
		public int selectPartnerListCnt (PartnerVO vo) throws Exception{
			return memberMapper.selectMberListCnt(vo);
		}
		
		//ȸ����
		ModelMap selectpartner (PartnerVO vo) throws Exception{
			return memberMapper.selectMber(vo);
		}

}
