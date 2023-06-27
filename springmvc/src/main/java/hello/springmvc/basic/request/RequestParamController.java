package hello.springmvc.basic.request;

import hello.springmvc.basic.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username={} age={}", username, age);

        response.getWriter().write("ok");
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(@RequestParam("username") String username,
                                 @RequestParam("age") int memberAge
    ) throws IOException {

        log.info("username={} age={}", username, memberAge);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(@RequestParam String username, //변수명 동일하면 생략
                                 @RequestParam int age
    ) throws IOException {

        log.info("username={} age={}", username, age);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, //단순타입이면 어노테이션도 생략가능
                                 int age
    ) throws IOException {

        log.info("username={} age={}", username, age);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(@RequestParam(required = true) String username, //단순타입이면 어노테이션도 생략가능
                                       @RequestParam(required = false) Integer age) // 객체에는 null이 가능한데, int 단순 타입에는 null 불가능
            throws IOException {

        log.info("username={} age={}", username, age);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(@RequestParam(defaultValue = "guest") String username,  // "" 의 빈문자의 경우에도 디폴트 값으로 처리
                                      @RequestParam(defaultValue = "-1") Integer age)
            throws IOException {

        log.info("username={} age={}", username, age);

        return "ok";
    }

    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamDefault(@RequestParam Map<String, Object> paramMap) // 파라미터 값이 여러개라면 multivalueMap 사용
            throws IOException {

        log.info("username={} age={}", paramMap.get("username"), paramMap.get("age"));

        return "ok";
    }

//    @ResponseBody
//    @RequestMapping("/model-attribute-v1")
//    public String modelAttributeV1(@RequestParam String username,
//                                   @RequestParam int age){
//        HelloData helloData = new HelloData();
//        helloData.setUsername(username);
//        helloData.setAge(age);
//        log.info("username={} age={}", helloData.getUsername(), helloData.getAge());
//        log.info("helloData={} ", helloData);
//        return "ok";
//    }
    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData){
        log.info("username={} age={}", helloData.getUsername(), helloData.getAge());
        log.info("helloData={} ", helloData);
        return "ok";
    }
    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData){
        log.info("username={} age={}", helloData.getUsername(), helloData.getAge());
        return "ok";
    }
}
