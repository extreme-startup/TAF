package automation.examples.api.resources;

import automation.examples.api.model.request.ContestDTO;
import automation.examples.api.model.response.AllContestDTO;
import automation.examples.api.model.response.CreateContestDTO;
import automation.examples.api.model.response.Identifiers;
import io.restassured.response.Response;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static automation.examples.api.RestAssuredContext.response;
import static automation.examples.framework.spring.utils.RandomUtils.getRandomFromCollection;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

@Service
public class Contest {

    private static final String ENDPOINT = "/contest/";

    public Response get() {
        return given().spec(requestSpecification).get(ENDPOINT);
    }

    public Response post(final ContestDTO contest) {
        return given().spec(requestSpecification).body(contest).post(ENDPOINT);
    }

    public Integer getRandomContestId() {
        final List<AllContestDTO> contests = Arrays.asList(get().as(AllContestDTO[].class));
        final List<Integer> contestIds = contests.stream().map(AllContestDTO::getId).collect(Collectors.toList());
        return getRandomFromCollection(contestIds);
    }

    public Integer getAddedContestId() {
        return  response.as(CreateContestDTO.class).getIdentifiers().stream().mapToInt(Identifiers::getId).sum();
    }

}
