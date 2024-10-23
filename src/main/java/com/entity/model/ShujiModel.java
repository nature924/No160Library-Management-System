package com.entity.model;

import com.entity.ShujiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 书籍
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShujiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 书籍编号
     */
    private String shujiUuidNumber;


    /**
     * 书籍名称
     */
    private String shujiName;


    /**
     * 书籍作者
     */
    private String shujiZuozhe;


    /**
     * 出版社
     */
    private String shujiChubanshe;


    /**
     * 书籍照片
     */
    private String shujiPhoto;


    /**
     * 书籍类型
     */
    private Integer shujiTypes;


    /**
     * 所在书架
     */
    private Integer shujiaTypes;


    /**
     * 详细地址
     */
    private String shujiaAddress;


    /**
     * 书籍库存
     */
    private Integer shujiKucunNumber;


    /**
     * 热度
     */
    private Integer shujiClicknum;


    /**
     * 书籍介绍
     */
    private String shujiContent;


    /**
     * 逻辑删除
     */
    private Integer shujiDelete;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：书籍编号
	 */
    public String getShujiUuidNumber() {
        return shujiUuidNumber;
    }


    /**
	 * 设置：书籍编号
	 */
    public void setShujiUuidNumber(String shujiUuidNumber) {
        this.shujiUuidNumber = shujiUuidNumber;
    }
    /**
	 * 获取：书籍名称
	 */
    public String getShujiName() {
        return shujiName;
    }


    /**
	 * 设置：书籍名称
	 */
    public void setShujiName(String shujiName) {
        this.shujiName = shujiName;
    }
    /**
	 * 获取：书籍作者
	 */
    public String getShujiZuozhe() {
        return shujiZuozhe;
    }


    /**
	 * 设置：书籍作者
	 */
    public void setShujiZuozhe(String shujiZuozhe) {
        this.shujiZuozhe = shujiZuozhe;
    }
    /**
	 * 获取：出版社
	 */
    public String getShujiChubanshe() {
        return shujiChubanshe;
    }


    /**
	 * 设置：出版社
	 */
    public void setShujiChubanshe(String shujiChubanshe) {
        this.shujiChubanshe = shujiChubanshe;
    }
    /**
	 * 获取：书籍照片
	 */
    public String getShujiPhoto() {
        return shujiPhoto;
    }


    /**
	 * 设置：书籍照片
	 */
    public void setShujiPhoto(String shujiPhoto) {
        this.shujiPhoto = shujiPhoto;
    }
    /**
	 * 获取：书籍类型
	 */
    public Integer getShujiTypes() {
        return shujiTypes;
    }


    /**
	 * 设置：书籍类型
	 */
    public void setShujiTypes(Integer shujiTypes) {
        this.shujiTypes = shujiTypes;
    }
    /**
	 * 获取：所在书架
	 */
    public Integer getShujiaTypes() {
        return shujiaTypes;
    }


    /**
	 * 设置：所在书架
	 */
    public void setShujiaTypes(Integer shujiaTypes) {
        this.shujiaTypes = shujiaTypes;
    }
    /**
	 * 获取：详细地址
	 */
    public String getShujiaAddress() {
        return shujiaAddress;
    }


    /**
	 * 设置：详细地址
	 */
    public void setShujiaAddress(String shujiaAddress) {
        this.shujiaAddress = shujiaAddress;
    }
    /**
	 * 获取：书籍库存
	 */
    public Integer getShujiKucunNumber() {
        return shujiKucunNumber;
    }


    /**
	 * 设置：书籍库存
	 */
    public void setShujiKucunNumber(Integer shujiKucunNumber) {
        this.shujiKucunNumber = shujiKucunNumber;
    }
    /**
	 * 获取：热度
	 */
    public Integer getShujiClicknum() {
        return shujiClicknum;
    }


    /**
	 * 设置：热度
	 */
    public void setShujiClicknum(Integer shujiClicknum) {
        this.shujiClicknum = shujiClicknum;
    }
    /**
	 * 获取：书籍介绍
	 */
    public String getShujiContent() {
        return shujiContent;
    }


    /**
	 * 设置：书籍介绍
	 */
    public void setShujiContent(String shujiContent) {
        this.shujiContent = shujiContent;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getShujiDelete() {
        return shujiDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setShujiDelete(Integer shujiDelete) {
        this.shujiDelete = shujiDelete;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
