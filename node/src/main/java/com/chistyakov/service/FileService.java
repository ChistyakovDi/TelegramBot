package com.chistyakov.service;


import com.chistyakov.entity.AppDocument;
import com.chistyakov.entity.AppPhoto;
import org.telegram.telegrambots.meta.api.objects.Message;

public interface FileService {
    AppDocument processDoc(Message telegramMessage);
    AppPhoto processPhoto(Message telegramMessage);
}

