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
		
		//视图对象
		LoginFrame loginFrame = new LoginFrame();
		MenuFrame menuFrame = new MenuFrame();
		ExamFrame examFrame = new ExamFrame();
		
		//控制器对象
		ClientContext clientContext = new ClientContext();
		
		//设置视图与控制器之间的依赖
		loginFrame.setClientContext(clientContext);
		menuFrame.setClientContext(clientContext);
		examFrame.setClientContext(clientContext);
		
		//创建数据层对象
		EntityContext entityContext = new EntityContext();
		//创建业务层对象
		ExamServiceImpl examService = new ExamServiceImpl();
		//建立数据层和业务层的联系
		examService.setEntityContext(entityContext);
		//建立控制器和业务层的联系
		clientContext.setExamService(examService);
		
		loginFrame.setVisible(true);
	}

}
