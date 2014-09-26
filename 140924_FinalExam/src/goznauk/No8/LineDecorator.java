package goznauk.No8;

/**
 * Created by goznauk on 2014. 9. 24..
 */
public class LineDecorator extends Decorator {
    public LineDecorator(BaseView v) {
        super(v);
    }

    public void viewing() {
        System.out.print("Line ");
        v.viewing();
    }
}
