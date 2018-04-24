package com.ddoj.web.service;

import com.ddoj.web.entity.AnnouncementEntity;

import java.util.List;

/**
 * @author zhengtt
 **/
public interface AnnouncementService {

    void saveAnnouncement(String title, String content);

    List<AnnouncementEntity> listAllAnnouncements();

    void updateAnnouncement(int aid, String title, String content);

    void deleteAnnouncement(int aid);

}
