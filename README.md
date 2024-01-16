```text
 ___                _                 _        _   _          
| __|__ _ ____  _  /_\  _ _  _ _  ___| |_ __ _| |_(_)___ _ _  
| _|/ _` (_-< || |/ _ \| ' \| ' \/ _ \  _/ _` |  _| / _ \ ' \ 
|___\__,_/__/\_, /_/ \_\_||_|_||_\___/\__\__,_|\__|_\___/_||_|
             |__/                                             
```

README LANGUAGES [ [**English**](README.md) | [中文](README_CN.md)  ]

# EasyAnnotation

[![version](https://img.shields.io/github/v/release/CarmJos/EasyAnnotation)](https://github.com/CarmJos/EasyAnnotation/releases)
[![License](https://img.shields.io/github/license/CarmJos/EasyAnnotation)](https://www.gnu.org/licenses/lgpl-3.0.html)
[![workflow](https://github.com/CarmJos/EasyAnnotation/actions/workflows/maven.yml/badge.svg?branch=master)](https://github.com/CarmJos/EasyAnnotation/actions/workflows/maven.yml)
[![CodeFactor](https://www.codefactor.io/repository/github/carmjos/EasyAnnotation/badge)](https://www.codefactor.io/repository/github/carmjos/EasyAnnotation)
![CodeSize](https://img.shields.io/github/languages/code-size/CarmJos/EasyAnnotation)
![](https://visitor-badge.glitch.me/badge?page_id=EasyAnnotation.readme)


**Easy _(to use)_ Annotations!** 

A lightweight, easy-to-use annotation load library in Java,
which can use the data values in the annotations in a simple, friendly and expandable way.

## Development

For the latest JavaDoc release, [CLICK HERE](https://CarmJos.github.io/EasyAnnotation).

### Code Samples

```java
public interface DemoMetas {

    /**
     * Meta descriptions
     */
    AnnotatedMetaType<DemoAnnotation, String> SAYING = AnnotatedMetaType.of(DemoAnnotation.class, DemoAnnotation::value);
    
    AnnotatedMetaType<DemoAnnotation, Boolean> SUCCESS = AnnotatedMetaType.of(DemoAnnotation.class, DemoAnnotation::success);
    
    AnnotatedMetaType<DemoAnnotation, Boolean> ANNOTATED = AnnotatedMetaType.of(DemoAnnotation.class, (a) -> true);
    
}

```

```java
public class Sample {
    public static void main(String[] args) {
        // Create a loader
        AnnotatedMetaLoader loader = AnnotatedMetaLoader.of(
                DemoMetas.ANNOTATED, DemoMetas.SAYING, DemoMetas.SUCCESS
        );

        // Load from a field
        Field field = AnnotationTest.class.getField("SOME_FIELD");
        AnnotatedMetaHolder fieldMeta = loader.load(field);
        boolean annotated = fieldMeta.get(DemoMetas.ANNOTATED);

        // Load from a class
        AnnotatedMetaHolder classMeta = loader.load(AnnotationTest.class);
        String saying = classMeta.get(DemoMetas.SAYING);
    }
}
```

### Dependencies

#### Maven Dependency

<details>
<summary>Remote Repository Configuration</summary>

```xml

<project>
    <repositories>

        <repository>
            <!-- Using Maven Central Repository for secure and stable updates, though synchronization might be needed. -->
            <id>maven</id>
            <name>Maven Central</name>
            <url>https://repo1.maven.org/maven2</url>
        </repository>

        <repository>
            <!-- Using GitHub dependencies for real-time updates, configure required (recommended). -->
            <id>github</id>
            <name>GitHub Packages</name>
            <url>https://maven.pkg.github.com/CarmJos/EasyAnnotation</url>
        </repository>

    </repositories>
</project>
```

</details>

<details>
<summary>Generic Native Dependency</summary>

```xml

<project>
    <dependencies>
        <dependency>
            <groupId>cc.carm.lib</groupId>
            <artifactId>easyannotation</artifactId>
            <version>[LATEST RELEASE]</version>
            <scope>compile</scope>
        </dependency>
    </dependencies>
</project>
```

</details>

#### Gradle Dependency

<details>
<summary>Remote Repository Configuration</summary>

```groovy
repositories {

    // Using Maven Central Repository for secure and stable updates, though synchronization might be needed.
    mavenCentral()

    // Using GitHub dependencies for real-time updates, configure required (recommended).
    maven { url 'https://maven.pkg.github.com/CarmJos/EasyAnnotation' }

}
```

</details>

<details>
<summary>Generic Native Dependency</summary>

```groovy

dependencies {
    api "cc.carm.lib:easyannotation:[LATEST RELEASE]"
}
```

</details>

## Support and Donation

If you appreciate this plugin, consider supporting me with a donation!

Thank you for supporting open-source projects!

Many thanks to Jetbrains for kindly providing a license for us to work on this and other open-source projects.

[![](https://resources.jetbrains.com/storage/products/company/brand/logos/jb_beam.svg)](https://www.jetbrains.com/?from=https://github.com/CarmJos/EasyAnnotation)

## Open Source License

This project's source code is licensed under [The MIT License](https://opensource.org/licenses/MIT).
