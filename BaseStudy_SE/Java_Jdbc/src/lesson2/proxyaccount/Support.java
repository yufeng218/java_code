package lesson2.proxyaccount;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.METHOD)			//�������ε����ע��
@Retention(RetentionPolicy.RUNTIME)	//ע����ʲôʱ����Ч
//�����ע����ʦSupport��Ĭ��ֵΪ"none"
public @interface Support {
	String value() default "none";
}
