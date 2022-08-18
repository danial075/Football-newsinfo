/**
 * Author:    Danial Sheikh
 * The Leaguetable Class is used to display the current postions of teams in the premier league
 **/

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Leaguetable {


    public void establishConnection() {
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        int status;


        try {
            // Setting up for the request
            URL url = new URL("https://football-web-pages1.p.rapidapi.com/league-table.json?comp=1");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // Request property gets
            conn.setRequestProperty("X-RapidAPI-Key", "e2a4f3ed6amsh19db660949f60aap11fa87jsn4a260e85a63f");
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(5000);

            // tells me what the current status code is
            status = conn.getResponseCode();
            System.out.println(status);

            // Checks if the connection is established
            if (status != 200) {
                throw new RuntimeException("HttpResponseCode: " + status);
            }
            // If it is then reads the data using a buffered reader
            else {
                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }

// creates a Gson object to parse the Json data into Java Objects
            Gson g = new Gson();


            JsonObject rootObj = g.fromJson(responseContent.toString(), JsonObject.class);

            // converts the Json object to an array and gets team array as the JSON array
            JsonArray locObj = rootObj.getAsJsonObject("league-table").getAsJsonArray("teams");

            // Creating a new type token tells gson to convert the JSON data to a list of Team objects
            Type token = new TypeToken<List<Team>>() {
            }.getType();
            // converts the data from the JSON array to a list of java team objects using the typetoken to say gson should convert it to a list of Team objects.
            List<Team> teams = g.fromJson(locObj.toString(), token);


            Collections.sort(teams, new Comparator<Team>() {
                @Override
                public int compare(Team o1, Team o2) {

                    int compare = Integer.valueOf(o2.getTotalPoints()).compareTo(o1.getTotalPoints());
                    if (compare == 0) {
                        Integer.valueOf(o2.getMatchdata().getGoalDifference()).compareTo(o1.getMatchdata().getGoalDifference());
                    }
                    return compare;
                }
            });
            int postion = 1;
            System.out.println("Premier league table");
            for (int i = 0; i < teams.size(); i++) {

                System.out.println(postion + "." + teams.get(i).getName() + " " + "points:" + teams.get(i).getTotalPoints() + " goal difference:" + teams.get(i).getMatchdata().getGoalDifference() + "\n");
                postion++;
            }


        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//
}
