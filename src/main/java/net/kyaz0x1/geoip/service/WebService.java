package net.kyaz0x1.geoip.service;

import net.kyaz0x1.geoip.utils.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public final class WebService {

    private static WebService INSTANCE;

    private WebService(){}

    public String read(String link){
        try {
            final URL url = new URL(link);

            final HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");

            final BufferedReader input = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            final StringBuilder content = new StringBuilder();

            String line;
            while((line = input.readLine()) != null){
                content.append(line);
            }

            input.close();

            return content.toString();
        }catch(IOException e) {
            System.err.println("[WebService] Ocorreu um erro ao ler o conteúdo do site! Erro: " + e.getMessage());
            return StringUtils.EMPTY;
        }
    }

    public static WebService getInstance(){
        if(INSTANCE == null){
            synchronized(WebService.class){
                if(INSTANCE == null){
                    INSTANCE = new WebService();
                }
            }
        }
        return INSTANCE;
    }

}