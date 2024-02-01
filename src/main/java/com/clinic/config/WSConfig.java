package com.clinic.config;

import com.clinic.ticket.service.TicketService;
import jakarta.xml.ws.Endpoint;
import lombok.RequiredArgsConstructor;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class WSConfig {
    private final TicketService ticketService;
    private final Bus bus;

    @Bean
    public Endpoint scheduleEndpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new ScheduleServiceImpl(ticketService));
        endpoint.publish("/schedules");
        return endpoint;
    }
}
