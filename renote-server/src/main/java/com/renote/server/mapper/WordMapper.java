package com.renote.server.mapper;

import com.renote.core.model.Word;

/**
 * @author joder
 * @create 19-5-25
 **/
public interface WordMapper {

    /**
     * 保存
     * @param word
     * @return
     */
    int save(Word word);

    /**
     * 更新
     * @param word
     * @return
     */
    int update(Word word);

    /**
     * 删除
     * @param name
     * @return
     */
    int delete(String name);

    /**
     * get
     * @param name
     * @return
     */
    Word get(String name);
}
