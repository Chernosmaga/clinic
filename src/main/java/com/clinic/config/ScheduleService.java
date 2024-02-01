package com.clinic.config;

import com.clinic.ticket.dto.TicketShortDto;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.xml.ws.RequestWrapper;
import jakarta.xml.ws.ResponseWrapper;

import javax.jws.WebResult;
import javax.jws.WebService;
import java.time.LocalDateTime;

@WebService(targetNamespace = "http://clinic.service/", name = "schedule")
public interface ScheduleService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "createSchedule", targetNamespace = "http://clinic.service/",
            className = "com.clinic.config.ScheduleService")
    @WebMethod(action = "urn:createSchedule")
    @ResponseWrapper(localName = "createSchedule", targetNamespace = "http://clinic.service/",
    className = "com.clinic.config.ScheduleService")
    TicketShortDto createSchedule(@WebParam(name = "doctorId", targetNamespace = "") Long doctorId,
                                  @WebParam(name = "start", targetNamespace = "") LocalDateTime start,
                                  @WebParam(name = "end", targetNamespace = "") LocalDateTime end);
}
