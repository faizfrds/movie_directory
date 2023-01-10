import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.File;
import java.util.Scanner;

public class MovieLibrary {
 
   ArrayList<Movie> movieList = new ArrayList<Movie>();
   String fileName;
   Scanner scnr;
   
   public MovieLibrary(String fileName){
   
      this.fileName = fileName; //initializing the fileName of class using the user-provided file name using constructor
   }
   
   public boolean isEmpty(){
   
      if(movieList.size()==0){ //if the arraylist size of movies is zero then it contains no elements thus is an empty list
      
         return true;
      }
      
      else{
      
         return false;
      } 
   }

   public void readAllMovies()  {
   
      try{    
      
         FileInputStream fileInput = new FileInputStream(fileName); //creating an input stream in order to allow for file reading
       
         Scanner scnr = new Scanner(fileInput); //using scanner to open the input stream of the file

         while(scnr.hasNextLine()){
         
            String line = scnr.nextLine();
            addMovie(this.processALine(line));    
         }
         scnr.close();   
      
      }catch(IOException e){System.out.println(e);}
   }

   public Movie processALine(String aLine) {
      
      String [] details = aLine.split(","); //split the string whenever a comman appears based on CSV format
       
      Movie movies = new Movie(details[0],details[1],details[2],Double.valueOf(details[3]),Double.valueOf(details[4])); //creating movie object based on the split string
      
      return movies;
   }

   public void writeMoviesToFile() {
      try{
      
         FileOutputStream fileOutput = new FileOutputStream(fileName); //creating output stream to write to a file
         
         char [] charArray = getMovieListAsString().toCharArray();
         
         for (int i = 0; i < charArray.length; i++){
             
            fileOutput.write(charArray[i]); //writing to file by using characters one by one using output stream
         }
         
         fileOutput.close();
      }
      
      catch(IOException e){System.out.println(e);} 
   }
      
   
 
   public void addMovie(Movie newMovie){
   
      movieList.add(newMovie);
   }
   
   public String getMovieListAsString(){
    
      String stringList = "";
      
      if (movieList.size()==0){
   
         return "no movies";
      }
      else{
         
         for (int i = 0; i < movieList.size(); i++){
            
            //generating a string line for each item inside array list
            stringList = stringList + movieList.get(i).getTitle()+","+movieList.get(i).getDirector()+","+movieList.get(i).getGenre()+
                           ","+String.valueOf(movieList.get(i).getPlayTime())+","+String.valueOf(movieList.get(i).getReleaseYear());
            
            //separate lines using new line
            if (i != movieList.size()-1){
               stringList = stringList + "\n";
            }
         }
         
         return stringList;
      }
   
   }
   
   public boolean removeMovieByDirector(String targetDirector){ 
      
      for (int k = 0; k < movieList.size(); k++){
               
         Movie currMovie = movieList.get(k);
         
         if (currMovie.getDirector().equals(targetDirector)){
             
            movieList.remove(k);
            return true;
         }
      }
      
      return false;         
   }
   
   public ArrayList<Movie> getMovieList(){
      
      ArrayList<Movie> getList = new ArrayList<Movie>();;
      
      for (Movie currMovie : movieList){
         
         getList.add(currMovie);
      }
      
      return getList;
   }

   public void clearMovieList(){
   
      movieList.clear();
   }   
}
