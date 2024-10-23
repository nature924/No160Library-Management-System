package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 书籍
 *
 * @author 
 * @email
 */
@TableName("shuji")
public class ShujiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShujiEntity() {

	}

	public ShujiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 书籍编号
     */
    @ColumnInfo(comment="书籍编号",type="varchar(200)")
    @TableField(value = "shuji_uuid_number")

    private String shujiUuidNumber;


    /**
     * 书籍名称
     */
    @ColumnInfo(comment="书籍名称",type="varchar(200)")
    @TableField(value = "shuji_name")

    private String shujiName;


    /**
     * 书籍作者
     */
    @ColumnInfo(comment="书籍作者",type="varchar(200)")
    @TableField(value = "shuji_zuozhe")

    private String shujiZuozhe;


    /**
     * 出版社
     */
    @ColumnInfo(comment="出版社",type="varchar(200)")
    @TableField(value = "shuji_chubanshe")

    private String shujiChubanshe;


    /**
     * 书籍照片
     */
    @ColumnInfo(comment="书籍照片",type="varchar(200)")
    @TableField(value = "shuji_photo")

    private String shujiPhoto;


    /**
     * 书籍类型
     */
    @ColumnInfo(comment="书籍类型",type="int(11)")
    @TableField(value = "shuji_types")

    private Integer shujiTypes;


    /**
     * 所在书架
     */
    @ColumnInfo(comment="所在书架",type="int(11)")
    @TableField(value = "shujia_types")

    private Integer shujiaTypes;


    /**
     * 详细地址
     */
    @ColumnInfo(comment="详细地址",type="varchar(200)")
    @TableField(value = "shujia_address")

    private String shujiaAddress;


    /**
     * 书籍库存
     */
    @ColumnInfo(comment="书籍库存",type="int(11)")
    @TableField(value = "shuji_kucun_number")

    private Integer shujiKucunNumber;


    /**
     * 热度
     */
    @ColumnInfo(comment="热度",type="int(11)")
    @TableField(value = "shuji_clicknum")

    private Integer shujiClicknum;


    /**
     * 书籍介绍
     */
    @ColumnInfo(comment="书籍介绍",type="text")
    @TableField(value = "shuji_content")

    private String shujiContent;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "shuji_delete")

    private Integer shujiDelete;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Shuji{" +
            ", id=" + id +
            ", shujiUuidNumber=" + shujiUuidNumber +
            ", shujiName=" + shujiName +
            ", shujiZuozhe=" + shujiZuozhe +
            ", shujiChubanshe=" + shujiChubanshe +
            ", shujiPhoto=" + shujiPhoto +
            ", shujiTypes=" + shujiTypes +
            ", shujiaTypes=" + shujiaTypes +
            ", shujiaAddress=" + shujiaAddress +
            ", shujiKucunNumber=" + shujiKucunNumber +
            ", shujiClicknum=" + shujiClicknum +
            ", shujiContent=" + shujiContent +
            ", shujiDelete=" + shujiDelete +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
