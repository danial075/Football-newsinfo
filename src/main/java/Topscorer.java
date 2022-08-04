// this class displays the top scorer throughout premier league history.

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

           Type GoalscorerHistory = new TypeToken<ArrayList<GoalscorerHistory>>(){}.getType();
            ArrayList<GoalscorerHistory> goalHistory = g.fromJson(responseContent.toString(),GoalscorerHistory);
//            GoalscorerHistory[] footballer = g.fromJson(responseContent.toString(), GoalscorerHistory[].class);
            // On the LHS new array of type GoalscorerHistory
            // and on the rhs using the parser and fromJson method which allows us to read the json data in an array format



//            for (GoalscorerHistory i : footballer) {
//                GoalscorerHistory j = new GoalscorerHistory(i.getRank(), i.getName(), i.getNationality(), i.getStat());
//                goalHistory.add(j);
//            }
//            ArrayList<GoalscorerHistory> goalHistory = new ArrayList<>();
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


