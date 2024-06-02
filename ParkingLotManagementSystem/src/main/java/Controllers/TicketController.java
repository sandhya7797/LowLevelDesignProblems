package Controllers;

import DTOS.IssueTicketRequestDTO;
import DTOS.IssueTicketResponseDTO;
import Enums.ResponseStatus;
import Models.Ticket;
import Services.TicketService;

//Use Case1 : Issue Ticket

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public IssueTicketResponseDTO issueTicket(IssueTicketRequestDTO issueTicketRequestDTO) {

        IssueTicketResponseDTO response = new IssueTicketResponseDTO();

        //controller talks to service

        Ticket ticket;

        try {
            ticket = ticketService.issueTicket(issueTicketRequestDTO.getVehicleNum(),
                    issueTicketRequestDTO.getOwnerNameOfVehicle(),
                    issueTicketRequestDTO.getVehicleType(),
                    issueTicketRequestDTO.getGateId());
        } catch (Exception ex) {
            response.setResponseStatus(ResponseStatus.FAILURE);
            response.setFailureReason("Ticket Creation Failed");
            System.out.println(ex.getStackTrace());
            return response;
        }

        response.setResponseStatus(ResponseStatus.SUCCESS);
        response.setTicket(ticket);
        return response;
    }
}
