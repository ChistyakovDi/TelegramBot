package com.chistyakov.service.impl;

import com.chistyakov.dao.AppDocumentDAO;
import com.chistyakov.dao.AppPhotoDAO;
import com.chistyakov.entity.AppDocument;
import com.chistyakov.entity.AppPhoto;
import com.chistyakov.entity.BinaryContent;
import com.chistyakov.service.FileService;
import lombok.extern.log4j.Log4j;
import org.apache.commons.io.FileUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Log4j
@Service
public class FileServiceImpl implements FileService {

    private final AppDocumentDAO appDocumentDAO;
    private final AppPhotoDAO appPhotoDAO;

    public FileServiceImpl(AppDocumentDAO appDocumentDAO, AppPhotoDAO appPhotoDAO) {
        this.appDocumentDAO = appDocumentDAO;
        this.appPhotoDAO = appPhotoDAO;
    }

    @Override
    public AppDocument getDocument(String docId) {
        //TODO  add decryption hash string
        var id = Long.parseLong(docId);
        return appDocumentDAO.findById(id).orElse(null);
    }

    @Override
    public AppPhoto getPhoto(String photoId) {
        //TODO  add decryption hash string
        var id = Long.parseLong(photoId);
        return appPhotoDAO.findById(id).orElse(null);
    }

    @Override
    public FileSystemResource getFileSystemResource(BinaryContent binaryContent) {
        try {
            //TODO добавить генерацию имени временного файла?
            File temp = File.createTempFile("tempFile", ".bin");
            temp.deleteOnExit(); // при завершении работы приложения удалит этот временный файл из памяти (регистрация файла в очередь на удаление)
            FileUtils.writeByteArrayToFile(temp, binaryContent.getFileAsArrayOfBytes());
            return new FileSystemResource(temp);
        } catch (IOException e) {
            log.error(e);
            return null;
        }
    }
}
