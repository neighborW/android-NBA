package com.example.mrwang.nbademo2019.model;

public class Player {
     String playername;
     String  playerteam;
     String playerjob;
     String playertall;
     String playerweight;
     public Player(String playername,String playerteam,String playerjob,String playertall,String playerweight) {

         this.playername = playername;
         this.playerteam = playerteam;
         this.playerjob = playerjob;
         this.playertall = playertall;
         this.playerweight = playerweight;
      }
      public String getPlayername(){
         return  playername;
      }
      public void getPlayername(String playername){
         this.playername = playername;
      }

      public String getPlayerteam(){
         return playerteam;
      }
      public void getPlayerteam(String playerteam){

         this.playerteam = playerteam;
      }

      public String getPlayerjob(){
         return playerjob;
     }
     public  void getPlayerjob(String playerjob){

         this.playerjob = playerjob;
     }

      public String getPlayertall(){
         return playertall;
      }
      public void getPlayertall(String playertall){
         this.playertall = playertall;
      }
      public String getPlayerweight(){
         return playerweight;
      }
      public void getPlayerweight(String playerweight){
         this.playerweight = playerweight;
      }
}
