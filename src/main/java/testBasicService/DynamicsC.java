package testBasicService;

import dataProvider.DataProvid;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;

import java.util.HashMap;
import java.util.Map;


public class DynamicsC {

    //分页查找用户任务动态-JIAOXUE-SERVICE-API-??
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getDynamics(String baseCourseURL) throws Exception {
        String templateIds = "1";
        String operateIds= "1";
        String pageSize= "1";
        String pageNum= "1";
        Map params = new HashMap();
        params.put("templateIds",templateIds);
        params.put("operateIds",operateIds);
        params.put("pageNum",pageNum);
        params.put("pageSize",pageSize);
        String askURL = "/dynamics/task-dynamics";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, params, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Assert.assertTrue(1==JsonResults.getJsonSomeStringValue(str,"pageNum"));
    }

    //分页查找用户任务动态-JIAOXUE-SERVICE-API-??
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getDynamicsByRef(String baseCourseURL) throws Exception {
        String templateIds = "1";
        String userRef= "2d4acfe9-4c79-4c72-8166-982a9a6762cd";
        String pageSize= "1";
        String pageNum= "1";
        Map params = new HashMap();
        params.put("templateIds",templateIds);
        params.put("pageNum",pageNum);
        params.put("pageSize",pageSize);
        String askURL = "/dynamics/userRef/"+userRef+"/personl-dynamics";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, params, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Assert.assertTrue(1==JsonResults.getJsonSomeStringValue(str,"pageNum"));
    }
}