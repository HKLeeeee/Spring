package hello.itemservice.domain.item;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
//@ScriptAssert(lang = "javascript", script = "_this.price * _this.quantity >= 1000", message = "수량 * 값은 10,000 이상이어야합니다.")
public class Item_BeanValidation {

    @NotNull(groups = UpdateCheck.class)
    private Long id;

    @NotBlank(groups = {UpdateCheck.class, SaveCheck.class}, message = "값을 입력하세요")
    private String itemName;

    @NotNull(groups = {UpdateCheck.class, SaveCheck.class}, message = "값을 입력하세요")
    @Range(min=1000, max=1000000)
    private Integer price;

    @NotNull(groups = {UpdateCheck.class, SaveCheck.class}, message = "값을 입력하세요")
    @Max(groups = {SaveCheck.class}, value = 9999)
    private Integer quantity;

    public Item_BeanValidation() {
    }

    public Item_BeanValidation(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
