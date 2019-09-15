/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.egym.movies;

import java.net.URL;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import com.egym.model.Movie;
import com.egym.model.Request;
/**
 *
 * @author ignis
 */
public class DownloadMovies {
    
    static String [] getMovieTitles(String substr){
        String baseUrl = null;
        List<String> list = new ArrayList<String>();
        URL url = null;
        int pages = 1, counter = 1;
        try{
            do{
                if(counter <= pages){
                    baseUrl = "https://jsonmock.hackerrank.com/api/movies/search/?Title="+substr+"&page="+counter;
                }
                url = new URL(baseUrl);
                HttpURLConnection request = (HttpURLConnection)url.openConnection();
                request.setDoOutput(true);
                request.setRequestMethod("GET");
                request.connect();
                JsonParser parser = new JsonParser();
                JsonElement element = parser.parse(new InputStreamReader((InputStream)request.getContent()));
                JsonElement movies = element.getAsJsonObject().get("data");
                pages = element.getAsJsonObject().get("total_pages").getAsInt();
                addToList(movies, list, substr);
                counter ++;
            }while(pages == counter);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        Collections.sort(list);
        return list.toArray(new String[list.size()]);
    }
    
    private static List addToList(JsonElement data, List list, String subtr){
        JsonArray movies = data.getAsJsonArray();
        for(JsonElement movie :  movies){
            String title = movie.getAsJsonObject().get("Title").toString();
            if(title.contains(subtr)){
                list.add(title);
            }
        }
        return list;
    }
    
    static String [] getMoviesTitlesUsingPOJO(String substr){
        String baseUrl = null;
        List<String> list = new ArrayList<String>();
        URL url = null;
        int pages = 1, counter = 1;
        try{
            do{
                if(counter <= pages){
                    baseUrl = "https://jsonmock.hackerrank.com/api/movies/search/?Title="+substr+"&page="+counter;
                }
                url = new URL(baseUrl);
                HttpURLConnection request = (HttpURLConnection)url.openConnection();
                request.setDoOutput(true);
                request.setRequestMethod("GET");
                request.connect();
                InputStreamReader in = new InputStreamReader((InputStream)request.getContent());
                BufferedReader buffer = new BufferedReader(in);
                StringBuilder response = new StringBuilder();
                String readLine;
                while((readLine =  buffer.readLine()) != null)
                    response.append(readLine);
                Gson gson = new Gson();
                Request requestObj = gson.fromJson(response.toString(), Request.class);
                pages = requestObj.getTotal_pages();
                addToList(requestObj.getData(), list, substr);
                counter ++;
                
            }while(pages == counter);
            
        }catch(Exception e){
            e.printStackTrace();
        }
        Collections.sort(list);
        return list.toArray(new String[list.size()]);
    }
    
    private static List addToList(Movie[] data, List list, String substr){
        
        for(Movie movie: data){
            if(movie.getTitle().contains(substr)){
                list.add(movie.getTitle());
            }
        }
        
        return list;
    }
}
