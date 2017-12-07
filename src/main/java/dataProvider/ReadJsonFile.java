package dataProvider;

import com.alibaba.fastjson.JSON;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mengfeifei on 2017/10/28.
 */
public class ReadJsonFile {

    public static String readFile(String Path){
        BufferedReader reader = null;
        String laststr = "";
        try{
            FileInputStream fileInputStream = new FileInputStream(Path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while((tempString = reader.readLine()) != null){
                laststr += tempString;
                laststr +="\n";
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }finally{
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return laststr;
    }
    public static String getJsonFile(String Path, int i){
        String jsonString =readFile(Path);
        String[] jsonStrings = jsonString.split("\n");
        JSON jsonFile = JSON.parseObject(jsonStrings[i]);
        return jsonFile.toJSONString();
    }
    public static String getJsonFileOnly(String Path){
        String jsonString =readFile(Path);
        JSON jsonFile = JSON.parseObject(jsonString);
        return jsonFile.toJSONString();
    }
    public static JSON getJson(String Path, int i){
        String jsonString =readFile(Path);
        String[] jsonStrings = jsonString.split("\n");
        JSON jsonFile = JSON.parseObject(jsonStrings[i]);
        return jsonFile;
    }
    public static void main(String[] args) {
       String s= getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",1);
        System.out.println(s);
    }
}