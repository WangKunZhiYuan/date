package com.example.like.dao;
import com.example.like.pojo.Goods;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;


/**
 * @author Robod
 * @date 2020/7/7 8:59
 */
@Repository("albumMapper")
public interface AlbumMapper {

    /**
     * 查询全部列表
     *
     * @return
     */
    @Select("select * from goods")
    public Page<Goods> findAll();

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    @Select("select * from goods where id = #{id} limit 1")
    public Goods findById(long id);

    /**
     * 增加
     *
     * @param album
     */
    @Insert("INSERT INTO goods" +
            " VALUES " +
            "(#{Goods.id},#{album.title},#{album.image},#{goods.imageItems})")
    public void add(@Param("album") Goods album);

    /**
     * 修改
     *
     * @param album
     */
    @Update("UPDATE goods" +
            " SET " +
            "id=#{album.id},title=#{album.title},image=#{album.image},image_items=#{album.imageItems}" +
            " WHERE id=#{album.id}")
    public void update(@Param("album") Goods album);

    /***
     * 删除
     * @param id
     */
    @Delete("DELETE FROM goods WHERE id=#{id}")
    public void delete(long id);

    /***
     * 多条件搜索
     * @param album
     * @return
     */
    @SelectProvider(type = AlbumProvider.class, method = "findList")
    Page<Goods> findList(Goods album);

    class AlbumProvider {
        public String findList(Goods album) {
            StringBuilder builder = new StringBuilder("select * from goods where 0=0");
            if (album != null) {
                if (!StringUtils.isEmpty(album.getname())) {
                    builder.append(" and title like ").append("\"%").append(album.getname()).append("%\" ");
                }

                if (!StringUtils.isEmpty(album.getPrice())) {
                    builder.append(" and image like ").append("\"%").append(album.getPrice()).append("%\" ");
                }
                if (!StringUtils.isEmpty(album.getcolor())) {
                    builder.append(" and image_items like ").append("\"%").append(album.getcolor()).append("%\" ");
                }
            }

            System.out.println(builder.toString());
            return builder.toString();
        }
    }
}