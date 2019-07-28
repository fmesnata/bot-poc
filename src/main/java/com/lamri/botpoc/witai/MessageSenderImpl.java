package com.lamri.botpoc.witai;

import com.lamri.botpoc.chat.dto.UserMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.web.util.DefaultUriBuilderFactory.EncodingMode.NONE;

@Component
public class MessageSenderImpl implements MessageSender {

    private RestTemplate restTemplate;

    @Value("${witai.url}")
    private String witaiUrl;

    @Value("${witai.token}")
    private String witaiToken;

    public MessageSenderImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public MessageReport send(UserMessage message) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer " + witaiToken);

        HttpEntity entity = new HttpEntity<>(headers);

        DefaultUriBuilderFactory factory = new DefaultUriBuilderFactory(witaiUrl);
        factory.setEncodingMode(NONE);
        restTemplate.setUriTemplateHandler(factory);

        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(witaiUrl)
                .queryParam("v", formattedDate())
                .queryParam("q", message.getText());

        return restTemplate.exchange(builder.toUriString(), GET, entity, MessageReport.class)
                .getBody();
    }

    private String formattedDate() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

        return localDate.format(formatter);
    }
}
