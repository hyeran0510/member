package hello.member.Controller;

import org.apache.tomcat.util.net.TLSClientHelloExtractor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@org.springframework.stereotype.Controller

public class Controller {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data","스프링");
        return "hello";
    }

    @GetMapping("mvc")
    public String helloMvc(@RequestParam(value = "name", required = false ) String name, Model model) {
        model.addAttribute("name", name);
        return "template";
    }

    @GetMapping("string")
    @ResponseBody
    public String String(@RequestParam("ran") String name)
    {
        return "hello" + name;   //hello ran
    }

        @GetMapping("api")
        @ResponseBody
        public Hello hello(@RequestParam("name") String name) {
            Hello hello = new Hello();
            hello.setName(name);
            return hello;
        }

            static class Hello {
                private String name;

                public String getName() {
                    return name;
                }
                public void setName(String name) {
                    this.name = name;
                }
            }
}
