package b01b.e2;

import java.util.List;
import java.util.ArrayList;

/**
 * LogicImpl
 */
public class LogicImpl implements Logic{

    private final List<Pair<Integer,Integer>> marks = new ArrayList<>();
    private Integer count = 1;

    @Override
    public void hit(Pair<Integer, Integer> pos) {
        if(count<=5){
            marks.add(pos);
        }
    }

    @Override
    public String write() {
        return (this.count <= 5) ? Integer.toString(this.count++) : "";
    }

    
}