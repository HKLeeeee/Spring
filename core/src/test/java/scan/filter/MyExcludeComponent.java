package scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE) // type -> class level
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
}
