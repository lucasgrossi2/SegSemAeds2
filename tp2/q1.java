

import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class q1 {

    public static class shows{
        private String show_id;
        private String type;
        private String title;
        private String director;
        private String[] cast;
        private String country;
        private Date date_added;
        private int release_year;
        private String rating;
        private String duration;
        private String[] listed_in;

        private shows(String show_id, String type, String title, String director, String[] cast, String country, Date date_added, int release_year, String rating, String duration, String[] listed_in){
            this.show_id = show_id;
            this.type = type;
            this.title = title;
            this.director = director;
            this.cast = cast;
            this.country = country;
            this.date_added = date_added;
            this.release_year = release_year;
            this.rating = rating;
            this.duration = duration;
            this.listed_in = listed_in;
        }

        private shows(){
            this.show_id = null;
            this.type = null;
            this.title = null;
            this.director = null;
            this.cast = null;
            this.country = null;
            this.date_added = null;
            this.release_year = -1;
            this.rating = null;
            this.duration = null;
            this.listed_in = null;
        }

        // Getter and Setter for show_id
        public String getShow_id() {
            return show_id;
        }

        public void setShow_id(String show_id) {
            this.show_id = show_id;
        }

        // Getter and Setter for type
        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        // Getter and Setter for title
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        // Getter and Setter for director
        public String getDirector() {
            return director;
        }

        public void setDirector(String director) {
            this.director = director;
        }

        // Getter and Setter for cast
        public String[] getCast() {
            return cast;
        }

        public void setCast(String[] cast) {
            this.cast = cast;
        }

        // Getter and Setter for country
        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        // Getter and Setter for date_added
        public Date getDate_added() {
            return date_added;
        }

        public void setDate_added(Date date_added) {
            this.date_added = date_added;
        }

        // Getter and Setter for release_year
        public int getRelease_year() {
            return release_year;
        }

        public void setRelease_year(int release_year) {
            this.release_year = release_year;
        }

        // Getter and Setter for rating
        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        // Getter and Setter for duration
        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        // Getter and Setter for listed_in
        public String[] getListed_in() {
            return listed_in;
        }

        public void setListed_in(String[] listed_in) {
            this.listed_in = listed_in;
        }

        public shows clone(){
            return new shows(this.show_id, this.type, this.title, this.director, this.cast, this.country, this.date_added, this.release_year, this.rating, this.duration, this.listed_in);
        }

        public static shows ler(String baseID){
            //String path = "disneyplus.csv";
            String path = "/tmp/disneyplus.csv";
            try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                String line;
                while((line = br.readLine()) != null){
                    if(line.startsWith(baseID + ",")){
                        String[] fields = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                        for(int i = 0; i < fields.length; i++){
                            if (fields[i].isEmpty()) {
                                fields[i] = "NaN";
                            }
                        } 
                        for(int i = 0; i < fields.length; i++){
                            fields[i] = fields[i].trim();
                        }
                        for(int i = 0; i < fields.length; i++){
                            fields[i] = fields[i].replaceAll("^\"|\"$", "");
                        }  
                        
                        String castToSplit = fields[4].replace("\"", "");
                        String listed_inToSplit = fields[10].replace("\"", "");

                        String[] cast = castToSplit.split(",\\s*");
                        insertionSort(cast);
                        String[] listed_in = listed_inToSplit.split(",\\s*");
                        insertionSort(listed_in);
    
                        SimpleDateFormat formatter = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
                        Date dateAdded = null;
                        try {
                            if (!fields[6].equals("NaN")) {
                                dateAdded = formatter.parse(fields[6]);
                            }
                        } catch (ParseException e) {
                            e.printStackTrace(); // or handle the error in some other way
                        }
                        int releaseYear = 0;
                        if (!fields[7].equals("NaN")) {
                            releaseYear = Integer.parseInt(fields[7]);
                        }
                        
                        String noDoubleQuotes = fields[2].replace("\"", "");

                        shows show = new shows(fields[0], fields[1], noDoubleQuotes, fields[3], cast, fields[5], dateAdded, releaseYear, fields[8], fields[9], listed_in); 
                        return show;
                    }
                    
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        public static void imprimir(String baseID){
            SimpleDateFormat outputFormat = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
            shows printableShow = ler(baseID);
            System.out.println("=> " + printableShow.show_id + " ## " + printableShow.title + " ## " + printableShow.type + " ## " + printableShow.director + " ## [" + String.join(", ", printableShow.cast) + "] ## " + printableShow.country + " ## " + outputFormat.format(printableShow.date_added) + " ## " + printableShow.release_year + " ## " + printableShow.rating + " ## " + printableShow.duration + " ## [" + String.join(", ", printableShow.listed_in) + "] ##");
        }
    }

    public static void insertionSort(String[] arr) {
        for (int i = 1; i < arr.length; i++) {
            String key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].compareToIgnoreCase(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            arr[j + 1] = key;
        }
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String baseID = "a";
        baseID = sc.nextLine();
        while(!baseID.equals("FIM")){
            shows.imprimir(baseID);
            baseID = sc.nextLine();
        }
        sc.close();
    }
}