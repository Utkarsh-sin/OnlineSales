package expression_evauator.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/expression")
public class Controller {

    @Autowired
    Service service;
    @PostMapping("/addProductWithA")
    public List<String> inputExpression(@RequestBody List<String> expression){
        return service.inputExpression(expression);
    }


}
