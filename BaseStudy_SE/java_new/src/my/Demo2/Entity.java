package my.Demo2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//����ע��һ��Ҫ˵��ע�����ε�˭
@Target(ElementType.TYPE) //�����������ӿ�

//����ע��һ��Ҫָ��ע��ʲôʱ����Ч,���Բ鿴RetentioPolicy
@Retention(RetentionPolicy.RUNTIME) //������ʱ��Ч

public @interface Entity {
	String desClass();
}
