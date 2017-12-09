package testBasicService;

import dataProvider.DataProvid;
import dataProvider.ReadJsonFile;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class UsersC {

    //根据用户id查找用户-JIAOXUE-SERVICE-API-？？
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getUserByID(String baseCourseURL) throws Exception {
        String userId = "873135";
        String askURL = "/users/"+userId;
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        String userName = JsonResults.getJsonStr(str,"userName");
        Assert.assertTrue("luyueyue".equals(userName));
    }

    //根据用户jid,appId查找用户-JIAOXUE-SERVICE-API-？？
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getUserByJIDAppID(String baseCourseURL) throws Exception {
        String jid = "873135";
        String appId = "873135";
        String askURL = "/users/apps/"+appId+"/jids/"+jid;
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //根据用户jid查找用户-JIAOXUE-SERVICE-API-？？
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getUserByJID(String baseCourseURL) throws Exception {
        String jid = "2";
        String askURL = "/users/jid/"+jid;
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        String userName = JsonResults.getJsonStr(str,"userName");
        Assert.assertTrue("教务12".equals(userName));
    }

    //根据用户jid查找用户-JIAOXUE-SERVICE-API-？？
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getUserByUserIDs(String baseCourseURL) throws Exception {
        String userId1 = "873135";
        String userId2 = "61037";
        String askURL = "/users/refs";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        String userName = JsonResults.getJsonStr(str,"userName");
        Assert.assertTrue("教务12".equals(userName));
    }
}