package network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;


//import org.json.JSONArray;
//import org.json.JSONObject;


public class ReadWebPageEx {

    public static void main(String[] args) throws MalformedURLException, IOException {

        BufferedReader br = null;

        try {
            String theURL = "file:///Users/yujiech/Desktop/welcomeMessage.htm";
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
            }

            System.out.println(sb);
        } finally {

            if (br != null) {
                br.close();
            }
        }
    }

}
