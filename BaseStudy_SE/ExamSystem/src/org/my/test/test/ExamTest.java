package org.my.test.test;

import javax.swing.text.html.parser.Entity;

import org.my.test.contol.ClientContext;
import org.my.test.data.EntityContext;
import org.my.test.service.ExamServiceImpl;
import org.my.test.view.ExamFrame;
import org.my.test.view.LoginFrame;
import org.my.test.view.MenuFrame;

public class ExamTest {

	public static void main(String[] args) {
		
		//��ͼ����
		LoginFrame loginFrame = new LoginFrame();
		MenuFrame menuFrame = new MenuFrame();
		ExamFrame examFrame = new ExamFrame();
		
		//����������
		ClientContext clientContext = new ClientContext();
		
		//������ͼ�������֮�������
		loginFrame.setClientContext(clientContext);
		menuFrame.setClientContext(clientContext);
		examFrame.setClientContext(clientContext);
		
		//�������ݲ����
		EntityContext entityContext = new EntityContext();
		//����ҵ������
		ExamServiceImpl examService = new ExamServiceImpl();
		//�������ݲ��ҵ������ϵ
		examService.setEntityContext(entityContext);
		//������������ҵ������ϵ
		clientContext.setExamService(examService);
		
		loginFrame.setVisible(true);
	}

}
