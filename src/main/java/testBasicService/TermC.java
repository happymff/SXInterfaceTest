package testBasicService;

import dataProvider.DataProvid;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;


public class TermC {

    //获取当前学期-JIAOXUE-SERVICE-API-??
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getTerm(String baseCourseURL) throws Exception {
        String askURL = "/terms/current-term-infos";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        String year = JsonResults.getJsonStr(str, "year");
        Assert.assertTrue("2017~2018".equals(year));
    }
}