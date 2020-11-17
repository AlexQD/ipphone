package ru.radcenter.ipphone.services;

import org.springframework.stereotype.Service;
import ru.radcenter.ipphone.model.History;
import ru.radcenter.ipphone.model.Historys;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

@Service
public class RequestService {

    private static final HttpClient httpClient = HttpClient.newBuilder()
            .version(HttpClient.Version.HTTP_2)
            .connectTimeout(Duration.ofSeconds(10))
            .build();

    public Historys mappingHistory() throws ParseException {
        String[] str = this.request_history().split("\\n"); // Разбиение текста на строки с помощью разграничителя (Enter)
        Historys historys = new Historys();
        for (String subStr : str) {
            String[] words = subStr.split(","); // Разбиение текста на слова с помощью разграничителя (,)
            //----------
            History history = new History();
            history.setUid_atc(Long.parseLong(words[0]));
            history.setType(words[1]);
            history.setClient(words[2]);
            history.setAccount(words[3]);
            history.setVia(words[4]);
            history.setStart(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(words[5]));
            history.setWait(words[6]);
            history.setDuration(words[7]);
            history.setRecord(words[8]);
            //----------
            historys.add(history);
            // }
        }
        return historys;
    }

    //Получение истории звонков с облачной телефонии
    public String request_history()  {

        // form parameters
        Map<Object, Object> data = new HashMap<>();
        data.put("cmd", "history");
        data.put("period", "today");
        data.put("token", "0000-0000-0000-0000-0000");


        HttpRequest request = HttpRequest.newBuilder()
                .POST(buildFormDataFromMap(data))
                .uri(URI.create("https://vats000000.megapbx.ru/sys/crm_api.wcgp"))
                .setHeader("User-Agent", "browser java ")
                .header("Content-Type", "application/x-www-form-urlencoded")
                .build();



        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        }
        catch (Exception e)
        {
            return "";
        }
    }

    private static HttpRequest.BodyPublisher buildFormDataFromMap(Map<Object, Object> data) {
        var builder = new StringBuilder();
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            if (builder.length() > 0) {
                builder.append("&");
            }
            builder.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
            builder.append("=");
            builder.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
        }
        return HttpRequest.BodyPublishers.ofString(builder.toString());
    }

}