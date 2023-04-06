package backTest;

import api.PostList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class GetNotMyPostTest extends AbstractTest {
    @BeforeEach
    public void configureSpecifications() {
        Specifications.installSpecifications(Specifications.getNotMyPost(), Specifications.responseUnique(200));
    }

    @Test
    void getNotMyPostPositiveTest() {
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
    void checkIsMyPostInListTest() {
        List<Integer> authorIdList = given()
                .when()
                .get()
                .then()
                .extract()
                .response().jsonPath().getList("data.authorId");

        assert authorIdList.stream().noneMatch(x -> x.equals(Integer.parseInt(getMyId())));
    }

    @Test
    void isForePostsInOnePageTest() {
        PostList postList = given()
                .when()
                .get()
                .then()
                .extract()
                .response().body().as(PostList.class);
        assertThat(postList.getData().size(), equalTo(4));
    }

    @Test
    void ASCSortedPostTest() {
        List<Integer> postId = given()
                .queryParam("order", "ASC")
                .when()
                .get()
                .then()
                .extract()
                .response().jsonPath().getList("data.id");
        assert postId.stream().sorted().collect(Collectors.toList()).equals(postId);
    }

    @Test
    void getAllPostTest() {
        PostList postList = given()
                .queryParam("order", "ALL")
                .when()
                .get()
                .then()
                .extract()
                .response().body().as(PostList.class);
        assertThat(postList.getData(), hasSize(greaterThan(0)));
    }


}
