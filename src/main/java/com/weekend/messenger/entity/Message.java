package com.weekend.messenger.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name="tb_messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    LocalDateTime sentTime;
    LocalDateTime receivedTime;
    String content;
    String sender;
    String receiver;

}
