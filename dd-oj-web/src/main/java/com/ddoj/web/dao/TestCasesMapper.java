package com.ddoj.web.dao;

import com.ddoj.web.entity.TestCaseEntity;
import com.ddoj.web.entity.TestCaseEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhengtt
 **/
@Repository
public interface TestCasesMapper {
    int save(TestCaseEntity testCaseEntity);

    List<TestCaseEntity> listTestCasesByPid(int pid);

    int updateByTidPid(@Param("tid") int tid, @Param("pid") int pid, @Param("data") TestCaseEntity data);

    int deleteByTidPid(@Param("tid") int tid, @Param("pid") int pid);

    int countByPid(int pid);

    int deleteByPid(int pid);
}
