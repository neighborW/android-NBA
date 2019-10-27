package com.example.mrwang.nbademo2019.model;

import java.io.Serializable;
public class Point implements Serializable {


    public String playername = null;
    public String playerteam = null;
    public String playerscore = null;
    public String playershotIn = null;
    public String playerthreeIn = null;

    public Point( String playername, String playerteam, String playerscore,String playershotIn,String playerthreeIn) {

        this.playername = playername;
        this.playerteam = playerteam;
        this.playerscore = playerscore;
        this.playershotIn = playershotIn;
        this.playerthreeIn = playerthreeIn;
    }



    public String getPlayername() {
        return playername;
    }

    public String getPlayerteam() {
        return playerteam;
    }

    public String getPlayerscore() {
        return playerscore;
    }

    public String getPlayershotIn() {
        return playershotIn;
    }

    public String getPlayerthreeIn() {
        return playerthreeIn;
    }


    public void setPlayername(String playername) {
        this.playername = playername;
    }

    public void setPlayerteam(String playerteam) {
        this.playerteam = playerteam;
    }

    public void setPlayerscore(String playerscore) {
        this.playerscore = playerscore;
    }

    public void setPlayershotIn(String playershotIn) {
        this.playershotIn = playershotIn;
    }

    public void setPlayerthreeIn(String playerthreeIn) {
        this.playerthreeIn = playerthreeIn;
    }
}
