package com.yh.utils.bean;

/**
 * 基础的item实体对象
 *
 * @author yh
 * @date 2019/1/9
 */
public class BaseItemBean {

    private String title;
    private String content;

    public BaseItemBean(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
