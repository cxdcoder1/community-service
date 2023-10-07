package com.example.community.utils;


import com.alibaba.fastjson.JSON;
import com.example.community.constant.SystemConstant;
import com.example.community.entity.SysUser;
import com.example.community.entity.CheckResult;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import io.jsonwebtoken.*;
import org.apache.maven.surefire.shade.org.apache.commons.lang3.StringUtils;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

public class JwtUtil {
      /**
       * 签发JWT
       * @param id
       * @param subject 可以是JSON数据 尽可能少
       * @param ttlMillis
       * @return
       */
      public static String createJWT(String id, String subject, long ttlMillis) {
          SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
          long nowMillis = System.currentTimeMillis();
          Date now = new Date(nowMillis);
          SecretKey secretKey = generalKey();
          JwtBuilder builder = Jwts.builder()
                  .setId(id)
                  .setSubject(subject)   // 主题
                  .setIssuer("Java1234")     // 签发者
                  .setIssuedAt(now)      // 签发时间
                  .signWith(signatureAlgorithm, secretKey); // 签名算法以及密匙
          if (ttlMillis >= 0) {
              long expMillis = nowMillis + ttlMillis;
              Date expDate = new Date(expMillis);
              builder.setExpiration(expDate); // 过期时间
          }
          return builder.compact();
      }
 
      /**
       * 验证JWT
       * @param jwtStr
       * @return
       */
      public static CheckResult validateJWT(String jwtStr) {
          CheckResult checkResult = new CheckResult();
          Claims claims = null;
          try {
              claims = parseJWT(jwtStr);
              checkResult.setSuccess(true);
              checkResult.setClaims(claims);
          } catch (ExpiredJwtException e) {
              checkResult.setErrCode(SystemConstant.JWT_ERRCODE_EXPIRE);
              checkResult.setSuccess(false);
          } catch (SignatureException e) {
              checkResult.setErrCode(SystemConstant.JWT_ERRCODE_FAIL);
              checkResult.setSuccess(false);
          } catch (Exception e) {
              checkResult.setErrCode(SystemConstant.JWT_ERRCODE_FAIL);
              checkResult.setSuccess(false);
          }
          return checkResult;
      }

      /**
       * 生成加密Key
       * @return
       */
      public static SecretKey generalKey() {
          byte[] encodedKey = Base64.decode(SystemConstant.JWT_SECERT);
          SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
          return key;
      }

      /**
       * 解析JWT字符串
       * @param jwt
       * @return
       * @throws Exception
       */
      public static Claims parseJWT(String jwt) throws Exception {
          SecretKey secretKey = generalKey();
          return Jwts.parser()
                  .setSigningKey(secretKey)
                  .parseClaimsJws(jwt)
                  .getBody();
      }
//    //根据token字符串得到用户名称
//    public static String getUserName(String token) {
//        if(StringUtils.isEmpty(token)) {
//            return "";
//        }
//        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(token).parseClaimsJws(token);
//        Claims claims = claimsJws.getBody();
//        return (String)claims.get("userName");
//    }


 }