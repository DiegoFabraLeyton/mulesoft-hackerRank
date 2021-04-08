package com.mulesoft.exercise.usecases.impl;

import com.mulesoft.exercise.model.Path;
import com.mulesoft.exercise.usecases.GetPath;

public class DefaultGetPath implements GetPath {

    private Path path;

    public DefaultGetPath(final Path path) {
        this.path = path;
    }

    @Override
    public Path get() {
        return path;
    }
}
