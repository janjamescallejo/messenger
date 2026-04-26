package com.weekend.messenger.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MessageDTO {
    @NotNull
    @Size(max=4000)
    String content;
    @NotNull
    String sender;
    @NotNull
    String receiver;
}
