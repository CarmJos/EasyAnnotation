package cc.carm.lib.easyannotation;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * A data holder for annotation meta.
 *
 * @author CarmJos
 * @version 1.0.0
 */
public class AnnotatedMetaHolder {

    protected final Map<AnnotatedMetaType<?, ?>, Object> values;

    public AnnotatedMetaHolder() {
        this(new ConcurrentHashMap<>());
    }

    public AnnotatedMetaHolder(Map<AnnotatedMetaType<?, ?>, Object> values) {
        this.values = values;
    }

    /**
     * Get the value of option.
     *
     * @param type         {@link AnnotatedMetaType}
     * @param defaultValue Default value if the value of option is not set.
     * @param <V>          Value type
     * @return Value of option
     */
    @SuppressWarnings("unchecked")
    @Contract("_, !null -> !null")
    public <V> @Nullable V get(@NotNull AnnotatedMetaType<?, V> type, @Nullable V defaultValue) {
        return (V) values.getOrDefault(type, defaultValue);
    }

    /**
     * Get the value of option.
     *
     * @param type {@link AnnotatedMetaType}
     * @param <V>  Value type
     * @return Value of option
     */
    public <V> @Nullable V get(@NotNull AnnotatedMetaType<?, V> type) {
        return get(type, null);
    }

    /**
     * Set the value of meta, if the value is null, the meta will be removed.
     * <br> Will only be changed in current holder.
     *
     * @param type  {@link AnnotatedMetaType}
     * @param value Value of meta
     * @param <V>   Value type
     * @return Previous value of meta
     */
    @SuppressWarnings("unchecked")
    public <V> @Nullable V set(@NotNull AnnotatedMetaType<?, V> type, @Nullable V value) {
        if (value == null) {
            return (V) values.remove(type);
        } else {
            return (V) values.put(type, value);
        }
    }

    protected void put(@NotNull AnnotatedMetaType<?, ?> type, @Nullable Object value) {
        values.put(type, value);
    }

}
