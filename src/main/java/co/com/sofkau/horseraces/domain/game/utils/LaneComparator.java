package co.com.sofkau.horseraces.domain.game.utils;

import co.com.sofkau.horseraces.domain.game.Lane;

import java.util.Comparator;

public class LaneComparator implements Comparator<Lane> {

    @Override
    public int compare(Lane e1, Lane e2) {
        if(e1.getSpeed().value()<e2.getSpeed().value()){
            return 1;
        }else if(e1.getSpeed().value()>e2.getSpeed().value()){
            return -1;
        }else{
            return 0;
        }
    }
}
