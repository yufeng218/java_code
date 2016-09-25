package lesson2.orm;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)		//–ﬁ Œ Ù–‘
@Retention(RetentionPolicy.RUNTIME)
public @interface TypeName {
	String value();
}
