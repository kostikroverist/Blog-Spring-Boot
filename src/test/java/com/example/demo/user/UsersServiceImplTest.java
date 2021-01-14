package com.example.demo.user;

import com.example.demo.article.repository.ArticalsRepository;
import com.example.demo.article.domain.ArticleEntity;
import com.example.demo.article.domain.Color;
import com.example.demo.user.domain.UserEntity;
import com.example.demo.user.repository.UserRepository;
import com.example.demo.user.service.impl.UsersServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.List;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@ActiveProfiles(profiles = "test")
@SpringBootTest
class UsersServiceImplTest {

    @Autowired
    private UsersServiceImpl usersService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArticalsRepository  articalsRepository;

    @Test
    void testSave() {
        List<UserEntity> userEntity = userRepository.findAll();
        assertThat(userEntity,hasSize(5));

        UserEntity userEntity1 = new UserEntity();
        userEntity1.setName("andre");
        userEntity1.setAge(17);

        usersService.save(userEntity1);

        List<UserEntity> users = userRepository.findAll();
        assertThat(users, hasSize(6));
    }



    @Test
    void testFindByOlderAge(){
        List<UserEntity> userEntities = userRepository.findAll();
        assertThat(userEntities,hasSize(7));

        UserEntity userEntity1 = new UserEntity();
        userEntity1.setName("andre");
        userEntity1.setAge(17);

        usersService.save(userEntity1);

        List<UserEntity> findbyOlderAge = usersService.findOlderUser(15);
         List<UserEntity> userEntities1 = userRepository.findAll();
         assertThat(userEntities1,hasSize(8));

        assertTrue(findbyOlderAge.get(7).getAge().equals(userEntity1.getAge()));
    }

    @Test
    void testFindByColor(){
        List<UserEntity> userEntities = userRepository.findAll();
        assertThat(userEntities,hasSize(6));

        UserEntity userEntity1 = new UserEntity();
        userEntity1.setName("andre");
        userEntity1.setAge(17);
        Color color = Color.BLUE;
        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setText("some tesx");
        articleEntity.setColor(color);
        articleEntity.setUsers(userEntity1);

        usersService.save(userEntity1);

        List<ArticleEntity> FindByColor = articalsRepository.findAllByColor(Color.BLUE);
        List<UserEntity> userEntities1 = userRepository.findAll();
        assertThat(userEntities1,hasSize(7));

        assertTrue(FindByColor.get(6).getColor().equals(articleEntity.getColor()));
    }


}