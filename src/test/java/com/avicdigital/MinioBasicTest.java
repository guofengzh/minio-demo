package com.avicdigital;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.InputStream;

public class MinioBasicTest {

  String bucketname = "testbuckt" ;

  @BeforeClass
  public static void init() {
    MinioClientFunctions.init();
  }

  @Test
  public void testMakeBucket() throws Exception {
    MinioClientFunctions.makeBucketIfNotExisted(bucketname) ;
  }

  @Test
  public void testStoreFile() throws Exception {
    MinioClientFunctions.storeFile(bucketname, "2020-8-19 10-38-16.avi", "2020-8-19 10-38-16.avi");
  }

  @Test
  public void testGetFile() throws Exception {
    InputStream stream = MinioClientFunctions.getFile(bucketname, "2020-8-19 10-38-16.avi");
    // ......
  }

  @Test
  public void testDownloadFile() throws Exception {
    MinioClientFunctions.downloadFile(bucketname, "2020-8-19 10-38-16.avi", "downloadedFile.avi") ;
  }
}
