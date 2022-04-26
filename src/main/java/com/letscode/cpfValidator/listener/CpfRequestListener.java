package com.letscode.cpfValidator.listener;

import com.letscode.cpfValidator.request.CpfRequest;
import com.letscode.cpfValidator.service.CpfService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CpfRequestListener {
    public final CpfService cpfService;
    @KafkaListener(topics = "${kafka.topic.name}", groupId = "$ {spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<String, CpfRequest> payload) {
        log.info("Payload consumed {} ", payload.key());
        cpfService.addWinner(payload.value());
    }
}
