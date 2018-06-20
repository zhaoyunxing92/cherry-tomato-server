package com.sunny.boot.cherrytomato.common.context;

import com.sunny.boot.cherrytomato.common.model.BaseModel;
import com.sunny.boot.cherrytomato.user.model.vo.AppUserVo;

/**
 * @author sunny
 * @class: com.sunny.boot.cherrytomato.common.context.AppUserContext
 * @date: 2018-06-08 16:12
 * @des:
 */
public class AppUserContext extends BaseModel<Long> {
    private static final long serialVersionUID = -3040901576313484640L;
    private static AppUserVo appUser;

    public static void setAppUser(AppUserVo user) {
        appUser = user;
    }

    public static String UserName() {
        return appUser.getUsername();
    }

    public static Long UserId() {
        return appUser.getId();
    }

}
