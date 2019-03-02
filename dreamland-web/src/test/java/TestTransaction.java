import com.zxx.dreamland.entity.User;
import com.zxx.dreamland.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

@ContextConfiguration(locations = {"classpath:spring-mybatis.xml","classpath:spring-mvc.xml"})
public class TestTransaction extends AbstractJUnit4SpringContextTests {

    @Autowired
    private UserService userService;

    @Test
    public void testSave(){
        User user = new User();
        user.setNickName("测试回滚");
        user.setEmail("123456@qq.com");
        userService.regist(user);
    }
}
