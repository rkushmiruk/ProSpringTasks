package com.kushmiruk.videocourse.core.firstapp;

import java.text.DateFormat;
import java.util.Date;

public class Event {
    private Integer id;
    private String msg;
    private Date date;
    private DateFormat dateFormat;

    public Event(String msg, Date date) {
        this.id = (int) (100 * Math.random());
        this.msg = msg;
        this.date = date;
    }

    public Event(String msg,Date date, DateFormat dateFormat) {
        this.id = (int) (100 * Math.random());
        this.msg = msg;
        this.date = date;
        this.dateFormat = dateFormat;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(DateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public Integer getId() {
        return id;
    }

    public String getMsg() {
        return msg;
    }

    public Date getDate() {
        return date;
    }


    @Override
    public String toString() {
        return "Event { " +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + dateFormat.format(date) +
                " } ";
    }
}
