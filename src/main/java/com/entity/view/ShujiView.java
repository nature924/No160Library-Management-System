package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ShujiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 书籍
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("shuji")
public class ShujiView extends ShujiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 书籍类型的值
	*/
	@ColumnInfo(comment="书籍类型的字典表值",type="varchar(200)")
	private String shujiValue;
	/**
	* 所在书架的值
	*/
	@ColumnInfo(comment="所在书架的字典表值",type="varchar(200)")
	private String shujiaValue;




	public ShujiView() {

	}

	public ShujiView(ShujiEntity shujiEntity) {
		try {
			BeanUtils.copyProperties(this, shujiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 书籍类型的值
	*/
	public String getShujiValue() {
		return shujiValue;
	}
	/**
	* 设置： 书籍类型的值
	*/
	public void setShujiValue(String shujiValue) {
		this.shujiValue = shujiValue;
	}
	//当前表的
	/**
	* 获取： 所在书架的值
	*/
	public String getShujiaValue() {
		return shujiaValue;
	}
	/**
	* 设置： 所在书架的值
	*/
	public void setShujiaValue(String shujiaValue) {
		this.shujiaValue = shujiaValue;
	}




	@Override
	public String toString() {
		return "ShujiView{" +
			", shujiValue=" + shujiValue +
			", shujiaValue=" + shujiaValue +
			"} " + super.toString();
	}
}
