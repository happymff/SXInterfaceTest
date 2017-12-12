package testBasicService;

import dataProvider.DataProvid;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;

import java.util.HashMap;
import java.util.Map;


public class GroupStudentsC {

    //根据一组groupId获取小组人员信息-JIAOXUE-SERVICE-API-??
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getGroupStudents(String baseCourseURL) throws Exception {
        String groupIds = "2";
        String askURL = "/groups-students/groups/"+groupIds;
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Assert.assertTrue(1==JsonResults.getJsonCode(str));
    }


    //根据学生的ID获取学生和班组的关系-JIAOXUE-SERVICE-API-??
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getGroupStuentBySubjectID(String baseCourseURL) throws Exception {
        String studentIds = "489566";
        Map params = new HashMap();
        params.put("studentIds",studentIds);
        String askURL = "/groups-students/subjects/classIds";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, params, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Assert.assertTrue(489566==JsonResults.getJsonStrInArrayValue(str,"userId",0));
    }
}