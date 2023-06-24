package proto;

import org.rubber.framework.*;
import org.rubber.framework.yaml.*;
import org.rubber.framework.css.*;
import org.rubber.framework.ui.*;
import org.rubber.framework.window.*;
import org.rubber.framework.data.*;
import org.rubber.framework.input.*;

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
                        Content(
                            FlexBox(
                                TextBlock(
                                    StyleId("text"),
                                    Text("Count: {}"),
                                    FormattingBinding { listOf(vm.count) }
                                ),
                                Button(
                                    StyleId("increment"),
                                    Text("increment"),
                                    CommandBinding { vm.increment }
                                )
                            )
                        ),
                        Stylesheet("home.css"),
                        HomeViewModel()
                    )
                )
            )
        ),
        ApplicationArgs(args)
    ).go();
}