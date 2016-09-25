package lesson2.proxyaccount;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.METHOD)			//用来修饰的类的注解
@Retention(RetentionPolicy.RUNTIME)	//注解在什么时候有效
//定义的注解名师Support，默认值为"none"
public @interface Support {
	String value() default "none";
}
