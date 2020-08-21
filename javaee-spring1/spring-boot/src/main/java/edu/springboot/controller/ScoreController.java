package edu.springboot.controller;

import edu.springboot.model.Score;
import edu.springboot.model.Stu;
import edu.springboot.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //相当于 @Controller + @ResponseBody
@RequestMapping("/score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping("/query") //因为我们做的是查询语句, 所以用get请求
    public Object query(Integer id) {
        Score scores = scoreService.query(id);
        return scores;
    }

    @PostMapping("/test")
    public Object query(Stu stu) {
        List<Score> scores = scoreService.test(stu);
        return scores;
    }
}
