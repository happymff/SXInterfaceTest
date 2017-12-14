package testBusiness;

import dataProvider.DataProvid;
import org.testng.Assert;
import org.testng.annotations.Test;
import util.HttpUtil;
import util.JsonResults;

import java.util.HashMap;
import java.util.Map;


public class ClassGroupB {

    //根据班级的ID获取班级的所有老师信息-JIAOXUE-SERVICE-API-？？
    @Test(description = "baseURL-GeneralB", dataProvider = "baseURL-GeneralB", dataProviderClass = DataProvid.class)
    public void getAllTeacherInfo(String baseCourseURL) throws Exception {
        String classId = "1291042";
        String ettUserId= "8439370";
        String schoolId= "50043";
        String askURL = "/classes/"+classId+"/ett-users/"+ettUserId+"/schools/"+schoolId+"/teachers";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //根据用户ref获取用户当前学期的班级-JIAOXUE-SERVICE-API-？？
    @Test(description = "baseURL-GeneralB", dataProvider = "baseURL-GeneralB", dataProviderClass = DataProvid.class)
    public void getRef(String baseCourseURL) throws Exception {
        String userRef = "2d4acfe9-4c79-4c72-8166-982a9a6762cd";
        String askURL = "/classes/user-refs/"+userRef+"/current-terms";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Assert.assertTrue(str.contains("强1班"));
    }

    //上传班级通知图片-JIAOXUE-SERVICE-API-？？
    @Test(description = "baseURL-GeneralB", dataProvider = "baseURL-GeneralB", dataProviderClass = DataProvid.class)
    public void uploadMessageImage(String baseCourseURL) throws Exception {
        String userId = "873135";
        String filePath = "/Users/mengfeifei/Desktop/skipAD.png";
        Map params = new HashMap();
        params.put("filePath",filePath);
        String askURL = "/classes/messages/user-ids/"+userId+"/images";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.post(url, params, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Integer code = JsonResults.getJsonCode(str);
        Assert.assertTrue(code==1);
    }

    //添加新的分组-JIAOXUE-SERVICE-API-？?
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void addNewGroup(String baseCourseURL) throws Exception {
        String cTime = "2017-12-12T04:56:47.293Z";
        String cUserId = "0";
        String classId = "0";
        String classType = "0";
        String groupId = "0";
        String groupName = "string";
        String mTime = "2017-12-12T04:56:47.293Z";
        String quoteId = "0";
        String subjectId = "0";
        String termId = "string";
        Map params = new HashMap();
        params.put("cTime", cTime);
        params.put("cUserId", cUserId);
        params.put("classId", classId);
        params.put("classType", classType);
        params.put("groupId", groupId);
        params.put("groupName", groupName);
        params.put("mTime", mTime);
        params.put("subjectId", subjectId);
        params.put("termId", termId);
        params.put("quoteId",quoteId);
        String askURL = "/classes-groups/groups-infos";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.postJsonFile(url, params, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Assert.assertTrue("string".equals(JsonResults.getJsonStr(str,"termId")));
    }

    //更新班组的信息-JIAOXUE-SERVICE-API-？?????????
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void updateGroupInfo(String baseCourseURL) throws Exception {
        String cTime = "2017-12-12T04:56:47.293Z";
        String cUserId = "0";
        String classId = "0";
        String classType = "0";
        String groupId = "0";
        String groupName = "string";
        String mTime = "2017-12-12T04:56:47.293Z";
        String quoteId = "0";
        String subjectId = "0";
        String termId = "string";
        Map params = new HashMap();
        params.put("cTime", cTime);
        params.put("cUserId", cUserId);
        params.put("classId", classId);
        params.put("classType", classType);
        params.put("groupId", groupId);
        params.put("groupName", groupName);
        params.put("mTime", mTime);
        params.put("subjectId", subjectId);
        params.put("termId", termId);
        params.put("quoteId",quoteId);
        String askURL = "/classes-groups/groups-infos";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.putJsonFile(url, params, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Assert.assertTrue("string".equals(JsonResults.getJsonStr(str,"termId")));
    }

    //根据一组分组ID查询分组与学生的关系-JIAOXUE-SERVICE-API-？？????
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getGroupStudentByID(String baseCourseURL) throws Exception {
        String groupIds = "2";
        Map params = new HashMap();
        params.put("groupIds",groupIds);
        String askURL = "/classes-groups/groups-students";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, params, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Assert.assertTrue(2==JsonResults.getJsonStrInArrayValue(str,"groupId",0));
    }

    //根据一组分组的ID获取分组的信息-JIAOXUE-SERVICE-API-？？????
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getGroupByID(String baseCourseURL) throws Exception {
        String groupIds = "2";
        String askURL = "/classes-groups/"+groupIds+"/groups";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Assert.assertTrue(2==JsonResults.getJsonStrInArrayValue(str,"groupId",0));
    }

    //根据分组ID获取分组信息-JIAOXUE-SERVICE-API-？？????
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getGroupByID1(String baseCourseURL) throws Exception {
        String groupIds = "2";
        String askURL = "/classes-groups/"+groupIds+"/group-info";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Assert.assertTrue(2==JsonResults.getJsonStrInArrayValue(str,"groupId",0));
    }

    //根据分组ID获取分组信息-JIAOXUE-SERVICE-API-？？????
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void getGroupByStudentID2(String baseCourseURL) throws Exception {
        String groupIds = "2";
        String askURL = "/classes-groups/"+groupIds+"/studentIds";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.get(url, null, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Assert.assertTrue(2==JsonResults.getJsonStrInArrayValue(str,"groupId",0));
    }

    //更新学生所属的组-JIAOXUE-SERVICE-API-？?????????
    @Test(description = "baseURL-GeneralC", dataProvider = "baseURL-GeneralC", dataProviderClass = DataProvid.class)
    public void updateGroup(String baseCourseURL) throws Exception {
        String newGroupId = "1";
        String oldGroupId = "2";
        String studentIds = "{}";
        Map params = new HashMap();
        params.put("newGroupId", newGroupId);
        params.put("oldGroupId", oldGroupId);
        params.put("studentIds", studentIds);
        String askURL = "/classes-groups/students";
        String url = baseCourseURL + askURL;
        String str = HttpUtil.putJsonFile(url, params, null, 3000, 3000, "UTF-8");
        System.out.println(str);
        Assert.assertTrue("string".equals(JsonResults.getJsonStr(str,"termId")));
    }
}