package com.example.demo;

import org.springframework.messaging.Message;

import java.util.Comparator;

public class CustomMessageComparator implements Comparator<Message<String>> {
    @Override
    public int compare(Message<String> m1, Message<String> m2) {
        String payload1 = m1.getPayload();
        String payload2 = m2.getPayload();

        boolean isPayloadEven = Integer.parseInt(payload1.substring(payload1.length() - 1)) % 2 == 0;
        boolean isPayload2Even = Integer.parseInt(payload2.substring(payload2.length() - 1)) % 2 == 0;

        if ((isPayloadEven && isPayload2Even) || (!isPayloadEven && !isPayload2Even)) {
            return 0;
        } else if (isPayloadEven) {
            return -1;
        } else {
            return 1;
        }
    }
}