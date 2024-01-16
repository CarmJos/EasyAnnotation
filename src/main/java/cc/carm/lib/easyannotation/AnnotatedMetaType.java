package cc.carm.lib.easyannotation;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.function.Function;

public abstract class AnnotatedMetaType<N extends Annotation, V> {

    public static <T extends Annotation, E> AnnotatedMetaType<T, E> of(@NotNull Class<T> annotationType,
                                                                       @NotNull Function<T, E> function) {
        return new AnnotatedMetaType<T, E>(annotationType) {
            @Override
            public E getValue(@NotNull T annotation) {
                return function.apply(annotation);
            }
        };
    }

    protected final Class<N> annotationClass;

    protected AnnotatedMetaType(@NotNull Class<N> annotationClass) {
        this.annotationClass = annotationClass;
    }

    public abstract @Nullable V getValue(@NotNull N annotation);

    public @Nullable V get(@Nullable Field field) {
        return field == null ? null : get(field.getAnnotation(annotationClass));
    }

    public @Nullable V get(@Nullable Class<?> clazz) {
        return clazz == null ? null : get(clazz.getAnnotation(annotationClass));
    }

    public @Nullable V get(@Nullable N annotation) {
        return annotation == null ? null : getValue(annotation);
    }

}
