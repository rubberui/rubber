# Rubber UI

The hypothesis that I would like to test is a fully declarative way to create GUI applications in Java, with full compatibility with other JVM languages and GraalVM support, there is no logic in the layout / layout code, and is very flexible, layout is possible like code, and yaml, xml, rbml (Rubber Markup Language).

Initially, I want to test a hypothesis for this product on the Desktop platform, and later, if the community really likes it, we will also implement bindings to the Android platform. Technically, it is planned to use only Java, Skia.

Also, rubber will only support MVVM, since I consider it the most successful idea among others, well, just, I know him well%).

The main goal of the framework is not performance (most likely this will not be the case), but the quality of the product code, and its support.

You may not agree with my ideas about this hypothesis/framework, any comments can be left in the issue, I will be happy to discuss any issues.

## Examples

Some examples may be on two languages (Java, Kotlin), but technically any JVM language is supported (or even GraalVM with FFI, even more languages)

1. An application that will draw a window on the main monitor that will be aligned to the center of the screen, and that will have an automatically calculated size, that will also have the title "Hello World", that will also have a root component that will be created from `home.yaml` markup file, with styles from `home.css`, and with a view of the `HomeViewModel`. In the same application, we are passing arguments from the main function. And simply, we launch this with calling `go()` method. [Example Link - Java](./proto/001_Simple_application.java) • [Example Link - Kotlin](./proto/0011_Simple_application.kt)

2. Everything is the same as in the first example, but the UI is created in the code. Now the content, inside itself, also accepts the rest of the UI elements, `FlexBox`, with two child elements, `TextBlock`, and `Button`, which have a `StyleId` (style identifier), since styling can occur not only in `.css`, but in any other another format (`yaml` for example). We also set `Text` for these components, inside it can take not only `String`. As well as bindings, which is typical for MVVM, for example, `TextBlock` has a `FormattingBinding`, into which we pass what we want to format, respectively, the text (`Count: {}`), namely `{}` will be replaced by first argument. It is similar with the button, but the binding goes exactly by the command, that is, its action, in this example, we will simply increase the counter in the viewmodel. [Example Link - Java](./proto/002_Simple_application_code_ui.java) • [Example Link - Kotlin](./proto/0021_Simple_application_code_ui.kt)

3. An example in RML (Rubber Markup Language), in which the creation of UI elements takes place in RML, everything is the same as in the second example, but in RML. Important note The `<>` operator is a binding operator. The `<` operator, is a one-way binding operator. (Accordingly, `>` is one-way, but in the opposite direction). [Example link](./proto/0022_Simple_application_rml_ui.rml)

## Why Rubber?

Because it is flexible, like rubber, at least it is planned to exist and be so. Since it is possible to write in different JVM languages, use it with FFI with GraalVM, including just compiling into a native application, typing and styling from yaml, xml, rml and code. Extend components and test them with decorating.

## Rubber prototypes:

### Kotlin variant, ([same as](./proto/0011_Simple_application.kt))

```kotlin
fun main(args: Array<String>) {
    Application(
        PrimaryMonitor(
            Monitors(),
            Window(
                WindowCenterPos(),
                WindowAutoSize(),
                WindowTitle("Hello World!"),
                Root(
                    Component(
                        YamlContent("home.yaml"),
                        Stylesheet("home.css"),
                        HomeViewModel()
                    )
                )
            )
        ),
        ApplicationArgs(args)
    ).go()
}
```

### RML (Rubber Markup Language) variant, ([same as](./proto/0022_Simple_application_rml_ui.rml))

```rust
@declare
    vm ~ com.mairwunnx.home.HomeViewModel

FlexBox
    TextBox
        styleId < "text"
        text <> "Count: {}" vm::count
    Button
        styleId < "increment"
        text < "Increment"
        command > vm::increment
```

## [✍️ Версия readme на русском языке](./README-RU.md)