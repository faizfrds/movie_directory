import java.util.Scanner;
/* This application manages a collection of movies for a user. The movies
 * are representeed by Movie objects. The movies are managed by a MovieList object.
 * The movies are stored in a comma-delimited text file.
 * A user has several options that are displayed in a menu format.
 * This class runs a console interface between a user and the MovieList
*/
import java.io.*;

public class LibraryMain {
       
    public static void main(String[] args) throws IOException{
         // the file to store the user's movies:
         String dataFile = "moviefiles/mymovies.txt";
         //String dataFile = "moviefiles/testing_writing.txt";
         // testing files- uncomment a file for running tests:
         dataFile = "moviefiles/test_no_genre.txt";
         //String dataFile = "moviefiles/test1movie.txt";
         //String dataFile = "moviefiles/test2movies.txt";
         //String dataFile = "moviefiles/test7movies.txt";

         System.out.println("My Movie Library");
         Scanner scan = new Scanner(System.in);
         
         MovieLibrary movieLibrary = new MovieLibrary(dataFile);
         movieLibrary.readAllMovies();

         boolean keepGoing = true;
         String userStr = "";
         
         while(keepGoing) {
              System.out.println("\n\nMain Menu:");
              System.out.println("Enter A to add a movie."); 
              System.out.println("Enter R to remove a movie."); 
              System.out.println("Enter P to view all movies.");
              System.out.println("Enter S to save all movies."); 
              System.out.println("Enter C to clear all movies."); 
              System.out.println("Enter X to quit.");
              System.out.println("");
              userStr = scan.nextLine();
              
              if (userStr.equalsIgnoreCase("A")){
                 System.out.println("Enter the title: ");
                 String title = scan.nextLine();
                 System.out.println("Enter the director");
                 String director = scan.nextLine();                 
                 System.out.println("Enter the genre, enter a space if none: ");
                 String genre = scan.nextLine();
                 System.out.println("Enter the playing time: ");
                 String playTime = scan.nextLine();
                 System.out.println("Enter the release year: ");
                 String releaseYear = scan.nextLine();
                 movieLibrary.addMovie(new Movie(title, director, genre, Double.parseDouble(playTime), Double.parseDouble(releaseYear)));
              }
              else if (userStr.equalsIgnoreCase("R")){
                 System.out.println("Enter the director of the movie to be removed:");
                 String director = scan.nextLine();
                 if(movieLibrary.removeMovieByDirector(director))
                     System.out.println("Movie with director "+director+" removed.");
                 else
                     System.out.println("Could not find "+director+" in the list.");
              }
              else if (userStr.equalsIgnoreCase("S")){
                 System.out.println("Your movies have been saved.");
                 movieLibrary.writeMoviesToFile();
              }
              else if (userStr.equalsIgnoreCase("P")){
                 System.out.println("Your movies: ");
                 System.out.println(movieLibrary.getMovieListAsString());
              }
              else if (userStr.equalsIgnoreCase("C")){
                 movieLibrary.clearMovieList();
                 System.out.println("Movies cleared.");
              }
              else if(userStr.equalsIgnoreCase("X"))
                 keepGoing = false;
              else
                 System.out.println("Unrecognized input.");               
         }
         System.out.println("Bye for now.");
         scan.close();
    }
  }
