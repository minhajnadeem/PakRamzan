package com.example.minhajlib.pakramzan.modal;

/**
 * Created by Minhaj lib on 5/19/2017.
 */

public class TimeModalBahawalpur {
    String roza,saherTime,iftarTime;

    public TimeModalBahawalpur(String roza,String saherTime,String iftarTime){
        setRoza(roza);
        setSaherTime(saherTime);
        setIftarTime(iftarTime);
    }

    public String getRoza() {
        return roza;
    }

    public void setRoza(String roza) {
        this.roza = roza;
    }

    public String getSaherTime() {
        return saherTime;
    }

    public void setSaherTime(String saherTime) {
        this.saherTime = saherTime;
    }

    public String getIftarTime() {
        return iftarTime;
    }

    public void setIftarTime(String iftarTime) {
        this.iftarTime = iftarTime;
    }
}
