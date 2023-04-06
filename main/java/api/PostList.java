package api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "data",
        "meta"
})

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostList {

    @JsonProperty("data")
    public List<Datum> data = new ArrayList<Datum>();
    @JsonProperty("meta")
    public Meta meta;
}
