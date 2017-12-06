package util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by mengfeifei on 2017/10/28.
 */

public class JsonExtracter {

    public static String getParamByRex(String json, String regex) {

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(json);
        String result = null;
        while (matcher.find()) {
            result = matcher.group(1);
        }
        return result;
    }

    public static String getJsonSomeString(String jsonStr, String someString) {
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        String someString1 = (String) jsonObject.get(someString);
        return someString1;
    }
    public static Integer getJsonSomeInt(String jsonStr, String someString) {
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        Integer someString1 = (Integer) jsonObject.get(someString);
        return someString1;
    }

    public static String getJSONArray(String jsonStr, String someStringToArray) {
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        String getArray = null;
        //注意：results中的内容带有中括号[]，所以要转化为JSONArray类型的对象
        JSONArray result = jsonObject.getJSONArray(someStringToArray);
        getArray = result.toString();
        return getArray;
    }

    public static String getJSONArrayString(String jsonStr, String someStringToArray, String stringInArray) {
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        String getStringInArray = null;
        //注意：results中的内容带有中括号[]，所以要转化为JSONArray类型的对象
        JSONArray result = jsonObject.getJSONArray(someStringToArray);
        for (int i = 0; i < result.size(); i++) {
            getStringInArray = result.getJSONObject(i).getString(stringInArray);
        }
        return getStringInArray;
    }

    public static String[] getJSONArrayStrings(String jsonStr, String someStringToArray, String stringInArray) {
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        String[] getStringInArray = new String[100];
        //注意：results中的内容带有中括号[]，所以要转化为JSONArray类型的对象
        JSONArray result = jsonObject.getJSONArray(someStringToArray);
        for (int i = 0; i < result.size(); i++) {
            getStringInArray[i] = result.getJSONObject(i).getString(stringInArray);
        }
        return getStringInArray;
    }

    public static String[] getJSONArrayStringsArray(String jsonStr, String someStringToArray, String someInnerStringToArray, String stringInArray) {
        JSONObject jsonObject = JSON.parseObject(jsonStr);
        JSONArray getStringInArray = null;
        String[] getStringInArrayString = null;
        //注意：results中的内容带有中括号[]，所以要转化为JSONArray类型的对象
        JSONArray result = jsonObject.getJSONArray(someStringToArray);
        for (int i = 0; i < result.size(); i++) {
            getStringInArray = JSON.parseObject(result.getJSONObject(i).toString()).getJSONArray(someInnerStringToArray);
            for (int j = 0; j < getStringInArray.size(); j++) {
                getStringInArrayString[i] = getStringInArray.getJSONObject(i).getString(stringInArray);
            }
        }
        return getStringInArrayString;
    }
}