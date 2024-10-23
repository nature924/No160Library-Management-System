package com.entity.model;

import com.entity.ShujiYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 书籍借阅
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShujiYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 书籍
     */
    private Integer shujiId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 借阅时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shujiYuyueTime;


    /**
     * 借阅天数
     */
    private Integer shujiYuyueNum;


    /**
     * 借阅状态
     */
    private Integer shujiYuyueTypes;


    /**
     * 逻辑删除
     */
    private Integer shujiYuyueDelete;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
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
	 * 获取：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
