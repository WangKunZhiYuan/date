package com.example.like.pojo;
import javax.persistence.*;
import java.io.Serializable;

/****
 * @Author:admin
 * @Description:Album构建
 * @Date 2019/6/14 19:13
 *****/
@Table(name="goods")
public class Goods implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;//编号

	@Column(name = "name")
	private String name;//相册名称

	@Column(name = "price")
	private  double price ;//相册封面

	@Column(name = "color")
	private String color;//图片列表


	//无参和有参构造方法
	public Goods() {
	}
	public Goods(int id, String name, double price, String color) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.color = color;
	}

	//get和set
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name  = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getcolor() {
		return color;
	}
	public void setcolor(String color) {
		this.color= color;
	}

	//toString()方法
	@Override
	public String toString() {
		return "Goods{" +
				"id=" + id +
				", goodsName='" + name + '\'' +
				", price=" + price +
				", desc='" + color + '\'' +
				'}';
	}
}

