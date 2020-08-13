package com.rain.wallpaper.ui;

import java.util.List;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: Entity
 * @CreateDate: 2020/8/13 0:23
 * @Describe:
 */
public class Entity {

    /**
     * code : 200
     * day : 2020年08月13日
     * content : ["隋文帝杨坚逝世","南唐后主李煜逝世","西班牙军队攻陷特诺奇蒂特兰","率领联军击败法国和巴伐利亚联军","法国著名画家欧仁德拉克罗瓦逝世","中华民国副总统李宗仁出生","美国著名电影导演希区柯克诞生","近代护理学与护理教育创始人南丁格尔逝世","人类首次发现癌细胞","诺贝尔化学奖得主弗雷德里克桑格出生","古巴革命领导人卡斯特罗出生"]
     */

    private String code;
    private String day;
    private List<String> content;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "code='" + code + '\'' +
                ", day='" + day + '\'' +
                ", content=" + content +
                '}';
    }
}
