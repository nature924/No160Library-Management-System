package com.entity.vo;

import com.entity.ShujiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 书籍
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shuji")
public class ShujiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 书籍编号
     */

    @TableField(value = "shuji_uuid_number")
    private String shujiUuidNumber;


    /**
     * 书籍名称
     */

    @TableField(value = "shuji_name")
    private String shujiName;


    /**
     * 书籍作者
     */

    @TableField(value = "shuji_zuozhe")
    private String shujiZuozhe;


    /**
     * 出版社
     */

    @TableField(value = "shuji_chubanshe")
    private String shujiChubanshe;


    /**
     * 书籍照片
     */

    @TableField(value = "shuji_photo")
    private String shujiPhoto;


    /**
     * 书籍类型
     */

    @TableField(value = "shuji_types")
    private Integer shujiTypes;


    /**
     * 所在书架
     */

    @TableField(value = "shujia_types")
    private Integer shujiaTypes;


    /**
     * 详细地址
     */

    @TableField(value = "shujia_address")
    private String shujiaAddress;


    /**
     * 书籍库存
     */

    @TableField(value = "shuji_kucun_number")
    private Integer shujiKucunNumber;


    /**
     * 热度
     */

    @TableField(value = "shuji_clicknum")
    private Integer shujiClicknum;


    /**
     * 书籍介绍
     */

    @TableField(value = "shuji_content")
    private String shujiContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "shuji_delete")
    private Integer shujiDelete;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：书籍编号
	 */
    public String getShujiUuidNumber() {
        return shujiUuidNumber;
    }


    /**
	 * 获取：书籍编号
	 */

    public void setShujiUuidNumber(String shujiUuidNumber) {
        this.shujiUuidNumber = shujiUuidNumber;
    }
    /**
	 * 设置：书籍名称
	 */
    public String getShujiName() {
        return shujiName;
    }


    /**
	 * 获取：书籍名称
	 */

    public void setShujiName(String shujiName) {
        this.shujiName = shujiName;
    }
    /**
	 * 设置：书籍作者
	 */
    public String getShujiZuozhe() {
        return shujiZuozhe;
    }


    /**
	 * 获取：书籍作者
	 */

    public void setShujiZuozhe(String shujiZuozhe) {
        this.shujiZuozhe = shujiZuozhe;
    }
    /**
	 * 设置：出版社
	 */
    public String getShujiChubanshe() {
        return shujiChubanshe;
    }


    /**
	 * 获取：出版社
	 */

    public void setShujiChubanshe(String shujiChubanshe) {
        this.shujiChubanshe = shujiChubanshe;
    }
    /**
	 * 设置：书籍照片
	 */
    public String getShujiPhoto() {
        return shujiPhoto;
    }


    /**
	 * 获取：书籍照片
	 */

    public void setShujiPhoto(String shujiPhoto) {
        this.shujiPhoto = shujiPhoto;
    }
    /**
	 * 设置：书籍类型
	 */
    public Integer getShujiTypes() {
        return shujiTypes;
    }


    /**
	 * 获取：书籍类型
	 */

    public void setShujiTypes(Integer shujiTypes) {
        this.shujiTypes = shujiTypes;
    }
    /**
	 * 设置：所在书架
	 */
    public Integer getShujiaTypes() {
        return shujiaTypes;
    }


    /**
	 * 获取：所在书架
	 */

    public void setShujiaTypes(Integer shujiaTypes) {
        this.shujiaTypes = shujiaTypes;
    }
    /**
	 * 设置：详细地址
	 */
    public String getShujiaAddress() {
        return shujiaAddress;
    }


    /**
	 * 获取：详细地址
	 */

    public void setShujiaAddress(String shujiaAddress) {
        this.shujiaAddress = shujiaAddress;
    }
    /**
	 * 设置：书籍库存
	 */
    public Integer getShujiKucunNumber() {
        return shujiKucunNumber;
    }


    /**
	 * 获取：书籍库存
	 */

    public void setShujiKucunNumber(Integer shujiKucunNumber) {
        this.shujiKucunNumber = shujiKucunNumber;
    }
    /**
	 * 设置：热度
	 */
    public Integer getShujiClicknum() {
        return shujiClicknum;
    }


    /**
	 * 获取：热度
	 */

    public void setShujiClicknum(Integer shujiClicknum) {
        this.shujiClicknum = shujiClicknum;
    }
    /**
	 * 设置：书籍介绍
	 */
    public String getShujiContent() {
        return shujiContent;
    }


    /**
	 * 获取：书籍介绍
	 */

    public void setShujiContent(String shujiContent) {
        this.shujiContent = shujiContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getShujiDelete() {
        return shujiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setShujiDelete(Integer shujiDelete) {
        this.shujiDelete = shujiDelete;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
