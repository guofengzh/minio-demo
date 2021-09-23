package com.avicdigital;

import io.minio.*;
import io.minio.errors.*;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 *
 */
public class MinioClientFunctions {

  private static MinioClient minioClient ;

  static void init() {
    minioClient = MinioClient.builder()
                    .endpoint("http://localhost:9000")
                    .credentials("minioadmin", "minioadmin")
                    .build();
  }

  static void makeBucketIfNotExisted(String bucketName) throws Exception {
    boolean found =
            minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build());
    if (!found) {
      minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
    }
  }

  static void storeFile(String bucketname, String objecName, String filePath) throws Exception {
    minioClient.uploadObject(
            UploadObjectArgs.builder()
                    .bucket(bucketname)
                    .object(objecName)
                    .filename(filePath)
                    .build());
  }

  static InputStream getFile(String bucketname, String objecName) throws Exception {
    InputStream stream = minioClient.getObject(
            GetObjectArgs.builder()
                    .bucket(bucketname)
                    .object(objecName)
                    .build());
    return stream ;
  }

  static void downloadFile(String bucketname, String objecName, String localFilePath) throws Exception {
    minioClient.downloadObject(
            DownloadObjectArgs.builder()
                    .bucket(bucketname)
                    .object(objecName)
                    .filename(localFilePath)
                    .build());
  }
}
