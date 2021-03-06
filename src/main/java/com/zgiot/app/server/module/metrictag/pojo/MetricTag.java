package com.zgiot.app.server.module.metrictag.pojo;

import com.zgiot.app.server.module.util.validate.AddValidate;
import com.zgiot.app.server.module.util.validate.DeleteValidate;
import com.zgiot.app.server.module.util.validate.UpdateValidate;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by wangfan on 2018/1/8.
 */
public class MetricTag {

    /**
     * 主键
     */
    @NotNull(message = "主键(metricTagId)不能为空", groups = {UpdateValidate.class, DeleteValidate.class})
    private Integer id;

    /**
     * code编号
     */
    @NotBlank(message = "code编号(code)不能为空", groups = {AddValidate.class})
    private String code;

    /**
     * 标签名称
     */
    @NotBlank(message = "标签名称(tagName)不能为空", groups = {AddValidate.class})
    private String tagName;

    /**
     * 所属父类标签id
     */
    private Integer parentId;

    /**
     * 层级路径
     */
    private String codePath;

    /**
     * 层级路径模糊查询
     */
    private String codePathLike;

    /**
     * 所属标签大类主键
     */
    @NotNull(message = "所属标签大类编号(metricTagGroupId)不能为空", groups = {AddValidate.class})
    private Integer metricTagGroupId;

    /**
     * 所属标签大类code
     */
    private String metricTagGroupCode;

    /**
     * 创建时间
     */
    private Date createDate;

    private Date updateDate;

    private String comments;

    private String operator;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getCodePath() {
        return codePath;
    }

    public void setCodePath(String codePath) {
        this.codePath = codePath;
    }

    public String getCodePathLike() {
        return codePathLike;
    }

    public void setCodePathLike(String codePathLike) {
        this.codePathLike = codePathLike;
    }

    public Integer getMetricTagGroupId() {
        return metricTagGroupId;
    }

    public void setMetricTagGroupId(Integer metricTagGroupId) {
        this.metricTagGroupId = metricTagGroupId;
    }

    public String getMetricTagGroupCode() {
        return metricTagGroupCode;
    }

    public void setMetricTagGroupCode(String metricTagGroupCode) {
        this.metricTagGroupCode = metricTagGroupCode;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public String getComments() {
        return comments;
    }

    public String getOperator() {
        return operator;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
