package hello.itemservice.web.validation;

import hello.itemservice.web.validation.form.ItemSaveForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/validation/api/items")
public class ValidationItemApiController {

    /*
    API 요청시 3가지 케이스가 존재
    - 성공 요청
    - 실패 요청 : Json에서 객체를 만드는 것 자체에서 실패 (ex. typeerror)
    - 검증 오류
     */
    @PostMapping("/add")
    public Object addItem(@RequestBody @Validated ItemSaveForm form, BindingResult bindingResult) {
        log.info("API 컨트롤러 호출");

        if (bindingResult.hasErrors()) {
            log.info("검증오류 발생 errors={}", bindingResult);
            return bindingResult.getAllErrors();
        }

        log.info("성공");
        return form;
    }

}
