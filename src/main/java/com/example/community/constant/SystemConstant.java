package com.example.community.constant;

public class SystemConstant {

      /**
       *token
       */
      public static final int JWT_ERRCODE_NULL = 4000; //Token不存在
      public static final int JWT_ERRCODE_EXPIRE = 4001; //Token过期
      public static final int JWT_ERRCODE_FAIL = 4002; //验证不通过
      /**
       * JWT
       */
      public static final String JWT_SECERT = "8677df7fc3a34e26a61c034d5ec8245d"; //密匙
//      30 * 60 * 1000; //token有效时间为半小时
      public static final long JWT_TTL = 30 * 60 * 1000; //token有效时间为半小时
      public static final long JWT_WE_CHAT = 2626560000L; //token有效时间为一个月

      public static final byte[] PUBLIC_KEY = {48, 89, 48, 19, 6, 7, 42, -122, 72, -50, 61, 2, 1, 6, 8, 42, -122, 72, -50, 61, 3, 1, 7, 3, 66, 0, 4, -29, -109, 30, -25, 122, 61, -47, -84, 95, 53, -69, 39, 89, 5, -29, 84, -110, 65, -7, -98, -11, 48, 83, 48, 44, 56, -31, 125, -90, 92, 81, 112, 105, 70, 7, -23, 33, -40, 64, -36, -60, 6, 109, 125, 56, -118, -64, 18, 60, 86, 100, -53, 9, 72, -123, -51, -18, 94, 75, 30, -39, 106, 39, -31}; //公钥
      public static final byte[] PRIVATE_KEY = {48, 65, 2, 1, 0, 48, 19, 6, 7, 42, -122, 72, -50, 61, 2, 1, 6, 8, 42, -122, 72, -50, 61, 3, 1, 7, 4, 39, 48, 37, 2, 1, 1, 4, 32, -54, 69, 92, -108, -80, 114, -91, 30, 63, -9, -25, -20, -101, -32, -112, 58, 82, -71, -29, -74, -2, 109, -60, -69, 78, 84, 6, -12, 1, 108, -8, -54};//私钥
  }