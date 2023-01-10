/**
 * This class encapsulates the data required to represent a movie in a movie collection.
 * The attributes of a song are: title, director, genre, and playing time, and release year.
 * The title, director, playing time and release year are required fields. The genre field is optional.
 * The playing time is represented by a double value. For example, a playing time of 
 * one hour and thirty-five minutes would be the number 1.35.
 **/
public class Movie {

   private String title;
   private String director;
   private String genre;
   private double playTime;
   private double releaseYear;
   
   /* Constructor when the genre field is not present.
   */
   public Movie(String title, String director, double playTime, double releaseYear){
      this.title = title;
      this.director = director;
      this.playTime = playTime; 
      this.releaseYear = releaseYear;
   }
  
   /* Constructor when all fields are present.
   */ 
   public Movie(String title, String director, String genre, double playTime, double releaseYear){
      this.title = title;
      this.director = director;
      this.genre = genre; 
      this.playTime = playTime;
      this.releaseYear = releaseYear;    
   }
   
   public String getTitle(){
      return title;
   }
   
   public String getDirector(){
      return director;
   }
   
   public String getGenre(){
      return genre;
   }
   
   public double getPlayTime(){
      return playTime;
   }

   public double getReleaseYear(){
      return releaseYear;
   }
   public String toString(){
      return title+","+director+","+genre+","+playTime+","+releaseYear;
   }
}
