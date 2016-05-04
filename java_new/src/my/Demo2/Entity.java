package my.Demo2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//定义注解一定要说明注解修饰的谁
@Target(ElementType.TYPE) //用来修饰类或接口

//定义注解一定要指明注解什么时候有效,可以查看RetentioPolicy
@Retention(RetentionPolicy.RUNTIME) //在运行时有效

public @interface Entity {
	String desClass();
}
