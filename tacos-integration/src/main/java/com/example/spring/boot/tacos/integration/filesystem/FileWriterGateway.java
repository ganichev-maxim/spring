package com.example.spring.boot.tacos.integration.filesystem;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.file.FileHeaders;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultRequestChannel = "textInChannel")
public interface FileWriterGateway {
    void writeToFile(
            @Header(FileHeaders.FILENAME) String filename,
            String data);
}
