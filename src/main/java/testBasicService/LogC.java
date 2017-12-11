package testBasicService;

import dataProvider.DataProvid;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;

import java.util.HashMap;
import java.util.Map;


public class LogC {

    //根据用户id和日志类型，按时间倒序获取日志列表-JIAOXUE-SERVICE-API-??
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getLogs(String baseCourseURL) throws Exception {
        String userId = "873135";
        String dynamicId= "1";
        String currentPage= "1";
        String pageSize= "1";
        Map params = new HashMap();
        params.put("currentPage",currentPage);
        params.put("pageSize",pageSize);
        String askURL = "/logs/users/"+userId+"/dynamic-types/"+dynamicId;
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, params, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer ettUserId = JsonResults.getJsonSomeStringValue(str, "ettUserId");
        Assert.assertTrue(8439370==ettUserId);
    }


}