package com.turkcell.pair1.service.abstraction;

public interface MessageService {
    String getMessage(String key);
    String getMessageWithArgs(String key, Object... args);
}
