package testBasicService;

import dataProvider.DataProvid;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;

import java.util.HashMap;
import java.util.Map;


public class ScoreC {

    //奖励用户积分-JIAOXUE-SERVICE-API-??
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getScores(String baseCourseURL) throws Exception {
        String userId = "8439370";
        String awardCondition= "1";
        String objTypeId= "1";
        String remark= "1";
        Map params = new HashMap();
        params.put("awardCondition",awardCondition);
        params.put("objTypeId",objTypeId);
        params.put("remark",remark);
        String askURL = "/scores/"+userId;
        String url = baseCourseURL + askURL;
        String str = HttpUtil.post(url, params, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Assert.assertTrue("操作成功".equals(JsonResults.getJsonMsg(str)));
    }

    //根据用户jid查询积分-JIAOXUE-SERVICE-API-???????????
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getScoresByJID(String baseCourseURL) throws Exception {
        String ettUserId = "8439370";
        String askURL = "/scores/"+ettUserId;
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Assert.assertTrue("操作成功".equals(JsonResults.getJsonMsg(str)));
    }
}