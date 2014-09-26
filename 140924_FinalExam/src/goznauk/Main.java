package goznauk;

import goznauk.No5.TreeMapTest;
import goznauk.No6.InputStreamReaderMain;
import goznauk.No8.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        ScrollDecorator sd = new ScrollDecorator(new TextView());
        sd.viewing();
        SpringDecorator spd = new SpringDecorator(new LineDecorator(new TextView()));
        spd.viewing();
        LineDecorator ld = new LineDecorator(new ScrollDecorator(new BorderDecorator(new TextView())));
        ld.viewing();
    }
}
