package testBasicService;

import dataProvider.DataProvid;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;


public class JClassUserC {

    //根据classIds获取班级学生数量-JIAOXUE-SERVICE-API-??
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getJClassUsers(String baseCourseURL) throws Exception {
        String classIds = "1291044";
        String askURL = "/j-class-users/class-ids/"+classIds;
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Assert.assertTrue(1==JsonResults.getJsonCode(str));
    }
}