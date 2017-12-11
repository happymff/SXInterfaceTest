package testBasicService;

import dataProvider.DataProvid;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;

import java.util.HashMap;
import java.util.Map;


public class ScoreHistorysC {

    //积分消费记录-JIAOXUE-SERVICE-API-??
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getVersionCounts(String baseCourseURL) throws Exception {
        int limit = 1;
        Map params = new HashMap();
        params.put("limit",limit);
        String askURL = "/score-historys/list";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, params, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        String orderNumber = JsonResults.getJsonStrInArray(str, "orderNumber",0);
        Assert.assertTrue("21494041764663".equals(orderNumber));
    }
}