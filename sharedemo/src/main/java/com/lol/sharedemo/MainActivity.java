package com.lol.sharedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ShareSDK.initSDK(this, "17c2127e3e596");
    }

    public void onClick(View view) {
        showShare();
    }

    private void showShare() {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
//关闭sso授权
        oks.disableSSOWhenAuthorize();

// title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间等使用
        oks.setTitle("LOL总决赛八强抽签结果：EDG碰虎牙 RNG硬刚SKT！");
// titleUrl是标题的网络链接，QQ和QQ空间等使用
        oks.setTitleUrl("http://news.pconline.com.cn/844/8442347.html");
// text是分享文本，所有平台都需要这个字段
        oks.setText("随着今天上午B组小组赛的结束，S6总决赛八强也随之出炉。");
// imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
//oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
// url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
// comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
// site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
// siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");
        oks.setImageUrl("http://img0.pconline.com.cn/pconline/1610/10/8442347_33_thumb.jpg");

// 启动分享GUI
        oks.show(this);
    }
}
