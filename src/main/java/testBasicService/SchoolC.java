package testBasicService;

import dataProvider.DataProvid;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;


public class SchoolC {

    //根据schoolId获取学校-JIAOXUE-SERVICE-API-??
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getSchool(String baseCourseURL) throws Exception {
        String schoolId = "50043";
        String askURL = "/schools/"+schoolId;
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        String name = JsonResults.getJsonStr(str, "name");
        Assert.assertTrue("大连分校910".equals(name));
    }
}