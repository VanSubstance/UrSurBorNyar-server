package com.my.ursurbornyar.service.externalapi;

import org.springframework.http.ResponseEntity;

import com.my.ursurbornyar.vo.TransportRequest;

public interface TransportService {
	public ResponseEntity<?> getPathInfoBySubwayList(TransportRequest transportRequest);
	public ResponseEntity<?> getPathInfoByBusList(TransportRequest transportRequest);
	public ResponseEntity<?> getPathInfoByBusNSubList(TransportRequest transportRequest);
}
