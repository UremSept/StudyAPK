package com.example.houjie.studyapk.studyhttp.activity;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.houjie.studyapk.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.squareup.picasso.Picasso;

public class ActivityHttpDownImage extends AppCompatActivity {
    //1、在MyApplication中初始化
    //2、储存卡、网络请求权限
    //注意引用包
    private ImageView httpDownImageImageView1;
    private SimpleDraweeView httpDownImageImageView3;
    private Button httpDownImageBtn1, httpDownImageBtn2, httpDownImageBtn3, httpDownImageBtn4, httpDownImageBtn5;
    private String uri = "http://www.cnr.cn/ent/list/20151116/W020151116277914069193.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_http_down_image);
        httpDownImageImageView1 = (ImageView) findViewById(R.id.httpDownImageImageView1);
        httpDownImageImageView3 = (SimpleDraweeView) findViewById(R.id.httpDownImageImageView3);
        httpDownImageBtn1 = (Button) findViewById(R.id.httpDownImageBtn1);
        httpDownImageBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runOnUiThread(new ThisThread());

            }
        });
        httpDownImageBtn2 = (Button) findViewById(R.id.httpDownImageBtn2);
        httpDownImageBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**Picasso
                 * 用于加载和缓存网络图片的框架
                 首先加载库
                 compile 'com.squareup.picasso:picasso:2.5.2'
                 */
                Picasso.with(ActivityHttpDownImage.this)
                        .load(uri)//加载地址
                        .placeholder(R.mipmap.ic_launcher)//占位图
                        .error(R.mipmap.aa)//加载失败的图
                        .fit()//充满
                        .tag(ActivityHttpDownImage.this)//标记
                        .into(httpDownImageImageView1);//加载到ImageView
            }
        });
        httpDownImageBtn3 = (Button) findViewById(R.id.httpDownImageBtn3);
        httpDownImageBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * Fresco是Facebook推出的加载图片的框架，支持gif图片。
                 Fresco能够自动加载图片，不需要再考虑下载以及缓存。可以加载网络图片，本地图片等等。
                 Fresco是二级缓存，内存缓存和sdcard缓存
                 有效避免内存溢出的情况
                 支持图片的格式JPEG GIF和WebP
                 官方地址
                 https://github.com/facebook/fresco
                 */
                /**
                 * uri支持
                 * network         http:// https://
                 * device          file://
                 * Content provider content://
                 * asset in app     asset://
                 * Resource in app   res://123456
                 * Data in URI       data:mime/type：base64
                 */
                /**
                 * <com.facebook.drawee.view.SimpleDraweeView
                 android:id="@+id/my_image_view"
                 android:layout_width="20dp"
                 android:layout_height="20dp"
                 fresco:fadeDuration="300"
                 fresco:actualImageScaleType="focusCrop"
                 fresco:placeholderImage="@color/wait_color"
                 fresco:placeholderImageScaleType="fitCenter"
                 fresco:failureImage="@drawable/error"
                 fresco:failureImageScaleType="centerInside"
                 fresco:retryImage="@drawable/retrying"
                 fresco:retryImageScaleType="centerCrop"
                 fresco:progressBarImage="@drawable/progress_bar"
                 fresco:progressBarImageScaleType="centerInside"
                 fresco:progressBarAutoRotateInterval="1000"
                 fresco:backgroundImage="@color/blue"
                 fresco:overlayImage="@drawable/watermark"
                 fresco:pressedStateOverlayImage="@color/red"
                 fresco:roundAsCircle="false"
                 fresco:roundedCornerRadius="1dp"
                 fresco:roundTopLeft="true"
                 fresco:roundTopRight="false"
                 fresco:roundBottomLeft="false"
                 fresco:roundBottomRight="true"
                 fresco:roundWithOverlayColor="@color/corner_color"
                 fresco:roundingBorderWidth="2dp"
                 fresco:roundingBorderColor="@color/border_color"
                 />
                 fadeDuration 		淡入淡出的时间
                 actualImageScaleType	图片的填充方式
                 placeholderImage 	预加载图片
                 placeholderImageScaleType	预加载图片填充方式
                 failureImage		加载失败图片
                 failureImageScaleType 	失败图片填充方式
                 retryImage		重试图片
                 retryImageScaleType	重试图片填充方式
                 progressBarImage	加载进度图片
                 progressBarImageScaleType	进度图片填充方式
                 progressBarAutoRotateInterval 自动旋转间隔
                 backgroundImage	背景图片
                 overlayImage		覆盖图片
                 pressedStateOverlayImage	按下时覆盖图
                 roundAsCircle		是否为圆形图
                 roundedCornerRadius	圆角弧度
                 roundTopLeft		左上角弧度
                 roundWithOverlayColor	圆角的覆盖色
                 roundingBorderWidth	圆角的边框宽度
                 roundingBorderColor	圆角边框颜色
                 */
                /**
                 * 支持gif图片
                 *   DraweeController animatedGifController = Fresco.newDraweeControllerBuilder()
                 .setAutoPlayAnimations(true)
                 .setUri(Uri.parse("https://s3.amazonaws.com/giphygifs/media/4aBQ9oNjgEQ2k/giphy.gif"))
                 .build();
                 mAnimatedGifView.setController(animatedGifController);
                 */
                DraweeController draweeController = Fresco.newDraweeControllerBuilder()
                        //.setAutoPlayAnimations(true)
                        .setUri(Uri.parse(uri))//fresco:fadeDuration="300"
                        //"http://pic11.nipic.com/20101107/5963073_141803043683_2.gif"
                        .build();
                httpDownImageImageView3.setController(draweeController);


            }
        });
        httpDownImageBtn4 = (Button) findViewById(R.id.httpDownImageBtn4);
        httpDownImageBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**Glide
                 * Google推荐的一个开源图片加载库。
                 能够加载图片，动态的Gif图，WebP以及视频文件的预览等等。
                 使用简单。
                 使用的jar包：
                 compile 'com.github.bumptech.glide:glide:3.5.2'
                 compile 'com.android.support:support-v4:22.0.0'
                 只加载一张静态图只需要
                 Glide.with(this).load(uri).into(imageview);
                 */
                Glide.with(ActivityHttpDownImage.this).load(uri).into(httpDownImageImageView1);

            }
        });
        httpDownImageBtn5 = (Button) findViewById(R.id.httpDownImageBtn5);
        httpDownImageBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /**
                 * PhotoView
                 * 开源的显示图片的控件，能够对控件进行放大缩小的操作
                 使用简单https://github.com/bm-x/PhotoView
                 */

            }
        });
    }

    class ThisThread implements Runnable {
        @Override
        public void run() {
            //url图片的地址
            //http://site.com/image.png             //from web
            //file:///mnt/sdcard//image.png          //from SD card
            //file:///mnt/sdcard//video.mp4          //from SD card(video thumbnail)
            //content://media/external/images/media/13    //from content provider
            //content://media/external/video/media/13    //from content provider (video thumbnail)
            //assets://image.png                   //from assets
            //drawable://+R.drawable.img      //from drawables (non-9patch images)

            DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()
                    .cacheInMemory(true)//设置缓存
                    .cacheOnDisc(true)//设置sdcard缓存
                    .showImageForEmptyUri(R.mipmap.ic_launcher)
                    .showImageOnLoading(R.mipmap.aa)
                    .displayer(new FadeInBitmapDisplayer(100))//图片的淡入动画
                    .build();
            ImageLoader.getInstance().displayImage(uri, httpDownImageImageView1, displayImageOptions);
            /**
             * ImageLoader.getInstance().displayImage(url, imageview, options, imageLoadingListener);
             * imageLoadingListener加载的监听器
             * onLoadingStarted onLoadingFailed
             * onLoadingComplete onLoadingCancelled
             */
        }
    }
}
