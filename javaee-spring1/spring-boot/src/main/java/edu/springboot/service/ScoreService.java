package edu.springboot.service;

import edu.springboot.mapper.ScoreMapper;
import edu.springboot.model.Score;
import edu.springboot.model.Stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    @Autowired
    private ScoreMapper scoreMapper;
    public Score query(Integer id) {
        return scoreMapper.selectByPrimaryKey(id);
    }

    public List<Score> test(Stu stu) {
        return scoreMapper.selectByStu(stu);
    }
}
