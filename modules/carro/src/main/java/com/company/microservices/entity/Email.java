package com.company.microservices.entity;

import com.company.microservices.enums.StatusEmail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Email {

    private String id;

    private String ownerRef;

    private String emailFrom;

    private String emailTo;

    private String subject;

    private String text;

    private LocalDateTime sendDateTime;

    private StatusEmail statusEmail;


}
