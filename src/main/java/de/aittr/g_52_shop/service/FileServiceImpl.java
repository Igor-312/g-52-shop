package de.aittr.g_52_shop.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import de.aittr.g_52_shop.service.interfaces.FileService;
import de.aittr.g_52_shop.service.interfaces.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
public class FileServiceImpl implements FileService {

    private final AmazonS3 client;
    private final ProductService productService;

    public FileServiceImpl(AmazonS3 client, ProductService productService) {
        this.client = client;
        this.productService = productService;
    }

    @Override
    public String upload(MultipartFile file, String productTitle) {
        try {
            String uniqueName = generateUniqueFileName(file);

            ObjectMetadata metadata = new ObjectMetadata();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private String generateUniqueFileName(MultipartFile file) {
        String sourceFilename = file.getOriginalFilename();
        int dotIndex = sourceFilename.lastIndexOf(".");
        String fileName = sourceFilename.substring(0, dotIndex);
        String extension = sourceFilename.substring(dotIndex);

        return String.format("%s-%s%s", fileName, UUID.randomUUID(), extension);
    }


}
