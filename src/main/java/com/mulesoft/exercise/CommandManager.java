package com.mulesoft.exercise;

import com.mulesoft.exercise.model.FileComponent;

public interface CommandManager  {

    FileComponent executeStep(String command);
}
