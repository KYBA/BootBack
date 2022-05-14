package com.example.demo.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.common.CommonPage;
import com.example.demo.dao.CharityMapper;
import com.example.demo.dao.EventMapper;
import com.example.demo.dao.QuizMapper;
import com.example.demo.entity.req.Question;
import com.example.demo.entity.resp.CharityVO;
import com.example.demo.entity.resp.Event;
import com.example.demo.entity.resp.QuestionVO;
import com.example.demo.entity.resp.Quiz;
import com.example.demo.entity.resp.ScoreAndCount;
import com.example.demo.service.SearchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hutool.core.util.StrUtil;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired(required = false)
    private EventMapper eventMapper;

    @Autowired(required = false)
    private CharityMapper charityMapper;

    @Autowired(required = false)
    private QuizMapper quizMapper;

    @Override
    public CommonPage searchEvent(String category, String location, String time, Integer pageNum, Integer pageSize) {
        CommonPage result = new CommonPage();
        int total = eventMapper.getTotal(category, location, time);
        result.setTotal(Long.valueOf(total));
        if (total % pageSize == 0) {
            result.setTotalPage(Long.valueOf(total / pageSize));
        } else {
            result.setTotalPage(Long.valueOf(total / pageSize + 1));
        }
        List<Event> list = eventMapper.getList(category, location, time, (pageNum - 1) * pageSize, pageSize);
        // result.setList(list);
        result.setPageNum(Long.valueOf(pageNum));
        result.setPageSize(Long.valueOf(pageSize));
        return result;
    }

    @Override
    public CommonPage searchCharity(String yearLevel, String state, String size, String keyword, Integer pageNum,
            Integer pageSize) {
        CommonPage result = new CommonPage();
        if (StrUtil.isNotBlank(keyword)) {
            keyword = "%" + keyword + "%";
        }
        int total = charityMapper.getTotal(yearLevel, state, size, keyword);
        result.setTotal(Long.valueOf(total));
        if (total % pageSize == 0) {
            result.setTotalPage(Long.valueOf(total / pageSize));
        } else {
            result.setTotalPage(Long.valueOf(total / pageSize + 1));
        }
        List<CharityVO> list = charityMapper.getList(yearLevel, state, size, keyword, (pageNum - 1) * pageSize,
                pageSize);
        for (CharityVO charityVO : list) {
            // System.out.println(charityVO.toString());
            List<String> states = charityMapper.getStateByCharity(charityVO.getCharityId());
            // System.out.println(states.toString());
            charityVO.setState(states.toString());
        }
        result.setList(list);
        result.setPageNum(Long.valueOf(pageNum));
        result.setPageSize(Long.valueOf(pageSize));
        return result;
    }

    @Override
    public ScoreAndCount scoreAndCount(List<Question> answers) {
        ScoreAndCount result = new ScoreAndCount();
        int rightCount = 0;
        int totalCount = 0;
        int totalRight = 0;
        long id = 1;
        List<QuestionVO> questionVOs = new ArrayList<>();
        for (Question question : answers) {
            Quiz quiz = quizMapper.selectOne(new QueryWrapper<Quiz>().eq("question_string", question.getQuestion()));
            QuestionVO questionVO = new QuestionVO();
            questionVO.setQuestion(question.getQuestion());
            double questionPercent = 0.00;
            if (quiz == null) {
                quiz = new Quiz();
                quiz.setQuestionId(id);
                id++;
                quiz.setQuestionString(question.getQuestion());
                quiz.setTotalParticipants(1);
                totalCount += quiz.getTotalParticipants();
                quiz.setCorrectCount(0);
                quiz.setWrongCount(0);
                if (question.isAnswer()) {
                    quiz.setCorrectCount(1);
                    rightCount++;

                } else {
                    quiz.setWrongCount(1);
                }
                totalRight += quiz.getCorrectCount();
                quizMapper.insert(quiz);
            } else {
                quiz.setTotalParticipants(quiz.getTotalParticipants() + 1);
                totalCount += quiz.getTotalParticipants();
                if (question.isAnswer()) {
                    quiz.setCorrectCount(quiz.getCorrectCount() + 1);
                    rightCount++;
                } else {
                    quiz.setWrongCount(quiz.getWrongCount() + 1);
                }
                totalRight += quiz.getCorrectCount();
                quizMapper.updateById(quiz);
            }
            questionPercent = (double) quiz.getCorrectCount() / quiz.getTotalParticipants();
            BigDecimal bigDecimal = new BigDecimal(questionPercent);
            questionVO.setPercent(bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
            questionVOs.add(questionVO);
        }
        double percent = (double) rightCount / answers.size();
        double totalPercent = (double) totalRight / totalCount;
        BigDecimal b = new BigDecimal(percent);
        result.setUserPercent(b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        b = new BigDecimal(totalPercent);
        result.setAvgPercent(b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue());
        result.setQuestionVOs(questionVOs);
        return result;
    }

}
