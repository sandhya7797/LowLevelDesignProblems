package DTOS;

import Enums.ResponseStatus;
import Models.Ticket;

public class IssueTicketResponseDTO {
    private Ticket ticket;//since we don't want to hide anything from ticket to external world, directly returning ticket.
    private ResponseStatus responseStatus;
    private String failureReason;

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }
}
