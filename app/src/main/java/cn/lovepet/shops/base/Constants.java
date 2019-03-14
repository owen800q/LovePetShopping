package cn.lovepet.shops.base;


/**
 * 全局文件
 * author：JSYL-DCL on 2017/6/19
 */
public class Constants {
    public static final boolean IS_TEST = true;
    public static final String APK_EXIT = "cn.mixu.reverse";
    public  static String USER_LOGIN_URL = "https://wap.epet.com/login.html?fw=0&referrer=https%3A//wap.epet.com/user/sign/UserSign.html";
    public  static String UNION_JOIN = "https://wap.epet.com/union/trials_intr_main.html?version=410&fw=2&pet_type=dog";
    public  static String UNION_RANK_MORE = "https://wap.epet.com/union/trials_score_rank.html";
    public  static String ERRORCODE_2 = "810002";
    public  static int ACTIVITY_REQUEST_CODE_1 = 99;
    public  static int ACTIVITY_RESULT_CODE_1 = 990;
    public  static int ACTIVITY_REQUEST_CODE_2 = 100;
    public  static int ACTIVITY_RESULT_CODE_2 = 1000;
    public  static String APPLICATION_BUGLY_APPID = "3b241f3459";
    public  static String APPLICATION_UMENG_APPKEY = "5c89bfb5203657804c00076d";
    //联盟-一级导航页签状态
    public  static boolean UNION_TAB_DOG = false;
    public  static boolean UNION_TAB_CAT = false;
    public  static boolean UNION_ISFIRSTSETTAB = false;
    public static String VOD_URL = "http://mov.bn.netease.com/open-movie/nos/flv/2017/01/03/SC8U8K7BC_hd.flv";
    public static String POPUP_BRAND_SELECTED = "";
    public static String POPUP_AGE_SELECTED = "";
    public static String POPUP_BODY_SELECTED = "";
    //颗粒
    public static String POPUP_KELISIZE_SELECTED = "";
    //一级筛选默认
    public static String POPUP_DEFAULT_SORT = "";
    //一级详情筛选<--------------------->
        //左侧菜单选中
        public static int POPUP_LEFT_SELECTED = 100;
        //右侧菜单第一类型选中
        public static String POPUP_RIGHT_SELECTED_0 = "";
        //右侧菜单第二类型选中
        public static String POPUP_RIGHT_SELECTED_1 = "";
        public static String POPUP_RIGHT_SELECTED_2 = "";
        //右侧菜单第...类型选中
        public static String POPUP_RIGHT_SELECTED_3 = "";
        public static String POPUP_RIGHT_SELECTED_4 = "";
        public static String POPUP_RIGHT_SELECTED_5 = "";
        public static String POPUP_RIGHT_SELECTED_6 = "";

    //一级详情筛选<--------------------->

    //二级筛选当前点击的筛选按钮
    public static int POPUP_CURRENT_CLICK = 0;

    //Asset文件全称
    //商品资讯
    public static String ASSET_GOODS_NEWS = "goods_news.txt";
    //商品主览
    public static String ASSET_GOODS_JD_HOME = "homeindex.txt";
    public static String ASSET_GOODS_JD_HOME_EVENT = "homeindexevent.txt";
    public static String ASSET_GOODS_JD_RECOMMEND = "recommend.txt";
    public static String ASSET_GOODS_JD_RECOMMENDED = "recommended.txt";


    public static int HTTP_READ_TIME_OUT = 15;
    public static int HTTP_CONNECT_TIME_OUT = 15;
    public static String BASE_URL = "http://api.douban.com/v2/movie/top250/";
    public static boolean DEBUG = true;
    public static String SHARE_PREFERENCE_FILE_NAME = "lovepet";
    public static boolean LOGIN = true;

    /*Zxing*/
    public static final int DECODE = 1;
    public static final int DECODE_FAILED = 2;
    public static final int DECODE_SUCCEEDED = 3;
    public static final int LAUNCH_PRODUCT_QUERY = 4;
    public static final int QUIT = 5;
    public static final int RESTART_PREVIEW = 6;
    public static final int RETURN_SCAN_RESULT = 7;
    public static final int FLASH_OPEN = 8;
    public static final int FLASH_CLOSE = 9;
    public static final int REQUEST_IMAGE = 10;
    public static final String CODED_CONTENT = "codedContent";
    public static final String CODED_BITMAP = "codedBitmap";
    /*传递的zxingconfing*/
    public static final String INTENT_ZXING_CONFIG = "zxingConfig";
}
