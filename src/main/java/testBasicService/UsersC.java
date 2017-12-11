package testBasicService;

import dataProvider.DataProvid;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;

import java.util.HashMap;
import java.util.Map;


public class UsersC {

    //根据用户id查找用户-JIAOXUE-SERVICE-API-05
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getUserByID(String baseCourseURL) throws Exception {
        String userId = "873135";
        String askURL = "/users/" + userId;
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        String userName = JsonResults.getJsonStr(str, "userName");
        Assert.assertTrue("luyueyue".equals(userName));
    }

    //根据用户jid,appId查找用户-JIAOXUE-SERVICE-API-？？
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getUserByJIDAppID(String baseCourseURL) throws Exception {
        String jid = "873135";
        String appId = "873135";
        String askURL = "/users/apps/" + appId + "/jids/" + jid;
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code == 1);
    }

    //根据用户jid查找用户-JIAOXUE-SERVICE-API-？？
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getUserByJID(String baseCourseURL) throws Exception {
        String jid = "2";
        String askURL = "/users/jid/" + jid;
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        String userName = JsonResults.getJsonStr(str, "userName");
        Assert.assertTrue("教务12".equals(userName));
    }

    //根据用户的userId查询用户-JIAOXUE-SERVICE-API-？？
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getUserByUserIDs(String baseCourseURL) throws Exception {
        String userId1 = "873135";
        String userId2 = "61037";
        Map params = new HashMap();
        params.put("userId1", userId1);
        params.put("userId2", userId2);
        String askURL = "/users/refs";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.postJsonFile(url, params, null, 3000, 3000, "UTF-8");
        System.out.println(str);
    }

    //根据用户ref查找用户-JIAOXUE-SERVICE-API-？？
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getUserByRef(String baseCourseURL) throws Exception {
        String ref = "2d4acfe9-4c79-4c72-8166-982a9a6762cd";
        String askURL = "/users/refs/" + ref;
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        String userName = JsonResults.getJsonStr(str, "userName");
        Assert.assertTrue("luyueyue".equals(userName));
    }

    //根据用户schoolId查找用户-JIAOXUE-SERVICE-API-？？????
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getUserBySchoolId(String baseCourseURL) throws Exception {
        String schoolId = "50043";
        String askURL = "/users/school-ids/" + schoolId;
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        String userName = JsonResults.getJsonStr(str, "userName");
        Assert.assertTrue("luyueyue".equals(userName));
    }

    //查找一组userId获取用户信息-JIAOXUE-SERVICE-API-？？????
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getUserByUserIDss(String baseCourseURL) throws Exception {
        String userId = "873135";
        String askURL = "/users/user-ids/" + userId;
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        String userName = JsonResults.getJsonStrInArray(str, "userName", 0);
        Assert.assertTrue("luyueyue".equals(userName));
    }

    //根据用户userName查找用户-JIAOXUE-SERVICE-API-？？????
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getUserByUserName(String baseCourseURL) throws Exception {
        String userName = "luyueyue";
        String askURL = "/users/usernames/" + userName;
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        String userName1 = JsonResults.getJsonStr(str, "userName");
        Assert.assertTrue("luyueyue".equals(userName1));
    }

    //根据userId更新用户信息-JIAOXUE-SERVICE-API-？？????
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void updateUserByID(String baseCourseURL) throws Exception {
        String userId = "873135";
        String address = "string";
        String birthDate = "2017-12-11T03:33:22.009Z";
        String cTime = "2017-12-11T03:33:22.009Z";
        String country = "string";
        int dcSchoolId = 0;
        Long ettUserId=0L;
        int gender=0;
        String headImage = "string";
        String hobbies = "string";
        String identityNumber = "string";
        int isActivity=0;
        int isModify= 0;
        String lzxUserId  = "string";
        String mailAddress = "string";
        String nation = "string";
        String passQuestion = "string";
        String password = "string";
        int qq = 0;
        String questionAnswer = "string";
        String realName = "卢yueyue";
        String schoolId = "50043";
        int stateId = 0;
        String userName = "luyueyue";

        Map params = new HashMap();
        params.put("address", address);
        params.put("birthDate", birthDate);
        params.put("cTime", cTime);
        params.put("country", country);
        params.put("dcSchoolId", dcSchoolId);
        params.put("ettUserId", ettUserId);
        params.put("gender", gender);
        params.put("terheadImagemId", headImage);
        params.put("hobbies", hobbies);
        params.put("addridentityNumberess", identityNumber);
        params.put("isActivity", isActivity);
        params.put("isModify", isModify);
        params.put("lzxUserId", lzxUserId);
        params.put("mailAddress", mailAddress);
        params.put("nation", nation);
        params.put("passQuestion", passQuestion);
        params.put("password", password);
        params.put("qq", qq);
        params.put("questionAnswer", questionAnswer);
        params.put("realName", realName);
        params.put("schoolId", schoolId);
        params.put("stateId", stateId);
        params.put("userName", userName);
        String askURL = "/users/" + userId;
        String url = baseCourseURL + askURL;
        String str = HttpUtil.putJsonFile(url, params, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Assert.assertTrue("1".equals(str));
    }

}