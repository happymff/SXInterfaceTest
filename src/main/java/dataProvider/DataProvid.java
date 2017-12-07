package dataProvider;

import org.testng.annotations.DataProvider;

/**
 * Created by mengfeifei on 2016/12/29.
 */
public class DataProvid {

    @DataProvider(name = "baseURL-General")
    public static Object[][] baseURLGeneral() {
        return new Object[][]{
                new Object[]{"http://192.168.11.197:30091"}
        };
    }

    @DataProvider(name = "baseURL-Course")
    public static Object[][] baseURLCourse() {
        return new Object[][]{
                new Object[]{"http://192.168.11.197:30092"}
        };
    }

    @DataProvider(name = "baseURL-Resource")
    public static Object[][] baseURLResource() {
        return new Object[][]{
                new Object[]{"http://192.168.11.197:30093"}
        };
    }

}
