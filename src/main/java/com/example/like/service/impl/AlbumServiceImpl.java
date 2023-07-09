package com.example.like.service.impl;


import com.example.like.dao.AlbumMapper;
import com.example.like.pojo.Goods;
import com.example.like.service.AlbumService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/****
 * @Author:admin
 * @Description:Album业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumMapper albumMapper;

    public AlbumServiceImpl(AlbumMapper albumMapper) {
        this.albumMapper = albumMapper;
    }

    /**
     * 查询全部列表
     * @return
     */
    @Override
    public Page<Goods> findAll() {
        return albumMapper.findAll();
    }


    /**
     * 增加
     * @param album
     */
    @Override
    public void add(Goods album){
        albumMapper.add(album);
    }

    @Override
    public Goods findById(Long id) {
        return  albumMapper.findById(id);
    }

    /**
     * 修改
     * @param album
     */
    @Override
    public void update(Goods album){
        albumMapper.update(album);
    }



    /**
     * 条件查询
     * @param album
     * @return
     */
    @Override
    public Page<Goods> findList(Goods album){
        return albumMapper.findList(album);
    }

    @Override
    public void delete(Long id) {
        albumMapper.delete(id);
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public Page<Goods> findPage(int page, int size){
        PageHelper.startPage(page,size);
        return (Page<Goods>) albumMapper.findAll();
    }

    /**
     * 条件+分页查询
     * @param album 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public Page<Goods> findPage(Goods album, int page, int size){
        PageHelper.startPage(page,size);
        return (Page<Goods>) albumMapper.findList(album);
    }

}
