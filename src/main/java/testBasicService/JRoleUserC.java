package testBasicService;

import dataProvider.DataProvid;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;


public class JRoleUserC {

    //根据userRef获取角色列表-JIAOXUE-SERVICE-API-??
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getJRoleUser(String baseCourseURL) throws Exception {
        String userRef = "18ad05ae-434e-4ab4-998e-3efdfb981308";
        String askURL = "/j-role-users/"+userRef;
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer roleId = JsonResults.getJsonStrInArrayValue(str, "roleId",0);
        Assert.assertTrue(1==roleId);
    }
}