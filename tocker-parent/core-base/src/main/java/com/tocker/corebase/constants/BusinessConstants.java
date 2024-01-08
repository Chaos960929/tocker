package com.tocker.corebase.constants;

/**
 * @version 1.0
 * @description 业务常量配置
 * @package com.itheima.common.constants
 */
public interface BusinessConstants {

    interface ApUserConstants{
        /** 认证状态：已认证 */
        int AUTHENTICATED=1;
        /** 认证状态：未认证 */
        int UNAUTHENTICATED=0;
        /** 用户类型：普通用户 */
        int FLAG_PERSONAL=0;
        /** 用户类型：自媒体用户 */
        int FLAG_WEMEDIA=1;
        /** 用户类型：大V 粉丝数>=50万的自媒体用户 */
        int FLAG_V=2;
    }
    /** 实名认证审核状态 */
    interface ApUserRealnameConstants {
        /** 创建中 */
        int AUTH_CREATING = 0;
        /** 待审核 */
        int AUTH_WAITING = 1;
        /** 审核失败 */
        int AUTH_REJECT = 2;
        /** 审核通过 */
        int AUTH_PASS = 9;
    }

    /** 自媒体账号状态 */
    interface WmUserConstants {
        /** 有效 */
        int STATUS_OK = 9;
        /** 冻结 */
        int STATUS_LOCKED = 0;
        /** 永久失效 */
        int STATUS_INVALID = 1;
        /** 自媒体账号为 个人类型 */
        int TYPE_PERSONAL = 0;
    }

    /** 文章作者类型 */
    interface ApAuthorConstants {
        /** 平台自媒体人 */
        int A_MEDIA_USER = 2;
        /** 合作商 */
        int A_MEDIA_SELLER = 1;
        /** 普通作者 */
        int A_MEDIA_ZERO = 0;
    }

    /** 自媒体文章相关常量 */
    interface WmNewsConstants {
        /** 文章封面布局为自动 */
        int TYPE_AUTO = -1;
        /** 文章封面布局为无图 */
        int TYPE_NONE_IMG = 0;
        /** 文章封面布局为单图 */
        int TYPE_SINGLE_IMG = 1;
        /** 文章封面布局为自动 */
        int TYPE_MULTIPLE_IMG = 3;
        /** 文章内容数据为图片类型 */
        String CONTENT_IMAGE="image";
        /** 内容图片素材 */
        int WM_CONTENT_REFERENCE = 0;
        /** 封面图片素材 */
        int WM_COVER_REFERENCE = 1;
        /** 文章已发布状态 */
        int STATUS_PUBLISHED=9;
        /** 文章状态 草稿 */
        int STATUS_DRAFT=0;
        /** 文章状态 待审核 */
        int STATUS_SUBMIT=1;
        /** 审核失败 */
        int STATUS_FAIL=2;
        /** 需要人工审核 */
        int STATUS_MANUAL=3;
        /** 人工审核通过 */
        int STATUS_MANUAL_PASS=4;
        /** 审核通过（待发布）*/
        int STATUS_PASS=8;
        /** 文章已上架 */
        int ENABLE_ON=1;
        /** 文章已下架 */
        int ENABLE_OFF=0;
    }

    /** MQ相关常量 */
    interface MqConstants{
        /** 文章自动审核主的topic */
        String WM_NEWS_AUTO_SCAN_TOPIC = "wm.news.auto.scan.topic";
        /** 上下架主题 */
        String WM_NEWS_DOWN_OR_UP_TOPIC = "wm.news.up.or.down.topic";
        /** 用户行为 */
        String FOLLOW_BEHAVIOR_TOPIC="follow.behavior.topic";
        /** 用户行为 kafka stream 输入 topic */
        String  HOT_ARTICLE_SCORE_TOPIC="article_behavior_input";
        /** 用户行为 kafka stream 消费者 topic */
        String HOT_ARTICLE_INCR_HANDLE_TOPIC="article_behavior_out";
    }
    /** 文章审核的3个结果 */
    interface ScanConstants{
        /** 通过 */
        String PASS = "pass";
        /** 人工复查 */
        String REVIEW = "review";
        /** 不能通过，阻止 */
        String BLOCK = "block";
    }
    interface ArticleConstants{
        /** 普通文章 */
        int FLAG_NORMAL = 0;
        /** 文章来源：自媒体 */
        int ORIGIN_WEMEDIA=1;
        /** 加载下一页 */
        int LOAD_MORE = 1;
        /** 加载第一页 */
        int LOAD_NEW = 2;
        /** 默认频道 */
        String DEFAULT_TAG = "__all__";

        int HOT_ARTICLE_LIKE_WEIGHT = 3;//点赞分数权重
        int HOT_ARTICLE_COMMENT_WEIGHT = 5;//评论分数权重
        int HOT_ARTICLE_COLLECTION_WEIGHT = 8;//收藏分数权重
        /** 每个频道热点文章在redis中的key前缀 */
        String HOT_ARTICLE_FIRST_PAGE = "hot_article_first_page_";
    }

}
