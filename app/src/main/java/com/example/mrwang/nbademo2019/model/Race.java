package com.example.mrwang.nbademo2019.model;

import java.io.Serializable;

public class Race implements Serializable {
    //private int imageId = 0;
    public String raceday = null;
    public String racetime = null;
    public String hometeam = null;
    public String guestteam = null;
    public Race(String raceday,String racetime,String hometeam,String guestteam){
        //this.imageId = imageId;
        this.raceday = raceday;
        this.racetime = racetime;
        this.hometeam = hometeam;
        this.guestteam = guestteam;
    }
//    public int getImageId(){return imageId;}
//    public void setImageId(int imageId){this.imageId = imageId;}

    public String getRaceday(){
        return raceday;
    }
    public void setRaceday(String racetime){ this.raceday = raceday; }

    public String getRacetime(){
        return racetime;
    }
    public void setRacetime(String racetime){
        this.racetime = racetime;
    }

    public String getHometeam(){return hometeam;}
    public void setHometeam(String hometeam){ this.hometeam = hometeam; }

    public String getGuestteam(){return guestteam;}
    public void setGuestteam(String guestteam){
        this.guestteam = guestteam;
    }
}
