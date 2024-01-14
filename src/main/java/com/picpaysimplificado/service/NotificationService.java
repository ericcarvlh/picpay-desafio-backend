package com.picpaysimplificado.service;

import com.picpaysimplificado.domain.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class NotificationService {
    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(User user, String message) throws Exception {
        ResponseEntity<Map> responseNotification = restTemplate.getForEntity("https://run.mocky.io/v3/54dc2cf1-3add-45b5-b5a9-6bf7e7f1f4a6", Map.class);

        if (!(responseNotification.getStatusCode() == HttpStatus.OK)) {
            System.out.println("Erro ao enviar notificacao!");
            throw new Exception("Servico de notificacao esta fora do ar.");
        }
    }
}
