/**
 * Author:    Danial Sheikh
 * The Topscorer Class is used to display  the top scorer throughout premier league history.
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.Scanner;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class Topscorer {
    ArrayList<GoalscorerHistory> goalHistory = new ArrayList<>();

    public void establishConnection() {
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        int status;


        try {
            // Setting up for the request
            URL url = new URL("https://premier-league-player-and-club-statistics.p.rapidapi.com/stats/top/players/goals");
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
            System.out.println(responseContent.toString());
            System.out.println(responseContent.toString().getClass().getSimpleName());

            Gson g = new Gson();
            // Creating a new type token tells gson to convert the JSON data to a list of GoalscorerHistory objects
            Type GoalscorerHistory = new TypeToken<ArrayList<GoalscorerHistory>>() {
            }.getType();

            // Deserialization of the JSON data into a list of GoalscorerHistory objects
            ArrayList<GoalscorerHistory> goalHistory = g.fromJson(responseContent.toString(), GoalscorerHistory);

            // This loops round and prints the players names and stats out
            for (int i = 0; i < goalHistory.size(); i++) {
                System.out.println("rank:" + goalHistory.get(i).getRank() + " name:" + goalHistory.get(i).getName() + " stat:" + goalHistory.get(i).getStat());
            }
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


