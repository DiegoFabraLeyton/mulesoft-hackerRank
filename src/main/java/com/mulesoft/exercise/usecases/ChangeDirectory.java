package com.mulesoft.exercise.usecases;

import com.mulesoft.exercise.model.FileComponent;

public interface ChangeDirectory {

    FileComponent change(FileComponent current ,String name);
}
