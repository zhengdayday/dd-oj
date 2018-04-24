package com.ddoj.web.judger;

import com.ddoj.web.service.JudgerService;
import com.ddoj.web.entity.JudgerEntity;
import com.ddoj.web.service.JudgerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

/**
 * @author zhengtt
 **/
@Service
public class JudgerDispatcher {

    @Autowired
    private JudgerService judgerService;

    private List<JudgerEntity> judgerList;

    public void refresh() {
        judgerList = judgerService.listJudger();
    }

    public String getJudgerUrl() {
        if (judgerList == null || judgerList.size() == 0) {
            refresh();
        }

        if (judgerList == null || judgerList.size() == 0) {
            return null;
        }

        return generateUrl(randomJudger());
    }

    private JudgerEntity randomJudger() {
        Random random = new Random();
        int size = judgerList.size();
        int offset = random.nextInt(size);
        return judgerList.get(offset);
    }

    private String generateUrl(JudgerEntity entity) {
        return "http://"+entity.getUrl()+":"+entity.getPort();
    }
}
