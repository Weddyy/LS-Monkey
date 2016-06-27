package com.lolStone.client.model.API;

import com.lolStone.client.enums.ServerId;
import com.lolStone.client.model.GameInfo;
import com.lolStone.client.model.JSONParser;
import com.lolStone.client.model.Loggs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Wed on 10.02.16.
 */
public class GameAPI {

    private static String API="NotForGit";
    Loggs _log=new Loggs();

    private String getServerURL(ServerId ser, String url)
    {
        switch (ser)
        {
            case NA1:
                return url.replace("{[0]}","na").replace("{[1]}","NA1");

            case RU:
                return url.replace("{[0]}","ru").replace("{[1]}","RU");

            case TR1:
                return url.replace("{[0]}","tr").replace("{[1]}","TR1");

            case KR:
                return url.replace("{[0]}","kr").replace("{[1]}","KR");

            case BR1:
                return url.replace("{[0]}","br").replace("{[1]}","BR1");

            case LA1:
                return url.replace("{[0]}","lan").replace("{[1]}","LA1");

            case LA2:
                return url.replace("{[0]}","las").replace("{[1]}","LA2");

            case EUN1:
                return url.replace("{[0]}","eune").replace("{[1]}","EUN1");

            case OC1:
                return url.replace("{[0]}","oce").replace("{[1]}","OC1");

            case EUW1:
                return url.replace("{[0]}","euw").replace("{[1]}","EUW1");
            case LOLKING:
                return url.replace("{[0]}","replays.lolking.net").replace("{[1]}","RU");

            default:
                return "";
        }
    }


    public GameInfo getGame(long id, ServerId ser) {
        if (id == 0)
            return null;

        try {
            URL url = new URL(getServerURL(ser,"https://{[0]}.api.pvp.net/observer-mode/rest/consumer/getSpectatorGameInfo/{[1]}/" + id + "?api_key=") + API);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                return null;
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            String tet = "";
            String output;
            while ((output = br.readLine()) != null) {
                tet += output;
            }

            conn.disconnect();
            return JSONParser.getGameIdAndURL(tet);

        } catch (MalformedURLException e) {

            _log.info(e);

        } catch (IOException e) {

            _log.info(e);

        }
        return null;
    }
}
