import com.yueguang.dao.UserDao;

import com.yueguang.model.User;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class SpringMybatisTest {
    /*
    * 1. 创建spring容器
           根据xml文件应用程序Context容器(上下文)
           classpath指配置文件的位置, 起点有java, resources. 写路径时相对这个起点去写
    * */
    static ClassPathXmlApplicationContext  context = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Test
    public void test1(){
        // 调用 Mapper映射文件里的方法
        UserDao userDao = (UserDao) context.getBean("userDao");
        User user = userDao.findUserById(3);
        System.out.println(user);
    }


}
