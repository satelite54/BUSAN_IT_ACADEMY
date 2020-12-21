package com.satelite54.translator.ui;

import android.app.Activity;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.satelite54.translator.CSingleton;
import com.satelite54.translator.ui.home.HomeFragment;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;


public class Ctranslator{
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static String post(String apiUrl, Map<String, String> requestHeaders, String text, int translatoritems){

        HttpURLConnection con = connect(apiUrl);
        String source = "";
        String target = "";
        switch (translatoritems) {
            case 0 :
                source = "ko";
                target = "en";
                break;
            case 1 :
                source = "ko";
                target = "zh-CN";
                break;
            case 2 :
                source = "ko";
                target = "zh-TW";
                break;
            case 3 :
                source = "ko";
                target = "es";
                break;
            case 4 :
                source = "ko";
                target = "fr";
                break;
            case 5 :
                source = "ko";
                target = "vi";
                break;
            case 6 :
                source = "ko";
                target = "th";
                break;
            case 7 :
                source = "ko";
                target = "id";
                break;
            case 8 :
                source = "en";
                target = "ja";
                break;
            case 9 :
                source = "en";
                target = "fr";
                break;
        }
        String postParams = "source=" + source + "&target=" + target + "&text=" + text; //원본언어: 한국어 (ko) -> 목적언어: 영어 (en)
        try {
            con.setRequestMethod("POST");
            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
                con.setRequestProperty(header.getKey(), header.getValue());
            }

            con.setDoOutput(true);
            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(postParams.getBytes());
                wr.flush();
            }

            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 응답
                return readBody(con.getInputStream());
            } else {  // 에러 응답
                return readBody(con.getErrorStream());
            }
        } catch (IOException e) {
            throw new RuntimeException("API 요청과 응답 실패", e);
        } finally {
            con.disconnect();
        }
    }

    private static HttpURLConnection connect(String apiUrl){
        try {
            URL url = new URL(apiUrl);
            return (HttpURLConnection)url.openConnection();
        } catch (MalformedURLException e) {
            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
        } catch (IOException e) {
            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private static String readBody(InputStream body){
        InputStreamReader streamReader = new InputStreamReader(body);

        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
            StringBuilder responseBody = new StringBuilder();

            String line;
            while ((line = lineReader.readLine()) != null) {
                responseBody.append(line);
            }

            return responseBody.toString();
        } catch (IOException e) {
            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
        }
    }
}
