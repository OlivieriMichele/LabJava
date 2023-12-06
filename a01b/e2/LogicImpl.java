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
            case 1:
                return HitType.FIRST;
            case 2:
                return HitType.SECOND;
            case 3:
                return HitType.THIRD;
            default:
                return HitType.WRONG;
        }
    }

    private boolean ok(Pair<Integer,Integer> pos){
        return true;
    }

}
