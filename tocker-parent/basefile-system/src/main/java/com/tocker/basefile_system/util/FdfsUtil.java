//package com.tocker.basefile_system.util;
//
//
///**
// * Created by dailin on 2018/7/11.
// */
//public class FdfsUtil {
//
//    static class Nested {
//        private static TrackerServer trackerServer =null;
//        private static StorageServer storageServer = null;
//        private static StorageClient storageClient = null;
//
//        static {
//            try {
//                ClientGlobal.init("fdfs_client.conf");
//                TrackerClient tracker = new TrackerClient();
//                trackerServer = tracker.getConnection();
//                storageClient = new StorageClient(trackerServer, storageServer);
//            }catch (Exception e) {
//                e.printStackTrace();
//            }
//
//        }
//    }
//
//    //获取单例
//    public  static StorageClient getStorageClient() {
//        return Nested.storageClient;
//    }
//}
