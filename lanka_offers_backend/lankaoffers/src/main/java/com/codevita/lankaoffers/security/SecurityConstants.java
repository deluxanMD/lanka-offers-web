 package com.codevita.lankaoffers.security;

public class SecurityConstants {
	
	public static final String SECRET = "LankaOffersSecret35$";
    public static final long EXPIRATION_TIME = 864_000_000 * 30 * 12 * 100; // 100 years
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String PUBLIC_SIGN_UP_URL = "/publicGuest/sign-up";
    public static final String COMPANY_SIGN_UP_URL = "/company/sign-up";

}
