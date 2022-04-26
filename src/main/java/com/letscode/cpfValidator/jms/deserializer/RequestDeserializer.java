package com.letscode.cpfValidator.jms.deserializer;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.letscode.cpfValidator.request.CpfRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Slf4j
public class RequestDeserializer implements Deserializer<CpfRequest> {
    private final ObjectMapper mapper = new ObjectMapper();

    @Override
    public CpfRequest deserialize(String s, byte[] bytes) {
        try {
            if (Objects.nonNull(bytes)) {
                return mapper.readValue(new String(bytes, StandardCharsets.UTF_8), CpfRequest.class);
            }
        } catch (JsonProcessingException e) {
            log.error("error on deserialize kafka object", e);
            throw new RuntimeException(e);
        }
        return null;
    }
}
