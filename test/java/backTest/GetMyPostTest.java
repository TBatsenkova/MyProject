package backTest;


import api.PostList;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetMyPostTest extends AbstractTest{
    @BeforeEach
    public void configureSpecifications() {
        Specifications.installSpecifications(Specifications.getMyPost(), Specifications.responseUnique(200));
    }

    @Test
    void getMyPostPositiveTest() {
        PostList postList = given()
                .when()
                .get()
                .then()
                .extract()
                .response().body().as(PostList.class);
        assertThat(postList, hasProperty("data"));
        assertThat(postList, hasProperty("meta"));
        assertThat(postList.getMeta(), hasProperty("prevPage"));
        assertThat(postList.getMeta(), hasProperty("nextPage"));
        assertThat(postList.getMeta(), hasProperty("count"));
    }

    @Test
    void checkAuthorOfPostListTest() {
        List<Integer> authorIdList = given()
                .when()
                .get()
                .then()
                .extract()
                .response().jsonPath().getList("data.authorId");
       //проверяем что посты написаны одним автором
        assert authorIdList.stream().allMatch(authorIdList.get(0)::equals);
    }

    @Test
    void isTenPostsInOnePageTest() {
        PostList postList = given()
                .when()
                .get()
                .then()
                .extract()
                .response().body().as(PostList.class);
        assertThat(postList.data.size(), equalTo(10));
    }

    @Test
    void getPageWithPostTest() {
        PostList postList = given()
                .queryParam("page", "2")
                .when()
                .get()
                .then()
                .extract()
                .response().body().as(PostList.class);
        assertThat(postList.getMeta().getPrevPage(), equalTo(1));
        assertThat(postList.getMeta().getNextPage(), equalTo(3));
        assertThat(postList.getData(), hasSize(greaterThan(0)));
    }

    @Test
    void getEmptyPageTest() {
        PostList postList = given()
                .queryParam("page", "10")
                .when()
                .get()
                .then()
                .extract()
                .response().body().as(PostList.class);
        assertThat(postList.getMeta().getPrevPage(), equalTo(9));
        assertThat(postList.getMeta().getNextPage(), equalTo(null));
        assertThat(postList.getData(), Matchers.hasSize(0));
    }
}
