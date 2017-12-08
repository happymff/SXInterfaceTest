package testAPI;

import dataProvider.DataProvid;
import dataProvider.ReadJsonFile;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class Users {

    //获取用户个人信息-JIAOXUE-SERVICE-API-01
    @Test(description = "baseURL-General", dataProvider = "baseURL-General", dataProviderClass = DataProvid.class)
    public void getAllUsers(String baseCourseURL) throws Exception {
        String askURL = "/users";
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //首页-上传用户头像-JIAOXUE-SERVICE-API-02
    @Test(description = "baseURL-General", dataProvider = "baseURL-General", dataProviderClass = DataProvid.class)
    public void uploadPhoto(String baseCourseURL) throws Exception {
        File file = new File("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/photo.png");
        Map params = new HashMap();
        params.put("file", file);
        String askURL = "/users/photos.do";
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseCourseURL + askURL;
        String str = HttpUtil.post(url, params, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }


    //首页-上传用户头像-JIAOXUE-SERVICE-API-02
    @Test(description = "baseURL-General", dataProvider = "baseURL-General", dataProviderClass = DataProvid.class)
    public void uploadPhotos(String baseCourseURL) throws Exception {
        String variableName = "file";
        String filename = "/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/photo.png";
        String askURL = "/users/photos.do";
        String url = baseCourseURL + askURL;
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        String str =  HttpUtil.postFile(url, variableName,filename,"UTF-8",userHeader);
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //首页-裁剪用户上传的头像-JIAOXUE-SERVICE-API-49
    @Test(description = "baseURL-General", dataProvider = "baseURL-General", dataProviderClass = DataProvid.class)
    public void updatePhoto(String baseCourseURL) throws Exception {
        String selectorX = "1";
        String selectorY = "1";
        String selectorW = "100";
        String selectorH = "100";
        String imageSource = "uploadfile/2017/12/8/1512712080193.png";
        Map params = new HashMap();
        params.put("selectorX", selectorX);
        params.put("selectorY", selectorY);
        params.put("selectorW", selectorW);
        params.put("selectorH", selectorH);
        params.put("imageSource", imageSource);
        String askURL = "/users/photos.do";
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseCourseURL + askURL;
        String str = HttpUtil.put(url, params, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

}