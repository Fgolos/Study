package com.home.web;

import com.home.web.resources.EndPoint;
import com.home.web.resources.TimeEndpoint;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by FDR on 15.03.2017.
 */
public class Time {
   public Long currentTime;


    public Time() {
    }

    public Time(Long currentTime) {
        this.currentTime = currentTime;
    }
}
