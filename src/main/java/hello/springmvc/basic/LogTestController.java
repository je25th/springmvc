package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j//롬복이 제공하는 annotation
@RestController//반환 값으로 뷰를 찾는 것이 아니라, HTTP 메시지 바디에 바로 입력한다.
public class LogTestController {
    //private final Logger log = LoggerFactory.getLogger(getClass());//@Slf4j써서 필요없음

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        log.trace("trace log="+name);//이런식으로 쓰면 쓸데없는 trace로그를 찍지 않아도 +연산은 일어나기 때문에 낭비임

        log.trace("trace log={},{}", name,name);
        log.debug("debug log={}", name);
        log.info("info log={}", name);
        log.warn("warn log={}", name);
        log.error("error log={}", name);

        return "ok";
    }
}
