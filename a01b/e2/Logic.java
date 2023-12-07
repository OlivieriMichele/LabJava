package a01b.e2;

public interface Logic {

    enum HitType{ FIRST, SECOND, THIRD, WRONG};

    HitType hit(int x, int y);

    boolean isStar(Integer x, Integer y);

    //boolean isSelected(int x, int y);

}
