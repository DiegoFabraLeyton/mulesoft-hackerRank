package com.mulesoft.exercise.model;

import java.util.ArrayList;
import java.util.List;

public class Folder implements FileComponent {

    private List<FileComponent> componentList;

    private String name;

    public Folder(final String name) {
        this.name = name;

        this.componentList = new ArrayList<>();
    }

    @Override
    public FileComponent addFileComponent(final FileComponent component) {
        componentList.add(component);
        return component;
    }

    @Override
    public void display() {

        System.out.println("/" + getName());

    }

    public String getName() {
        return name;
    }

    @Override
    public boolean isDirectory() {
        return Boolean.TRUE;
    }

    public List<FileComponent> getComponentList() {
        return componentList;
    }

}
