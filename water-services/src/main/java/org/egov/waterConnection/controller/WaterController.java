package org.egov.waterConnection.controller;

import java.util.List;
import javax.validation.Valid;

import org.egov.waterConnection.model.RequestInfoWrapper;
import org.egov.waterConnection.model.WaterConnection;
import org.egov.waterConnection.model.WaterConnectionRequest;
import org.egov.waterConnection.model.WaterConnectionResponse;
import org.egov.waterConnection.model.SearchCriteria;
import org.egov.waterConnection.service.WaterService;
import org.egov.waterConnection.util.ResponseInfoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@RestController
@RequestMapping("/wc")
public class WaterController {

	@Autowired
	WaterService waterService;

	@Autowired
	private final ResponseInfoFactory responseInfoFactory;

	@RequestMapping(value = "/_create", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<WaterConnectionResponse> createWaterConnection(
			@Valid @RequestBody WaterConnectionRequest waterConnectionRequest) {
		List<WaterConnection> waterConnection = waterService.createWaterConnection(waterConnectionRequest);
		WaterConnectionResponse response = WaterConnectionResponse.builder().waterConnection(waterConnection)
				.responseInfo(responseInfoFactory
						.createResponseInfoFromRequestInfo(waterConnectionRequest.getRequestInfo(), true))
				.build();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/_search", method = RequestMethod.POST)
	public ResponseEntity<WaterConnectionResponse> search(@Valid @RequestBody RequestInfoWrapper requestInfoWrapper,
			@Valid @ModelAttribute SearchCriteria criteria) {
		List<WaterConnection> waterConnectionList = waterService.search(criteria, requestInfoWrapper.getRequestInfo());
		WaterConnectionResponse response = WaterConnectionResponse.builder().waterConnection(waterConnectionList)
				.responseInfo(responseInfoFactory.createResponseInfoFromRequestInfo(requestInfoWrapper.getRequestInfo(),
						true))
				.build();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/_update", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<WaterConnectionResponse> updateWaterConnection(
			@Valid @RequestBody WaterConnectionRequest waterConnectionRequest) {
		List<WaterConnection> waterConnection = waterService.updateWaterConnection(waterConnectionRequest);
		WaterConnectionResponse response = WaterConnectionResponse.builder().waterConnection(waterConnection)
				.responseInfo(responseInfoFactory
						.createResponseInfoFromRequestInfo(waterConnectionRequest.getRequestInfo(), true))
				.build();
		return new ResponseEntity<>(response, HttpStatus.OK);

	}

	// @RequestMapping(value = "/_cancel", method = RequestMethod.POST)
	// public ResponseEntity<WaterConnectionResponse> cancel(@Valid @RequestBody
	// RequestInfoWrapper requestInfoWrapper,
	// @Valid @ModelAttribute WaterConnectionCancelCriteria
	// waterConnectionCancelCriteria) {
	// List<WaterConnection> waterConnectionList =
	// waterService.cancelWaterConnection(waterConnectionCancelCriteria,requestInfoWrapper.getRequestInfo());
	// WaterConnectionResponse response =
	// WaterConnectionResponse.builder().waterConnection(waterConnectionList)
	// .responseInfo(responseInfoFactory.createResponseInfoFromRequestInfo(requestInfoWrapper.getRequestInfo(),
	// true))
	// .build();
	// return new ResponseEntity<>(response, HttpStatus.OK);
	// }

}
