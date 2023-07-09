package com.example.like.service;

import com.example.like.pojo.Goods;
import com.github.pagehelper.Page;
public interface AlbumService {

    /***
     * Album多条件分页查询
     */
    Page<Goods> findPage(Goods goods, int page, int size);

    /***
     * Album分页查询
     */
    Page<Goods> findPage(int page, int size);

    /***
     * Album多条件搜索方法
     */
    Page<Goods> findList(Goods goods);

    /***
     * 删除Album
     * @param id
     */
    void delete(Long id);

    /***
     * 修改Album数据
     * @param album
     */
    void update(Goods album);

    /***
     * 新增Album
     * @param album
     */
    void add(Goods album);

    /**
     * 根据ID查询Album
     * @param id
     * @return
     */
    Goods findById(Long id);

    /***
     * 查询所有Album
     * @return
     */
    Page<Goods> findAll();
}
