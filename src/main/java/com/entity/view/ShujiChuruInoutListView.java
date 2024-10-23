package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.ShujiChuruInoutListEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 出入库详情
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("shuji_churu_inout_list")
public class ShujiChuruInoutListView extends ShujiChuruInoutListEntity implements Serializable {
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
	//级联表 出入库
		/**
		* 出入库流水号
		*/

		@ColumnInfo(comment="出入库流水号",type="varchar(200)")
		private String shujiChuruInoutUuidNumber;
		/**
		* 出入库名称
		*/

		@ColumnInfo(comment="出入库名称",type="varchar(200)")
		private String shujiChuruInoutName;
		/**
		* 出入库类型
		*/
		@ColumnInfo(comment="出入库类型",type="int(11)")
		private Integer shujiChuruInoutTypes;
			/**
			* 出入库类型的值
			*/
			@ColumnInfo(comment="出入库类型的字典表值",type="varchar(200)")
			private String shujiChuruInoutValue;
		/**
		* 备注
		*/

		@ColumnInfo(comment="备注",type="longtext")
		private String shujiChuruInoutContent;



	public ShujiChuruInoutListView() {

	}

	public ShujiChuruInoutListView(ShujiChuruInoutListEntity shujiChuruInoutListEntity) {
		try {
			BeanUtils.copyProperties(this, shujiChuruInoutListEntity);
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
	//级联表的get和set 出入库

		/**
		* 获取： 出入库流水号
		*/
		public String getShujiChuruInoutUuidNumber() {
			return shujiChuruInoutUuidNumber;
		}
		/**
		* 设置： 出入库流水号
		*/
		public void setShujiChuruInoutUuidNumber(String shujiChuruInoutUuidNumber) {
			this.shujiChuruInoutUuidNumber = shujiChuruInoutUuidNumber;
		}

		/**
		* 获取： 出入库名称
		*/
		public String getShujiChuruInoutName() {
			return shujiChuruInoutName;
		}
		/**
		* 设置： 出入库名称
		*/
		public void setShujiChuruInoutName(String shujiChuruInoutName) {
			this.shujiChuruInoutName = shujiChuruInoutName;
		}
		/**
		* 获取： 出入库类型
		*/
		public Integer getShujiChuruInoutTypes() {
			return shujiChuruInoutTypes;
		}
		/**
		* 设置： 出入库类型
		*/
		public void setShujiChuruInoutTypes(Integer shujiChuruInoutTypes) {
			this.shujiChuruInoutTypes = shujiChuruInoutTypes;
		}


			/**
			* 获取： 出入库类型的值
			*/
			public String getShujiChuruInoutValue() {
				return shujiChuruInoutValue;
			}
			/**
			* 设置： 出入库类型的值
			*/
			public void setShujiChuruInoutValue(String shujiChuruInoutValue) {
				this.shujiChuruInoutValue = shujiChuruInoutValue;
			}

		/**
		* 获取： 备注
		*/
		public String getShujiChuruInoutContent() {
			return shujiChuruInoutContent;
		}
		/**
		* 设置： 备注
		*/
		public void setShujiChuruInoutContent(String shujiChuruInoutContent) {
			this.shujiChuruInoutContent = shujiChuruInoutContent;
		}


	@Override
	public String toString() {
		return "ShujiChuruInoutListView{" +
			", shujiChuruInoutUuidNumber=" + shujiChuruInoutUuidNumber +
			", shujiChuruInoutName=" + shujiChuruInoutName +
			", shujiChuruInoutContent=" + shujiChuruInoutContent +
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
