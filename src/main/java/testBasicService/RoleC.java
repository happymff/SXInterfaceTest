package testBasicService;

import dataProvider.DataProvid;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;


public class RoleC {

    //根据roleId获取角色-JIAOXUE-SERVICE-API-??
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getRoleName(String baseCourseURL) throws Exception {
        String roleId = "1";
        String askURL = "/roles/"+roleId;
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        String roleName = JsonResults.getJsonStr(str, "roleName");
        Assert.assertTrue("学生".equals(roleName));
    }
}