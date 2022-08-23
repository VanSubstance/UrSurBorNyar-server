package com.my.ursurbornyar.service.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.my.ursurbornyar.service.externalapi.TransportService;
import com.my.ursurbornyar.vo.TransportRequest;

@Service
public class TransportServiceImpl implements TransportService {
	private final static String BASE_URL = "http://ws.bus.go.kr/api/rest/pathinfo/";
	private final static String API_KEY = "VdRk2V2HFMLC2wHseWr1v%2B8H5KihBFvWqrd5jakZK1m6koEnvmiGb3pQl8E5HSlTVXtw8BYG85JJS1RdEjk1fA%3D%3D";

	private ResponseEntity<?> getUri(String url, TransportRequest transportRequest) {
		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders header = new HttpHeaders();
		HttpEntity<?> entity = new HttpEntity<>(header);

		UriComponents uri = UriComponentsBuilder.fromHttpUrl(BASE_URL + "getPathInfoBySubway")
				.queryParam("ServiceKey", API_KEY).queryParam("resultType", "json")
				.queryParam("startX", transportRequest.getStartX()).queryParam("startY", transportRequest.getStartY())
				.queryParam("endX", transportRequest.getEndX()).queryParam("endY", transportRequest.getEndY()).build();
		
		System.out.println("URI CHECK:: " + uri.toString());

		return restTemplate.exchange(uri.toString(), HttpMethod.GET, entity, Object.class);
	}

	@Override
	public ResponseEntity<?> getPathInfoBySubwayList(TransportRequest transportRequest) {
		// TODO Auto-generated method stub
		ResponseEntity<?> response = getUri(BASE_URL + "getPathInfoBySubway", transportRequest);

		System.out.println("Check the response::");
		System.out.println(response + "\n");

		return response;
	}

	@Override
	public ResponseEntity<?> getPathInfoByBusList(TransportRequest transportRequest) {
		// TODO Auto-generated method stub
		ResponseEntity<?> response = getUri(BASE_URL + "getPathInfoByBus", transportRequest);

		System.out.println("Check the response::");
		System.out.println(response + "\n");

		return response;
	}

	@Override
	public ResponseEntity<?> getPathInfoByBusNSubList(TransportRequest transportRequest) {
		// TODO Auto-generated method stub
		ResponseEntity<?> response = getUri(BASE_URL + "getPathInfoByBusNSub", transportRequest);

		System.out.println("Check the response::");
		System.out.println(response + "\n");

		return response;
	}

}
