
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Data {
	String name() default "Default Name";
	int num() default 0;
}
