package com.ddoj.web.service.async;

/**
 * @author zhengtt
 **/
public interface AsyncTaskService {

    void closeOfficialContest(int cid);

    void closeNormalContest(int cid);

    void sendProblemAuditingMessage(String title, int owner, int pid, boolean isAccepted);

    void sendGroupMessage(String message, String groupName, int gid);
}
