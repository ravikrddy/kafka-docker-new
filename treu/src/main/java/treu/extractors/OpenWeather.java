package treu.extractors; 
 
import com.fasterxml.jackson.databind.JsonNode; 
import com.fasterxml.jackson.databind.ObjectMapper; 
import treu.extractors.OpenExchange; 
import java.io.IOException; 
import java.net.MalformedURLException; 
import java.net.URL; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
 
public class OpenWeather { 
   
  private static final String API_KEY = "49b62aa6ae87e5728ff22b558d5a7d";                 //1 
  protected static final ObjectMapper MAPPER = new ObjectMapper(); 
   
  public double getTemperature() { 
             
    try { 
      URL url = new URL("http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=49b62aa6ae87e5728ff22b558d5a7de6");
      //URL url = new URL("http://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon="+  lon + "&units=metric&appid=" + API_KEY); 
     
      JsonNode root = MAPPER.readTree(url); 
      JsonNode node = root.path("main").path("temp"); 
      return Double.parseDouble(node.toString()); 
     
    } catch (MalformedURLException ex) { 
      Logger.getLogger(OpenExchange.class.getName()).log(Level.SEVERE, null, ex); 
    } catch (IOException ex) { 
      Logger.getLogger(OpenExchange.class.getName()).log(Level.SEVERE, null, ex); 
    }     
    return 0;   
  }  
} 