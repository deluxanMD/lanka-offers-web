package com.codevita.lankaoffers.util;

public class AppConstants {
	
	public static final String BASE_URL = "/api/v1";

	public static final String ACTIVITYlOG_URL = "/activityLogs";
	public static final String ACTIVITYlOG_BY_ID_URL = "/activityLogs/{id}";
	
	public static final String ADMINS_URL = "/admins";
	public static final String ADMINS_BY_ID_URL = "/admins/{id}";
	
	public static final String BLOCKED_COMPANY_URL = "/blockedCompanies";
	public static final String BLOCKED_COMPANY_BY_ID_URL = "/blockedCompanies/{id}";
	
//	public static final String CATEGORY_URL = "/categories";
//	public static final String CATEGORY_BY_ID_URL = "/categories/{id}";
	
	public static final String CATEGORY_PREFERENCE_URL = "/categoryPreferences";
	public static final String CATEGORY_PREFERENCE_BY_ID_URL = "/categoryPreferences/{id}";
	
	public static final String COINS_PACKAGE_URL = "/coinsPackages";
	public static final String COINS_PACKAGE_BY_ID_URL = "/coinsPackages/{id}";
	
	public static final String COINS_PURCHASE_URL = "/coinsPurchases";
	public static final String COINS_PURCHASE_BY_ID_URL = "/coinsPurchases/{id}";
	
	public static final String COMPANY_CARD_INFO_URL = "/CompanyCardInfos";
	public static final String COMPANY_CARD_INFO_BY_ID_URL = "/CompanyCardInfos/{id}";
	
	public static final String COMPANY_SIGN_UP = "/companySignUp";
	public static final String COMPANY_URL = "/companies";
	public static final String COMPANY_BY_ID_URL = "/companies/{id}";
	public static final String UPLOAD_COMPANY_LOGO = "/uploadCompanyImage";
	public static final String COMPANY_CREATED_DATEWISE ="/getLatestCompanies";
	
	public static final String COMPANY_PREFERENCE_URL = "/companyPreferences";
	public static final String COMPANY_PREFERENCE_BY_ID_URL = "/companyPreferences/{id}";
	
	public static final String COMPANY_RATING_URL = "/companyRatings";
	public static final String COMPANY_RATING_BY_ID_URL = "/companyRatings/{id}";
	
	public static final String UPLOAD_IMAGE = "/uploadImage";
	public static final String UPLOAD_MULTYPLE_IMAGES = "/uploadMultipleImages";
	public static final String DOWNLOAD_IMAGE = "/downloadImage/{picName:.+}";
	
	public static final String LOCATION_URL = "/locations";
	public static final String LOCATION_BY_ID_URL = "/locations/{id}";
	
	public static final String LOGIN_HISTORY_URL = "/loginHistories";
	public static final String LOGIN_HISTORY_BY_ID_URL = "/loginHistories/{id}";
	
	public static final String POST_CATEGORY_URL = "/postCategories";
	public static final String POST_CATEGORY_BY_ID_URL = "/postCategories/{id}";

	public static final String POST_COMMENT_URL = "/postComments";
	public static final String POST_COMMENT_BY_ID_URL = "/postComments/{id}";
	
	public static final String POST_URL = "/posts";
	public static final String POST_BY_ID_URL = "/posts/{id}";
	public static final String UPLOAD_POST_IMAGE = "/uploadPostImage";
	public static final String UPLOAD_POST_MULTYPLE_IMAGES = "/uploadPostMultipleImages";
	public static final String POST_BY_CREATE_DATE ="/getLatestPosts";
	public static final String POST_COUNT_BY_POST_CATARGORIES ="/getPostCountByCatagories";
	public static final String POST_BY_POST_CATARGORIES ="/getPostByCatagories/{postcategory_id}";
	public static final String POST_COUNT_BY_COMPANIES ="/getPostCountByCompanies";
	public static final String POST_BY_COMPANIES ="/getPostByCompanies/{company_id}";
	public static final String DEALS_OF_THE_DAY ="/getDealsOfTheDay";
	public static final String POPULAR_POST ="/getPopularPost";
	
	public static final String POST_LIKE_URL = "/postLikes";
	public static final String POST_LIKE_BY_ID_URL = "/postLikes/{id}";
	
	public static final String POST_RATING_URL = "/postRatings";
	public static final String POST_RATING_BY_ID_URL = "/postRatings/{id}";
	
	public static final String POST_REPORT_URL = "/postReports";
	public static final String POST_REPORT_BY_ID_URL = "/postReports/{id}";
	
	public static final String POST_SHARE_URL = "/postShares";
	public static final String POST_SHARE_BY_ID_URL = "/postShares/{id}";
	
	public static final String POST_TAG_URL = "/postTags";
	public static final String POST_TAG_BY_ID_URL = "/postTags/{id}";
	
	public static final String POST_VIEW_URL = "/postViews";
	public static final String POST_VIEW_BY_ID_URL = "/postViews/{id}";
	
	public static final String POST_WISH_URL = "/postWish";
	public static final String POST_WISH_BY_ID_URL = "/postWish/{id}";

	public static final String PUBLIC_GUESTS_SIGN_UP = "/publicGuestsSignUp";
	public static final String PUBLIC_GUEST_URL = "/publicGuests";
	public static final String PUBLIC_GUEST_BY_ID_URL = "/publicGuests/{id}";

	public static final String SETTING_URL = "/settings";
	public static final String SETTING_BY_ID_URL = "/settings/{id}";

	public static final String USERS_SIGN_IN = "/authenticate";
	public static final String USER_URL = "/users";
	public static final String USER_BY_ID_URL = "/users/{id}";
	
	//Other Constants
	public static final String UPLOAD_PATH = "/lankaoffers/src/main/resources/Images";


	// Message Constants HARI TOVI
	public static final String MSG_EMPTY = "cannot be empty";
	public static final String MSG_SUCCESS = "SUCCESS";
	public static final String MSG_FAILED = "FAILED";
	public static final String MSG_NO_AUTH = "You have no authority";
	public static final String MSG_INVALID_TOKEN = "INVALID TOKEN";
	public static final String MSG_NOT_NUMBER = "Not number";
	public static final String MSG_NOT_AVAILABLE = "Not available";
	public static final String MSG_SOMETHING_WENT_WRONG = "Sorry, something went wrong";
	public static final String MSG_NOT_FOUND = "Object not found";

	public static final String LOGGER_MSG_SERVICE_STARTED = "Service Started";
	public static final String LOGGER_MSG_OPERATION_SUCCESSFUL = "Operation Successful";
	public static final String LOGGER_MSG_OPERATION_FAILED = "Operation Failed";
	public static final String LOGGER_MSG_OPERATION_DATA_NOT_FOUND = "Operation Failed: Data not found.";
	
	// Country Codes
	public static final String COUNTRY_SL = "SL";

	// HTTP Status
	public static final String HTTP_RESULT_SUCCESS = "SUCCESS";
	public static final String HTTP_RESULT_FAILED = "FAILED";


	

	
	

}
