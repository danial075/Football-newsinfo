// // This class displays the latest transfers

import com.google.gson.Gson;
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

public class Transferupdates {
    ArrayList<Playertransfer> playertransfers = new ArrayList<>();

    public void establishConnection() {
        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();
        int status;


        try {
            // Setting up for the request
            URL url = new URL("https://soccer-transfers.p.rapidapi.com/en");
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
//            // Creating a new type token tells gson to convert the JSON data to a list of GoalscorerHistory objects
            Type Playertransfer = new TypeToken<ArrayList<Playertransfer>>() {
            }.getType();

//            // Deserialization of the JSON data into a list of Playertransfer objects
              playertransfers = g.fromJson(responseContent.toString(), Playertransfer);
//
//            // This loops round and prints the players names and stats out
            for (int i = 0; i < playertransfers.size(); i++) {
                System.out.println( "Player name:" +playertransfers.get(i).getPlayer() + " From:" + playertransfers.get(i).getFrom() + " To:" + playertransfers.get(i).getTo());
            }
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void favouriteTeam(String teamName) {
      establishConnection();
        System.out.println(teamName + " Transfers:");
        for (int i = 0; i < playertransfers.size(); i++) {
           if(playertransfers.get(i).getFrom().toLowerCase().equals(teamName.toLowerCase()) || playertransfers.get(i).getTo().toLowerCase().equals(teamName.toLowerCase())) {
               System.out.println( "Player name:" +playertransfers.get(i).getPlayer() + " From:" + playertransfers.get(i).getFrom() + " To:" + playertransfers.get(i).getTo());
           }

        }

    }
}



