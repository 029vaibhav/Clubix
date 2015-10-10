package com.prolificwebworks.theclubix.utils;

import com.prolificwebworks.theclubix.entities.EventData;

import java.util.List;


/**
 * Created by vaibhav on 10/10/15.
 */
public enum MyEnum {


    INSTANCE;

    public List<EventData> today, tomorrow, later;

    public List<EventData> getToday() {
        return today;
    }

    public void setToday(List<EventData> today) {
        this.today = today;
    }

    public List<EventData> getTomorrow() {
        return tomorrow;
    }

    public void setTomorrow(List<EventData> tomorrow) {
        this.tomorrow = tomorrow;
    }

    public List<EventData> getLater() {
        return later;
    }

    public void setLater(List<EventData> later) {
        this.later = later;
    }
}
