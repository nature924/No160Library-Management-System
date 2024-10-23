package com.entity.vo;

import com.entity.ShujiYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 书籍借阅
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shuji_yuyue")
public class ShujiYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 书籍
     */

    @TableField(value = "shuji_id")
    private Integer shujiId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 借阅时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "shuji_yuyue_time")
    private Date shujiYuyueTime;


    /**
     * 借阅天数
     */

    @TableField(value = "shuji_yuyue_num")
    private Integer shujiYuyueNum;


    /**
     * 借阅状态
     */

    @TableField(value = "shuji_yuyue_types")
    private Integer shujiYuyueTypes;


    /**
     * 逻辑删除
     */

    @TableField(value = "shuji_yuyue_delete")
    private Integer shujiYuyueDelete;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show3 listShow
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
	 * 设置：书籍
	 */
    public Integer getShujiId() {
        return shujiId;
    }


    /**
	 * 获取：书籍
	 */

    public void setShujiId(Integer shujiId) {
        this.shujiId = shujiId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：借阅时间
	 */
    public Date getShujiYuyueTime() {
        return shujiYuyueTime;
    }


    /**
	 * 获取：借阅时间
	 */

    public void setShujiYuyueTime(Date shujiYuyueTime) {
        this.shujiYuyueTime = shujiYuyueTime;
    }
    /**
	 * 设置：借阅天数
	 */
    public Integer getShujiYuyueNum() {
        return shujiYuyueNum;
    }


    /**
	 * 获取：借阅天数
	 */

    public void setShujiYuyueNum(Integer shujiYuyueNum) {
        this.shujiYuyueNum = shujiYuyueNum;
    }
    /**
	 * 设置：借阅状态
	 */
    public Integer getShujiYuyueTypes() {
        return shujiYuyueTypes;
    }


    /**
	 * 获取：借阅状态
	 */

    public void setShujiYuyueTypes(Integer shujiYuyueTypes) {
        this.shujiYuyueTypes = shujiYuyueTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getShujiYuyueDelete() {
        return shujiYuyueDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setShujiYuyueDelete(Integer shujiYuyueDelete) {
        this.shujiYuyueDelete = shujiYuyueDelete;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
