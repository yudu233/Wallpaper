package com.rain.api;

/**
 * @Author: Rain
 * @Org: www.yudu233.com
 * @Email: yudu233@gmail.com
 * @ClassName: UrlCollection
 * @CreateDate: 2020/9/12 13:58
 * @Describe: api相关
 */
public class UrlCollection {

    /* ----------------------------- BASE URL ----------------------------- */

    public static final String UNSPLASH_NAPI_BASE_URL = "https://unsplash.com/napi/";

    public static final String UNSPLASH_API_BASE_URL = "https://api.unsplash.com/";

    public static final String UNSPLASH_IMAGE_REAL_URL = "https://images.unsplash.com/";

    public static final String UNSPLASH_IMAGE_REQUEST_URL = "http://unsplash.nesnode.com/";

    public static final String UNSPLASH_ACCESS_KEY = "Wv5MGYt-bU22ODCtpcKLG681ef9aCVsNpYmTjiOG4Fk";

    public static final String UNSPLASH_SECRET_KEY = "Eie2l1XqSiODrnKM0bYh0-dNmEHeNGvtLMROhOWfU8M";


    /* ----------------------------- DETAILS API ----------------------------- */

    public static final String CATEGORIES = "categories";

    public static final String TOPICS = "topics";



    //get recommend photos
    public static final String RECOMMEND_PHOTOS = "photos";

    //get photo from categories
    public static final String GET_PHOTO_BY_CATEGORIES = TOPICS + "%1$s";

    public static final String CATEGORIES_FASHION = "fashion";

}
