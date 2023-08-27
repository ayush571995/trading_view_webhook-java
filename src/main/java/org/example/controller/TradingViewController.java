package org.example.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.example.pojo.BaseResponse;
import org.example.pojo.ErrorResponse;
import org.example.pojo.SuccessResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TradingViewController {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    @PostMapping(value = "/",  produces = MediaType.APPLICATION_JSON_VALUE)
    public BaseResponse HandleTradingViewPostRequest(@RequestBody String reqBody)
    {
        try {
            JsonNode jsonNode = objectMapper.readTree(reqBody);

            // You can now work with the JSON data using the JsonNode object
            String message = "Received JSON data: " + jsonNode.toString();
            log.info("Request received {}", message);
            return new SuccessResponse(message);
        } catch (Exception e) {
            return new ErrorResponse(e.getMessage(), 500);
        }
    }
}
