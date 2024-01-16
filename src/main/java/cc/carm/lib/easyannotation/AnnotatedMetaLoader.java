package cc.carm.lib.easyannotation;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * The Annotated meta loader.
 * <br> {@link AnnotatedMetaLoader} will load the registered meta types from {@link Class} or {@link Field}.
 *
 * @author CarmJos
 * @version 1.0.0
 */
public class AnnotatedMetaLoader {

    /**
     * Create a new Annotated meta loader.
     *
     * @param types The types to register
     * @return The new Annotated meta loader
     */
    public static AnnotatedMetaLoader of(AnnotatedMetaType<?, ?>... types) {
        return of(Arrays.asList(types));
    }

    public static AnnotatedMetaLoader of(Collection<AnnotatedMetaType<?, ?>> types) {
        return new AnnotatedMetaLoader(new HashSet<>(types));
    }

    protected final Set<AnnotatedMetaType<?, ?>> types;

    public AnnotatedMetaLoader(Set<AnnotatedMetaType<?, ?>> types) {
        this.types = types;
    }

    public void register(AnnotatedMetaType<?, ?> type) {
        types.add(type);
    }

    public void unregister(AnnotatedMetaType<?, ?> type) {
        types.remove(type);
    }

    /**
     * Load meta from a class.
     *
     * @param clazz The class to load
     * @return {@link AnnotatedMetaHolder}
     */
    public AnnotatedMetaHolder load(Class<?> clazz) {
        AnnotatedMetaHolder holder = new AnnotatedMetaHolder();
        for (AnnotatedMetaType<?, ?> type : types) {
            Object v = type.get(clazz);
            if (v != null) holder.put(type, v);
        }
        return holder;
    }

    /**
     * Load meta from a field.
     *
     * @param clazz The field to load
     * @return {@link AnnotatedMetaHolder}
     */
    public AnnotatedMetaHolder load(Field clazz) {
        AnnotatedMetaHolder holder = new AnnotatedMetaHolder();
        for (AnnotatedMetaType<?, ?> type : types) {
            Object v = type.get(clazz);
            if (v != null) holder.put(type, v);
        }
        return holder;
    }

}
