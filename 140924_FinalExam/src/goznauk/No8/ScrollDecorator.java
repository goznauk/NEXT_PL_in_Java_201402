package goznauk.No8;

/**
 * Created by goznauk on 2014. 9. 24..
 */
public class ScrollDecorator extends Decorator {
    public ScrollDecorator(BaseView v) {
        super(v);
    }

    public void viewing() {
        System.out.print("scroll ");
        v.viewing();
    }
}
