package org.learning.statics.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * Created by jieli5 on 9/7/2017.
 */
public class CMSContent {
    private Integer id;
    private Integer siteId;
    private String title;
    private Integer userId;
    private Integer checkUserId;
    private Integer categoryId;
    private String modelId;
    private Integer parentId;
    private Integer copied;
    private String author;
    private String editor;
    private Integer onlyUrl;
    private Integer hasImages;
    private Integer hasFiles;
    private Integer hasStatic;
    private String url;
    private String description;
    private Integer tagIds;
    private String cover;
    private Integer childs;
    private Integer scores;
    private Integer comments;
    private Integer clicks;
    private Date publishDate;
    private Date createDate;
    private Integer sort;
    private Integer status;
    private Integer disabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCheckUserId() {
        return checkUserId;
    }

    public void setCheckUserId(Integer checkUserId) {
        this.checkUserId = checkUserId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getModelId() {
        return modelId;
    }

    public void setModelId(String modelId) {
        this.modelId = modelId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getCopied() {
        return copied;
    }

    public void setCopied(Integer copied) {
        this.copied = copied;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public Integer getOnlyUrl() {
        return onlyUrl;
    }

    public void setOnlyUrl(Integer onlyUrl) {
        this.onlyUrl = onlyUrl;
    }

    public Integer getHasImages() {
        return hasImages;
    }

    public void setHasImages(Integer hasImages) {
        this.hasImages = hasImages;
    }

    public Integer getHasFiles() {
        return hasFiles;
    }

    public void setHasFiles(Integer hasFiles) {
        this.hasFiles = hasFiles;
    }

    public Integer getHasStatic() {
        return hasStatic;
    }

    public void setHasStatic(Integer hasStatic) {
        this.hasStatic = hasStatic;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getTagIds() {
        return tagIds;
    }

    public void setTagIds(Integer tagIds) {
        this.tagIds = tagIds;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public Integer getChilds() {
        return childs;
    }

    public void setChilds(Integer childs) {
        this.childs = childs;
    }

    public Integer getScores() {
        return scores;
    }

    public void setScores(Integer scores) {
        this.scores = scores;
    }

    public Integer getComments() {
        return comments;
    }

    public void setComments(Integer comments) {
        this.comments = comments;
    }

    public Integer getClicks() {
        return clicks;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDisabled() {
        return disabled;
    }

    public void setDisabled(Integer disabled) {
        this.disabled = disabled;
    }
}
