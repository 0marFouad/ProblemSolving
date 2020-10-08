package Leetcode.Favorite_Genre;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
// CLASS BEGINS, THIS CLASS IS REQUIRED
class Solution {

    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static HashMap<String, List<String>> favoriteVideoGenre(int numUsers,
                                                     HashMap<String, List<String>> userBooksListenedTo,
                                                     int numGenres,
                                                     HashMap<String, List<String>> bookGenres) {
        // WRITE YOUR CODE HERE
        if(numGenres == 0){
            HashMap<String, List<String>> ret = new HashMap<>();
            for (Map.Entry<String, List<String>> entry : userBooksListenedTo.entrySet()) {
                List<String> toInsert = new ArrayList<>();
                String user = entry.getKey();
                ret.put(user,toInsert);
            }
            return ret;
        }
        HashMap<String, Integer> maxForUser = new HashMap<>();
        HashMap<List<String>, Integer> numberOfFavs = new HashMap<>();
        HashMap<String, String> movieGenre = new HashMap<>();
        for (Map.Entry<String, List<String>> entry : bookGenres.entrySet()) {
            String Genre = entry.getKey();
            List<String> movies = entry.getValue();
            for (int i = 0; i < movies.size(); i++) {
                movieGenre.put(movies.get(i), Genre);
            }
        }

        for (Map.Entry<String, List<String>> entry : userBooksListenedTo.entrySet()) {
            String user = entry.getKey();
            maxForUser.put(user, 0);
            List<String> movieList = entry.getValue();
            for (int i = 0; i < movieList.size(); i++) {
                List<String> p = new ArrayList<>();
                p.add(user);
                p.add(movieGenre.get(movieList.get(i)));
                if (numberOfFavs.get(p) == null) {
                    numberOfFavs.put(p, 1);
                    maxForUser.put(user, Math.max(1, maxForUser.get(user)));
                } else {
                    numberOfFavs.put(p, numberOfFavs.get(p) + 1);
                    maxForUser.put(user, Math.max(numberOfFavs.get(p), maxForUser.get(user)));
                }
            }
        }
        HashMap<String, List<String>> result = new HashMap<>();
        for (Map.Entry<String, List<String>> userMap : userBooksListenedTo.entrySet()) {
            List<String> toInsert = new ArrayList<>();
            String user = userMap.getKey();
            for (Map.Entry<String, List<String>> genreMap : bookGenres.entrySet()) {
                String genre = genreMap.getKey();
                List<String> testPair = new ArrayList<>();
                testPair.add(user);
                testPair.add(genre);
                if(numberOfFavs.get(testPair) != null){
                    if (numberOfFavs.get(testPair).equals(maxForUser.get(user))) {
                        toInsert.add(genre);
                    }
                }
            }
            result.put(user, toInsert);
        }


        return result;

    }
    // METHOD SIGNATURE ENDS
    public static void main(String[] args){
        HashMap<String, List<String>> users = new HashMap<>();
        List<String> davidList = new ArrayList<>();
        davidList.add("song11");
        davidList.add("song21");
        davidList.add("song31");
        davidList.add("song41");
        davidList.add("song81");
        users.put("David",davidList);

        List<String> emmaList = new ArrayList<>();
        emmaList.add("song51");
        emmaList.add("song61");
        emmaList.add("song71");
        users.put("Emma",emmaList);

        HashMap<String, List<String>> movies = new HashMap<>();
        List<String> rockList = new ArrayList<>();
        rockList.add("song1");
        rockList.add("song3");
        movies.put("Rock",rockList);

        List<String> dubList = new ArrayList<>();
        dubList.add("song7");
        movies.put("Dubstep",dubList);

        List<String> tList = new ArrayList<>();
        tList.add("song4");
        tList.add("song2");
        movies.put("Techno",tList);

        List<String> pList = new ArrayList<>();
        pList.add("song5");
        pList.add("song6");
        movies.put("Pop",pList);

        List<String> jList = new ArrayList<>();
        jList.add("song8");
        jList.add("song9");
        movies.put("Jazz",jList);

        HashMap<String, List<String>> res =  favoriteVideoGenre(1,users,1,movies);

        for (Map.Entry<String, List<String>> entry : res.entrySet()) {
            List<String> toInsert = entry.getValue();
            String user = entry.getKey();

            System.out.print(user + " ");
            for(int i=0;i<toInsert.size();i++){
                System.out.print(toInsert.get(i) + " ");
            }
            System.out.println("");
        }

    }
}