package com.chistyakov.service;

import com.chistyakov.entity.AppDocument;
import com.chistyakov.entity.AppPhoto;
import com.chistyakov.entity.BinaryContent;
import org.springframework.core.io.FileSystemResource;

public interface FileService {
    AppDocument getDocument(String id);
    AppPhoto getPhoto(String id);

    //массив байт из Бд преобразовываем в объект , который можно отправить в теле ответа
    FileSystemResource getFileSystemResource(BinaryContent binaryContent);

}
