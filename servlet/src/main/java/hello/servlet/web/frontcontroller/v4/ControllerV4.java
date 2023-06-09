package hello.servlet.web.frontcontroller.v4;

import java.util.Map;

public interface ControllerV4 {
    /**
     *
     * @param paramMap
     * @param model
     * @return
     */
    // v3와 차이점. v3는 model view 가 모델을 들고 있어 컨트롤러에게 전달했는데
    // v4는 프론트 컨트롤러가 모델까지 관리하여 컨트롤러에 전달..
    String process(Map<String, String> paramMap, Map<String, Object> model);


}
