package org.egov.bookings.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity(name = "RoomsModel")
@Table(name = "BK_ROOMS_MODEL")
public class RoomsModel {

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "ROOM_APPLICATION_NUMBER")
	private String roomApplicationNumber;

	@Column(name = "TYPE_OF_ROOM")
	private String typeOfRoom;

	@Column(name = "TOTAL_NO_OF_ROOMS")
	private String totalNoOfRooms;

	@Column(name = "COMMUNITY_APPLICATION_NUMBER")
	private String communityApplicationNumber;

	@Column(name = "ROOM_APPLICATION_STATUS")
	private String roomApplicationStatus;

	@Column(name = "ROOM_BUSINESS_SERVICE")
	private String roomBusinessService;

	@Column(name = "REMARKS")
	private String remarks;

	@Column(name = "ACTION")
	private String action;

	@Column(name = "LAST_MODIFIED_DATE")
	private Date lastModifiedDate;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "FROM_DATE")
	private Date fromDate;

	@Column(name = "TO_DATE")
	private Date toDate;

	@Column(name = "discount")
	private BigDecimal discount;

	@Column(name = "facilation_charge")
	private BigDecimal facilationCharge;

	@Column(name = "room_payment_status")
	private String roomPaymentStatus;

}
