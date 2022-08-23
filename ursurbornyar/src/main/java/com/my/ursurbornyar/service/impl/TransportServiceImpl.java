package com.my.ursurbornyar.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.ursurbornyar.service.externalapi.TransportService;
import com.my.ursurbornyar.vo.TransportRequest;

@Service
public class TransportServiceImpl implements TransportService {
	private final static String BASE_URL = "http://ws.bus.go.kr/api/rest/pathinfo/";
	private final static String API_KEY = "VdRk2V2HFMLC2wHseWr1v%2B8H5KihBFvWqrd5jakZK1m6koEnvmiGb3pQl8E5HSlTVXtw8BYG85JJS1RdEjk1fA%3D%3D";

	private ResponseEntity<?> getUri(String url, TransportRequest transportRequest) {
		StringBuilder urlBuilder = new StringBuilder(url); /* URL */
		try {
			urlBuilder.append("?" + URLEncoder.encode("ServiceKey", "UTF-8") + "=" + API_KEY);
			urlBuilder.append("&" + URLEncoder.encode("resultType", "UTF-8") + "=" + URLEncoder.encode("json", "UTF-8"));
			urlBuilder.append("&" + URLEncoder.encode("startX", "UTF-8") + "=" + transportRequest.getStartX());
			urlBuilder.append("&" + URLEncoder.encode("startY", "UTF-8") + "=" + transportRequest.getStartY());
			urlBuilder.append("&" + URLEncoder.encode("endX", "UTF-8") + "=" + transportRequest.getEndX());
			urlBuilder.append("&" + URLEncoder.encode("endY", "UTF-8") + "=" + transportRequest.getEndY());

			System.out.println("URI CHECK:: " + urlBuilder.toString());
			URL urlMade = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) urlMade.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-type", "application/json");
			HashMap<String, Object> response = new ObjectMapper().readValue(conn.getInputStream(), HashMap.class);
			HttpStatus status = HttpStatus.GONE;
			if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
				status = HttpStatus.OK;
			} else {
				status = HttpStatus.GONE;
			}
			conn.disconnect();
			ResponseEntity result = new ResponseEntity<HashMap<String, Object>>((HashMap<String, Object>) response.get("msgBody"), status);
			return result;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResponseEntity<?> getPathInfoBySubwayList(TransportRequest transportRequest) {
		// TODO Auto-generated method stub
		ResponseEntity<?> response = getUri(BASE_URL + "getPathInfoBySubway", transportRequest);
		return response;
	}

	@Override
	public ResponseEntity<?> getPathInfoByBusList(TransportRequest transportRequest) {
		// TODO Auto-generated method stub
		ResponseEntity<?> response = getUri(BASE_URL + "getPathInfoByBus", transportRequest);
		return response;
	}

	@Override
	public ResponseEntity<?> getPathInfoByBusNSubList(TransportRequest transportRequest) {
		// TODO Auto-generated method stub
		ResponseEntity<?> response = getUri(BASE_URL + "getPathInfoByBusNSub", transportRequest);
		return response;
	}

}
