package proto;

public class HomeViewModel {
    public final IBindingProperty<Integer> count = new BindingProperty<>(0);

    public final ICommand increment = new Command(
        () -> count.weakvalue().get() + 1,
        () -> count.weakref()
    );
}
