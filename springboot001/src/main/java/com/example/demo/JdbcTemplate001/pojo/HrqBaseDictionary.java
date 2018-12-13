package com.example.demo.JdbcTemplate001.pojo;

import java.io.Serializable;

/**
 * @ClassName HrqBaseDictionary
 * @Description // 一句话描述这个类
 * @Author huangrq
 * @Date 2018/12/13 20:33
 */
public class HrqBaseDictionary implements Serializable {
    private static final long serialVersionUID = 2365108015852407716L;

    private Long id;
    private String code="001";
    private String text="003";
    private String type="004";
    private String note="005";
    private Integer status=0;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "HrqBaseDictionary{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", text='" + text + '\'' +
                ", type='" + type + '\'' +
                ", note='" + note + '\'' +
                ", status=" + status +
                '}';
    }
}
