package com.example.demo.service.impl;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.service.PapagoService;
import com.example.demo.vo.TranslateVO;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PapagoServiceImpl implements PapagoService {

   public String doTranslate(Map<String, String> map) {
      String urlstr = "https://openapi.naver.com/v1/papago/n2mt";
      String source= map.get("source");
      String target = map.get("target");
      String text = map.get("text");
      String id = "dPzIwt2tZ0T0OPRXs3Mr";
      String secret = "rtDItnpfae";
      URL url;
      try {
         url = new URL(urlstr);//url만들었고 url형식이 아니면 여기서 에러
         HttpURLConnection con = (HttpURLConnection) url.openConnection();//커넥션 만들었고 형식이 맞지 않으면 여기서 에러
         con.setRequestMethod("POST");//메소드를 설정
         con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
         con.setRequestProperty("X-Naver-Client-Id", id);
         con.setRequestProperty("X-Naver-Client-Secret", secret);
         String param = "source="+ source + "&target="+ target + "&text=" + text;
         con.setDoOutput(true);
         DataOutputStream dos = new DataOutputStream(con.getOutputStream());
         dos.write(param.getBytes());
         dos.flush();
         
         int status = con.getResponseCode();//200이어야 함
         StringBuffer sb = new StringBuffer();
         String str;
         if(status == 200) {
            InputStreamReader isr = new InputStreamReader(con.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            while((str=br.readLine())!=null) {
               sb.append(str);
            }
         }else {
            InputStreamReader isr = new InputStreamReader(con.getErrorStream());
            BufferedReader br = new BufferedReader(isr);
            while((str=br.readLine())!=null) {
               sb.append(str);
            }
         }
         System.out.println(sb.toString());
         ObjectMapper om =new ObjectMapper();
         TranslateVO transVO =om.readValue(sb.toString(),TranslateVO.class);
         return transVO.getMessage().getResult().getTranslatedText();
      } catch (Exception e) {
         // TODO Auto-generated catch block
         e.printStackTrace();
      }
      
      return null;
   }

}
