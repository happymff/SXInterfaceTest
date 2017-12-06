package util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonResults {

    /**
     * 返回json字符串msg
     */
    public static String getJsonMsg(String json) {
        if (json.contains("msg")) {
            return JsonExtracter.getJsonSomeString(json,"msg");
        } else {
            return null;
        }
    }

    /**
     * 返回json字符串msg
     */
    public static Integer getJsonCode(String json) {
        if (json.contains("code")) {
            return JsonExtracter.getJsonSomeInt(json,"code");
        } else {
            return null;
        }
    }

    /**
     * 返回json字符串data
     */
    public static String getJsonData(String json) {
        if (json.contains("data")) {
            return JsonExtracter.getJSONArray(json,"data");
        } else {
            return null;
        }
    }

    /**
     * 返回json中某个数组中的指定字符的所有值
     */
    public static String[] getStringsInArray(String json, String arrayName, String getstring) {
        if (json.contains(arrayName)) {
            return JsonExtracter.getJSONArrayStrings(json,arrayName,getstring);
        } else {
            return null;
        }
    }

    /**
     * 返回json中某个数组中的指定字符的值
     */
    public static String getJsonDataInArray(String json, String arrayName, String getstring) {
        if (json.contains(arrayName)) {
            return JsonExtracter.getJSONArrayString(json,arrayName,getstring);
        } else {
            return null;
        }
    }

    /**
     * 返回json中某个数组中的指定字符的所有值
     */
    public static String[] getStringsInArrays(String json, String arrayName, String arrayInArray,String getstring) {
        if (json.contains(arrayName)) {
            return JsonExtracter.getJSONArrayStringsArray(json,arrayName,arrayInArray,getstring);
        } else {
            return null;
        }
    }

    /**
     * 返回json字符串中对应的值
     * json json格式字符串
     * regex 正则表达式
     */
    public static String getParamByRex(String json, String regex) {

        if (json !=null) {
            return JsonExtracter.getParamByRex(json,regex);
        } else {
            return null;
        }
    }
}
