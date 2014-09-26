package goznauk.No8;

/**
 * Created by goznauk on 2014. 9. 24..
 */
public class BorderDecorator extends Decorator {
    public BorderDecorator(BaseView v) {
        super(v);
    }

    public void viewing() {
        System.out.print("border ");
        v.viewing();
    }
}
