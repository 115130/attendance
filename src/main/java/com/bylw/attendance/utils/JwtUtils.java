package com.bylw.attendance.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class JwtUtils {
    //过期时间
    public static final long EXPIRE= 1000*60*60*24;
    //加密密钥
    public static final String APP_SECRET="GYd1as2FSdsYUgY43UIGg43yDSAgDSAuDSyUdsY65dU564Gd3YU3GYUG0Y3U";

    public static String getJwtToken(String id,String nickname){
        return Jwts.builder()
                //头信息
                .setHeaderParam("typ","JWT")
                .setHeaderParam("alg","HS256")
                //过期时间
                .setSubject("user")
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime()+EXPIRE))
                //主体
                .claim("id",id)
                .claim("nickname",nickname)
                //防伪
                .signWith(SignatureAlgorithm.HS256,APP_SECRET)
                .compact();
    }

    /**
     * 判断是否有效
     * @param jwtToken
     * @return
     */
    public static boolean checkToken(String jwtToken){
        if (StringUtils.isEmpty(jwtToken)) {
            return false;
        }
        try {
            //有效则不会有异常
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 判断是否有效
     * @param request
     * @return
     */
    public static boolean checkToken(HttpServletRequest request){
        try {
            String token = request.getHeader("token");
            if (StringUtils.isEmpty(token)){
                return false;
            }
            Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(token);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 根据token字符串获取会员id
     * @param request
     * @return
     */
    public static String getMemberIdByJwtToken(HttpServletRequest request){
        String jwtToken = request.getHeader("token");
        if (StringUtils.isEmpty(jwtToken)){
            return "";
        }
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(APP_SECRET).parseClaimsJws(jwtToken);
        Claims body = claimsJws.getBody();
        return (String) body.get("id");
    }

}
