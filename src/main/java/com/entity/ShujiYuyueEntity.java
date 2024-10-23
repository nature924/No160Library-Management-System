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
 * 书籍借阅
 *
 * @author 
 * @email
 */
@TableName("shuji_yuyue")
public class ShujiYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShujiYuyueEntity() {

	}

	public ShujiYuyueEntity(T t) {
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
     * 书籍
     */
    @ColumnInfo(comment="书籍",type="int(11)")
    @TableField(value = "shuji_id")

    private Integer shujiId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 借阅时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="借阅时间",type="timestamp")
    @TableField(value = "shuji_yuyue_time")

    private Date shujiYuyueTime;


    /**
     * 借阅天数
     */
    @ColumnInfo(comment="借阅天数",type="int(11)")
    @TableField(value = "shuji_yuyue_num")

    private Integer shujiYuyueNum;


    /**
     * 借阅状态
     */
    @ColumnInfo(comment="借阅状态",type="int(11)")
    @TableField(value = "shuji_yuyue_types")

    private Integer shujiYuyueTypes;


    /**
     * 逻辑删除
     */
    @ColumnInfo(comment="逻辑删除",type="int(11)")
    @TableField(value = "shuji_yuyue_delete")

    private Integer shujiYuyueDelete;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="添加时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间   listShow
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
	 * 获取：书籍
	 */
    public Integer getShujiId() {
        return shujiId;
    }
    /**
	 * 设置：书籍
	 */

    public void setShujiId(Integer shujiId) {
        this.shujiId = shujiId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 设置：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：借阅时间
	 */
    public Date getShujiYuyueTime() {
        return shujiYuyueTime;
    }
    /**
	 * 设置：借阅时间
	 */

    public void setShujiYuyueTime(Date shujiYuyueTime) {
        this.shujiYuyueTime = shujiYuyueTime;
    }
    /**
	 * 获取：借阅天数
	 */
    public Integer getShujiYuyueNum() {
        return shujiYuyueNum;
    }
    /**
	 * 设置：借阅天数
	 */

    public void setShujiYuyueNum(Integer shujiYuyueNum) {
        this.shujiYuyueNum = shujiYuyueNum;
    }
    /**
	 * 获取：借阅状态
	 */
    public Integer getShujiYuyueTypes() {
        return shujiYuyueTypes;
    }
    /**
	 * 设置：借阅状态
	 */

    public void setShujiYuyueTypes(Integer shujiYuyueTypes) {
        this.shujiYuyueTypes = shujiYuyueTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getShujiYuyueDelete() {
        return shujiYuyueDelete;
    }
    /**
	 * 设置：逻辑删除
	 */

    public void setShujiYuyueDelete(Integer shujiYuyueDelete) {
        this.shujiYuyueDelete = shujiYuyueDelete;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 设置：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间   listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间   listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ShujiYuyue{" +
            ", id=" + id +
            ", shujiId=" + shujiId +
            ", yonghuId=" + yonghuId +
            ", shujiYuyueTime=" + DateUtil.convertString(shujiYuyueTime,"yyyy-MM-dd") +
            ", shujiYuyueNum=" + shujiYuyueNum +
            ", shujiYuyueTypes=" + shujiYuyueTypes +
            ", shujiYuyueDelete=" + shujiYuyueDelete +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
