package cc.carm.lib.easyannotation;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class AnnotatedMetaLoader {

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

    public AnnotatedMetaHolder load(Class<?> clazz) {
        AnnotatedMetaHolder holder = new AnnotatedMetaHolder();
        for (AnnotatedMetaType<?, ?> type : types) {
            Object v = type.get(clazz);
            if (v != null) holder.put(type, v);
        }
        return holder;
    }

    public AnnotatedMetaHolder load(Field clazz) {
        AnnotatedMetaHolder holder = new AnnotatedMetaHolder();
        for (AnnotatedMetaType<?, ?> type : types) {
            Object v = type.get(clazz);
            if (v != null) holder.put(type, v);
        }
        return holder;
    }

}
