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
        return ((p.getX()==list.get(list.size()-1).getX() || p.getY()==list.get(list.size()-1).getY()));
    }

    @Override
    public boolean isInList(Pair<Integer, Integer> value) {
        for (var elem : list) {
            if(elem.getX()==value.getX() && elem.getY()==value.getY()){
                return true;
            }
        }
        return false;
    }

    @Override
    public void setInList(Pair<Integer, Integer> p) {
        if(p.getX()==this.list.get(this.list.size()-1).getX()){
            for(int y=0; y<Math.abs(list.get(list.size()-1).getY()-p.getY()); y++){
                this.list.add(new Pair<>(p.getX(), y));
            }
        } else {
            for(int x=0; x<Math.abs(list.get(list.size()-1).getX()-p.getX()); x++){
                this.list.add(new Pair<>(p.getY(), x));
            }
        }
        this.list.add(p);
    }

}
