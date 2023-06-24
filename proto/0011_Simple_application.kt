package proto;

import org.rubber.framework.*;
import org.rubber.framework.yaml.*;
import org.rubber.framework.css.*;
import org.rubber.framework.ui.*;
import org.rubber.framework.window.*;

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