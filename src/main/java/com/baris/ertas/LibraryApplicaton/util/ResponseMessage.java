package com.baris.ertas.LibraryApplicaton.util;

import lombok.AllArgsConstructor;

public class ResponseMessage {
    public final String message;
    public final MessageType messageType;

    public ResponseMessage(String message, MessageType messageType) {
        this.message = message;
        this.messageType = messageType;
    }
}
