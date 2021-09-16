import com.yueguang.dao.UserDao;
import com.yueguang.mapper.UserMapper;
import com.yueguang.model.Student;
import com.yueguang.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;


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

    @Test
    public void test2(){
        UserMapper userMapper = (UserMapper) context.getBean("userMapper");
        User user = userMapper.findUserById(3);
        System.out.println(user);
    }

    @Test
    public void getMybatisTest(){
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
        SqlSession sqlSession =sqlSessionFactory.openSession();
        User user = new User(0,"admin","男",26);

        int result_id =sqlSession.insert("com.yueguang.mapper.UserMapper.save",user);
        System.out.println("result_id:"+result_id);

        List<Map<String,Object>> list = sqlSession.selectList("com.yueguang.mapper.UserMapper.slecetUser");
        System.out.println(list.toString());
        for (Map<String,Object> row : list){
            System.out.println(row.get("name"));
        }

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectStudentTest(){
        SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) context.getBean("sqlSessionFactory");
        SqlSession sqlSession =sqlSessionFactory.openSession();

        List<Student> studentList = sqlSession.selectList("com.yueguang.mapper.UserMapper.selectStudent");

        for (Student student : studentList) {
            System.out.println(student);
        }

        sqlSession.commit();
        sqlSession.close();

    }
}
