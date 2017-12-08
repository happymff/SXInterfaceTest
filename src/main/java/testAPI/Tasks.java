package testAPI;

import dataProvider.DataProvid;
import dataProvider.ReadJsonFile;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;

import java.util.HashMap;
import java.util.Map;


public class Tasks {

    //获取用户进行中的任务列表-JIAOXUE-SERVICE-API-20
    @Test(description = "baseURL-Course", dataProvider = "baseURL-Course", dataProviderClass = DataProvid.class)
    public void getAllModules(String baseCourseURL) throws Exception {
        String  task = "1";
        String askURL = "/tasks/classes/"+task+"/index/tasks";
        String userHeader = ReadJsonFile.getJsonFile("/Users/mff/Desktop/workspace/SXInterfaceTest/src/main/resources/jsonFiles.txt",0);
        Map headerMap = new HashMap();
        headerMap.put("ZUUL_CURRENT_USER", userHeader);
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, headerMap, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

}