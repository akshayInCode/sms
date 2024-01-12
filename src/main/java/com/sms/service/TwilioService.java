package com.sms.service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class TwilioService {

    @Value("${twilio.accountSid}")
    private String accountSid;

    @Value("${twilio.authToken}")
    private String authToken;

    @Value("${twilio.phoneNumber}")
    private String twilioPhoneNumber;

    public void sendSms(String to, String message)  {

            Twilio.init(accountSid, authToken);

            Message twilioMessage = Message.creator(
                            new com.twilio.type.PhoneNumber(to),
                            new com.twilio.type.PhoneNumber(twilioPhoneNumber),
                            message)
                    .create();

            // Handle success or use logger to log information
            System.out.println("SMS sent with SID: " + twilioMessage.getSid());
        }
    }


