package koxign.partner.service;

import java.util.List;

import org.springframework.ui.ModelMap;


public interface PartnerService {
	
	//ȸ��IDã��
	public PartnerVO findpartnerEmail(PartnerVO vo) throws Exception;
	
	//ȸ����й�ȣã��
	public PartnerVO findpartnerPwd(PartnerVO vo) throws Exception;
	
	//ȸ����й�ȣ������Ʈ
	void partnerPwdUpdate(PartnerVO vo) throws Exception;
	
	//ȸ�����
	public List selectpartnerList(PartnerVO vo) throws Exception;
	
	//ȸ����ϼ�
	public int selectPartnerListCnt (PartnerVO vo) throws Exception;
	
	//ȸ����
	ModelMap selectpartner (PartnerVO vo) throws Exception;
}
