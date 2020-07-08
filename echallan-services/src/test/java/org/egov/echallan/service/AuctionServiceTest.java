package org.egov.echallan.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.egov.common.contract.request.RequestInfo;
import org.egov.common.contract.request.User;
import org.egov.common.contract.response.ResponseInfo;
import org.egov.echallan.producer.Producer;
import org.egov.echallan.repository.AuctionRepository;
import org.egov.echallan.repository.ViolationRepository;
import org.egov.echallan.service.validator.CustomBeanValidator;
import org.egov.echallan.web.models.Auction;
import org.egov.echallan.web.models.AuditDetails;
import org.egov.echallan.web.models.EcSearchCriteria;
import org.egov.echallan.web.models.RequestInfoWrapper;
import org.egov.echallan.web.models.Violation;
import org.egov.echallan.web.models.workflow.ProcessInstanceRequest;
import org.egov.echallan.workflow.WorkflowIntegrator;
import org.egov.tracer.model.CustomException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(MockitoJUnitRunner.class)
public class AuctionServiceTest {

	@Mock
	private AuctionRepository repository;
	
	@Mock
	private ViolationRepository repository1;

	@InjectMocks
	private AuctionService service;

	/*@Mock
	private ResponseInfoFactory responseInfoFactory;*/

	@InjectMocks
	private Auction auctionMaster;
	
	@InjectMocks
	private Violation violation;

	@Mock
	private Producer producer;

	@Mock
	private ObjectMapper objectMapper;

	@Mock
	WorkflowIntegrator wfIntegrator;
	
	@Mock
	CustomBeanValidator validate;
	
	@Mock
	DeviceSourceService deviceSource;

	@Test
	public void testGetAuction() throws Exception {
		Auction auction = Auction.builder().auctionUuid("aasdjiasdu8ahs89asdy8a9h").build();
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(auction)
				.requestInfo(RequestInfo.builder().userInfo(User.builder().tenantId("ch").build()).build()).build();
		
		Mockito.when(objectMapper.convertValue(infoWrapper.getRequestBody(), Auction.class)).thenReturn(auction);
		
		EcSearchCriteria searchCriteria = EcSearchCriteria.builder().build();
		
		Mockito.when(repository.getAuction(searchCriteria)).thenReturn(new ArrayList<Auction>());
		Assert.assertEquals(HttpStatus.OK, service.getAuction(infoWrapper).getStatusCode());
	}

	@Test(expected = CustomException.class)
	public void testGetAuctionException() throws CustomException {
		service.getAuction(null);
	}

	@Test
	public void testCreateAuction() {
		List<Auction> auctionList=new ArrayList<Auction>();
		Auction auction = Auction.builder().auctionUuid("aasdjiasdu8ahs89asdy8a9h").build();
		AuditDetails auditDetails = AuditDetails.builder().createdBy("1").createdTime(1546515646L).lastModifiedBy("1")
				.lastModifiedTime(15645455L).build();
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().auditDetails(auditDetails).requestBody(auction)
				.build();
		Mockito.when(objectMapper.convertValue(infoWrapper.getRequestBody(), Auction.class)).thenReturn(auction);
		auctionList.add(auction);
		auction.setAuctionList(auctionList);
		when(wfIntegrator.callWorkFlow(Matchers.any(ProcessInstanceRequest.class)))
		.thenReturn(ResponseInfo.builder().status("successful").build());
		Assert.assertEquals(HttpStatus.OK, service.addAuction(infoWrapper,"xyz").getStatusCode());
		
		validate.validateFields(auction.getAuctionList());
		repository.saveAuction(auction);

	}

	@Test(expected = CustomException.class)
	public void testCreateAuctionException() {

		Auction auction = null;
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(null).build();
		Mockito.when(objectMapper.convertValue(infoWrapper.getRequestBody(), Auction.class)).thenReturn(auction);
		service.addAuction(infoWrapper,"");
	}

	@Test
	public void testUpdateAuction() {
		List<Auction> auctionList=new ArrayList<Auction>();
		Auction auction = Auction.builder().auctionUuid("aasdjiasdu8ahs89asdy8a9h").status("APPROVE").build();
		Violation violation = Violation.builder().violationUuid("aasdjiasdu8ahs89asdy8a9h").status("APPROVE").build();
		AuditDetails auditDetails = AuditDetails.builder().createdBy("1").createdTime(1546515646L).lastModifiedBy("1")
				.lastModifiedTime(15645455L).build();
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().auditDetails(auditDetails).requestBody(auction)
				.build();
		Mockito.when(objectMapper.convertValue(infoWrapper.getRequestBody(), Auction.class)).thenReturn(auction);
		Mockito.when(objectMapper.convertValue(infoWrapper.getRequestBody(), Violation.class)).thenReturn(violation);
		when(wfIntegrator.callWorkFlow(Matchers.any(ProcessInstanceRequest.class)))
		.thenReturn(ResponseInfo.builder().status("successful").build());
		auctionList.add(auction);
		auction.setAuctionList(auctionList);
		Assert.assertEquals(HttpStatus.OK, service.updateAuction(infoWrapper).getStatusCode());
	}

	@Test
	public void testUpdateAuction_1() {
		List<Auction> auctionList=new ArrayList<Auction>();
		Auction auction = Auction.builder().auctionUuid("aasdjiasdu8ahs89asdy8a9h").status("REJECT").build();
		AuditDetails auditDetails = AuditDetails.builder().createdBy("1").createdTime(1546515646L).lastModifiedBy("1")
				.lastModifiedTime(15645455L).build();
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().auditDetails(auditDetails).requestBody(auction)
				.build();
		Mockito.when(objectMapper.convertValue(infoWrapper.getRequestBody(), Auction.class)).thenReturn(auction);		
		when(wfIntegrator.callWorkFlow(Matchers.any(ProcessInstanceRequest.class)))
		.thenReturn(ResponseInfo.builder().status("successful").build());
		auctionList.add(auction);
		auction.setAuctionList(auctionList);
		Assert.assertEquals(HttpStatus.OK, service.updateAuction(infoWrapper).getStatusCode());
	}
	
	@Test(expected = CustomException.class)
	public void testUpdateAuctionException() {

		Auction auction = null;
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(null).build();
		Mockito.when(objectMapper.convertValue(infoWrapper.getRequestBody(), Auction.class)).thenReturn(auction);
		service.updateAuction(infoWrapper);
	}
	
	@Test
	public void testGetAuctionChallan() throws Exception {
		Auction auction = Auction.builder().auctionUuid("aasdjiasdu8ahs89asdy8a9h").build();
		RequestInfoWrapper infoWrapper = RequestInfoWrapper.builder().requestBody(auction)
				.requestInfo(RequestInfo.builder().userInfo(User.builder().tenantId("ch").build()).build()).build();
		
		Mockito.when(objectMapper.convertValue(infoWrapper.getRequestBody(), Auction.class)).thenReturn(auction);
				
		Mockito.when(repository.getAuctionChallan(auction)).thenReturn(new ArrayList<Auction>());
		Assert.assertEquals(HttpStatus.OK, service.getAuction(infoWrapper).getStatusCode());
	}

	@Test(expected = CustomException.class)
	public void testGetAuctionChallanException() throws CustomException {
		service.getAuctionChallan(null);
	}

}
