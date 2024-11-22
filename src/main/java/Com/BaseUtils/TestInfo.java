package Com.BaseUtils;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface TestInfo {
	
	public Tags[] tags();
	
	public String TCId() default ""; // Default value is an empty string
	
	public String Feature() default "";

}
