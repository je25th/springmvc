package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/hello-basic", method = RequestMethod.GET)
    public String holloBasic() {
        log.info("helloBasic");
        return "hello";
    }

    @GetMapping("/hello-baice-v2")
    public String helloBasicV2() {
        log.info("helloBasicV2");
        return "hello2";
    }

    /**
     * pathVariable 사용
     * 변수명이 같으면 생략 가능
     *
     * @PathVariable("userId") String userId -> @PathVariable userId
     * /mapping/userA
     * <p>
     * 최근 HTTP API는 아래와 같이 리소스 경로에 식별자를 넣는 스타일을 선호함
     * /mapping/userA
     * /users/1
     */
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        log.info("mappingPath userId={}", data);
        return "ok";
    }

    @GetMapping("/mapping2/{userId}")//변수명 같으면 ("userId") 생략 가능함
    public String mappingPath2(@PathVariable String userId) {
        log.info("mappingPath userId={}", userId);
        return "ok";
    }

    /**
     * PathVariable 다중 사용
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable String orderId) {
        log.info("mappingPath userId={}, order={}", userId, orderId);
        return "ok";
    }

    /**
     * 파라미터로 추가 매핑 --> 별로 쓰지는 않음
     * params="mode"
     * params="!mode"
     * params="mode=debug"
     * params="mode!=debug"
     * params = {"mode=debug, data=good"}
     */
    @GetMapping(value = "/mapping-param", params = "mode=debug")///mapping-param?mode=debug라고 해야지 호출됨
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }

    /**
     * 특정 헤더로 추가 매핑
     * headers="mode"
     * headers="!mode"
     * headers="mode=debug"
     * headers="mode!=debug"
     */
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type
     * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     */
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }

    /**
     * Accept 헤더 기반 Media Type
     * produces="text/html"
     * produces="!text/html"
     * produces="text/*"
     * produces="*\/*"
     */
    @PostMapping(value = "/mapping-produce", produces = "text/html")
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }
}
