package api;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "title",
        "description",
        "content",
        "authorId",
        "mainImage",
        "updatedAt",
        "createdAt",
        "labels",
        "delayPublishTo",
        "draft"
})

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Datum {
    @JsonProperty("id")
    public Integer id;
    @JsonProperty("title")
    public String title;
    @JsonProperty("description")
    public String description;
    @JsonProperty("content")
    public String content;
    @JsonProperty("authorId")
    public Integer authorId;
    //@JsonProperty("mainImage")
    //public MainImage mainImage;
    @JsonProperty("updatedAt")
    public String updatedAt;
    @JsonProperty("createdAt")
    public String createdAt;
    //@JsonProperty("labels")
    //public List<Object> labels = new ArrayList<Object>();
    @JsonProperty("delayPublishTo")
    public Object delayPublishTo;
    @JsonProperty("draft")
    public Boolean draft;
}
