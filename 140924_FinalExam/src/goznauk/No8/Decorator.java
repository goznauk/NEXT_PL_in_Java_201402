package goznauk.No8;

/**
 * Created by goznauk on 2014. 9. 24..
 */
public abstract class Decorator extends BaseView {
    protected volatile BaseView v;
    protected Decorator(BaseView v) {
        this.v = v;
    }
    public void viewing() {
        System.out.println(str);
    }
}
