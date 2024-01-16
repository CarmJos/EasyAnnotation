package cc.carm.tests.easyannotation;

import cc.carm.lib.easyannotation.AnnotatedMetaHolder;
import cc.carm.lib.easyannotation.AnnotatedMetaLoader;
import org.junit.Test;

import java.lang.reflect.Field;

@DemoAnnotation(value = "Bye!")
public class AnnotationTest {

    @DemoAnnotation(value = "Hello!", success = false)
    public static final String SOME_FIELD = "TEST";


    @Test
    public void test() throws Exception {

        // Create a loader
        AnnotatedMetaLoader loader = AnnotatedMetaLoader.of(
                DemoMetas.ANNOTATED, DemoMetas.SAYING, DemoMetas.SUCCESS
        );

        // Load from a field
        Field field = AnnotationTest.class.getField("SOME_FIELD");
        AnnotatedMetaHolder fieldMeta = loader.load(field);
        System.out.println("Field: ");
        System.out.println("  Annotated: " + fieldMeta.get(DemoMetas.ANNOTATED));
        System.out.println("  Saying: " + fieldMeta.get(DemoMetas.SAYING));
        System.out.println("  Success: " + fieldMeta.get(DemoMetas.SUCCESS));

        // Load from a class
        AnnotatedMetaHolder classMeta = loader.load(AnnotationTest.class);
        System.out.println("Class: ");
        System.out.println("  Annotated: " + classMeta.get(DemoMetas.ANNOTATED));
        System.out.println("  Saying: " + classMeta.get(DemoMetas.SAYING));
        System.out.println("  Success: " + classMeta.get(DemoMetas.SUCCESS));
    }


}
