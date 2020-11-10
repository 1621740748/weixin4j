package com.jrj.weixin;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import org.weixin4j.Configuration;
import org.weixin4j.Weixin;
import org.weixin4j.WeixinException;
import org.weixin4j.component.MediaComponent;
import org.weixin4j.component.MessageComponent;
import org.weixin4j.model.message.Articles;

public class MessageTest {

	public static void main(String[] args) throws WeixinException {
        System.setProperty("weixin4j.debug", "false");
        //打印调试开关，如果打开调试开关，则会向控制台打印方法调用执行日志
        System.out.println(Configuration.isDebug());
        //1.初始化weixin对象
        Weixin weixin = new Weixin();
        //2.打印开发者appid
        System.out.println(weixin.getAppId());
        MediaComponent media=new MediaComponent(weixin);
        String picUrl1=MessageTest.class.getResource("Flying_Whale_by_Shu_Le.jpg").getPath();
        System.out.println(picUrl1);
        String picUrl=media.uploadimg(new File(picUrl1));
        System.out.println(picUrl);
	    Articles ar=new Articles();
	    ar.setTitle("拜登团队敦促联邦批准权力交接 今日黄金回升至1870上方");
	    ar.setDescription("路透社11月9日消息，拜登竞选团队周日敦促特朗普政府任命的美国总务署(GSA)负责人批准正式的权力交接。拜登竞选团队警告说，美国的国家安全和经济利益取决于一个明确的信号，即国家将启动“平稳、和平的权力交接”。周二(11月10日)亚市早盘，现货黄金展开反弹，金价现报1872美元/盎司附近，日内涨幅0.5%。");
	    ar.setPicUrl(picUrl);
	    ar.setPicurl(picUrl);
	    ar.setUrl("http://gold.cnfol.com/jinshizhibo/20201110/28513786.shtml");
	    
	    MessageComponent message=new MessageComponent(weixin);
	    List<Articles> articles=new LinkedList<>();
	    articles.add(ar);
	    String openid="o-tpEszP1LcqAKkdcqKm0Y31YN4s";
	    message.customSendNews(openid, articles);
	}

}
