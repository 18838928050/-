1.实体类：
@Data
@Accessors(chain = true)
public class TrialInsuredDto {

	@ApiModelProperty(value = "投保人性别")
    @JSONField(name = "AppntSex")
    @JsonProperty(value = "AppntSex")
    private String AppntSex;



}