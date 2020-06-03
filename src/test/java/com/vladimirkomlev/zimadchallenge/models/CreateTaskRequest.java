package com.vladimirkomlev.zimadchallenge.models;

import java.util.List;

public class CreateTaskRequest {
    private long projectId;
    private long sectionId;
    private int order;
    private String content;
    private List<Integer> labelIds;
    private int priority;
    private long parent;

    public long getParent() {
        return parent;
    }

    public CreateTaskRequest withParent(long parent) {
        this.parent = parent;
        return this;
    }

    public long getProjectId() {
        return projectId;
    }

    public CreateTaskRequest withProjectId(int projectId) {
        this.projectId = projectId;
        return this;
    }

    public long getSectionId() {
        return sectionId;
    }

    public CreateTaskRequest withSectionId(int sectionId) {
        this.sectionId = sectionId;
        return this;
    }

    public int getOrder() {
        return order;
    }

    public CreateTaskRequest withOrder(int order) {
        this.order = order;
        return this;
    }

    public String getContent() {
        return content;
    }

    public CreateTaskRequest withContent(String content) {
        this.content = content;
        return this;
    }

    public List<Integer> getLabelIds() {
        return labelIds;
    }

    public CreateTaskRequest withLabelIds(List<Integer> labelIds) {
        this.labelIds = labelIds;
        return this;
    }

    public int getPriority() {
        return priority;
    }

    public CreateTaskRequest withPriority(int priority) {
        this.priority = priority;
        return this;
    }
}
