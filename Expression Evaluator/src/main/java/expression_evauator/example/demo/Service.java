package expression_evauator.example.demo;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Service{
    public List<String> inputExpression(List<String> expression) {
        int i=0;
        List<String> ans = new ArrayList<>();
        while(expression.get(i) != "end"){
            ExpressionParser parser = new SpelExpressionParser();
            String s= expression.get(i);
            Expression exp = (Expression) parser.parseExpression("s");
            String message = (String) exp.getValue();
            ans.add(message);
            i++;
        }
        return ans;
    }
}
