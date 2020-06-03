package com.vladimirkomlev.zimadchallenge.models;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;

public class TaskResponse {
    private long id;
    private long projectId;
    private long sectionId;
    private int order;
    private String content;
    private List<Integer> labelIds;
    private int priority;
    private boolean completed;
    private int commentCount;
    private long parent;
    private String url;
    private ZonedDateTime created;

    public long getId() {
        return id;
    }

    public long getProjectId() {
        return projectId;
    }

    public long getSectionId() {
        return sectionId;
    }

    public int getOrder() {
        return order;
    }

    public String getContent() {
        return content;
    }

    public long getParent() {
        return parent;
    }

    public List<Integer> getLabelIds() {
        return labelIds;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isCompleted() {
        return completed;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public String getUrl() {
        return url;
    }

    public ZonedDateTime getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return "TaskResponse{" +
                "id=" + id +
                ", projectId=" + projectId +
                ", sectionId=" + sectionId +
                ", order=" + order +
                ", content='" + content + '\'' +
                ", labelIds=" + labelIds +
                ", priority=" + priority +
                ", completed=" + completed +
                ", commentCount=" + commentCount +
                ", parent=" + parent +
                ", url='" + url + '\'' +
                ", created=" + created +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TaskResponse)) return false;
        TaskResponse response = (TaskResponse) o;
        return getId() == response.getId() &&
                getProjectId() == response.getProjectId() &&
                getSectionId() == response.getSectionId() &&
                getOrder() == response.getOrder() &&
                getPriority() == response.getPriority() &&
                isCompleted() == response.isCompleted() &&
                getCommentCount() == response.getCommentCount() &&
                getParent() == response.getParent() &&
                Objects.equals(getContent(), response.getContent()) &&
                Objects.equals(getLabelIds(), response.getLabelIds()) &&
                Objects.equals(getUrl(), response.getUrl()) &&
                Objects.equals(getCreated(), response.getCreated());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getProjectId(), getSectionId(), getOrder(), getContent(), getLabelIds(), getPriority(), isCompleted(), getCommentCount(), getParent(), getUrl(), getCreated());
    }
}
