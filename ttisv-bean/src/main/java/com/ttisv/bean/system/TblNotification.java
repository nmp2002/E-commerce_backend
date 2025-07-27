package com.ttisv.bean.system;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "TBL_NOTIFICATION")
public class TblNotification implements Serializable {
	   private static final long serialVersionUID = 1L;

	    @Id
	    @SequenceGenerator(name = "SEQ_TBL_NOTIFICATION", sequenceName = "SEQ_TBL_NOTIFICATION", initialValue = 1, allocationSize = 1)
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TBL_NOTIFICATION")
	    @Column(name = "ID")
	    private Long id;
	    
	    @Column(name = "MESSAGE")
	    private String message;
	    
	    @Column(name = "STATUS")
	    private Long status;
	    
	    @Column(name = "TIME")
	    private String time;
	    
	    @Column(name = "FIELDID")
	    private Long fieldId;
	    
	    @Column(name = "CREATEBY")
		private String createby;
		
		@Column(name ="MODIFIEDBY")
		private String modifieldby;
		
		@Temporal(TemporalType.DATE)
		@Column(name = "CREATED_DATE")
		private Date createdDate;
		
		@Temporal(TemporalType.DATE)
		@Column(name = "MODIFIED_DATE")
		private Date modifiedDate;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public Long getStatus() {
			return status;
		}

		public void setStatus(Long status) {
			this.status = status;
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public Long getFieldId() {
			return fieldId;
		}

		public void setFieldId(Long fieldId) {
			this.fieldId = fieldId;
		}

		public String getCreateby() {
			return createby;
		}

		public void setCreateby(String createby) {
			this.createby = createby;
		}

		public String getModifieldby() {
			return modifieldby;
		}

		public void setModifieldby(String modifieldby) {
			this.modifieldby = modifieldby;
		}

		public Date getCreatedDate() {
			return createdDate;
		}

		public void setCreatedDate(Date createdDate) {
			this.createdDate = createdDate;
		}

		public Date getModifiedDate() {
			return modifiedDate;
		}

		public void setModifiedDate(Date modifiedDate) {
			this.modifiedDate = modifiedDate;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public TblNotification() {
			super();
			// TODO Auto-generated constructor stub
		}

		public TblNotification(Long id, String message, Long status, String time, Long fieldId, String createby,
				String modifieldby, Date createdDate, Date modifiedDate) {
			super();
			this.id = id;
			this.message = message;
			this.status = status;
			this.time = time;
			this.fieldId = fieldId;
			this.createby = createby;
			this.modifieldby = modifieldby;
			this.createdDate = createdDate;
			this.modifiedDate = modifiedDate;
		}

		
}
