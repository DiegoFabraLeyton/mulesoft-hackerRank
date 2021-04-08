package com.mulesoft.exercise.usecases.impl;

import com.mulesoft.exercise.model.Path;
import com.mulesoft.exercise.usecases.GetPath;
import com.mulesoft.exercise.usecases.ShowPath;

import java.util.Set;

public class DefaultShowPath implements ShowPath {

    private GetPath getPath;

    public DefaultShowPath(final GetPath getPath) {
        this.getPath = getPath;
    }

    @Override
    public void display() {

        final Path root = getPath.get();

        final Set<String> names = root.getListFolderNames();

        names.forEach(e -> System.out.print("/" + e));

    }
}
