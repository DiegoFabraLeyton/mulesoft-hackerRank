package com.mulesoft.exercise.model;

import java.util.Map;
import java.util.Set;

public class Path {

    private Set<String> path;
    private Map<String, FileComponent> fileComponentMap;

    public Path(Set<String> path, Map<String, FileComponent> fileComponentMap) {
        this.path = path;
        this.fileComponentMap = fileComponentMap;
    }

    public Set<String> getListFolderNames() {
        return path;
    }

    public Map<String, FileComponent> getFileComponentMap() {
        return fileComponentMap;
    }

    public void setPath(Set<String> path) {
        this.path = path;
    }
}
