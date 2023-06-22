package chat.accen.Questions;

import com.atlassian.oai.validator.OpenApiInteractionValidator;
import com.atlassian.oai.validator.restassured.OpenApiValidationFilter;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")        
class QuestionsApplicationTests {

        @LocalServerPort
	Integer localPort;
        
        OpenApiValidationFilter filter = new OpenApiValidationFilter("openapi.json");
        
	@BeforeEach
        void setUp(){
            RestAssured.baseURI = "http://localhost";
            RestAssured.port = localPort;
        }
        
        @Test
        void testGetQuestion(){
            
            int id = 1;
            
            RestAssured.given().contentType(ContentType.JSON)
                    .when()
                    .filter(filter)
                    .get("/question/" + id)
                    .then()
                    .assertThat()
                    .statusCode(200);
        
        }

}
