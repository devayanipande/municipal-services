package org.egov.assets.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Hold the material receipt specific information.
 */

public class MaterialReceipt {
	@JsonProperty("id")
	private String id = null;

	@JsonProperty("tenantId")
	private String tenantId = null;

	@JsonProperty("mrnNumber")
	private String mrnNumber = null;

	@JsonProperty("manualReceiptNumber")
	private String manualReceiptNumber = null;

	@JsonProperty("issueNumber")
	private String issueNumber = null;

	@JsonProperty("receiptDate")
	private Long receiptDate = null;

	@JsonProperty("financialYear")
	private String financialYear = null;

	@JsonProperty("manualReceiptDate")
	private Long manualReceiptDate = null;

	/**
	 * Different receipt types enumeration. By default the value will be \"PURCHASE
	 * RECEIPT\".
	 */
	public enum ReceiptTypeEnum {
		PURCHASE_RECEIPT("PURCHASE RECEIPT"),

		MISCELLANEOUS_RECEIPT("MISCELLANEOUS RECEIPT"),

		INWARD_RECEIPT("INWARD RECEIPT"),

		OPENING_BALANCE("OPENING BALANCE");

		private String value;

		ReceiptTypeEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static ReceiptTypeEnum fromValue(String text) {
			for (ReceiptTypeEnum b : ReceiptTypeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("receiptType")
	private ReceiptTypeEnum receiptType = null;

	/**
	 * Applicable if receipt type is MISCELLANEOUS RECEIPT
	 */
	public enum ReceiptPurposeEnum {
		RETURN_OF_MATERIALS("RETURN OF MATERIALS"),

		SCRAP("SCRAP");

		private String value;

		ReceiptPurposeEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static ReceiptPurposeEnum fromValue(String text) {
			for (ReceiptPurposeEnum b : ReceiptPurposeEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("receiptPurpose")
	private ReceiptPurposeEnum receiptPurpose = null;

	@JsonProperty("receivingStore")
	private Store receivingStore = null;

	@JsonProperty("issueingStore")
	private Store issueingStore = null;

	@JsonProperty("supplier")
	private Supplier supplier = null;

	@JsonProperty("supplierBillNo")
	private String supplierBillNo = null;

	@JsonProperty("supplierBillDate")
	private Long supplierBillDate = null;

	@JsonProperty("challanNo")
	private String challanNo = null;

	@JsonProperty("challanDate")
	private Long challanDate = null;

	@JsonProperty("description")
	private String description = null;

	@JsonProperty("receivedBy")
	private String receivedBy = null;

	@JsonProperty("designation")
	private String designation = null;

	/**
	 * Shows the current status of the receipt. By default the value will be
	 * \"CREATED\".
	 */
	public enum MrnStatusEnum {
		CREATED("CREATED"),

		REVIEWOFSDO("REVIEWOFSDO"), REVIEWOFEE("REVIEWOFEE"), REVIEWOFSE("REVIEWOFSE"), REVIEWOFCE(
				"REVIEWOFCE"), SENDTOCREATOR("SENDTOCREATOR"), COMMISSIONERAPPROVAL("COMMISSIONERAPPROVAL"), APPROVED(
						"APPROVED"), REASSIGNTOJE(
								"REASSIGNTOJE"), REVIEWOFCAO("REVIEWOFCAO"), REVIEWOFACMC("REVIEWOFACMC"),

		REVIEWOFSO("REVIEWOFSO"), REVIEWOFSA("REVIEWOFSA"), REVIEWOFSP("REVIEWOFSP"), REVIEWOFJC(
				"REVIEWOFJC"), REVIEWOFMOH("REVIEWOFMOH"),

		CANCELED("CANCELED"),

		RECEIPTED("RECEIPTED");

		private String value;

		MrnStatusEnum(String value) {
			this.value = value;
		}

		@Override
		@JsonValue
		public String toString() {
			return String.valueOf(value);
		}

		@JsonCreator
		public static MrnStatusEnum fromValue(String text) {
			for (MrnStatusEnum b : MrnStatusEnum.values()) {
				if (String.valueOf(b.value).equals(text)) {
					return b;
				}
			}
			return null;
		}
	}

	@JsonProperty("mrnStatus")
	private MrnStatusEnum mrnStatus = null;

	@JsonProperty("bill")
	private String bill = null;

	@JsonProperty("inspectedBy")
	private String inspectedBy = null;

	@JsonProperty("inspectionDate")
	private Long inspectionDate = null;

	@JsonProperty("inspectionRemarks")
	private String inspectionRemarks = null;

	@JsonProperty("totalReceiptValue")
	private BigDecimal totalReceiptValue = null;

	@JsonProperty("receiptDetails")
	private List<MaterialReceiptDetail> receiptDetails = null;

	@JsonProperty("fileStoreId")
	private String fileStoreId = null;

	@JsonProperty("paymentTerms")
	private String paymentTerms = null;

	@JsonProperty("supplierBillPaid")
	private Boolean supplierBillPaid = false;

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails = null;

	public MaterialReceipt id(String id) {
		this.id = id;
		return this;
	}

	/**
	 * Unique Identifier of the Material Receipt Header
	 *
	 * @return id
	 **/
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public MaterialReceipt tenantId(String tenantId) {
		this.tenantId = tenantId;
		return this;
	}

	/**
	 * Tenant id of the Material Receipt Header
	 *
	 * @return tenantId
	 **/
	@Size(min = 2, max = 128)
	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public MaterialReceipt mrnNumber(String mrnNumber) {
		this.mrnNumber = mrnNumber;
		return this;
	}

	/**
	 * Unique number generated internally on creating a receipt.
	 *
	 * @return mrnNumber
	 **/

	@NotNull

	public String getMrnNumber() {
		return mrnNumber;
	}

	public void setMrnNumber(String mrnNumber) {
		this.mrnNumber = mrnNumber;
	}

	public MaterialReceipt manualReceiptNumber(String manualReceiptNumber) {
		this.manualReceiptNumber = manualReceiptNumber;
		return this;
	}

	/**
	 * Manual Receipt Number, applicable only for Opening Balanace Entry.
	 *
	 * @return manualReceiptNumber
	 **/
	@Size(max = 128)
	public String getManualReceiptNumber() {
		return manualReceiptNumber;
	}

	public void setManualReceiptNumber(String manualReceiptNumber) {
		this.manualReceiptNumber = manualReceiptNumber;
	}

	public MaterialReceipt issueNumber(String issueNumber) {
		this.issueNumber = issueNumber;
		return this;
	}

	/**
	 * material issue number.
	 *
	 * @return issueNumber
	 **/
	public String getIssueNumber() {
		return issueNumber;
	}

	public void setIssueNumber(String issueNumber) {
		this.issueNumber = issueNumber;
	}

	public MaterialReceipt receiptDate(Long receiptDate) {
		this.receiptDate = receiptDate;
		return this;
	}

	/**
	 * The date on which the receipt was made.
	 *
	 * @return receiptDate
	 **/

	@NotNull
	public Long getReceiptDate() {
		return receiptDate;
	}

	public void setReceiptDate(Long receiptDate) {
		this.receiptDate = receiptDate;
	}

	public MaterialReceipt financialYear(String financialYear) {
		this.financialYear = financialYear;
		return this;
	}

	/**
	 * This field holds the financial year information for Opening Balance Entry.
	 *
	 * @return financialYear
	 **/
	public String getFinancialYear() {
		return financialYear;
	}

	public void setFinancialYear(String financialYear) {
		this.financialYear = financialYear;
	}

	public MaterialReceipt manualReceiptDate(Long manualReceiptDate) {
		this.manualReceiptDate = manualReceiptDate;
		return this;
	}

	/**
	 * Manual Receipt Date, applicable only for Opening Balance Entry.
	 *
	 * @return manualReceiptDate
	 **/
	public Long getManualReceiptDate() {
		return manualReceiptDate;
	}

	public void setManualReceiptDate(Long manualReceiptDate) {
		this.manualReceiptDate = manualReceiptDate;
	}

	public MaterialReceipt receiptType(ReceiptTypeEnum receiptType) {
		this.receiptType = receiptType;
		return this;
	}

	/**
	 * Different receipt types enumeration. By default the value will be \"PURCHASE
	 * RECEIPT\".
	 *
	 * @return receiptType
	 **/

	@NotNull
	public ReceiptTypeEnum getReceiptType() {
		return receiptType;
	}

	public void setReceiptType(ReceiptTypeEnum receiptType) {
		this.receiptType = receiptType;
	}

	public MaterialReceipt receiptPurpose(ReceiptPurposeEnum receiptPurpose) {
		this.receiptPurpose = receiptPurpose;
		return this;
	}

	/**
	 * Applicable if receipt type is MISCELLANEOUS RECEIPT
	 *
	 * @return receiptPurpose
	 **/
	public ReceiptPurposeEnum getReceiptPurpose() {
		return receiptPurpose;
	}

	public void setReceiptPurpose(ReceiptPurposeEnum receiptPurpose) {
		this.receiptPurpose = receiptPurpose;
	}

	public MaterialReceipt receivingStore(Store receivingStore) {
		this.receivingStore = receivingStore;
		return this;
	}

	/**
	 * The unique code of the store that is receiving the materials.
	 *
	 * @return receivingStore
	 **/

	@NotNull
	public Store getReceivingStore() {
		return receivingStore;
	}

	public void setReceivingStore(Store receivingStore) {
		this.receivingStore = receivingStore;
	}

	public MaterialReceipt issueingStore(Store issueingStore) {
		this.issueingStore = issueingStore;
		return this;
	}

	/**
	 * The unique code of the store that is Issued the materials. Useful in case of
	 * inter store transfer inward receipt.
	 *
	 * @return issueingStore
	 **/
	public Store getIssueingStore() {
		return issueingStore;
	}

	public void setIssueingStore(Store issueingStore) {
		this.issueingStore = issueingStore;
	}

	public MaterialReceipt supplier(Supplier supplier) {
		this.supplier = supplier;
		return this;
	}

	/**
	 * Supplier from whom the receipt is made.
	 *
	 * @return supplier
	 **/
	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public MaterialReceipt supplierBillNo(String supplierBillNo) {
		this.supplierBillNo = supplierBillNo;
		return this;
	}

	/**
	 * The bill number what is mentioned in the bill given by the supplier.
	 *
	 * @return supplierBillNo
	 **/
	public String getSupplierBillNo() {
		return supplierBillNo;
	}

	public void setSupplierBillNo(String supplierBillNo) {
		this.supplierBillNo = supplierBillNo;
	}

	public MaterialReceipt supplierBillDate(Long supplierBillDate) {
		this.supplierBillDate = supplierBillDate;
		return this;
	}

	/**
	 * The date on which the supplier has raised the bill for the delivered
	 * materials.
	 *
	 * @return supplierBillDate
	 **/
	public Long getSupplierBillDate() {
		return supplierBillDate;
	}

	public void setSupplierBillDate(Long supplierBillDate) {
		this.supplierBillDate = supplierBillDate;
	}

	public MaterialReceipt challanNo(String challanNo) {
		this.challanNo = challanNo;
		return this;
	}

	/**
	 * The challan number associated with this receipt.
	 *
	 * @return challanNo
	 **/
	@Size(max = 52)
	public String getChallanNo() {
		return challanNo;
	}

	public void setChallanNo(String challanNo) {
		this.challanNo = challanNo;
	}

	public MaterialReceipt challanDate(Long challanDate) {
		this.challanDate = challanDate;
		return this;
	}

	/**
	 * Date on which the challan was made.
	 *
	 * @return challanDate
	 **/
	public Long getChallanDate() {
		return challanDate;
	}

	public void setChallanDate(Long challanDate) {
		this.challanDate = challanDate;
	}

	public MaterialReceipt description(String description) {
		this.description = description;
		return this;
	}

	/**
	 * Any general description pertaining to the material receipt.
	 *
	 * @return description
	 **/
	@Size(max = 512)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public MaterialReceipt receivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
		return this;
	}

	/**
	 * The code of the employee who has received the materials in store.
	 *
	 * @return receivedBy
	 **/
	public String getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}

	public MaterialReceipt designation(String designation) {
		this.designation = designation;
		return this;
	}

	/**
	 * Designation of the employee who has received the materials in store.
	 *
	 * @return designation
	 **/
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public MaterialReceipt mrnStatus(MrnStatusEnum mrnStatus) {
		this.mrnStatus = mrnStatus;
		return this;
	}

	/**
	 * Shows the current status of the receipt. By default the value will be
	 * \"CREATED\".
	 *
	 * @return mrnStatus
	 **/

	@NotNull
	public MrnStatusEnum getMrnStatus() {
		return mrnStatus;
	}

	public void setMrnStatus(MrnStatusEnum mrnStatus) {
		this.mrnStatus = mrnStatus;
	}

	public MaterialReceipt bill(String bill) {
		this.bill = bill;
		return this;
	}

	/**
	 * Bill number reference, if bill is generatd in system for receipt.
	 *
	 * @return bill
	 **/
	public String getBill() {
		return bill;
	}

	public void setBill(String bill) {
		this.bill = bill;
	}

	public MaterialReceipt inspectedBy(String inspectedBy) {
		this.inspectedBy = inspectedBy;
		return this;
	}

	/**
	 * The unique code of the employee who has inspected the receipt of materials.
	 *
	 * @return inspectedBy
	 **/
	public String getInspectedBy() {
		return inspectedBy;
	}

	public void setInspectedBy(String inspectedBy) {
		this.inspectedBy = inspectedBy;
	}

	public MaterialReceipt inspectionDate(Long inspectionDate) {
		this.inspectionDate = inspectionDate;
		return this;
	}

	/**
	 * Date on which the inspection was done.
	 *
	 * @return inspectionDate
	 **/
	public Long getInspectionDate() {
		return inspectionDate;
	}

	public void setInspectionDate(Long inspectionDate) {
		this.inspectionDate = inspectionDate;
	}

	public MaterialReceipt inspectionRemarks(String inspectionRemarks) {
		this.inspectionRemarks = inspectionRemarks;
		return this;
	}

	/**
	 * Any remarks made by the inspection authority.
	 *
	 * @return inspectionRemarks
	 **/
	public String getInspectionRemarks() {
		return inspectionRemarks;
	}

	public void setInspectionRemarks(String inspectionRemarks) {
		this.inspectionRemarks = inspectionRemarks;
	}

	public MaterialReceipt totalReceiptValue(BigDecimal totalReceiptValue) {
		this.totalReceiptValue = totalReceiptValue;
		return this;
	}

	/**
	 * The sum total of the receipt value. This will be the total value of all the
	 * materials that are received as part of this receipt note.
	 *
	 * @return totalReceiptValue
	 **/
	@Valid

	public BigDecimal getTotalReceiptValue() {
		return totalReceiptValue;
	}

	public void setTotalReceiptValue(BigDecimal totalReceiptValue) {
		this.totalReceiptValue = totalReceiptValue;
	}

	public MaterialReceipt receiptDetails(List<MaterialReceiptDetail> receiptDetails) {
		this.receiptDetails = receiptDetails;
		return this;
	}

	public MaterialReceipt addReceiptDetailsItem(MaterialReceiptDetail receiptDetailsItem) {
		if (this.receiptDetails == null) {
			this.receiptDetails = new ArrayList<MaterialReceiptDetail>();
		}
		this.receiptDetails.add(receiptDetailsItem);
		return this;
	}

	/**
	 * Material and Purchase order details that are associated with this receipt.
	 *
	 * @return receiptDetails
	 **/
	public List<MaterialReceiptDetail> getReceiptDetails() {
		return receiptDetails;
	}

	public void setReceiptDetails(List<MaterialReceiptDetail> receiptDetails) {
		this.receiptDetails = receiptDetails;
	}

	public MaterialReceipt fileStoreId(String fileStoreId) {
		this.fileStoreId = fileStoreId;
		return this;
	}

	/**
	 * fileStoreId File Store id of the Material Receipt
	 *
	 * @return fileStoreId
	 **/
	public String getFileStoreId() {
		return fileStoreId;
	}

	public void setFileStoreId(String fileStoreId) {
		this.fileStoreId = fileStoreId;
	}

	public MaterialReceipt paymentTerms(String paymentTerms) {
		this.paymentTerms = paymentTerms;
		return this;
	}

	/**
	 * payment terms of the Material Receipt
	 *
	 * @return paymentTerms
	 **/
	@Size(max = 1000)
	public String getPaymentTerms() {
		return paymentTerms;
	}

	public void setPaymentTerms(String paymentTerms) {
		this.paymentTerms = paymentTerms;
	}

	public MaterialReceipt supplierBillPaid(Boolean supplierBillPaid) {
		this.supplierBillPaid = supplierBillPaid;
		return this;
	}

	/**
	 * Boolean value to identify whether the supplierbill paid for the selected
	 * receipt.
	 *
	 * @return supplierBillPaid
	 **/
	public Boolean getSupplierBillPaid() {
		return supplierBillPaid;
	}

	public void setSupplierBillPaid(Boolean supplierBillPaid) {
		this.supplierBillPaid = supplierBillPaid;
	}

	public MaterialReceipt auditDetails(AuditDetails auditDetails) {
		this.auditDetails = auditDetails;
		return this;
	}

	/**
	 * Get auditDetails
	 *
	 * @return auditDetails
	 **/
	public AuditDetails getAuditDetails() {
		return auditDetails;
	}

	public void setAuditDetails(AuditDetails auditDetails) {
		this.auditDetails = auditDetails;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		MaterialReceipt materialReceipt = (MaterialReceipt) o;
		return Objects.equals(this.id, materialReceipt.id) && Objects.equals(this.tenantId, materialReceipt.tenantId)
				&& Objects.equals(this.mrnNumber, materialReceipt.mrnNumber)
				&& Objects.equals(this.manualReceiptNumber, materialReceipt.manualReceiptNumber)
				&& Objects.equals(this.issueNumber, materialReceipt.issueNumber)
				&& Objects.equals(this.receiptDate, materialReceipt.receiptDate)
				&& Objects.equals(this.financialYear, materialReceipt.financialYear)
				&& Objects.equals(this.manualReceiptDate, materialReceipt.manualReceiptDate)
				&& Objects.equals(this.receiptType, materialReceipt.receiptType)
				&& Objects.equals(this.receiptPurpose, materialReceipt.receiptPurpose)
				&& Objects.equals(this.receivingStore, materialReceipt.receivingStore)
				&& Objects.equals(this.issueingStore, materialReceipt.issueingStore)
				&& Objects.equals(this.supplier, materialReceipt.supplier)
				&& Objects.equals(this.supplierBillNo, materialReceipt.supplierBillNo)
				&& Objects.equals(this.supplierBillDate, materialReceipt.supplierBillDate)
				&& Objects.equals(this.challanNo, materialReceipt.challanNo)
				&& Objects.equals(this.challanDate, materialReceipt.challanDate)
				&& Objects.equals(this.description, materialReceipt.description)
				&& Objects.equals(this.receivedBy, materialReceipt.receivedBy)
				&& Objects.equals(this.designation, materialReceipt.designation)
				&& Objects.equals(this.mrnStatus, materialReceipt.mrnStatus)
				&& Objects.equals(this.bill, materialReceipt.bill)
				&& Objects.equals(this.inspectedBy, materialReceipt.inspectedBy)
				&& Objects.equals(this.inspectionDate, materialReceipt.inspectionDate)
				&& Objects.equals(this.inspectionRemarks, materialReceipt.inspectionRemarks)
				&& Objects.equals(this.totalReceiptValue, materialReceipt.totalReceiptValue)
				&& Objects.equals(this.receiptDetails, materialReceipt.receiptDetails)
				&& Objects.equals(this.fileStoreId, materialReceipt.fileStoreId)
				&& Objects.equals(this.paymentTerms, materialReceipt.paymentTerms)
				&& Objects.equals(this.supplierBillPaid, materialReceipt.supplierBillPaid)
				&& Objects.equals(this.auditDetails, materialReceipt.auditDetails);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, tenantId, mrnNumber, manualReceiptNumber, issueNumber, receiptDate, financialYear,
				manualReceiptDate, receiptType, receiptPurpose, receivingStore, issueingStore, supplier, supplierBillNo,
				supplierBillDate, challanNo, challanDate, description, receivedBy, designation, mrnStatus, bill,
				inspectedBy, inspectionDate, inspectionRemarks, totalReceiptValue, receiptDetails, fileStoreId,
				paymentTerms, supplierBillPaid, auditDetails);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class MaterialReceipt {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    tenantId: ").append(toIndentedString(tenantId)).append("\n");
		sb.append("    mrnNumber: ").append(toIndentedString(mrnNumber)).append("\n");
		sb.append("    manualReceiptNumber: ").append(toIndentedString(manualReceiptNumber)).append("\n");
		sb.append("    issueNumber: ").append(toIndentedString(issueNumber)).append("\n");
		sb.append("    receiptDate: ").append(toIndentedString(receiptDate)).append("\n");
		sb.append("    financialYear: ").append(toIndentedString(financialYear)).append("\n");
		sb.append("    manualReceiptDate: ").append(toIndentedString(manualReceiptDate)).append("\n");
		sb.append("    receiptType: ").append(toIndentedString(receiptType)).append("\n");
		sb.append("    receiptPurpose: ").append(toIndentedString(receiptPurpose)).append("\n");
		sb.append("    receivingStore: ").append(toIndentedString(receivingStore)).append("\n");
		sb.append("    issueingStore: ").append(toIndentedString(issueingStore)).append("\n");
		sb.append("    supplier: ").append(toIndentedString(supplier)).append("\n");
		sb.append("    supplierBillNo: ").append(toIndentedString(supplierBillNo)).append("\n");
		sb.append("    supplierBillDate: ").append(toIndentedString(supplierBillDate)).append("\n");
		sb.append("    challanNo: ").append(toIndentedString(challanNo)).append("\n");
		sb.append("    challanDate: ").append(toIndentedString(challanDate)).append("\n");
		sb.append("    description: ").append(toIndentedString(description)).append("\n");
		sb.append("    receivedBy: ").append(toIndentedString(receivedBy)).append("\n");
		sb.append("    designation: ").append(toIndentedString(designation)).append("\n");
		sb.append("    mrnStatus: ").append(toIndentedString(mrnStatus)).append("\n");
		sb.append("    bill: ").append(toIndentedString(bill)).append("\n");
		sb.append("    inspectedBy: ").append(toIndentedString(inspectedBy)).append("\n");
		sb.append("    inspectionDate: ").append(toIndentedString(inspectionDate)).append("\n");
		sb.append("    inspectionRemarks: ").append(toIndentedString(inspectionRemarks)).append("\n");
		sb.append("    totalReceiptValue: ").append(toIndentedString(totalReceiptValue)).append("\n");
		sb.append("    receiptDetails: ").append(toIndentedString(receiptDetails)).append("\n");
		sb.append("    fileStoreId: ").append(toIndentedString(fileStoreId)).append("\n");
		sb.append("    paymentTerms: ").append(toIndentedString(paymentTerms)).append("\n");
		sb.append("    supplierBillPaid: ").append(toIndentedString(supplierBillPaid)).append("\n");
		sb.append("    auditDetails: ").append(toIndentedString(auditDetails)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
