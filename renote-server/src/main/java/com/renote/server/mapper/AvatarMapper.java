package com.renote.server.mapper;

import com.renote.core.model.Avatar;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author joder
 * @create 19-5-25
 **/
public interface AvatarMapper {

    /**
     * 保存
     *
     * @param avatar
     * @return
     */
    int save(Avatar avatar);

    /**
     * 获得用户头像
     *
     * @param userId
     * @return
     */
    Avatar getAvatar(@Param("userId") Long userId);

    /**
     * 获得用户历史头像
     *
     * @param userId
     * @return
     */
    List<Avatar> getHistoryAvatars(@Param("userId") Long userId);

    /**
     * 更新时间
     *
     * @param avatar
     * @return
     */
    int updateTime(Avatar avatar);
}
