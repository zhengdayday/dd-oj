package com.ddoj.web.controller;

import com.ddoj.web.controller.exception.WebErrorException;
import com.ddoj.web.entity.ResponseEntity;
import com.ddoj.web.service.LeaderboardService;
import com.ddoj.web.util.WebUtil;
import com.ddoj.web.controller.exception.WebErrorException;
import com.ddoj.web.entity.ResponseEntity;
import com.ddoj.web.service.LeaderboardService;
import com.ddoj.web.util.WebUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageRowBounds;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.ehcache.Cache;
import com.ddoj.web.cache.CacheController;
import com.ddoj.web.controller.exception.WebErrorException;
import com.ddoj.web.entity.ContestEntity;
import com.ddoj.web.entity.ContestProblemUserEntity;
import com.ddoj.web.entity.ResponseEntity;
import com.ddoj.web.service.ContestProblemUserService;
import com.ddoj.web.service.ContestService;
import com.ddoj.web.service.LeaderboardService;
import com.ddoj.web.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author zhengtt
 **/
@RestController
@Validated
@RequestMapping(value = "/leaderboard", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class LeaderboardController {

    @Autowired
    private LeaderboardService leaderboardService;

    @ApiOperation("获取某个比赛的排行榜")
    @GetMapping("/contest")
    @SuppressWarnings("unchecked")
    public ResponseEntity getContestLeaderboard(@RequestParam int cid) {
        List<Map<String, Object>> list = leaderboardService.getContestLeaderboard(cid);
        if (list == null) {
            throw new WebErrorException("不存在此比赛");
        }
        List<Map<String, Object>> targetList = new LinkedList<>(list);
        targetList.remove(1);
        return new ResponseEntity(targetList);
    }

    @ApiOperation("获取某个比赛中某个用户的详情")
    @GetMapping("/user")
    public ResponseEntity getUserInContestDetail(@RequestParam int cid,
                                                 @RequestParam int uid) {
        return new ResponseEntity(leaderboardService.getUserDetailInContest(cid, uid));
    }

    @ApiOperation("获取网站比赛排行榜")
    @GetMapping
    public ResponseEntity getLeaderboard(@RequestParam("page") int page,
                                         @RequestParam("page_size") int pageSize) {
        Page pager = PageHelper.startPage(page, pageSize);
        return new ResponseEntity(WebUtil.generatePageData(pager, leaderboardService.getLeaderboard()));
    }
}
