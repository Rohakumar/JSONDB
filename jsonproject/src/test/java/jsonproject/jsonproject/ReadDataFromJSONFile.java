package jsonproject.jsonproject;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


// This program creates a database of names of a particular user and their groceries.
public class ReadDataFromJSONFile {
	
	
//Create a json file with user provided name
	public static void createJsonfile(String fname ){
		File file = new File(fname+".json");
		try {
			file.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    
	}
	
	
//write in json file delete any previous data in file (overwrite file) 	
	public static void writejsonfile(String fname, String namee, String grocery1, String grocery2){
		 JSONObject jsonObject = new JSONObject();
		 
		 jsonObject.put("name", namee);
		 
	        // create a JSON array
	     JSONArray jsonArray = new JSONArray();
	     jsonArray.add(grocery1);
	     jsonArray.add(grocery2);
	        // add the JSON array to the JSON object
	     jsonObject.put("groceries", jsonArray);
	    
	     
	     try (FileWriter file = new FileWriter(fname+".json")) {
	            file.write(jsonObject.toJSONString());
	            //System.out.println("JSON file created successfully!");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	     
		    
		
	}
	
//Write in json file append new info	
	public static void writejsondata(String fname, String namee, String grocery1, String grocery2){
		
		JSONParser jsonParser=new JSONParser();
		
		try{
			Object obj = jsonParser.parse(new FileReader(fname+".json"));
            JSONArray jsonArray = (JSONArray)obj;

            System.out.println(jsonArray);

            JSONObject student1 = new JSONObject();
            student1.put("name", "BROCK");
            student1.put("age", new Integer(3));

            
            jsonArray.add(student1);
            
            System.out.println(jsonArray);

            FileWriter file = new FileWriter(fname+".json");
            file.write(jsonArray.toJSONString());
           
		}catch (ParseException | IOException e) {
            e.printStackTrace();
        }
		
	     
	
	}
	
	
//read json file and print it on console	
	public static void readjson(String fname ){
		try (FileReader reader = new FileReader(fname+".json")) {
            JSONParser parser = new JSONParser();
            JSONObject jsonObjectFromFile = (JSONObject) parser.parse(reader);
            System.out.println("Name: " + jsonObjectFromFile.get("name"));
            JSONArray jsonArrayFromFile = (JSONArray) jsonObjectFromFile.get("groceries");
            System.out.println("groceries:");
            for (Object language : jsonArrayFromFile) {
                System.out.println(language);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
		    
		
	}
	
//delete the entire file
	public static void deletejson(String fname ){
		File file= new File(fname+".json");
		file.delete();
		   
		
	}
	
	
	
// main class	
	public static void main(String[] args) {
		
		createJsonfile("blue");
		writejsonfile("blue", "yoyo", "eggs", "veggies");
		readjson("blue");
		writejsondata("blue", "popo", "eggs", "veggies");
		readjson("blue");
		//deletejson("blue");
	}

}
