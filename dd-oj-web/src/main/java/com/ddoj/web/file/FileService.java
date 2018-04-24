package com.ddoj.web.file;

import com.ddoj.judge.LanguageEnum;
import com.ddoj.web.setting.SettingService;
import com.ddoj.web.util.FileUtil;
import com.ddoj.web.util.WebUtil;
import com.ddoj.web.controller.exception.WebErrorException;
import com.ddoj.web.setting.SettingService;
import com.ddoj.web.util.FileUtil;
import com.ddoj.web.util.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;

/**
 * @author zhengtt
 **/
@Service
public class FileService {

    @Autowired
    private SettingService settingService;

    @Autowired
    private FileUtil fileUtil;

    public boolean test(String accessKey, String secretKey, String endPoint, String bucket) {
        return fileUtil.test(accessKey, secretKey, endPoint, bucket);
    }

    public void refresh() {
        fileUtil.refresh();
    }

    public String uploadCode(LanguageEnum lang, String code)  {
        checkIsOpen();
        String url = fileUtil.uploadCode(lang, code);
        WebUtil.assertNotNull(url, "上传代码出错");
        return url;
    }

    public String uploadAvatar(InputStream is, String postfix) {
        checkIsOpen();
        String url =  fileUtil.uploadAvatar(is, postfix);
        WebUtil.assertNotNull(url, "上传头像出错");
        return url;
    }

    private void checkIsOpen() {
        if (! settingService.isOpenStorage()) {
            throw new WebErrorException("未开启存储功能");
        }
    }
}
