package testAPI;

import dataProvider.DataProvid;
import dataProvider.ReadJsonFile;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Classes {

    //首页-班级通知列表-JIAOXUE-SERVICE-API-29
    @Test(description = "baseURL-General", dataProvider = "baseURL-General", dataProviderClass = DataProvid.class)
    public void getMaterials(String baseCourseURL) throws Exception {
        Integer currentPage = 1;
        Integer pageSize = 1;
        Map params = new HashMap();
        params.put("pageSize", pageSize);
        params.put("currentPage", currentPage);
        String askURL = "/classes/messages";
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, params, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //首页-发班级通知-JIAOXUE-SERVICE-API-30
    @Test(description = "baseURL-General", dataProvider = "baseURL-General", dataProviderClass = DataProvid.class)
    public void sendmessages(String baseCourseURL) throws Exception {
        String  title = "1";
        String  content = "1";
        String  clsId = "1";
        String  jzpl = "1";
        String  lookType = "1";
        String  imgurl = "1";
        String  userId = "1";
        String  gradeId = "1";
        Map params = new HashMap();
        params.put("title", title);
        params.put("content", content);
        params.put("gId", gradeId);
        params.put("jzpl",jzpl);
        params.put("lookType", lookType);
        params.put("clsId", clsId);
        params.put("imgurl", imgurl);
        params.put("userId",userId);
        String askURL = "/classes/messages";
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseCourseURL + askURL;
        String str = HttpUtil.post(url, params, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //首页-发班级通知照片-JIAOXUE-SERVICE-API-31
    @Test(description = "baseURL-General", dataProvider = "baseURL-General", dataProviderClass = DataProvid.class)
    public void sendMessageImage(String baseCourseURL) throws Exception {
        String variableName = "file";
        String filename = "/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/photo.png";
        String askURL = "/classes/messages/images";
        String url = baseCourseURL + askURL;
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        String str =  HttpUtil.uploadFile(url, variableName,filename,"UTF-8",userHeader);
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }
}