package com.mulesoft.exercise;

import com.mulesoft.exercise.model.FileComponent;

public interface ShieldCommand {

    FileComponent execute(String command, FileComponent component);
}
