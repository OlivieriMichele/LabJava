package a01b.e2;

import java.util.ArrayList;
import java.util.List;

public class LogicImpl implements Logic{

    private List<Pair<Integer,Integer>> hit = new ArrayList<>();

    @Override
    public HitType hit(int x, int y) {
        var pos = new Pair<>(x, y);
        if (this.hit.size()==3) {
            this.hit.clear();
        }
        if (!this.ok(pos)){
            return HitType.WRONG;
        }
        this.hit.add(pos);
        switch (this.hit.size()) {
            case 1: return HitType.FIRST;
            case 2: return HitType.SECOND;
            case 3: return HitType.THIRD;
            default: return HitType.WRONG;
        }
    }

    private boolean ok(Pair<Integer,Integer> pos){
        switch (this.hit.size()) {
            case 0: return true;
            case 1: return (pos.getX()==this.hit.get(0).getX()) || (pos.getY()==this.hit.get(0).getY());
            case 2: return (this.hit.get(0).getX()==this.hit.get(1).getX())&&(pos.getY()==this.hit.get(0).getY()) || 
                            (this.hit.get(0).getY()==this.hit.get(1).getY())&&(pos.getX()==this.hit.get(0).getX());
            default: return false;
        }
    }

    @Override
    public boolean isStar(Integer x, Integer y) {
        if(isInRange(new Pair<>(x, y),hit.get(0),hit.get(1))||isInRange(new Pair<>(x, y),hit.get(0),hit.get(2))){
            return true;
        }
        return false;
    }

    private boolean isInRange(Pair<Integer, Integer> point, Pair<Integer, Integer> first, Pair<Integer, Integer> second) {
        return((point.getX() == first.getX()) && (point.getX() == second.getX() && this.exclude(point.getY(), first.getY(), second.getY())) ||
            (point.getY() == first.getY()) && (point.getY() == second.getY()) && this.exclude(point.getX(),first.getX(),second.getX()));
    }

    private boolean exclude(Integer p, Integer x1, Integer x2) {
        return (p>=Math.min(x1, x2) && p<=Math.max(x1, x2));
    }

}
