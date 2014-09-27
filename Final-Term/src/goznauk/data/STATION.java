package goznauk.data;

/**
 * Created by goznauk on 2014. 9. 26..
 */
public enum STATION {
    SEOUL, CHUNCHEON, ASAN, WONJU, GYEONGJU, DAEJEON, GWANGJU;

    public static STATION parse(String s) {
        if(s.equals("Seoul")) return SEOUL;
        if(s.equals("Chuncheon")) return CHUNCHEON;
        if(s.equals("Asan")) return ASAN;
        if(s.equals("Wonju")) return WONJU;
        if(s.equals("Gyeongju")) return GYEONGJU;
        if(s.equals("Deajeon")) return DAEJEON;
        if(s.equals("Gwangju")) return GWANGJU;
        return null;
    }
}
