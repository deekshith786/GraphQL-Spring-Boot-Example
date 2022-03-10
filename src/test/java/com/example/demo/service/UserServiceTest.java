package com.example.demo.service;

import static com.example.demo.utils.Constants.TEST_ADDRESS;
import static com.example.demo.utils.Constants.TEST_ID;
import static com.example.demo.utils.Constants.TEST_PASSWORD;
import static com.example.demo.utils.Constants.TEST_PHONE;
import static com.example.demo.utils.Constants.TEST_USERNAME;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.demo.Entity.UserModel;
import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserServiceTest {

    @Autowired
    private GraphQLTestTemplate graphQLTestTemplate;

    @MockBean
    UserService userServiceMock;

    @Test
    public void userItem() throws Exception {

        UserModel user = new UserModel();
        user.setUserId(TEST_ID);
        user.setUserName(TEST_USERNAME);
        user.setUserAddress(TEST_ADDRESS);
        user.setPassword(TEST_PASSWORD);
        user.setUserPhone(TEST_PHONE);

        doReturn(user).when(userServiceMock).userItem(TEST_ID);
        System.out.println("user value = "+user.toString());
        GraphQLResponse response = graphQLTestTemplate.postForResource("userDetails.graphql");
        System.out.println("response value = "+response.isOk());
        assertThat(response.isOk()).isTrue();
        assertThat(response.get("$.data.user.userId")).isNotNull();
        assertThat(response.get("$.data.user.userName")).isEqualTo(TEST_USERNAME);
    }

}