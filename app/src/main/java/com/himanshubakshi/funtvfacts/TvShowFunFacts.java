package com.himanshubakshi.funtvfacts;

import java.util.List;

/**
 * Created by hbakshi on 5/14/16.
 */
public class TvShowFunFacts {
    List<String> factsList;

    public List<String> getFactstList(){
        return this.factsList;
    }

    public TvShowFunFacts(List<String> facts){
        this.factsList = facts;
    }
}
