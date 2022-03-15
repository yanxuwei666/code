package com.yxw.mongodb;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import com.yxw.mongodb.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * @Author yxw
 * @Date 2022/3/15 16:27
 * @Description TODO
 */
@SpringBootTest
public class MongodbApplicationTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Test
    public void createUser() {
        User user = new User();
        user.setAge(25);
        user.setName("YXW");
        user.setEmail("1076372957@qq.com");
        User user1 = mongoTemplate.insert(user);
        System.out.println(user1);
    }

    @Test
    public void findAllUser() {
        // 同理findById
        List<User> users = mongoTemplate.findAll(User.class);
        System.out.println(users);
    }

    @Test
    public void findUserList() {
        Query query = new Query(
                Criteria.where("name").is("yxw").and("age").is(24)
        );
        List<User> users = mongoTemplate.find(query, User.class);
        System.out.println(users);
    }

    @Test
    public void findUserLikeName() {
        String name = "yxw";
        // 模糊查询，匹配规则，相当于 where name like 'yxw%'
        String regex = String.format("%s%s%s", "^.*", name, ".*$");
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        Query query = new Query(Criteria.where("name").regex(pattern));
        List<User> userList = mongoTemplate.find(query, User.class);
        System.out.println(userList);
    }

    @Test
    public void findUserPage() {
        String name = "yxw";
        Query query = new Query();
        String regex = String.format("%s%s%s", "^.*", name, ".*$");
        Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
        query.addCriteria(Criteria.where("name").regex(pattern));

        // 分页查询
        int pageNumber = 1;
        int pageSize = 10;
        int totalCount = (int) mongoTemplate.count(query, User.class);
        List<User> userList = mongoTemplate.find(query.skip((pageNumber - 1) * pageSize).limit(pageSize), User.class);
        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("list", userList);
        pageMap.put("totalCount",totalCount);
        System.out.println(pageMap);
    }

    @Test
    public void updateUser() {
        User user = mongoTemplate.findById("5ffbfa2ac290f356edf9b5aa", User.class);
        user.setName("test_1");
        user.setAge(25);
        user.setEmail("493220990@qq.com");
        Query query = new Query(Criteria.where("_id").is(user.getId()));
        Update update = new Update();
        update.set("name", user.getName());
        UpdateResult result = mongoTemplate.upsert(query, update, User.class);
        long count = result.getModifiedCount();
        System.out.println(count);
    }


    @Test
    public void delete() {
        Query query = new Query(Criteria.where("_id").is("5ffbfa2ac290f356edf9b5aa"));
        DeleteResult result = mongoTemplate.remove(query, User.class);
        long count = result.getDeletedCount();
        System.out.println(count);
    }
}
