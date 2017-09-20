package n3.algorithms.common.tag;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author hzyemao
 * @version 1.0 , 2017/9/20
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface Tag {

    KeyIdea[] value();
}
