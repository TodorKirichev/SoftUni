package ProgrammingBasicsOnlineExam6and7April2019;

import java.util.Scanner;

public class MovieRatings {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int numMovies = Integer.parseInt(scan.nextLine());
        double minRating = Integer.MAX_VALUE;
        double maxRating = Integer.MIN_VALUE;
        String maxMovieRating = "";
        String minMovieRating = "";
        double averageRating = 0;

        for (int i = 0; i < numMovies; i++) {
            String movieName = scan.nextLine();
            double rating = Double.parseDouble(scan.nextLine());
            if (rating>maxRating){
                maxRating=rating;
                maxMovieRating=movieName;
            }else if (rating<minRating){
                minRating=rating;
                minMovieRating=movieName;
            }
            averageRating+=rating;

        }
        System.out.printf("%s is with highest rating: %.1f%n",maxMovieRating,maxRating);
        System.out.printf("%s is with lowest rating: %.1f%n",minMovieRating,minRating);
        System.out.printf("Average rating: %.1f%n",averageRating/numMovies);
    }
}
