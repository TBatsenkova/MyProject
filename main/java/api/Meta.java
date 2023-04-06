package api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "prevPage",
        "nextPage",
        "count"
})

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Meta {
    @JsonProperty("prevPage")
    public Integer prevPage;
    @JsonProperty("nextPage")
    public Integer nextPage;
    @JsonProperty("count")
    public Integer count;
}
