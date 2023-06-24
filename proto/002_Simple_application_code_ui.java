package proto;

import org.rubber.framework.*;
import org.rubber.framework.yaml.*;
import org.rubber.framework.css.*;
import org.rubber.framework.ui.*;
import org.rubber.framework.window.*;
import org.rubber.framework.data.*;
import org.rubber.framework.input.*;

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
                            new Content(
                                new FlexBox(
                                    new TextBlock(
                                        new StyleId("text"),
                                        new Text("Count: {}"),
                                        new FormattingBinding(() -> List.of(vm.count))
                                    ),
                                    new Button(
                                        new StyleId("increment"),
                                        new Text("increment"),
                                        new CommandBinding(() -> vm.increment)
                                    )
                                )
                            ),
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