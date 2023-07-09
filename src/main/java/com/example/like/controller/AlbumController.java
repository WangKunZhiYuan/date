package com.example.like.controller;
import com.example.like.config.UserService;
import com.example.like.pojo.Goods;
import com.example.like.pojo.PageResult;
import com.example.like.pojo.Result;
import com.example.like.pojo.StatusCode;
import com.example.like.service.AlbumService;
import com.github.pagehelper.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/****
 * @Author:admin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@Api(value = "用户管理", description = "", tags = {"用户管理"})
@RestController
@RequestMapping("/album")
@CrossOrigin
public class AlbumController {

    @Autowired
    private AlbumService albumService;

//    @Autowired
//    private RedisTemplate redisTemplate;

//    /***
//     * Album分页条件搜索实现
//     * @param album
//     * @param page
//     * @param size
//     * @return
//     */
//    @PostMapping(value = "/search/{page}/{size}" )
//    public Result<PageInfo> findPage(@RequestBody(required = false)  Goods album, @PathVariable int page, @PathVariable int size){
//        //调用AlbumService实现分页条件查询Album
//        Page<Goods> pageInfo = albumService.findPage(album, page, size);
//        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
//    }

    /***
     * Album分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
//    @GetMapping(value = "/search/{page}/{size}" )
//    public Result<PageInfo> findPage(@PathVariable int page, @PathVariable int size){
//        //调用AlbumService实现分页查询Album
//        PageInfo<Goods> pageInfo = albumService.findPage(page, size);
//        //PageHelper.startPage(pageNum,pageSize);
//        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
//    }

    @ApiOperation(value = "desc of method", notes = "ddddd")
    @GetMapping(value = "/search/{page}/{size}" )
    public Result findPage(@RequestBody(required = false) Goods album, @PathVariable  int page, @PathVariable  int size){
        Page<Goods> pageList = albumService.findPage(album, page, size);
        PageResult pageResult=new PageResult(pageList.getTotal(),pageList.getResult());

//        try {
//            String key="test";
//            Boolean isHas = redisTemplate.hasKey(key);
//            if (isHas){
//                Object test = redisTemplate.opsForValue().get(key);
//                System.out.println(test);
//            }else {
//                System.out.println("抱歉！不存在key值为"+key);
//            }
//        } catch (Exception e){
//            System.out.println(e.toString());
//        }

        UserService userService = new UserService();
        String res = userService.saveUser();



        return new Result(true, StatusCode.OK,"查询成功"+res,pageResult);
    }

    /***
     * 多条件搜索品牌数据
     * @param album
     * @return
     */
    @GetMapping(value = "/search" )
    public Result findList(@RequestBody(required = false)  Goods album){
        //调用AlbumService实现条件查询Album
        Page<Goods> list = albumService.findList(album);
//        try {
//            redisTemplate.opsForValue().set("test","This is a Springboot-Redis test!");
//        } catch (Exception e){
//            System.out.println(e.toString());
//        }

        UserService userService = new UserService();
        String res = userService.getUser();


        return new Result(true,StatusCode.OK,"查询成功"+res ,list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用AlbumService实现根据主键删除
        albumService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /*** allow-circular-references: true
     * 修改Album数据
     */

    @PutMapping(value="/{id}")
    public Result update(@RequestBody Goods goods, @PathVariable int id){
        //设置主键值
        goods.setId(id);
        //调用AlbumService实现修改Album
        albumService.update(goods);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增Album数据

     */
    @PostMapping
    public Result add(@RequestBody Goods goods){
        //调用AlbumService实现添加Album
        albumService.add(goods);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询Album数据
     * @param id
     * @return
     */
    @ApiOperation(value = "desc of method", notes = "ddddd")
    @GetMapping("/{id}")
    public Result<Goods> findById(@PathVariable Long id){
        //调用AlbumService实现根据主键查询Album
        Goods album = albumService.findById(id);
        return new Result<Goods>(true,StatusCode.OK,"查询成功",album);
    }

    /***
     * 查询Album全部数据
     * @return
     */
    @ApiOperation(value = "desc of method", notes = "ddddd")
    @GetMapping
    public Result<List<Goods>> findAll(){
        //调用AlbumService实现查询所有Album
        List<Goods> list = albumService.findAll();
        return new Result<List<Goods>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
