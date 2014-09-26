package goznauk.No8;

/**
 * Created by goznauk on 2014. 9. 24..
 */
public class SpringDecorator extends Decorator {
    public SpringDecorator(BaseView v) {
        super(v);
    }

    public void viewing() {
        System.out.print("spring ");
        v.viewing();
    }
}
