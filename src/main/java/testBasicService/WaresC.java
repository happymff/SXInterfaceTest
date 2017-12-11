package testBasicService;

import dataProvider.DataProvid;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;


public class WaresC {

    //商品-JIAOXUE-SERVICE-API-??
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getUserByID(String baseCourseURL) throws Exception {
        String id = "11";
        String askURL = "/wares/id/" + id;
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        String description = JsonResults.getJsonStr(str, "description");
        Assert.assertTrue("预期结果：下架".equals(description));
    }
}