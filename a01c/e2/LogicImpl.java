package a01c.e2;

import java.util.ArrayList;
import java.util.List;

public class LogicImpl implements Logic{

    private final List<Pair<Integer,Integer>> list = new ArrayList<>();

    @Override
    public boolean isFirst(Pair<Integer, Integer> p) {
        if (this.list.size() == 0) {
            this.list.add(p);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOk(Pair<Integer, Integer> p) {
        return ((p.getX()==list.get(0).getX() || p.getY()==list.get(0).getY()));
    }

    @Override
    public boolean isInList(Pair<Integer, Integer> value) {
        return false;
    }

    @Override
    public void setInList(Pair<Integer, Integer> pair) {
        
    }

}
