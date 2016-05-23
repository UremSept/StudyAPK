package com.example.houjie.studyapk;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.x;


/**
 * Created by houjie on 2016/5/6.
 */
public class MainApplication extends Application {
    /**
     * ImageLoaderConfiguration.Builder config = new ImageLoaderConfiguration.Builder(context);
     config.threadPriority(Thread.NORM_PRIORITY - 2);//线程优先级
     config.denyCacheImageMultipleSizesInMemory();//使用内存缓存
     config.diskCacheFileNameGenerator(new Md5FileNameGenerator());
     //使用硬盘缓存时图片名字
     config.diskCacheSize(50 * 1024 * 1024); //硬盘最大缓存 50 MiB
     config.tasksProcessingOrder(QueueProcessingType.LIFO);
     //队列机制
     config.writeDebugLogs(); // Remove for release app

     // Initialize ImageLoader with configuration.
     ImageLoader.getInstance().init(config.build());
     */
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this);
        ImageLoader.getInstance().init(configuration);

    }
}
