package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.PandianEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 每日盘点
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("pandian")
public class PandianView extends PandianEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表

	//级联表 书籍
		/**
		* 书籍编号
		*/

		@ColumnInfo(comment="书籍编号",type="varchar(200)")
		private String shujiUuidNumber;
		/**
		* 书籍名称
		*/

		@ColumnInfo(comment="书籍名称",type="varchar(200)")
		private String shujiName;
		/**
		* 书籍作者
		*/

		@ColumnInfo(comment="书籍作者",type="varchar(200)")
		private String shujiZuozhe;
		/**
		* 出版社
		*/

		@ColumnInfo(comment="出版社",type="varchar(200)")
		private String shujiChubanshe;
		/**
		* 书籍照片
		*/

		@ColumnInfo(comment="书籍照片",type="varchar(200)")
		private String shujiPhoto;
		/**
		* 书籍类型
		*/
		@ColumnInfo(comment="书籍类型",type="int(11)")
		private Integer shujiTypes;
			/**
			* 书籍类型的值
			*/
			@ColumnInfo(comment="书籍类型的字典表值",type="varchar(200)")
			private String shujiValue;
		/**
		* 所在书架
		*/
		@ColumnInfo(comment="所在书架",type="int(11)")
		private Integer shujiaTypes;
			/**
			* 所在书架的值
			*/
			@ColumnInfo(comment="所在书架的字典表值",type="varchar(200)")
			private String shujiaValue;
		/**
		* 详细地址
		*/

		@ColumnInfo(comment="详细地址",type="varchar(200)")
		private String shujiaAddress;
		/**
		* 书籍库存
		*/

		@ColumnInfo(comment="书籍库存",type="int(11)")
		private Integer shujiKucunNumber;
		/**
		* 热度
		*/

		@ColumnInfo(comment="热度",type="int(11)")
		private Integer shujiClicknum;
		/**
		* 书籍介绍
		*/

		@ColumnInfo(comment="书籍介绍",type="text")
		private String shujiContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer shujiDelete;



	public PandianView() {

	}

	public PandianView(PandianEntity pandianEntity) {
		try {
			BeanUtils.copyProperties(this, pandianEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





	//级联表的get和set 书籍

		/**
		* 获取： 书籍编号
		*/
		public String getShujiUuidNumber() {
			return shujiUuidNumber;
		}
		/**
		* 设置： 书籍编号
		*/
		public void setShujiUuidNumber(String shujiUuidNumber) {
			this.shujiUuidNumber = shujiUuidNumber;
		}

		/**
		* 获取： 书籍名称
		*/
		public String getShujiName() {
			return shujiName;
		}
		/**
		* 设置： 书籍名称
		*/
		public void setShujiName(String shujiName) {
			this.shujiName = shujiName;
		}

		/**
		* 获取： 书籍作者
		*/
		public String getShujiZuozhe() {
			return shujiZuozhe;
		}
		/**
		* 设置： 书籍作者
		*/
		public void setShujiZuozhe(String shujiZuozhe) {
			this.shujiZuozhe = shujiZuozhe;
		}

		/**
		* 获取： 出版社
		*/
		public String getShujiChubanshe() {
			return shujiChubanshe;
		}
		/**
		* 设置： 出版社
		*/
		public void setShujiChubanshe(String shujiChubanshe) {
			this.shujiChubanshe = shujiChubanshe;
		}

		/**
		* 获取： 书籍照片
		*/
		public String getShujiPhoto() {
			return shujiPhoto;
		}
		/**
		* 设置： 书籍照片
		*/
		public void setShujiPhoto(String shujiPhoto) {
			this.shujiPhoto = shujiPhoto;
		}
		/**
		* 获取： 书籍类型
		*/
		public Integer getShujiTypes() {
			return shujiTypes;
		}
		/**
		* 设置： 书籍类型
		*/
		public void setShujiTypes(Integer shujiTypes) {
			this.shujiTypes = shujiTypes;
		}


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
		/**
		* 获取： 所在书架
		*/
		public Integer getShujiaTypes() {
			return shujiaTypes;
		}
		/**
		* 设置： 所在书架
		*/
		public void setShujiaTypes(Integer shujiaTypes) {
			this.shujiaTypes = shujiaTypes;
		}


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

		/**
		* 获取： 详细地址
		*/
		public String getShujiaAddress() {
			return shujiaAddress;
		}
		/**
		* 设置： 详细地址
		*/
		public void setShujiaAddress(String shujiaAddress) {
			this.shujiaAddress = shujiaAddress;
		}

		/**
		* 获取： 书籍库存
		*/
		public Integer getShujiKucunNumber() {
			return shujiKucunNumber;
		}
		/**
		* 设置： 书籍库存
		*/
		public void setShujiKucunNumber(Integer shujiKucunNumber) {
			this.shujiKucunNumber = shujiKucunNumber;
		}

		/**
		* 获取： 热度
		*/
		public Integer getShujiClicknum() {
			return shujiClicknum;
		}
		/**
		* 设置： 热度
		*/
		public void setShujiClicknum(Integer shujiClicknum) {
			this.shujiClicknum = shujiClicknum;
		}

		/**
		* 获取： 书籍介绍
		*/
		public String getShujiContent() {
			return shujiContent;
		}
		/**
		* 设置： 书籍介绍
		*/
		public void setShujiContent(String shujiContent) {
			this.shujiContent = shujiContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getShujiDelete() {
			return shujiDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setShujiDelete(Integer shujiDelete) {
			this.shujiDelete = shujiDelete;
		}


	@Override
	public String toString() {
		return "PandianView{" +
			", shujiUuidNumber=" + shujiUuidNumber +
			", shujiName=" + shujiName +
			", shujiZuozhe=" + shujiZuozhe +
			", shujiChubanshe=" + shujiChubanshe +
			", shujiPhoto=" + shujiPhoto +
			", shujiaAddress=" + shujiaAddress +
			", shujiKucunNumber=" + shujiKucunNumber +
			", shujiClicknum=" + shujiClicknum +
			", shujiContent=" + shujiContent +
			", shujiDelete=" + shujiDelete +
			"} " + super.toString();
	}
}
