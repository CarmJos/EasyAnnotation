package cc.carm.tests.easyannotation;

import cc.carm.lib.easyannotation.AnnotatedMetaType;

public interface DemoMetas {

    /**
     * Meta descriptions
     */
    AnnotatedMetaType<DemoAnnotation, String> SAYING = AnnotatedMetaType.of(DemoAnnotation.class, DemoAnnotation::value);

    AnnotatedMetaType<DemoAnnotation, Boolean> SUCCESS = AnnotatedMetaType.of(DemoAnnotation.class, DemoAnnotation::success);

    AnnotatedMetaType<DemoAnnotation, Boolean> ANNOTATED = AnnotatedMetaType.of(DemoAnnotation.class, (a) -> true);


}
