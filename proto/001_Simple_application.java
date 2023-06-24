package proto;

import org.rubber.framework.*;
import org.rubber.framework.yaml.*;
import org.rubber.framework.css.*;
import org.rubber.framework.ui.*;
import org.rubber.framework.window.*;

class Zygote {
    public static void main(String[] args) {
        new Application(
            new PrimaryMonitor(
                new Monitors(),
                new Window(
                    new WindowCenterPos(),
                    new WindowAutoSize(),
                    new WindowTitle("Hello World!"),
                    new Root(
                        new Component(
                            new YamlContent("home.yaml"),
                            new Stylesheet("home.css"),
                            new HomeViewModel()
                        )
                    )
                )
            ),
            new ApplicationArgs(args)
        ).go();
    }
}